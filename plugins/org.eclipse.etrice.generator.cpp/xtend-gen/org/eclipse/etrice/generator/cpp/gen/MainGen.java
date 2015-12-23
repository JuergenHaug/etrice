/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Peter Karlitschek
 */
package org.eclipse.etrice.generator.cpp.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.generator.cpp.gen.ActorClassGen;
import org.eclipse.etrice.generator.cpp.gen.DataClassGen;
import org.eclipse.etrice.generator.cpp.gen.NodeGen;
import org.eclipse.etrice.generator.cpp.gen.NodeRunnerGen;
import org.eclipse.etrice.generator.cpp.gen.ProtocolClassGen;
import org.eclipse.etrice.generator.generic.PrepareFileSystem;

@Singleton
@SuppressWarnings("all")
public class MainGen {
  @Inject
  private DataClassGen dataClassGen;
  
  @Inject
  private ProtocolClassGen protocolClassGen;
  
  @Inject
  private ActorClassGen actorClassGen;
  
  @Inject
  private NodeGen subsystemClassGen;
  
  @Inject
  private NodeRunnerGen subsystemRunnerGen;
  
  @Inject
  private PrepareFileSystem prepFS;
  
  public void doGenerate(final Resource resource) {
    this.prepFS.prepareCodeTargetPaths(resource);
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
