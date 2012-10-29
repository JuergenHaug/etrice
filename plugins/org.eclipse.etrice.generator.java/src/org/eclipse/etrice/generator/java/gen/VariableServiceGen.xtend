/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.java.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import java.util.LinkedList
import java.util.List
import java.util.Map
import org.eclipse.etrice.core.config.ActorClassConfig
import org.eclipse.etrice.core.config.ActorInstanceConfig
import org.eclipse.etrice.core.config.AttrInstanceConfig
import org.eclipse.etrice.core.genmodel.base.ILogger
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.room.SubSystemClass
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.TypeHelpers
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.etrice.generator.base.IDataConfiguration

@Singleton
class VariableServiceGen {
	
	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension JavaExtensions stdExt
	@Inject extension RoomExtensions roomExt
	@Inject extension IDataConfiguration configExt
	@Inject extension ProcedureHelpers helpers
	@Inject extension TypeHelpers
	@Inject ILogger logger
	/* 
	def doGenerate(Root root, SubSystemInstance ssi) {
		var path = ssi.subSystemClass.generationTargetPath+ssi.subSystemClass.getPath
		var file = ssi.subSystemClass.name+"VariableService.java"
		logger.logInfo("generating VariableService implementation: '"+file+"' in '"+path+"'")
		fileAccess.setOutputPath(path)
		fileAccess.generateFile(file, root.generate(ssi, ssi.subSystemClass))
	}
	
	def private generate(Root root, SubSystemInstance comp, SubSystemClass cc) {'''
		�val dynConfig = cc.subSystemConfig.dynConfig�
		
		package �cc.getPackage()�;
		
		import java.util.Arrays;
		import java.util.HashMap;
		import java.util.Map;
		import org.eclipse.etrice.runtime.java.config.VariableService;
		�IF dynConfig.userCode1 != null�
			�dynConfig.userCode1�;
		�ELSE�
			import org.eclipse.etrice.runtime.java.config.ConfigSourceFile;
		�ENDIF�
		�var ais = dynConfigsAIs(comp)�
		�FOR model : ais.roomModels�
			import �model.name�.*;
		�ENDFOR�
		
		
		public class �comp.name+"VariableService"� extends VariableService{
			
			private �cc.name� subSystem;
			
			// Actor instances
			�FOR ai : ais�
				private �ai.actorClass.name� �ai.path.split("/").drop(2).toPath("_")�;
			�ENDFOR�
			
			public �comp.name+"VariableService"�(�cc.name� subSystem) {
				super(�IF dynConfig.filePath != null�new ConfigSourceFile("�dynConfig.filePath�")�ELSE��dynConfig.userCode2��ENDIF�);
				this.subSystem = subSystem;
			}
			
			@Override
			protected void initInstances(){
				�FOR ai : ais�
					�ai.path.split("/").drop(2).toPath("_")� = (�ai.actorClass.name�)subSystem.getInstance("�ai.path�");
				�ENDFOR�
			}
			
		
			@Override
			protected void setAttributeValues(Map<String, Object> values) {
				Object object;
				String id = null;
				�FOR attrConfig : cc.dynConfigReadAttributes�
					�var aiName = (attrConfig.eContainer as ActorInstanceConfig).path.refs.toPath("_")�
					try{
						boolean changed = false;
						�FOR entry : attrConfig.allAttributes.entrySet�
							�var a = entry.key�
							�var aPath = attrConfig.getPath(true, true, true, false).toPath("/")+entry.value.toPath("/")+"/"+a.name�
							id = "�aPath�";
							�IF a.size==0��a.refType.type.typeName.toWrapper��ELSE��a.refType.type.typeName�[]�ENDIF� _�a.name� = null;
							object = values.get(id);
							if(object != null){
								_�a.name� = ensure�a.refType.type.typeName.toFirstUpper��IF a.size>0�Array�ENDIF�(object�IF a.size>0�, �a.size��ENDIF�);
								�genMinMaxCheck(attrConfig, (attrConfig.eContainer as ActorInstanceConfig).actorClassConfig)�
								if(!�IF a.size==0�_�a.name�.equals(�ELSE�Arrays.equals(_�a.name�, �ENDIF�(�IF a.size==0��a.refType.type.typeName.toWrapper��ELSE��a.refType.type.typeName�[]�ENDIF�)getDiffMap().get(id)))
									changed = true;
							} else
								warning(id, "is missing");
						�ENDFOR�
						if(changed)
							synchronized(�aiName�.�invokeGetter(attrConfig.attribute.name+"Lock", null)�){
								if(�aiName�.�invokeGetter(attrConfig.attribute.name+"Lock", null)�.isUpdate()){
									�FOR entry : attrConfig.allAttributes.entrySet�
										if(_�entry.key.name� != null){
											�aiName��entry.value.toInvoke�.�invokeSetter(entry.key.name, null, "_"+entry.key.name)�;
											getDiffMap().put("�attrConfig.getPath(true, true, true, false).toPath("/")+entry.value.toPath("/")+"/"+entry.key.name�", _�entry.key.name�);
										}
									�ENDFOR�
								} 
							}
					}catch(IllegalArgumentException e){
						error(id, e);
					}
				�ENDFOR�
			}
			
			@Override
			protected Map<String, Object> getAttributeValues(){
				Map<String, Object> values = new HashMap<String, Object>();
				�FOR attrConfig : cc.getAttrDynConfigs(true, false)�
					�var aiName = (attrConfig.eContainer as ActorInstanceConfig).path.refs.toPath("_")�
					�FOR entry : attrConfig.allAttributes.entrySet�
						�var array = entry.key.size>0�
						�var aPath = attrConfig.getPath(true, true, true, false).toPath("/")+entry.value.toPath("/")+"/"+entry.key.name�
						values.put("�aPath�", �IF array�toObjectArray(�ENDIF��aiName��entry.value.toInvoke�.�invokeGetter(entry.key.name, null)��IF array�)�ENDIF�);
					�ENDFOR�
				�ENDFOR�
				
				return values;
			}
			
			@Override
			public void writeDataClass(String id, Object dcObject, Map<String, Object> writeMap) {
				�FOR dc : comp.dynDataClasses�
					if(dcObject.getClass().equals(�dc.typeName�.class))
						writeDataClass(id, (�dc.typeName�) dcObject, writeTasks);
				�ENDFOR�
			}
			
			// DataClasses write operations
			
			�FOR dc : comp.allDynDataClasses�
				private void writeDataClass(String id, �dc.typeName� object, Map<String, Object> map){
					�FOR a : dc.attributes�
						�IF a.refType.type.primitive�
							map.put(id+"/�a.name�", �IF a.size>0�toObjectArray(�ENDIF�object.�invokeGetter(a.name, null)��IF a.size>0�)�ENDIF�);
						�ELSE�
							writeDataClass(id+"/�a.name�", object.�invokeGetter(a.name, null)�, map);
						�ENDIF�
					�ENDFOR�
				}
			�ENDFOR�
			
			@Override
			protected int getPollingTimerUser(){
				return �dynConfig.polling�;
			}
			
		}
	'''}
	
	def private genMinMaxCheck(AttrInstanceConfig instConf, ActorClassConfig acConf){
		var config = acConf?.resolve(instConf.getPath(false, false, true, true))
		if(config?.min == null && config?.max == null)
			return ''''''
		var path = config.getPath(false, false, true, true).toPath("_")
		var acName = (config.eContainer as ActorClassConfig).actor.name
		'''
			checkMinMax(_�config.attribute.name�, �IF config.min != null��acName�.MIN�path��ELSE�null�ENDIF�, �IF config.max != null��acName�.MAX�path��ELSE�null�ENDIF�);
		'''
	}
		
	def private Map<Attribute, List<String>> getAllAttributes(AttrInstanceConfig config){
		var map = new HashMap<Attribute, List<String>>()
		if(config.attribute.refType.type.primitive)
			map.put(config.attribute, new ArrayList<String>())
		else
			config.attribute.getAllAttributes(new LinkedList<String>(), map)
		
		return map
	}
	
	def private void getAllAttributes(Attribute attribute, List<String> path, Map<Attribute, List<String>> map){
		if(attribute.refType.type.primitive)
			map.put(attribute, path)
		else if (attribute.refType.type.dataClass){
			var new_path = new ArrayList<String>(path)
			new_path.add(attribute.name)
			for(dc : (attribute.refType.type as DataClass).allAttributes)
				dc.getAllAttributes(new_path, map)
		}
	}
	
	def private String toInvoke(List<String> path){
		var builder = new StringBuilder()
		for(p : path)
			builder.append("."+p.invokeGetter(null))
			
		return builder.toString
	}
	
	def private List<ActorInstance> dynConfigsAIs(SubSystemInstance comp){
		val aiPaths = new HashSet<String>();
		for(attrConfig : comp.subSystemClass.dynConfigReadAttributes)
			aiPaths.add(attrConfig.getPath(true, true, false, false).toPath("/"))
		
		var ais = new ArrayList<ActorInstance>();
		for(ai : comp.allContainedInstances)
			if(aiPaths.contains(ai.path))
				ais.add(ai);

		return ais
	}
	
	
	def private getDynDataClasses(SubSystemInstance comp){
		var dcs = new HashSet<DataClass>()
		for(config : comp.subSystemClass.getAttrDynConfigs(false, true))
			if(config.attribute.refType.type.dataClass)
				dcs.add(config.attribute.refType.type as DataClass)
		
		return dcs
	}
	
	def private getAllDynDataClasses(SubSystemInstance comp){
		var dcs = new HashSet<DataClass>()
		var stack = new LinkedList<DataClass>()
		stack.addAll(comp.dynDataClasses)
		dcs.addAll(stack)
		while(!stack.empty){
			var dc = stack.pop
			for(a : dc.allAttributes)
				if(a.refType.type.dataClass){
					dcs.add(a.refType.type as DataClass)
					stack.push(a.refType.type as DataClass);
				}
		}		
		
		return dcs
	}
	
	def private resolve(ActorClassConfig config, String[] path){
		var result = config.attributes.findFirst(c | c.attribute.name.equals(path.head))
		for (String ref : path.tail) {
			result = result?.attributes.findFirst(c | c.attribute.name.equals(ref))
			if (result == null)
				return null
		}

		return result
	}
	
	def private getRoomModels(List<ActorInstance> ais){
		val models = new HashSet<RoomModel>
		ais.forEach(ai | models.add(ai.actorClass.eContainer as RoomModel))
		return models
	}
	
	*/
}