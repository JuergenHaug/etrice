/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.ui.wizard

import org.eclipse.core.runtime.preferences.InstanceScope
import org.eclipse.etrice.generator.ui.preferences.PreferenceConstants
import org.eclipse.ui.preferences.ScopedPreferenceStore

/**
 * @author Henrik Rentz-Reichert
 *
 */
class ProjectFileFragments {
	
	def static String getBasicRoomModel(String baseName) {
		'''
			RoomModel �baseName� {
				LogicalSystem �baseName� {
					SubSystemRef main: MainSubSystem
				}
				SubSystemClass MainSubSystem {
					ActorRef appl: Application
					LogicalThread defaultThread
				}
				ActorClass Application {
				}
			}
		'''
	}
	
	/**
	 * @see ETPhysUtil
	 */
	def static String getBasicPhysicalModel(String baseName) {
		'''
			PhysicalModel �baseName� {
				
				PhysicalSystem PhysSys1 {
					NodeRef nodeRef1 : NodeClass1
				}
				
				NodeClass NodeClass1 {
					runtime = RuntimeClass1
					priomin = -10
					priomax = 10
					
					DefaultThread PhysicalThread1 {
						execmode = mixed
						interval = 100ms
						prio = 0
						stacksize = 1024
						msgblocksize = 32
						msgpoolsize = 10
					}
				}
			
				RuntimeClass RuntimeClass1 {
					model = multiThreaded
				} 
			}
		'''
	}
	
	def static String getBasicMappingModel(String baseName) {
		'''
			MappingModel �baseName� {
				import �baseName�.* from "�baseName�.room"
				import �baseName�.* from "�baseName�.etphys"
				Mapping �baseName� -> PhysSys1 {
					SubSystemMapping main -> nodeRef1 {
						ThreadMapping defaultThread -> PhysicalThread1
					}
				}
			}
		'''
	}
	
	def static String getGeneratorLaunchConfig(String targetLanguage, String modelPath, String mainMethodName, String[] addLines) {
		val prefStore = new ScopedPreferenceStore(InstanceScope.INSTANCE, "org.eclipse.etrice.generator.ui");
		val useTranslation = prefStore.getBoolean(PreferenceConstants::GEN_USE_TRANSLATION)
		'''
			<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<launchConfiguration type="org.eclipse.etrice.generator.launch.�targetLanguage�.launchConfigurationType">
			<booleanAttribute key="MSC" value="true"/>
			<booleanAttribute key="DataLogging" value="true"/>
			<booleanAttribute key="UseTranslation" value="�useTranslation�"/>
			<stringAttribute key="MainMethodName" value="�mainMethodName�"/>
			<listAttribute key="ModelFiles">
			<listEntry value="${workspace_loc:�modelPath�/Mapping.etmap}"/>
			<listEntry value="${workspace_loc:�modelPath�/TemplateModel.room}"/>
			</listAttribute>
			<listAttribute key="org.eclipse.debug.ui.favoriteGroups">
			<listEntry value="org.eclipse.debug.ui.launchGroup.run"/>
			</listAttribute>
			�FOR line : addLines�
				�line�
			�ENDFOR�
			</launchConfiguration>
		'''
	}
	
	def static String getLaunchJavaApplicationConfig(String project, String mdlName, String mainClass) {
		'''
			<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<launchConfiguration type="org.eclipse.jdt.launching.localJavaApplication">
			<listAttribute key="org.eclipse.debug.core.MAPPED_RESOURCE_PATHS">
			<listEntry value="/�project�/src-gen/�mdlName.replace('.', '/')�/�mainClass�.java"/>
			</listAttribute>
			<listAttribute key="org.eclipse.debug.core.MAPPED_RESOURCE_TYPES">
			<listEntry value="1"/>
			</listAttribute>
			<booleanAttribute key="org.eclipse.jdt.launching.ATTR_USE_START_ON_FIRST_THREAD" value="true"/>
			<stringAttribute key="org.eclipse.jdt.launching.MAIN_TYPE" value="�mdlName�.�mainClass�"/>
			<stringAttribute key="org.eclipse.jdt.launching.PROJECT_ATTR" value="�project�"/>
			</launchConfiguration>
		'''
	}
	
	def static String getLaunchCApplicationConfig(String project) {
		'''
			<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<launchConfiguration type="org.eclipse.cdt.launch.applicationLaunchType">
			<booleanAttribute key="org.eclipse.cdt.debug.mi.core.verboseMode" value="false"/>
			<intAttribute key="org.eclipse.cdt.launch.ATTR_BUILD_BEFORE_LAUNCH_ATTR" value="2"/>
			<stringAttribute key="org.eclipse.cdt.launch.DEBUGGER_START_MODE" value="run"/>
			<stringAttribute key="org.eclipse.cdt.launch.PROGRAM_NAME" value="Debug/�project�.exe"/>
			<stringAttribute key="org.eclipse.cdt.launch.PROJECT_ATTR" value="�project�"/>
			<booleanAttribute key="org.eclipse.cdt.launch.use_terminal" value="true"/>
			<listAttribute key="org.eclipse.debug.core.MAPPED_RESOURCE_PATHS">
			<listEntry value="/�project�"/>
			</listAttribute>
			<listAttribute key="org.eclipse.debug.core.MAPPED_RESOURCE_TYPES">
			<listEntry value="4"/>
			</listAttribute>
			</launchConfiguration>
		'''
	}
	
	def static String getMavenPOM(String project, String mdlName, String mainClass) {
		'''
			<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
						xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
				<modelVersion>4.0.0</modelVersion>
				<groupId>�project�</groupId>
				<artifactId>�mdlName�</artifactId>
				<version>1.0.0</version>
				
				<repositories>
					<repository>
						<id>repo.eclipse.org-snapshots</id>
						<name>eTrice Repository - Snapshots</name>
						<url>https://repo.eclipse.org/content/repositories/etrice-snapshots/</url>
					</repository>
				</repositories>
				
				<pluginRepositories>
					<pluginRepository>
						<id>repo.eclipse.org-snapshots</id>
						<name>eTrice Repository - Snapshots</name>
						<url>https://repo.eclipse.org/content/repositories/etrice-snapshots/</url>
					</pluginRepository>
				</pluginRepositories>
				
				<build>
					<sourceDirectory>src-gen</sourceDirectory>
					<resources>
						<resource>
							<directory>src-gen</directory>
							<excludes>
								<exclude>**/*.java</exclude>
							</excludes>
						</resource>
					</resources>
					<plugins>
						<plugin>
							<groupId>org.codehaus.mojo</groupId>
							<artifactId>build-helper-maven-plugin</artifactId>
							<version>1.7</version>
							<executions>
								<execution>
									<id>add-source</id>
									<phase>generate-sources</phase>
									<goals>
										<goal>add-source</goal>
									</goals>
									<configuration>
										<sources>
											<source>src</source>
										</sources>
									</configuration>
								</execution>
							</executions>
						</plugin>
						<plugin>
							<groupId>org.eclipse.etrice</groupId>
							<artifactId>org.eclipse.etrice.generator.java.mvn</artifactId>
							<version>0.5.0-SNAPSHOT</version>
							<executions>
								<execution>
									<goals>
										<goal>eTriceJavaGenerator</goal>
									</goals>
							        <configuration>
							          <arguments>
										<!-- allowed switches for the generator (not complete) -->
										<!-- generate the store/restore interface using POJO data objects
										<param>-storeDataObj</param>
										-->
										<!-- generate MSC instrumentation
										<param>-msc_instr</param>
										-->
										<!-- generate the persistence interface for dynamic actors
										<param>-persistable</param>
										-->
										<!-- generate all ROOM classes as library
										<param>-lib</param>
										-->
										<!-- generate documentation
										<param>-genDocu</param>
										-->
										<!-- generate files incrementally (overwrite only if contents changed)
										<param>-inc</param>
										-->
							          	<param>model/�mdlName�.etmap</param>
							          </arguments>
							        </configuration>
								</execution>
							</executions>
							<dependencies>
								<!-- put the modellib on the class path to allow resolution of models by the generator -->
								<dependency>
									<groupId>org.eclipse.etrice</groupId>
									<artifactId>org.eclipse.etrice.modellib.java</artifactId>
									<version>0.5.0-SNAPSHOT</version>
								</dependency>
							</dependencies>
						</plugin>
						<plugin>
							<artifactId>maven-compiler-plugin</artifactId>
							<version>3.1</version>
							<configuration>
								<source>1.6</source>
								<target>1.6</target>
							</configuration>
						</plugin>
						<plugin>
							<artifactId>maven-assembly-plugin</artifactId>
							<executions>
								<execution>
									<phase>package</phase>
									<goals>
										<goal>single</goal>
									</goals>
								</execution>
							</executions>
							<configuration>
								<descriptorRefs>
									<descriptorRef>jar-with-dependencies</descriptorRef>
								</descriptorRefs>
								<archive>
									<manifest>
										<mainClass>�mdlName�.�mainClass�</mainClass>
									</manifest>
								</archive>
							</configuration>
						</plugin>
					</plugins>
					<pluginManagement>
						<plugins>
							<!--This plugin's configuration is used to store Eclipse m2e settings only. It has no influence on the Maven build itself.-->
							<plugin>
								<groupId>org.eclipse.m2e</groupId>
								<artifactId>lifecycle-mapping</artifactId>
								<version>1.0.0</version>
								<configuration>
									<lifecycleMappingMetadata>
										<pluginExecutions>
											<pluginExecution>
												<pluginExecutionFilter>
													<groupId>
														org.eclipse.etrice
													</groupId>
													<artifactId>
														org.eclipse.etrice.generator.java.mvn
													</artifactId>
													<versionRange>
														[0.5.0-SNAPSHOT,)
													</versionRange>
													<goals>
														<goal>
															eTriceJavaGenerator
														</goal>
													</goals>
												</pluginExecutionFilter>
												<action>
													<ignore></ignore>
												</action>
											</pluginExecution>
											<pluginExecution>
												<pluginExecutionFilter>
													<groupId>
														org.codehaus.mojo
													</groupId>
													<artifactId>
														build-helper-maven-plugin
													</artifactId>
													<versionRange>
														[1.7,)
													</versionRange>
													<goals>
														<goal>add-source</goal>
													</goals>
												</pluginExecutionFilter>
												<action>
													<ignore></ignore>
												</action>
											</pluginExecution>
										</pluginExecutions>
									</lifecycleMappingMetadata>
								</configuration>
							</plugin>
						</plugins>
					</pluginManagement>
				</build>
				<dependencies>
					<dependency>
						<groupId>org.eclipse.etrice</groupId>
						<artifactId>org.eclipse.etrice.runtime.java</artifactId>
						<version>0.5.0-SNAPSHOT</version>
				  	</dependency>
				  	<dependency>
				  		<groupId>org.eclipse.etrice</groupId>
				  		<artifactId>org.eclipse.etrice.modellib.java</artifactId>
				  		<version>0.5.0-SNAPSHOT</version>
				  	</dependency>
				</dependencies>
			</project>
		'''
	}
	
	def static String getMavenBuilder(String project) {
		'''
			<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<launchConfiguration type="org.eclipse.m2e.Maven2LaunchConfigurationType">
			<booleanAttribute key="M2_DEBUG_OUTPUT" value="false"/>
			<stringAttribute key="M2_GOALS" value="package"/>
			<booleanAttribute key="M2_NON_RECURSIVE" value="false"/>
			<booleanAttribute key="M2_OFFLINE" value="false"/>
			<stringAttribute key="M2_PROFILES" value=""/>
			<listAttribute key="M2_PROPERTIES"/>
			<stringAttribute key="M2_RUNTIME" value="EMBEDDED"/>
			<booleanAttribute key="M2_SKIP_TESTS" value="false"/>
			<intAttribute key="M2_THREADS" value="1"/>
			<booleanAttribute key="M2_UPDATE_SNAPSHOTS" value="false"/>
			<booleanAttribute key="M2_WORKSPACE_RESOLUTION" value="false"/>
			<stringAttribute key="org.eclipse.jdt.launching.WORKING_DIRECTORY" value="${workspace_loc:/�project�}"/>
			</launchConfiguration>
		'''
	}
	
	def static String getMavenLauncher(String project, String mdlName) {
		'''
			<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<launchConfiguration type="org.eclipse.ui.externaltools.ProgramLaunchConfigurationType">
			<stringAttribute key="org.eclipse.ui.externaltools.ATTR_LOCATION" value="${env_var:JAVA_HOME}/bin/java.exe"/>
			<stringAttribute key="org.eclipse.ui.externaltools.ATTR_TOOL_ARGUMENTS" value="-jar target/�mdlName�-1.0.0-jar-with-dependencies.jar"/>
			<stringAttribute key="org.eclipse.ui.externaltools.ATTR_WORKING_DIRECTORY" value="${workspace_loc:/�project�}"/>
			</launchConfiguration>
		'''
	}
}