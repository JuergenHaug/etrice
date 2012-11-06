package org.eclipse.etrice.core.config

import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.etrice.core.ConfigStandaloneSetup
import org.eclipse.etrice.core.genmodel.base.ILogger
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.SubSystemClass
import org.eclipse.etrice.generator.base.IDataConfiguration

class DataConfiguration implements IDataConfiguration {
	

	override doSetup() {
		ConfigStandaloneSetup::doSetup()
	}
	
	override setResources(ResourceSet resource, ILogger logger) {
		DataConfigurationHelper::setConfigModels(resource, logger)
	}
	
	// static
	
	override getAttrClassConfigValue(ActorClass actor, List<Attribute> path) {
		actor.getAttrClassConfig(path)?.value?.toStringExpr
	}
	
	override getAttrClassConfigMaxValue(ActorClass actor, List<Attribute> path) {
		actor.getAttrClassConfig(path)?.min?.toStringExpr
	}
	
	override getAttrClassConfigMinValue(ActorClass actor, List<Attribute> path) {
		actor.getAttrClassConfig(path)?.max?.toStringExpr
	}
	
	def private getAttrClassConfig(ActorClass actor, List<Attribute> path){
		var id = '''/�actor.name�/�path.toStringPath�'''.toString
		DataConfigurationHelper::actorClassAttrMap.get(id)
	}
	
	override getAttrClassConfigValue(ProtocolClass pc, boolean regular, List<Attribute> path) {
		var id = '''/�pc.name�/�IF regular�regular�ELSE�conjugated�ENDIF�/�path.toStringPath�'''.toString
		DataConfigurationHelper::protocolClassAttrMap.get(id)?.value?.toStringExpr
	}
	
	def private toStringPath(List<Attribute> path){
		'''�FOR a : path SEPARATOR '/'��a.name��ENDFOR�'''.toString
	}
	
	override getAttrInstanceConfigValue(ActorInstance ai, List<Attribute> path) {
		var id = ai.path+"/"+path.toStringPath
		DataConfigurationHelper::actorInstanceAttrMap.get(id)?.value?.toStringExpr
	}
	
	// dynamic
	
	override getPollingTimerUser(SubSystemClass subsystem) {
		 subsystem.config?.dynConfig?.polling
	}
	
	override getUserCode1(SubSystemClass subsystem) {
		var dynConfig = subsystem.config?.dynConfig
		return 
			if(dynConfig?.filePath != null)
				"import org.eclipse.etrice.runtime.java.config.ConfigSourceFile; // TODO JH make lang independent"
			else 
				dynConfig?.userCode1
	}
	
	override getUserCode2(SubSystemClass subsystem) {
		var dynConfig = subsystem.config?.dynConfig
		return 
			if(dynConfig?.filePath != null)
				'''new ConfigSourceFile("�dynConfig.filePath�")'''
			else 
				dynConfig?.userCode2
	}
	
	override getDynConfigReadAttributes(String actorInstance) {
		val result = new ArrayList<Attribute>
		var configs = DataConfigurationHelper::dynActorInstanceAttrMap.get(actorInstance)
		configs?.forEach(c | if(c.readOnly)result.add(c.attribute))
		
		return result
	}
	
	override getDynConfigWriteAttributes(String actorInstance) {
		val result = new ArrayList<Attribute>
		var configs = DataConfigurationHelper::dynActorInstanceAttrMap.get(actorInstance)
		configs?.forEach(c | if(!c.readOnly)result.add(c.attribute))
		
		return result
	}
	
	
	override hasVariableService(SubSystemClass subsystem) {
		subsystem.config?.dynConfig != null
	}
	
	def private toStringExpr(LiteralArray literal){
		'''�FOR l : literal.literals SEPARATOR ','��l.toStringExpr��ENDFOR�'''.toString
	}
	
	def private toStringExpr(Literal literal){
		switch(literal){
			BooleanLiteral: literal.isTrue.toString
			IntLiteral: literal.value.toString
			RealLiteral: literal.value.toString
			StringLiteral: literal.value.toString
		}
	}

	def private getConfig(SubSystemClass cc){
		DataConfigurationHelper::subSystemConfigMap.get(cc)
	}	

	override getDynConfigReadAttributes(ActorClass actor) {
		val result = new ArrayList<Attribute>
		var configs = DataConfigurationHelper::dynActorClassAttrMap.get(actor)
		configs?.forEach(c | if(c.readOnly)result.add(c.attribute))
		return result
	}
	
	override getDynConfigWriteAttributes(ActorClass actor) {
		val result = new ArrayList<Attribute>
		var configs = DataConfigurationHelper::dynActorClassAttrMap.get(actor)
		configs?.forEach(c | if(!c.readOnly)result.add(c.attribute))
		return result
	}
	
}