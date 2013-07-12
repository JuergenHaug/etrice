/**
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 */
package org.eclipse.etrice.generator.generic;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * Target language independent part of an actor class generator.
 * It uses the {@link ILanguageExtension}.
 */
@SuppressWarnings("all")
public class GenericActorClassGenerator {
  @Inject
  @Extension
  protected RoomExtensions _roomExtensions;
  
  @Inject
  protected ILanguageExtension langExt;
  
  /**
   * Generate constants for the local IDs of all interface items of an actor
   * class.
   * 
   * @param xpac an {@link ExpandedActorClass}
   * @return the generated code
   */
  public String genInterfaceItemConstants(final ExpandedActorClass xpac) {
    final ActorClass ac = xpac.getActorClass();
    List<Port> _xifexpression = null;
    boolean _usesInheritance = this.langExt.usesInheritance();
    if (_usesInheritance) {
      List<Port> _endPorts = RoomHelpers.getEndPorts(ac);
      _xifexpression = _endPorts;
    } else {
      List<Port> _allEndPorts = RoomHelpers.getAllEndPorts(ac);
      _xifexpression = _allEndPorts;
    }
    List<Port> endPorts = _xifexpression;
    List<SAPRef> _xifexpression_1 = null;
    boolean _usesInheritance_1 = this.langExt.usesInheritance();
    if (_usesInheritance_1) {
      EList<SAPRef> _strSAPs = ac.getStrSAPs();
      _xifexpression_1 = _strSAPs;
    } else {
      List<SAPRef> _allSAPs = RoomHelpers.getAllSAPs(ac);
      _xifexpression_1 = _allSAPs;
    }
    List<SAPRef> strSAPs = _xifexpression_1;
    List<ServiceImplementation> _xifexpression_2 = null;
    boolean _usesInheritance_2 = this.langExt.usesInheritance();
    if (_usesInheritance_2) {
      EList<ServiceImplementation> _serviceImplementations = ac.getServiceImplementations();
      _xifexpression_2 = _serviceImplementations;
    } else {
      List<ServiceImplementation> _allServiceImplementations = RoomHelpers.getAllServiceImplementations(ac);
      _xifexpression_2 = _allServiceImplementations;
    }
    List<ServiceImplementation> svcImpls = _xifexpression_2;
    ArrayList<Pair<String,String>> _arrayList = new ArrayList<Pair<String,String>>();
    ArrayList<Pair<String,String>> list = _arrayList;
    for (final Port ep : endPorts) {
      String _name = ep.getName();
      String _plus = ("IFITEM_" + _name);
      int _interfaceItemLocalId = xpac.getInterfaceItemLocalId(ep);
      int _plus_1 = (1 + _interfaceItemLocalId);
      String _string = Integer.valueOf(_plus_1).toString();
      Pair<String,String> _pair = Tuples.<String, String>pair(_plus, _string);
      list.add(_pair);
    }
    for (final SAPRef sap : strSAPs) {
      String _name_1 = sap.getName();
      String _plus_2 = ("IFITEM_" + _name_1);
      int _interfaceItemLocalId_1 = xpac.getInterfaceItemLocalId(sap);
      int _plus_3 = (1 + _interfaceItemLocalId_1);
      String _string_1 = Integer.valueOf(_plus_3).toString();
      Pair<String,String> _pair_1 = Tuples.<String, String>pair(_plus_2, _string_1);
      list.add(_pair_1);
    }
    for (final ServiceImplementation svc : svcImpls) {
      SPPRef _spp = svc.getSpp();
      String _name_2 = _spp.getName();
      String _plus_4 = ("IFITEM_" + _name_2);
      SPPRef _spp_1 = svc.getSpp();
      int _interfaceItemLocalId_2 = xpac.getInterfaceItemLocalId(_spp_1);
      int _plus_5 = (1 + _interfaceItemLocalId_2);
      String _string_2 = Integer.valueOf(_plus_5).toString();
      Pair<String,String> _pair_2 = Tuples.<String, String>pair(_plus_4, _string_2);
      list.add(_pair_2);
    }
    return this.langExt.genEnumeration("interface_items", list);
  }
}
