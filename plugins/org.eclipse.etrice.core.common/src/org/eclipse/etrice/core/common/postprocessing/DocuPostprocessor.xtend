/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 		Eyrak Paen
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.postprocessing

import org.eclipse.xtext.GeneratedMetamodel

import static extension org.eclipse.etrice.core.common.postprocessing.PostprocessingHelpers.*

class DocuPostprocessor {
	def process(GeneratedMetamodel metamodel) {
		val pckg = metamodel.EPackage
		
		//------------------------------------------------------------------
		var cls = pckg.getClass("LiteralArray")
		cls.setDocumentation(
			'''
				Aggregates one or more {@link Literal literals}.		
			''')
			
		cls.getReference("literals").setDocumentation(
			'''
				This is a list of literals.
			''')
			
		//------------------------------------------------------------------
		
		cls = pckg.getClass("Literal")
		cls.setDocumentation(
			'''
				It is the super class of
				<ul>
					<li>{@link BooleanLiteral}</li>
					<li>{@link NumberLiteral}</li>
					<li>{@link StringLiteral}</li>
				</ul>
				that represents a primitive value.
			''')
			
		//------------------------------------------------------------------
		cls = pckg.getClass("Documentation")
		cls.setDocumentation('''
			A piece of documentation that can be optionally attached at
			certain places in the model.
		''')
		
		cls.getAttribute("lines").setDocumentation(
			'''
				This is the documentation's contents.
			''')

		//------------------------------------------------------------------
		cls = pckg.getClass("Annotation")
		cls.setDocumentation('''
			An annotation similar to Java annotations that can be used
			to add {@link KeyValue} pairs to certain model items. The structure 
			of Annotations are defined by {@AnnotationType}s.
		''')
		
		cls.getReference("type").setDocumentation(
			'''
				The {@AnnotationType} that defines the structure of 
				the annotation.
			''')
		
		cls.getReference("attributes").setDocumentation(
			'''
				This is a list of key/value pairs.
			''')

		//------------------------------------------------------------------
		cls = pckg.getClass("KeyValue")
		cls.setDocumentation('''
			A key/value pair.
		''')
		
		cls.getAttribute("key").setDocumentation(
			'''
				This is the key of the pair.
			''')
		
		cls.getReference("value").setDocumentation(
			'''
				This is the value of the pair.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("AnnotationType")
		cls.setDocumentation(
			'''Defines the structure of {@link Annotation}s.'''
		)
		cls.getAttribute("name").setDocumentation(
			'''The name of the AnnotationType'''
		)
		cls.getAttribute("targets").setDocumentation(
			'''A list of names representing the locations in which 
			{@Annotation}s of this AnnotationType can occur'''
		)
		cls.getReference("docu").setDocumentation(
			'''Optional model-level documentation'''
		)
		cls.getReference("attributes").setDocumentation(
			'''Defines the {@link Attribute}s that are required or allowed in 
			{@Annotation} instances of this AnnotationType'''
		)
				
		//------------------------------------------------------------------
		cls = pckg.getClass("AnnotationAttribute")
		cls.setDocumentation(
			'''Defines an attribute in an {@link AnnotationType}. This attribute 
			can then be declared in respective {@link Annotation} instances.'''
		)
		cls.getAttribute("optional").setDocumentation(
			'''Specifies whether the attribute should be optional or not. If the 
			attribute is optional, it can be omitted by {@link Annotation}s of 
			the same {@link AnnotationType}.
			'''
		)
		cls.getAttribute("name").setDocumentation(
			'''The name of the attribute'''
		)
		
		//------------------------------------------------------------------
		cls = pckg.getClass("SimpleAnnotationAttribute")
		cls.setDocumentation(
			'''An {@link AnnotationAttribute} that is associated with a 
			{@link LiteralType}.'''
		)
		cls.getAttribute("type").setDocumentation(
			'''The type of the attribute'''
		)
		
		//------------------------------------------------------------------
		cls = pckg.getClass("EnumAnnotationAttribute")
		cls.setDocumentation(
			'''An {@link AnnotationAttribute} whose possible values are defined 
			by a list of String values.'''
		)
		cls.getAttribute("values").setDocumentation(
			'''A list of values that define the enumeration'''
		)
		
		
	}
}