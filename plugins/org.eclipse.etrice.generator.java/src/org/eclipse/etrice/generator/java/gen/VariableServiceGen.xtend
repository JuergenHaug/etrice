/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
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
import java.util.Collection
import java.util.HashMap
import java.util.HashSet
import java.util.LinkedList
import java.util.List
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.generator.base.IDataConfiguration
import org.eclipse.etrice.generator.base.IGeneratorFileIo
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.TypeHelpers

import static extension org.eclipse.etrice.core.room.util.RoomHelpers.*
import org.eclipse.etrice.core.etmap.util.ETMapUtil
import org.eclipse.etrice.core.common.converter.TimeConverter

@Singleton
class VariableServiceGen {
	
	@Inject IGeneratorFileIo fileIO
	@Inject extension JavaExtensions stdExt
	@Inject extension RoomExtensions roomExt
	@Inject IDataConfiguration configExt
	@Inject extension ProcedureHelpers helpers
	@Inject extension TypeHelpers
	 
	def doGenerate(Root root, SubSystemInstance ssi) {
		val nr = ETMapUtil::getNodeRef(ssi)
		val clsname = nr.getJavaClassName(ssi)
		val path = ssi.subSystemClass.generationTargetPath+ssi.subSystemClass.getPath
		val infopath = ssi.subSystemClass.generationInfoPath+ssi.subSystemClass.getPath
		val file = clsname+"VariableService.java"
		fileIO.generateFile("generating VariableService implementation", path, infopath, file, root.generate(ssi))
	}
	
	def private generate(Root root, SubSystemInstance comp) {
		val nr = ETMapUtil::getNodeRef(comp)
		val clsname = nr.getJavaClassName(comp)
		val aisAttrMap = new HashMap<ActorInstance, List<Attribute>>
		comp.allContainedInstances.forEach(ai | if(!configExt.getDynConfigReadAttributes(ai).empty)aisAttrMap.put(ai, configExt.getDynConfigReadAttributes(ai)))
	'''
		
		package �comp.subSystemClass.getPackage()�;
		
		import java.util.Arrays;
		import java.util.HashMap;
		import java.util.Map;
		import org.eclipse.etrice.runtime.java.config.AbstractVariableService;
		�configExt.getUserCode1(comp)�
		�FOR model : aisAttrMap.keySet.roomModels�
			import �model.name�.*;
		�ENDFOR�
		
		
		public class �clsname�VariableService extends AbstractVariableService{
			
			private �clsname� subSystem;
			
			// Actor instances
			�FOR ai : aisAttrMap.keySet�
				private �ai.actorClass.name� �ai.varName�;
			�ENDFOR�
			
			public �clsname�VariableService(�clsname� subSystem) {
				super(�configExt.getUserCode2(comp)�);
				this.subSystem = subSystem;
			}
			
			@Override
			protected void initInstances(){
				�FOR ai : aisAttrMap.keySet�
					�ai.varName� = (�ai.actorClass.name�)subSystem.getInstance("�ai.path�");
				�ENDFOR�
			}
			
		
			@Override
			protected void setAttributeValues(Map<String, Object> values) {
				Object object;
				String id = null;
				
				�FOR ai : aisAttrMap.keySet�
					�FOR a : aisAttrMap.get(ai)�
						try{
							boolean changed = false;
							�genSetAttributeValues1(new ArrayList<Attribute>.union(a), ai)�
							if(changed)
								synchronized(�ai.varName�.�invokeGetter(a.name+"Lock", null)�){
									if(�ai.varName�.�invokeGetter(a.name+"Lock", null)�.isUpdate()){
										�genSetAttributeValues2(new ArrayList<Attribute>.union(a), ai)�
									}
								}
						}catch(IllegalArgumentException e){
							error(id, e);
						}
					�ENDFOR�
				�ENDFOR�
			}
			
			@Override
			protected Map<String, Object> getAttributeValues(){
				Map<String, Object> values = new HashMap<String, Object>();
				�FOR ai : aisAttrMap.keySet�
					�FOR a : aisAttrMap.get(ai)�
						�genGetAttributeValues(new ArrayList<Attribute>.union(a), ai)�
					�ENDFOR�
				�ENDFOR�
				
				return values;
			}
			
			@Override
			public void writeDataClass(String id, Object dcObject, Map<String, Object> writeMap) {
				�var dataClasses = aisAttrMap.keySet.dynConfigDataClasses�
				�FOR dc : dataClasses�
					if(dcObject.getClass().equals(�dc.typeName�.class))
						writeDataClass(id, (�dc.typeName�) dcObject, writeTasks);
				�ENDFOR�
			}
			
			// DataClasses write operations
			
			�FOR dc : getAllDataClasses(dataClasses)�
				private void writeDataClass(String id, �dc.typeName� object, Map<String, Object> map){
					�FOR a : dc.allAttributes�
						�IF a.type.type.enumerationOrPrimitive�
							map.put(id+"/�a.name�", �IF a.size>0�toObjectArray(�ENDIF�object.�invokeGetter(a.name, null)��IF a.size>0�)�ENDIF�);
						�ELSE�
							writeDataClass(id+"/�a.name�", object.�invokeGetter(a.name, null)�, map);
						�ENDIF�
					�ENDFOR�
				}
			�ENDFOR�
			
			@Override
			protected int getPollingTimerUser(){
				return �TimeConverter::split(configExt.getPollingTimerUser(comp), TimeConverter.MILLI_SEC, true)�;
			}
			
		}
	'''}
	
	def private genMinMaxCheck(List<Attribute> path, ActorClass ac){
		var a = path.last
		var aVarName = path.toAbsolutePath("_")
		var min = configExt.getAttrClassConfigMinValue(ac, path) != null
		var max = configExt.getAttrClassConfigMaxValue(ac, path) != null
		if(min || max)
			'''
				�IF a.size>0�for(�a.type.type.typeName� e : �aVarName�)
					�ENDIF�checkMinMax(�IF a.size>0�e�ELSE��aVarName��ENDIF�, �IF min��ac.name�.MIN�aVarName��ELSE�null�ENDIF�, �IF max��ac.name�.MAX�aVarName��ELSE�null�ENDIF�);
			'''
	}

	def private getDynConfigDataClasses(Iterable<ActorInstance> ais){
		val result = new HashSet<DataClass>
		ais.forEach(ai | configExt.getDynConfigReadAttributes(ai).
			forEach(a | if(a.type.type.dataClass)result.add(a.type.type as DataClass)
			))
		return result
	}
	
	def private getAllDataClasses(Iterable<DataClass> dcs){
		val result = new HashSet<DataClass>
		result.addAll(dcs)
		val visit = new LinkedList<DataClass>
		visit.addAll(dcs)
		while(!visit.empty){
			var dc = visit.pop
			dc.allAttributes.forEach(a | if(a.type.type.dataClass)visit.add(a.type.type as DataClass))
		}
		return result
	}
	
	def private getRoomModels(Collection<ActorInstance> ais){
		val models = new HashSet<RoomModel>
		ais.forEach(ai | models.add(ai.actorClass.eContainer as RoomModel))
		return models
	}
	
	def private toAbsolutePath(List<Attribute> path, String pathDelim){
		'''�FOR p : path��pathDelim��p.name��ENDFOR�'''.toString
	}
	
	def private getVarName(ActorInstance ai){
		'''�FOR p : ai.path.split('/').drop(2) SEPARATOR '_'��p��ENDFOR�'''
	}
	
	def private CharSequence genGetAttributeValues(List<Attribute> path, ActorInstance ai){
		val a = path.last
		
		if (a.type.type.enumerationOrPrimitive) {
			'''
				values.put("�ai.path��path.toAbsolutePath('/')�", �IF a.size>0�toObjectArray(�ENDIF��ai.varName�.�path.invokeGetters(null)��IF a.size>0�)�ENDIF�);
			'''
		}
		else if (a.type.type.dataClass) {
			var dataClass = (a.type.type as DataClass)
			'''
				�FOR at : dataClass.allAttributes�
					�genGetAttributeValues(path.union(at), ai)�
				�ENDFOR�
			'''
		}
	}
	
	def private CharSequence genSetAttributeValues1(List<Attribute> path, ActorInstance ai){
		var a = path.last
		var aVarName = path.toAbsolutePath("_")
		
		if(a.type.type.enumerationOrPrimitive){'''
			id = "�ai.path��path.toAbsolutePath("/")�";
			�IF a.size==0��a.type.type.typeName.toWrapper��ELSE��a.type.type.typeName�[]�ENDIF� �aVarName� = null;
			object = values.get(id);
			if(object != null){
				�aVarName� = ensure�a.type.type.typeName.toFirstUpper��IF a.size>0�Array�ENDIF�(object�IF a.size>0�, �a.size��ENDIF�);
				�genMinMaxCheck(path, ai.actorClass)�
				if(!�IF a.size==0��aVarName�.equals(�ELSE�Arrays.equals(�aVarName�, �ENDIF�(�IF a.size==0��a.type.type.typeName.toWrapper��ELSE��a.type.type.typeName�[]�ENDIF�)getDiffMap().get(id)))
					changed = true;
			} else
				warning(id, "is missing");
		'''
		} else if(a.type.type.dataClass){
			var dataClass = (a.type.type as DataClass)
			'''
				�FOR at : dataClass.allAttributes�
					�genSetAttributeValues1(path.union(at), ai)�
				�ENDFOR�
			'''
		}
	}
	
	def private CharSequence genSetAttributeValues2(List<Attribute> path, ActorInstance ai){
		var a = path.last 
		var aVarName = path.toAbsolutePath("_")
		
		if (a.type.type.enumerationOrPrimitive) {
			val getters = if(path.size>1)path.take(path.size-1).invokeGetters(null)+"." else ""
			'''
				if(�aVarName� != null){
					�ai.varName�.�getters��invokeSetter(a.name, null, aVarName)�;
					getDiffMap().put("�ai.path��path.toAbsolutePath("/")�", �aVarName�);
				}
			'''
		} else if (a.type.type.dataClass) {
			val dataClass = (a.type.type as DataClass)
			'''
				�FOR at : dataClass.allAttributes�
					�genSetAttributeValues2(path.union(at), ai)�
				�ENDFOR�
			'''
		}
	}
}
