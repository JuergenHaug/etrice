/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Thomas Schuetz (changed for C code generator)
 */
package org.eclipse.etrice.generator.c.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.generator.c.gen.ActorClassGen;
import org.eclipse.etrice.generator.c.gen.DataClassGen;
import org.eclipse.etrice.generator.c.gen.ProtocolClassGen;
import org.eclipse.etrice.generator.c.gen.SubSystemClassGen;
import org.eclipse.etrice.generator.c.gen.SubSystemRunnerGen;
import org.eclipse.etrice.generator.generic.PrepareFileSystem;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

@Singleton
@SuppressWarnings("all")
public class MainGen implements IGenerator {
  @Inject
  private DataClassGen dataClassGen;
  
  @Inject
  private ProtocolClassGen protocolClassGen;
  
  @Inject
  private ActorClassGen actorClassGen;
  
  @Inject
  private SubSystemClassGen subsystemClassGen;
  
  @Inject
  private SubSystemRunnerGen subsystemRunnerGen;
  
  @Inject
  private PrepareFileSystem prepFS;
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    this.prepFS.prepare(resource);
    EList<EObject> _contents = resource.getContents();
    for (final EObject e : _contents) {
      if ((e instanceof Root)) {
        this.doGenerate(((Root) e));
      }
    }
  }
  
  public void doGenerate(final Root e) {
    this.dataClassGen.doGenerate(e);
    this.protocolClassGen.doGenerate(e);
    this.actorClassGen.doGenerate(e);
    this.subsystemClassGen.doGenerate(e);
    boolean _isLibrary = e.isLibrary();
    boolean _not = (!_isLibrary);
    if (_not) {
      this.subsystemRunnerGen.doGenerate(e);
    }
  }
}
