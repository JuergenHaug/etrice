package org.eclipse.etrice.generator.generic;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class GenericActorClassGenerator {
  @Inject
  private ILanguageExtension langExt;
  
  @Inject
  private RoomExtensions roomExt;
  
  public String genInterfaceItemConstants(final ExpandedActorClass xpac, final ActorClass ac) {
      List<Port> _xifexpression = null;
      boolean _usesInheritance = this.langExt.usesInheritance();
      if (_usesInheritance) {
        List<Port> _endPorts = this.roomExt.getEndPorts(ac);
        _xifexpression = _endPorts;
      } else {
        List<Port> _allEndPorts = this.roomExt.getAllEndPorts(ac);
        _xifexpression = _allEndPorts;
      }
      List<Port> endPorts = _xifexpression;
      List<SAPRef> _xifexpression_1 = null;
      boolean _usesInheritance_1 = this.langExt.usesInheritance();
      if (_usesInheritance_1) {
        EList<SAPRef> _strSAPs = ac.getStrSAPs();
        _xifexpression_1 = _strSAPs;
      } else {
        List<SAPRef> _allSAPs = this.roomExt.getAllSAPs(ac);
        _xifexpression_1 = _allSAPs;
      }
      List<SAPRef> strSAPs = _xifexpression_1;
      List<ServiceImplementation> _xifexpression_2 = null;
      boolean _usesInheritance_2 = this.langExt.usesInheritance();
      if (_usesInheritance_2) {
        EList<ServiceImplementation> _serviceImplementations = ac.getServiceImplementations();
        _xifexpression_2 = _serviceImplementations;
      } else {
        List<ServiceImplementation> _allServiceImplementations = this.roomExt.getAllServiceImplementations(ac);
        _xifexpression_2 = _allServiceImplementations;
      }
      List<ServiceImplementation> svcImpls = _xifexpression_2;
      ArrayList<Pair<String,String>> _arrayList = new ArrayList<Pair<String,String>>();
      ArrayList<Pair<String,String>> list = _arrayList;
      for (final Port ep : endPorts) {
        String _name = ep.getName();
        String _operator_plus = StringExtensions.operator_plus("IFITEM_", _name);
        int _interfaceItemLocalId = xpac.getInterfaceItemLocalId(ep);
        int _operator_plus_1 = IntegerExtensions.operator_plus(((Integer)1), ((Integer)_interfaceItemLocalId));
        String _string = ((Integer)_operator_plus_1).toString();
        Pair<String,String> _pair = Tuples.<String, String>pair(_operator_plus, _string);
        list.add(_pair);
      }
      for (final SAPRef sap : strSAPs) {
        String _name_1 = sap.getName();
        String _operator_plus_2 = StringExtensions.operator_plus("IFITEM_", _name_1);
        int _interfaceItemLocalId_1 = xpac.getInterfaceItemLocalId(sap);
        int _operator_plus_3 = IntegerExtensions.operator_plus(((Integer)1), ((Integer)_interfaceItemLocalId_1));
        String _string_1 = ((Integer)_operator_plus_3).toString();
        Pair<String,String> _pair_1 = Tuples.<String, String>pair(_operator_plus_2, _string_1);
        list.add(_pair_1);
      }
      for (final ServiceImplementation svc : svcImpls) {
        SPPRef _spp = svc.getSpp();
        String _name_2 = _spp.getName();
        String _operator_plus_4 = StringExtensions.operator_plus("IFITEM_", _name_2);
        SPPRef _spp_1 = svc.getSpp();
        int _interfaceItemLocalId_2 = xpac.getInterfaceItemLocalId(_spp_1);
        int _operator_plus_5 = IntegerExtensions.operator_plus(((Integer)1), ((Integer)_interfaceItemLocalId_2));
        String _string_2 = ((Integer)_operator_plus_5).toString();
        Pair<String,String> _pair_2 = Tuples.<String, String>pair(_operator_plus_4, _string_2);
        list.add(_pair_2);
      }
      String _genEnumeration = this.langExt.genEnumeration("interface_items", list);
      return _genEnumeration;
  }
}
