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
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.generator.base.CodegenHelpers;
import org.eclipse.etrice.generator.cpp.gen.ProtocolClassGen;
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Peter Karlitschek
 */
@Singleton
@SuppressWarnings("all")
public class StateMachineGen extends GenericStateMachineGenerator {
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  @Inject
  private ProtocolClassGen cppProtGen;
  
  public CharSequence genExtraDecl(final ExpandedActorClass xpac) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected:");
    _builder.newLine();
    _builder.append(" \t");
    _builder.append("static std::string s_stateStrings[];");
    _builder.newLine();
    _builder.append(" \t");
    _builder.append("static const int s_numberOfStates;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("private:");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("void setState(int new_state);");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence genExtra(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("std::string ");
      String _name = ac.getName();
      _builder.append(_name, "");
      _builder.append("::s_stateStrings[] = {\"<no state>\",\"<top>\",");
      {
        List<State> _allBaseStatesLeavesLast = this._roomExtensions.getAllBaseStatesLeavesLast(ac);
        boolean _hasElements = false;
        for(final State state : _allBaseStatesLeavesLast) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "");
          }
          _builder.append("\"");
          String _genStatePathName = CodegenHelpers.getGenStatePathName(state);
          _builder.append(_genStatePathName, "");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("};");
      _builder.newLineIfNotEmpty();
      _builder.append("const int ");
      String _name_1 = ac.getName();
      _builder.append(_name_1, "");
      _builder.append("::s_numberOfStates = ");
      List<State> _allBaseStatesLeavesLast_1 = this._roomExtensions.getAllBaseStatesLeavesLast(ac);
      int _size = _allBaseStatesLeavesLast_1.size();
      int _plus = (_size + 2);
      _builder.append(_plus, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("void ");
      String _name_2 = ac.getName();
      _builder.append(_name_2, "");
      _builder.append("::setState(int new_state) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("DebuggingService::getInstance().addActorState(*this, s_stateStrings[new_state]);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (s_stateStrings[new_state]!=\"Idle\") {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("std::cout << getInstancePath() << \" -> \" << s_stateStrings[new_state] << std::endl;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("m_state = new_state;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public String genTriggerConstants(final ExpandedActorClass xpac) {
    EList<MessageFromIf> _xifexpression = null;
    boolean _usesInheritance = this.langExt.usesInheritance();
    if (_usesInheritance) {
      _xifexpression = xpac.getOwnTriggers();
    } else {
      _xifexpression = xpac.getTriggers();
    }
    final EList<MessageFromIf> triggers = _xifexpression;
    final ArrayList<Pair<String,String>> list = new ArrayList<Pair<String, String>>();
    Pair<String,String> _pair = Tuples.<String, String>pair("POLLING", "0");
    list.add(_pair);
    for (final MessageFromIf mif : triggers) {
      String _triggerCodeName = xpac.getTriggerCodeName(mif);
      InterfaceItem _from = mif.getFrom();
      String _name = _from.getName();
      String _plus = ("IFITEM_" + _name);
      String _plus_1 = (_plus + " + EVT_SHIFT*");
      String _messageID = this.cppProtGen.getMessageID(mif);
      String _plus_2 = (_plus_1 + _messageID);
      Pair<String,String> _pair_1 = Tuples.<String, String>pair(_triggerCodeName, _plus_2);
      list.add(_pair_1);
    }
    return this.langExt.genEnumeration("triggers", list);
  }
  
  public String constPointer(final String classname) {
    return (("const " + classname) + "*");
  }
  
  public String boolType() {
    return "bool";
  }
}
