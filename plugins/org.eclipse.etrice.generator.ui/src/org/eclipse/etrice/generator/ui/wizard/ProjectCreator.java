/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.generator.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.settings.model.CIncludePathEntry;
import org.eclipse.cdt.core.settings.model.CLibraryFileEntry;
import org.eclipse.cdt.core.settings.model.CLibraryPathEntry;
import org.eclipse.cdt.core.settings.model.ICConfigurationDescription;
import org.eclipse.cdt.core.settings.model.ICFolderDescription;
import org.eclipse.cdt.core.settings.model.ICLanguageSetting;
import org.eclipse.cdt.core.settings.model.ICLanguageSettingEntry;
import org.eclipse.cdt.core.settings.model.ICProjectDescription;
import org.eclipse.cdt.core.settings.model.ICSettingEntry;
import org.eclipse.cdt.core.settings.model.ICTargetPlatformSetting;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.etrice.core.ui.RoomUiActivator;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * @author Henrik Rentz-Reichert - Initial contribution and API
 * 
 */
public class ProjectCreator {

	private static final String[] commonNatureIDs = {JavaCore.NATURE_ID,
			"org.eclipse.xtext.ui.shared.xtextNature"};
	private static final String[] commonBuilderIDs = {"org.eclipse.xtext.ui.shared.xtextBuilder",};

	public static List<String> getCommonNatureIDs() {
		return Arrays.asList(commonNatureIDs);
	}

	public static List<String> getCommonBuilderIDs() {
		return Arrays.asList(commonBuilderIDs);
	}

	public static IProject createETriceProject(IPath javaSource,
			IPath javaSourceGen, URI projectLocationURI,
			IProject runtimeProject, List<String> naturesToAdd,
			List<String> buildersToAdd, List<IClasspathEntry> pathEntries, Monitor monitor) {
		IProgressMonitor progressMonitor = BasicMonitor
				.toIProgressMonitor(monitor);
		String projectName = javaSource.segment(0);
		IProject project = null;
		try {
			List<IClasspathEntry> classpathEntries = new UniqueEList<IClasspathEntry>();

			progressMonitor.beginTask("", 10);
			progressMonitor.subTask("Creating eTrice project "
					+ projectName
					+ " ("
					+ (projectLocationURI != null ? projectLocationURI
							.toString() : projectName) + ")");
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			project = workspace.getRoot().getProject(projectName);

			// Clean up any old project information.
			//
			if (!project.exists()) {
				URI location = projectLocationURI;
				if (location == null) {
					location = URI.createFileURI(workspace.getRoot()
							.getLocation().append(projectName).toOSString());
				}
				location = location.appendSegment(".project");
				File projectFile = new File(location.toString());
				if (projectFile.exists()) {
					projectFile
							.renameTo(new File(location.toString() + ".old"));
				}
			}

			IJavaProject javaProject = JavaCore.create(project);
			IProjectDescription projectDescription = null;
			if (!project.exists()) {
				projectDescription = ResourcesPlugin.getWorkspace()
						.newProjectDescription(projectName);
				if (projectLocationURI != null) {
					projectDescription.setLocationURI(new java.net.URI(
							projectLocationURI.toString()));
				}
				project.create(projectDescription, new SubProgressMonitor(
						progressMonitor, 1));
				project.open(new SubProgressMonitor(progressMonitor, 1));
			} else {
				projectDescription = project.getDescription();
				project.open(new SubProgressMonitor(progressMonitor, 1));
				if (project.hasNature(JavaCore.NATURE_ID)) {
					classpathEntries.addAll(Arrays.asList(javaProject
							.getRawClasspath()));
				}
			}

			boolean isInitiallyEmpty = classpathEntries.isEmpty();

			{
				ArrayList<IProject> referencedProjects = new ArrayList<IProject>();
				if (runtimeProject != null)
					referencedProjects.add(runtimeProject);
				if (!referencedProjects.isEmpty()) {
					projectDescription.setReferencedProjects(referencedProjects
							.toArray(new IProject[referencedProjects.size()]));
					for (IProject referencedProject : referencedProjects) {
						IClasspathEntry referencedProjectClasspathEntry = JavaCore
								.newProjectEntry(referencedProject
										.getFullPath());
						classpathEntries.add(referencedProjectClasspathEntry);
					}
				}
			}

			{
				addNatures(projectDescription, naturesToAdd);
				addBuilders(projectDescription, buildersToAdd);

				project.setDescription(projectDescription,
						new SubProgressMonitor(progressMonitor, 1));

				createSrcFolder(progressMonitor, project, classpathEntries,
						javaSource);
				createSrcFolder(progressMonitor, project, classpathEntries,
						javaSourceGen);

				if (isInitiallyEmpty) {
					IClasspathEntry jreClasspathEntry = JavaCore
							.newVariableEntry(new Path(
									JavaRuntime.JRELIB_VARIABLE), new Path(
									JavaRuntime.JRESRC_VARIABLE), new Path(
									JavaRuntime.JRESRCROOT_VARIABLE));
					for (Iterator<IClasspathEntry> i = classpathEntries
							.iterator(); i.hasNext();) {
						IClasspathEntry classpathEntry = i.next();
						if (classpathEntry.getPath().isPrefixOf(
								jreClasspathEntry.getPath())) {
							i.remove();
						}
					}

					String jreContainer = JavaRuntime.JRE_CONTAINER;
					jreContainer += "/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6";
					classpathEntries.add(JavaCore.newContainerEntry(new Path(
							jreContainer)));
				}

				for (IClasspathEntry pathEntry : pathEntries) {
					classpathEntries.add(pathEntry);
				}
				
				javaProject.setRawClasspath(classpathEntries
						.toArray(new IClasspathEntry[classpathEntries.size()]),
						new SubProgressMonitor(progressMonitor, 1));
			}

			if (isInitiallyEmpty) {
				javaProject.setOutputLocation(
						new Path("/" + javaSource.segment(0) + "/bin"),
						new SubProgressMonitor(progressMonitor, 1));
			}

			javaProject.setRawClasspath(classpathEntries
					.toArray(new IClasspathEntry[classpathEntries.size()]),
					new SubProgressMonitor(progressMonitor, 1));

			if (isInitiallyEmpty) {
				javaProject.setOutputLocation(
						new Path("/" + javaSource.segment(0) + "/bin"),
						new SubProgressMonitor(progressMonitor, 1));
			}

		} catch (Exception e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		} finally {
			progressMonitor.done();
		}

		return project;
	}

	/**
	 * @param desc
	 * @param naturesToAdd
	 */
	public static void addNatures(IProjectDescription desc,
			List<String> naturesToAdd) {
		HashSet<String> natures = new HashSet<String>();
		String[] ids = desc.getNatureIds();
		if (ids != null)
			for (String id : ids) {
				natures.add(id);
			}

		natures.addAll(naturesToAdd);

		ids = new String[natures.size()];
		ids = natures.toArray(ids);

		desc.setNatureIds(ids);
	}

	public static void addBuilders(IProjectDescription desc,
			List<String> buildersToAdd) {
		HashMap<String, ICommand> builders = new HashMap<String, ICommand>();
		ICommand[] buildSpecs = desc.getBuildSpec();
		for (ICommand spec : buildSpecs) {
			builders.put(spec.getBuilderName(), spec);
		}
		for (String builder : buildersToAdd) {
			if (!builders.containsKey(builder)) {
				ICommand cmd = desc.newCommand();
				cmd.setBuilderName(builder);
				builders.put(builder, cmd);
			}
		}

		buildSpecs = new ICommand[builders.size()];
		buildSpecs = builders.values().toArray(buildSpecs);

		desc.setBuildSpec(buildSpecs);
	}

	/**
	 * @param progressMonitor
	 * @param project
	 * @param classpathEntries
	 * @param src
	 * @throws CoreException
	 */
	private static void createSrcFolder(IProgressMonitor progressMonitor,
			IProject project, List<IClasspathEntry> classpathEntries, IPath src)
			throws CoreException {
		if (src.segmentCount() > 1) {
			IPath sourceContainerPath = src.removeFirstSegments(1)
					.makeAbsolute();
			IFolder sourceContainer = project.getFolder(sourceContainerPath);
			if (!sourceContainer.exists()) {
				for (int i = sourceContainerPath.segmentCount() - 1; i >= 0; i--) {
					sourceContainer = project.getFolder(sourceContainerPath
							.removeLastSegments(i));
					if (!sourceContainer.exists()) {
						((IFolder) sourceContainer).create(false, true,
								new SubProgressMonitor(progressMonitor, 1));
					}
				}
			}

			IClasspathEntry sourceClasspathEntry = JavaCore.newSourceEntry(src);
			for (Iterator<IClasspathEntry> i = classpathEntries.iterator(); i
					.hasNext();) {
				IClasspathEntry classpathEntry = i.next();
				if (classpathEntry.getPath().isPrefixOf(src)) {
					i.remove();
				}
			}
			classpathEntries.add(0, sourceClasspathEntry);
		}
	}

	public static IContainer findOrCreateContainer(IPath path,
			boolean forceRefresh, IPath localLocation,
			IProgressMonitor progressMonitor) throws CoreException {
		String projectName = path.segment(0);
		IProjectDescription projectDescription = ResourcesPlugin.getWorkspace()
				.newProjectDescription(projectName);
		projectDescription.setLocation(localLocation);
		return findOrCreateContainer(path, forceRefresh, projectDescription,
				progressMonitor);
	}

	public static IContainer findOrCreateContainer(IPath path,
			boolean forceRefresh, IProjectDescription projectDescription,
			IProgressMonitor progressMonitor) throws CoreException {
		try {
			String projectName = path.segment(0);
			progressMonitor.beginTask("", path.segmentCount() + 3);
			progressMonitor.subTask("examine new project " + projectName);
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IProject project = workspace.getRoot().getProject(path.segment(0));

			if (forceRefresh) {
				project.refreshLocal(IResource.DEPTH_INFINITE,
						new SubProgressMonitor(progressMonitor, 1));
			} else {
				progressMonitor.worked(1);
			}

			if (!project.exists()) {
				project.create(projectDescription, new SubProgressMonitor(
						progressMonitor, 1));
				project.open(new SubProgressMonitor(progressMonitor, 1));
			} else {
				project.open(new SubProgressMonitor(progressMonitor, 2));
			}

			IContainer container = project;
			for (int i = 1, length = path.segmentCount(); i < length; ++i) {
				IFolder folder = container.getFolder(new Path(path.segment(i)));
				if (!folder.exists()) {
					folder.create(false, true, new SubProgressMonitor(
							progressMonitor, 1));
				} else {
					progressMonitor.worked(1);
				}

				container = folder;
			}

			return container;
		} finally {
			progressMonitor.done();
		}
	}

	public static void createModel(URI uri, String baseName) {
		writeFile(uri, ProjectFileFragments.getBasicRoomModel(baseName));
	}

	public static void createPhysicalModel(URI uri, String baseName) {
		writeFile(uri, ProjectFileFragments.getBasicPhysicalModel(baseName));
	}

	public static void createMappingModel(URI uri, String baseName) {
		writeFile(uri, ProjectFileFragments.getBasicMappingModel(baseName));
	}

	public static void createBuildProperties(URI uri, String baseName) {
		try {
			PrintStream prop = new PrintStream(
					URIConverter.INSTANCE.createOutputStream(uri, null), false,
					"UTF-8");
			prop.println("source.. = src/,\\");
			prop.println("src-gen/");
			prop.close();
		} catch (UnsupportedEncodingException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		} catch (IOException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		}
	}

	public static void createLaunchGeneratorConfig(URI uri,
			String targetLanguage, String modelPath, String baseName, String[] addLines) {
		writeFile(uri, ProjectFileFragments.getGeneratorLaunchConfig(targetLanguage, modelPath, baseName, addLines));
	}

	public static void createLaunchJavaApplicationConfig(URI uri,
			String project, String mdlName, String mainClass) {
		writeFile(uri, ProjectFileFragments.getLaunchJavaApplicationConfig(project, mdlName, mainClass));
	}

	public static void createLaunchCApplicationConfig(URI uri, String project) {
		writeFile(uri, ProjectFileFragments.getLaunchCApplicationConfig(project));
	}

	public static void addIncludePathsAndLibraries(IProject project)
			throws CoreException {
		if (project.getNature("org.eclipse.cdt.core.cnature") == null)
			return;

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject runtime = workspace.getRoot().getProject(
				"org.eclipse.etrice.runtime.c");
		IFolder common = runtime.getFolder("src/common");
		IFolder config = runtime.getFolder("src/config");
		IFolder posix = runtime.getFolder("src/platforms/MT_POSIX_GENERIC_GCC");
		IFolder mingw = runtime.getFolder("src/platforms/MT_WIN_MinGW");
		IFolder src_gen = project.getFolder("src-gen");
		IFolder mingw_debug = project.getFolder("MinGWDebug");
		IFolder mingw_release = project.getFolder("MinGWRelease");
		IFolder posix_debug = project.getFolder("PosixDebug");
		IFolder posix_release = project.getFolder("PosixRelease");

		ICProjectDescription projectDescription = CoreModel.getDefault()
				.getProjectDescription(project, true);
		ICConfigurationDescription configDecriptions[] = projectDescription
				.getConfigurations();

		for (ICConfigurationDescription configDescription : configDecriptions) {
			ICFolderDescription projectRoot = configDescription
					.getRootFolderDescription();
			ICLanguageSetting[] settings = projectRoot.getLanguageSettings();
			for (ICLanguageSetting setting : settings) {
				if (!"org.eclipse.cdt.core.gcc".equals(setting.getLanguageId())) {
					continue;
				}

				ICTargetPlatformSetting tgt = configDescription
						.getTargetPlatformSetting();
				String id = tgt.getId();

				ArrayList<ICLanguageSettingEntry> includes = new ArrayList<ICLanguageSettingEntry>();
				includes.add(new CIncludePathEntry(src_gen,
						ICSettingEntry.LOCAL));
				includes.add(new CIncludePathEntry(common, ICSettingEntry.LOCAL));
				includes.add(new CIncludePathEntry(config, ICSettingEntry.LOCAL));
				if (id.startsWith("cdt.managedbuild.target.gnu.platform.mingw.exe")) {
					includes.add(new CIncludePathEntry(mingw,
							ICSettingEntry.LOCAL));
				} else if (id
						.startsWith("cdt.managedbuild.target.gnu.platform.posix.exe")) {
					includes.add(new CIncludePathEntry(posix,
							ICSettingEntry.LOCAL));
				}
				addSettings(setting, ICSettingEntry.INCLUDE_PATH, includes);

				List<? extends ICLanguageSettingEntry> libPaths = null;
				if (id.startsWith("cdt.managedbuild.target.gnu.platform.mingw.exe.debug")) {
					libPaths = Collections.singletonList(new CLibraryPathEntry(
							mingw_debug, ICSettingEntry.LOCAL));
				} else if (id
						.startsWith("cdt.managedbuild.target.gnu.platform.mingw.exe.release")) {
					libPaths = Collections.singletonList(new CLibraryPathEntry(
							mingw_release, ICSettingEntry.LOCAL));
				} else if (id
						.startsWith("cdt.managedbuild.target.gnu.platform.posix.exe.debug")) {
					libPaths = Collections.singletonList(new CLibraryPathEntry(
							posix_debug, ICSettingEntry.LOCAL));
				} else if (id
						.startsWith("cdt.managedbuild.target.gnu.platform.posix.exe.release")) {
					libPaths = Collections.singletonList(new CLibraryPathEntry(
							posix_release, ICSettingEntry.LOCAL));
				}
				if (libPaths != null)
					addSettings(setting, ICSettingEntry.LIBRARY_PATH, libPaths);

				List<? extends ICLanguageSettingEntry> libs = Collections
						.singletonList(new CLibraryFileEntry(
								"org.eclipse.etrice.runtime.c", 0));
				addSettings(setting, ICSettingEntry.LIBRARY_FILE, libs);
			}
		}
		try {
			CoreModel.getDefault().setProjectDescription(project,
					projectDescription);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private static void addSettings(ICLanguageSetting setting, int kind,
			List<? extends ICLanguageSettingEntry> entries) {
		HashMap<String, ICLanguageSettingEntry> newEntries = new HashMap<String, ICLanguageSettingEntry>();
		for (ICLanguageSettingEntry entry : setting.getSettingEntriesList(kind)) {
			newEntries.put(entry.getName(), entry);
		}
		for (ICLanguageSettingEntry entry : entries) {
			newEntries.put(entry.getName(), entry);
		}
		setting.setSettingEntries(kind, new ArrayList<ICLanguageSettingEntry>(
				newEntries.values()));
	}

	public static void createRunAndLaunchConfigurations(String baseName,
			IProject project, String mdlPath,
			String[] additionalLaunchConfigLines) throws CoreException {

		if (project.getNature(JavaCore.NATURE_ID) != null) {
			ProjectCreator.createLaunchGeneratorConfig(
					URI.createPlatformResourceURI("/" + project.getName()
							+ "/gen_" + baseName + ".launch", true), "java",
					mdlPath, baseName, additionalLaunchConfigLines);
			ProjectCreator.createLaunchJavaApplicationConfig(
					URI.createPlatformResourceURI("/" + project.getName()
							+ "/run_" + baseName + ".launch", true),
					project.getName(), baseName,
					"Node_nodeRef1_subSysRef1Runner");
		} else if (project.getNature("org.eclipse.cdt.core.cnature") != null) {
			ProjectCreator.createLaunchGeneratorConfig(
					URI.createPlatformResourceURI("/" + project.getName()
							+ "/gen_" + baseName + ".launch", true), "c",
					mdlPath, baseName, additionalLaunchConfigLines);
			ProjectCreator.createLaunchCApplicationConfig(
					URI.createPlatformResourceURI("/" + project.getName()
							+ "/run_" + baseName + ".launch", true),
					project.getName());
		}
	}

	public static void createMavenPOM(URI uri, String project, String mdlName, String mainClass) {
		writeFile(uri, ProjectFileFragments.getMavenPOM(project, mdlName, mainClass));
	}

	public static void createMavenBuilder(URI uri, String project) {
		writeFile(uri, ProjectFileFragments.getMavenBuilder(project));
	}

	public static void createMavenLauncher(URI uri, String project, String mdlName) {
		writeFile(uri, ProjectFileFragments.getMavenLauncher(project, mdlName));
	}

	/**
	 * @param project
	 * @param progressMonitor
	 * @throws CoreException
	 */
	public static void addXtextNature(IProject project,
			IProgressMonitor progressMonitor) throws CoreException {
		IProjectDescription description = project.getDescription();
		ProjectCreator.addNatures(description, Collections
				.singletonList("org.eclipse.xtext.ui.shared.xtextNature"));
		ProjectCreator.addBuilders(description, Collections
				.singletonList("org.eclipse.xtext.ui.shared.xtextBuilder"));

		project.setDescription(description, new SubProgressMonitor(
				progressMonitor, 1));
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		ImageDescriptor desc = RoomUiActivator.getDefault().getImageRegistry()
				.getDescriptor(path);
		if (desc == null) {
			desc = RoomUiActivator.imageDescriptorFromPlugin(
					"org.eclipse.etrice.core.room.ui", path);
			if (desc == null)
				System.err.println("image not found: " + path);
			else {
				RoomUiActivator.getDefault().getImageRegistry().put(path, desc);
				RoomUiActivator.getDefault().getImageRegistry().get(path);
			}
		}
		return desc;
	}

	/**
	 * @param uri
	 * @param contents
	 */
	private static void writeFile(URI uri, String contents) {
		try {
			PrintStream model = new PrintStream(URIConverter.INSTANCE.createOutputStream(uri, null), false, "UTF-8");
			model.print(contents);
			model.close();
		} catch (UnsupportedEncodingException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		} catch (IOException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		}
	}
}
