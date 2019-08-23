/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/
package org.eclipse.etrice.core.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.etrice.core.common.validation.CustomValidatorManager;
import org.eclipse.etrice.core.common.validation.ICustomValidator;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.osgi.framework.Bundle;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Custom validator manager for room language, that provides registration via an
 * extension point.
 * 
 */
public class ValidatorExtensionManager extends CustomValidatorManager {

	public static class ValidatorInfo {
		public static final String SEP = "@";

		private ICustomValidator validator;
		private String id;

		private String mode;

		public ValidatorInfo(ICustomValidator validator, String mode, String id) {
			super();
			this.validator = validator;
			this.mode = mode;
			this.id = id;
		}

		public ICustomValidator getValidator() {
			return validator;
		}

		public String getName() {
			return validator.getName();
		}

		public String getDescription() {
			return validator.getDescription();
		}

		public String getMode() {
			return mode;
		}

		public String getId() {
			return id;
		}
	}

	public static class Registry {

		private static final String IVALIDATOR_ID = "org.eclipse.etrice.core.room.validation";
		private static Registry instance = null;
		private HashMap<String, ArrayList<ICustomValidator>> fastClass2Ext = new HashMap<String, ArrayList<ICustomValidator>>();
		private HashMap<String, ArrayList<ICustomValidator>> normalClass2Ext = new HashMap<String, ArrayList<ICustomValidator>>();
		private HashMap<String, ArrayList<ICustomValidator>> expensiveClass2Ext = new HashMap<String, ArrayList<ICustomValidator>>();
		private ArrayList<ValidatorInfo> infos = new ArrayList<ValidatorInfo>();
		private ArrayList<ValidatorInfo> excludedInfos = new ArrayList<ValidatorInfo>();
		private HashSet<ICustomValidator> excluded = new HashSet<ICustomValidator>();

		public static Registry getInstance() {
			if (instance == null)
				instance = new Registry();

			return instance;
		}

		public static boolean isAvailable() {
			return EMFPlugin.IS_ECLIPSE_RUNNING && Platform.getExtensionRegistry() != null
					&& Platform.getExtensionRegistry().getExtensionPoint(IVALIDATOR_ID) != null;
		}

		public void loadValidatorExtensions(Injector injector) {
			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(IVALIDATOR_ID);

			// we use parent-package.class-name as key in our tables
			
			// compute all sub classes for all classes of the Room package
			HashMap<String, ArrayList<String>> cls2sub = new HashMap<String, ArrayList<String>>();
			for (EClassifier cls : RoomPackage.eINSTANCE.getEClassifiers()) {
				if (cls instanceof EClass) {
					EList<EClass> superTypes = ((EClass) cls).getESuperTypes();
					if (cls.getName().equals("ActorClass")) {
						for (EClass sup : superTypes) {
							EPackage pckg = (EPackage) sup.eContainer();
							String path = pckg.getName();
							put(path+"."+sup.getName(), cls.getEPackage().getName()+"."+((EClass) cls).getName(), cls2sub);
						}
					}
				}
			}

			// now we add each extension to our maps
			for (IConfigurationElement e : config) {
				try {
					final String extContributor = e.getContributor().getName();
					final Bundle extBundle = Platform.getBundle(extContributor);
					final String extClassName = e.getAttribute("class");
					final Class<?> extClass = extBundle.loadClass(extClassName);
					final Object ext = injector.getInstance(extClass);
					if (ext instanceof ICustomValidator) {
						ICustomValidator validator = (ICustomValidator) ext;
						String mode = e.getAttribute("mode");
						infos.add(new ValidatorInfo(validator, mode, e.getName() + ValidatorInfo.SEP
								+ e.getNamespaceIdentifier()));
						String classToCheck = e.getAttribute("classToCheck");
						int pos = classToCheck.lastIndexOf('.');
						if (pos>=0) {
							pos = classToCheck.lastIndexOf('.', pos-1);
							if (pos>=0) {
								classToCheck = classToCheck.substring(pos+1);
							}
						}
						HashMap<String, ArrayList<ICustomValidator>> map = getMap(mode);
						if (map != null) {
							put(map, classToCheck, (ICustomValidator) ext);
							ArrayList<String> subTypes = cls2sub.get(classToCheck);
							if (subTypes != null)
								for (String type : subTypes) {
									put(map, type, (ICustomValidator) ext);
								}
						}
					}
					else {
						System.out.println("ValidatorExtensionManager: unexpected extension");
					}
				}
				catch (ClassNotFoundException ex) {
					System.out.println(ex.toString());
				}
			}
		}

		public void exclude(ValidatorInfo info) {
			excludedInfos.add(info);
			excluded.add(info.getValidator());
		}

		public void include(ValidatorInfo info) {
			excludedInfos.remove(info);
			excluded.remove(info.getValidator());
		}

		public void setIncluded(Collection<ValidatorInfo> includedInfos) {
			excluded.clear();
			excludedInfos.clear();

			Set<ValidatorInfo> toExclude = new HashSet<ValidatorInfo>(infos);
			toExclude.removeAll(includedInfos);
			excludedInfos.addAll(toExclude);

			for (ValidatorInfo info : excludedInfos)
				excluded.add(info.getValidator());
		}

		public List<ValidatorInfo> getInfos() {
			return Collections.unmodifiableList(infos);
		}

		public List<ValidatorInfo> getExcludedInfos() {
			return Collections.unmodifiableList(excludedInfos);
		}

		public List<ICustomValidator> getValidatorsToExecute(EObject object, CheckMode checkMode,
				ValidationMessageAcceptor messageAcceptor) {
			Set<ICustomValidator> validators = new LinkedHashSet<>();

			// Bug 550296
			if (checkMode.shouldCheck(CheckType.FAST))
				validators.addAll(getValidators(object, messageAcceptor, fastClass2Ext));
			if (checkMode.shouldCheck(CheckType.NORMAL))
				validators.addAll(getValidators(object, messageAcceptor, normalClass2Ext));
			if (checkMode.shouldCheck(CheckType.EXPENSIVE))
				validators.addAll(getValidators(object, messageAcceptor, expensiveClass2Ext));
			validators.removeAll(excluded);

			return Lists.newArrayList(validators);
		}

		private List<ICustomValidator> getValidators(EObject object, ValidationMessageAcceptor messageAcceptor,
				HashMap<String, ArrayList<ICustomValidator>> map) {
			ArrayList<ICustomValidator> result = new ArrayList<ICustomValidator>();

			ArrayList<ICustomValidator> validators = map.get(object.eClass().getEPackage().getName() + "." + object.eClass().getName());
			if (validators != null)
				for (ICustomValidator validator : validators) {
					result.add(validator);
				}

			return result;
		}

		private void put(String cls, String sub, HashMap<String, ArrayList<String>> cls2sub) {

			ArrayList<String> list = cls2sub.get(cls);
			if (list == null) {
				list = new ArrayList<String>();
				cls2sub.put(cls, list);
			}
			list.add(sub);
		}

		private void put(HashMap<String, ArrayList<ICustomValidator>> map, String cls, ICustomValidator val) {
			ArrayList<ICustomValidator> list = map.get(cls);
			if (list == null) {
				list = new ArrayList<ICustomValidator>();
				map.put(cls, list);
			}
			list.add(val);
		}

		private HashMap<String, ArrayList<ICustomValidator>> getMap(String mode) {
			if (mode.equals(CheckType.FAST.name()))
				return fastClass2Ext;
			else if (mode.equals(CheckType.NORMAL.name()))
				return normalClass2Ext;
			else if (mode.equals(CheckType.EXPENSIVE.name()))
				return normalClass2Ext;
			else
				return null;
		}
	}

	protected boolean isRegistryAvailable;
	
	public ValidatorExtensionManager(){
		super();
		isRegistryAvailable = Registry.isAvailable();
	}
	
	@Inject
	public void registerExtensionValidators(Injector injector) {
		if(isRegistryAvailable) {
			Registry.getInstance().loadValidatorExtensions(injector);
		}
	}
	
	@Override
	public void checkObjectsStandalone(EObject object) {
		// replaced by methods below
	}
	
	@Check(CheckType.FAST)
	public void checkObjectFast(EObject object) {
		checkObject(object, CheckType.FAST);
	}
	
	@Check(CheckType.NORMAL)
	public void checkObjectNormal(EObject object) {
		checkObject(object, CheckType.NORMAL);
	}
	
	@Check(CheckType.EXPENSIVE)
	public void checkObjectExpensive(EObject object) {
		checkObject(object, CheckType.EXPENSIVE);
	}
	
	protected void checkObject(EObject object, CheckType checkType) {
		// Bug 550296 - use CheckType instead of CheckMode
		// Diagnostic markers must be associated with correct CheckType for editor sync
		CheckMode checkMode;
		switch(checkType) {
			case FAST: checkMode = CheckMode.FAST_ONLY; break;
			case NORMAL: checkMode = CheckMode.NORMAL_ONLY; break;
			case EXPENSIVE: checkMode = CheckMode.EXPENSIVE_ONLY; break;
			default: throw new IllegalArgumentException(Objects.toString(checkType));
		}
		if (isRegistryAvailable) {
			ICustomValidator.ValidationContext context = new ValidationContextImpl(isStandalone(), isGeneration(), checkMode);
			for (ICustomValidator val : Registry.getInstance().getValidatorsToExecute(object, checkMode, getMessageAcceptor())) {
				executeValidator(val, object, null, getMessageAcceptor(), context);
			}
		}
		else {
			// use default registry
			super.checkObjectsStandalone(object);
		}
	}

}
