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

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.Guard;
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.util.ETriceGenUtil;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedRefinedState;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.TransitionChain;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.CodegenHelpers;
import org.eclipse.etrice.generator.generic.GenericProtocolClassGenerator;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TransitionChainGenerator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * A target language independent generator of the state machine implementation-
 */
@SuppressWarnings("all")
public class GenericStateMachineGenerator {
  @Inject
  @Extension
  protected RoomHelpers _roomHelpers;
  
  @Inject
  @Extension
  protected ETriceGenUtil _eTriceGenUtil;
  
  @Inject
  @Extension
  protected CodegenHelpers _codegenHelpers;
  
  @Inject
  @Extension
  protected RoomExtensions _roomExtensions;
  
  @Inject
  protected ILanguageExtension langExt;
  
  @Inject
  protected GenericProtocolClassGenerator pcGen;
  
  @Inject
  protected TransitionChainGenerator transitionChainGenerator;
  
  /**
   * generates state ID constants.
   * Inheritance (if available) is used for base class IDs.
   * 
   * @param xpac the {@link ExpandedActorClass}
   * @return the generated code
   */
  protected String genStateIdConstants(final ExpandedActorClass xpac) {
    final ActorClass ac = xpac.getActorClass();
    int _xifexpression = (int) 0;
    boolean _usesInheritance = this.langExt.usesInheritance();
    if (_usesInheritance) {
      _xifexpression = this._roomExtensions.getNumberOfInheritedBaseStates(ac);
    } else {
      _xifexpression = 0;
    }
    int offset = (2 + _xifexpression);
    List<State> _xifexpression_1 = null;
    boolean _usesInheritance_1 = this.langExt.usesInheritance();
    if (_usesInheritance_1) {
      StateGraph _stateMachine = ac.getStateMachine();
      _xifexpression_1 = this._roomHelpers.getBaseStateList(_stateMachine);
    } else {
      StateGraph _stateMachine_1 = xpac.getStateMachine();
      _xifexpression_1 = this._roomHelpers.getBaseStateList(_stateMachine_1);
    }
    List<State> baseStates = _xifexpression_1;
    List<State> _leafStatesLast = this._roomExtensions.getLeafStatesLast(baseStates);
    baseStates = _leafStatesLast;
    ArrayList<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
    boolean _usesInheritance_2 = this.langExt.usesInheritance();
    boolean _not = (!_usesInheritance_2);
    if (_not) {
      Pair<String, String> _pair = Tuples.<String, String>pair("NO_STATE", "0");
      list.add(_pair);
      Pair<String, String> _pair_1 = Tuples.<String, String>pair("STATE_TOP", "1");
      list.add(_pair_1);
    }
    for (final State state : baseStates) {
      {
        String _genStateId = this._codegenHelpers.getGenStateId(state);
        String _string = Integer.valueOf(offset).toString();
        Pair<String, String> _pair_2 = Tuples.<String, String>pair(_genStateId, _string);
        list.add(_pair_2);
        offset = (offset + 1);
      }
    }
    String _string = Integer.valueOf(offset).toString();
    Pair<String, String> _pair_2 = Tuples.<String, String>pair("STATE_MAX", _string);
    list.add(_pair_2);
    return this.langExt.genEnumeration("state_ids", list);
  }
  
  /**
   * generates transition chain ID constants.
   * Inheritance (if available) is used for base class IDs.
   * 
   * @param xpac the {@link ExpandedActorClass}
   * @return the generated code
   */
  protected String genTransitionChainConstants(final ExpandedActorClass xpac) {
    EList<TransitionChain> _xifexpression = null;
    boolean _usesInheritance = this.langExt.usesInheritance();
    if (_usesInheritance) {
      _xifexpression = xpac.getOwnTransitionChains();
    } else {
      _xifexpression = xpac.getTransitionChains();
    }
    EList<TransitionChain> chains = _xifexpression;
    int _xifexpression_1 = (int) 0;
    boolean _usesInheritance_1 = this.langExt.usesInheritance();
    if (_usesInheritance_1) {
      EList<TransitionChain> _transitionChains = xpac.getTransitionChains();
      int _size = _transitionChains.size();
      int _size_1 = chains.size();
      _xifexpression_1 = (_size - _size_1);
    } else {
      _xifexpression_1 = 0;
    }
    int offset = _xifexpression_1;
    ArrayList<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
    for (final TransitionChain chain : chains) {
      {
        offset = (offset + 1);
        String _genChainId = this._codegenHelpers.getGenChainId(chain);
        String _string = Integer.valueOf(offset).toString();
        Pair<String, String> _pair = Tuples.<String, String>pair(_genChainId, _string);
        list.add(_pair);
      }
    }
    return this.langExt.genEnumeration("chain_ids", list);
  }
  
  /**
   * generates trigger IDs.
   * Inheritance (if available) is used for base class IDs.
   * 
   * @param xpac the {@link ExpandedActorClass}
   * @return the generated code
   */
  protected String genTriggerConstants(final ExpandedActorClass xpac) {
    List<MessageFromIf> _xifexpression = null;
    boolean _usesInheritance = this.langExt.usesInheritance();
    if (_usesInheritance) {
      ActorClass _actorClass = xpac.getActorClass();
      _xifexpression = this._roomHelpers.getOwnMessagesFromInterfaces(_actorClass);
    } else {
      ActorClass _actorClass_1 = xpac.getActorClass();
      _xifexpression = this._roomHelpers.getAllMessagesFromInterfaces(_actorClass_1);
    }
    final List<MessageFromIf> triggers = _xifexpression;
    final ArrayList<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
    Pair<String, String> _pair = Tuples.<String, String>pair("POLLING", "0");
    list.add(_pair);
    for (final MessageFromIf mif : triggers) {
      String _triggerCodeName = xpac.getTriggerCodeName(mif);
      AbstractInterfaceItem _from = mif.getFrom();
      String _name = _from.getName();
      String _plus = ("IFITEM_" + _name);
      String _plus_1 = (_plus + " + EVT_SHIFT*");
      String _messageID = this.pcGen.getMessageID(mif);
      String _plus_2 = (_plus_1 + _messageID);
      Pair<String, String> _pair_1 = Tuples.<String, String>pair(_triggerCodeName, _plus_2);
      list.add(_pair_1);
    }
    return this.langExt.genEnumeration("triggers", list);
  }
  
  /**
   * generates the code of the whole state machine
   * 
   * @param xpac the {@link ExpandedActorClass}
   * @return the generated code
   * 
   * @see #genStateMachine
   */
  public CharSequence genStateMachine(final ExpandedActorClass xpac) {
    return this.genStateMachine(xpac, true);
  }
  
  /**
   * generates the code of the whole state machine
   * 
   * @param xpac the {@link ExpandedActorClass}
   * @param shallGenerateOneFile if <code>true</code> the generation of state IDs and
   * 		other constants is skipped (and left for the header file)
   * @return the generated code
   */
  public CharSequence genStateMachine(final ExpandedActorClass xpac, final boolean shallGenerateOneFile) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      ComponentCommunicationType _commType = ac.getCommType();
      final boolean async = Objects.equal(_commType, ComponentCommunicationType.ASYNCHRONOUS);
      ComponentCommunicationType _commType_1 = ac.getCommType();
      final boolean eventDriven = Objects.equal(_commType_1, ComponentCommunicationType.EVENT_DRIVEN);
      boolean _or = false;
      if (async) {
        _or = true;
      } else {
        _or = eventDriven;
      }
      final boolean handleEvents = _or;
      String _name = ac.getName();
      final String opScope = this.langExt.operationScope(_name, false);
      String _xifexpression = null;
      boolean _usesInheritance = this.langExt.usesInheritance();
      if (_usesInheritance) {
        _xifexpression = opScope;
      } else {
        _xifexpression = "";
      }
      final String opScopePriv = _xifexpression;
      String _xifexpression_1 = null;
      boolean _usesInheritance_1 = this.langExt.usesInheritance();
      if (_usesInheritance_1) {
        _xifexpression_1 = this.langExt.accessLevelPublic();
      } else {
        _xifexpression_1 = this.langExt.accessLevelPrivate();
      }
      final String publicIf = _xifexpression_1;
      final String privAccess = this.langExt.accessLevelPrivate();
      String _name_1 = ac.getName();
      final String selfPtr = this.langExt.selfPointer(_name_1, true);
      String _name_2 = ac.getName();
      final String selfOnly = this.langExt.selfPointer(_name_2, false);
      String _xifexpression_2 = null;
      boolean _usesInheritance_2 = this.langExt.usesInheritance();
      if (_usesInheritance_2) {
        String _xifexpression_3 = null;
        boolean _usesPointers = this.langExt.usesPointers();
        if (_usesPointers) {
          _xifexpression_3 = "->getLocalId()";
        } else {
          _xifexpression_3 = ".getLocalId()";
        }
        _xifexpression_2 = _xifexpression_3;
      } else {
        _xifexpression_2 = "->localId";
      }
      final String getLocalId = _xifexpression_2;
      String _pointerLiteral = this.langExt.pointerLiteral();
      final String ifItemPtr = ("InterfaceItemBase" + _pointerLiteral);
      String _xifexpression_4 = null;
      boolean _usesPointers_1 = this.langExt.usesPointers();
      if (_usesPointers_1) {
        _xifexpression_4 = ("const " + ifItemPtr);
      } else {
        _xifexpression_4 = ifItemPtr;
      }
      final String constIfItemPtr = _xifexpression_4;
      final boolean usesHdlr = this.usesHandlerTrPoints(xpac);
      StringConcatenation _builder = new StringConcatenation();
      {
        if (shallGenerateOneFile) {
          _builder.append("/* state IDs */");
          _builder.newLine();
          String _genStateIdConstants = this.genStateIdConstants(xpac);
          _builder.append(_genStateIdConstants, "");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("/* transition chains */");
          _builder.newLine();
          String _genTransitionChainConstants = this.genTransitionChainConstants(xpac);
          _builder.append(_genTransitionChainConstants, "");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("/* triggers */");
          _builder.newLine();
          String _genTriggerConstants = this.genTriggerConstants(xpac);
          _builder.append(_genTriggerConstants, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      CharSequence _genExtra = this.genExtra(xpac);
      _builder.append(_genExtra, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* Entry and Exit Codes */");
      _builder.newLine();
      {
        StateGraph _stateMachine = xpac.getStateMachine();
        List<State> _stateList = this._roomHelpers.getStateList(_stateMachine);
        for(final State state : _stateList) {
          {
            boolean _or_1 = false;
            boolean _usesInheritance_3 = this.langExt.usesInheritance();
            boolean _not = (!_usesInheritance_3);
            if (_not) {
              _or_1 = true;
            } else {
              boolean _isOwnObject = xpac.isOwnObject(state);
              _or_1 = _isOwnObject;
            }
            if (_or_1) {
              CharSequence _genActionCodeMethods = this.genActionCodeMethods(xpac, state);
              _builder.append(_genActionCodeMethods, "");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("/* Action Codes */");
      _builder.newLine();
      {
        StateGraph _stateMachine_1 = xpac.getStateMachine();
        List<Transition> _allTransitionsRecursive = this._roomHelpers.getAllTransitionsRecursive(_stateMachine_1);
        for(final Transition tr : _allTransitionsRecursive) {
          {
            boolean _and = false;
            boolean _or_2 = false;
            boolean _usesInheritance_4 = this.langExt.usesInheritance();
            boolean _not_1 = (!_usesInheritance_4);
            if (_not_1) {
              _or_2 = true;
            } else {
              boolean _isOwnObject_1 = xpac.isOwnObject(tr);
              _or_2 = _isOwnObject_1;
            }
            if (!_or_2) {
              _and = false;
            } else {
              DetailCode _action = tr.getAction();
              boolean _hasDetailCode = this._roomHelpers.hasDetailCode(_action);
              _and = _hasDetailCode;
            }
            if (_and) {
              TransitionChain _chain = xpac.getChain(tr);
              Transition _transition = null;
              if (_chain!=null) {
                _transition=_chain.getTransition();
              }
              Transition start = _transition;
              _builder.newLineIfNotEmpty();
              boolean _and_1 = false;
              if (!(start instanceof NonInitialTransition)) {
                _and_1 = false;
              } else {
                _and_1 = (!(start instanceof GuardedTransition));
              }
              boolean hasArgs = _and_1;
              _builder.newLineIfNotEmpty();
              String _accessLevelProtected = this.langExt.accessLevelProtected();
              _builder.append(_accessLevelProtected, "");
              _builder.append("void ");
              _builder.append(opScopePriv, "");
              String _actionCodeOperationName = this._codegenHelpers.getActionCodeOperationName(tr);
              _builder.append(_actionCodeOperationName, "");
              _builder.append("(");
              String _name_3 = ac.getName();
              String _selfPointer = this.langExt.selfPointer(_name_3, hasArgs);
              _builder.append(_selfPointer, "");
              {
                if (hasArgs) {
                  _builder.append(constIfItemPtr, "");
                  _builder.append(" ifitem");
                  String _generateArgumentList = this.transitionChainGenerator.generateArgumentList(xpac, tr);
                  _builder.append(_generateArgumentList, "");
                }
              }
              _builder.append(") {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              AbstractGenerator _instance = AbstractGenerator.getInstance();
              DetailCode _action_1 = tr.getAction();
              String _translatedCode = _instance.getTranslatedCode(_action_1);
              _builder.append(_translatedCode, "\t");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* calls exit codes while exiting from the current state to one of its");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* parent states while remembering the history");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param current__et - the current state");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param to - the final parent state");
      _builder.newLine();
      {
        if (usesHdlr) {
          _builder.append(" ");
          _builder.append("* @param handler__et - entry and exit codes are called only if not handler (for handler TransitionPoints)");
          _builder.newLine();
        }
      }
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append(privAccess, "");
      _builder.append("void ");
      _builder.append(opScopePriv, "");
      _builder.append("exitTo(");
      _builder.append(selfPtr, "");
      String _stateType = this.stateType();
      _builder.append(_stateType, "");
      _builder.append(" current__et, ");
      String _stateType_1 = this.stateType();
      _builder.append(_stateType_1, "");
      _builder.append(" to");
      {
        if (usesHdlr) {
          _builder.append(", ");
          String _boolType = this.boolType();
          _builder.append(_boolType, "");
          _builder.append(" handler__et");
        }
      }
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("while (current__et!=to) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch (current__et) {");
      _builder.newLine();
      {
        StateGraph _stateMachine_2 = xpac.getStateMachine();
        List<State> _baseStateList = this._roomHelpers.getBaseStateList(_stateMachine_2);
        for(final State state_1 : _baseStateList) {
          _builder.append("\t\t\t");
          _builder.append("case ");
          String _genStateId = this._codegenHelpers.getGenStateId(state_1);
          _builder.append(_genStateId, "\t\t\t");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("\t");
          {
            boolean _hasExitCode = this._roomHelpers.hasExitCode(state_1, true);
            if (_hasExitCode) {
              {
                if (usesHdlr) {
                  _builder.append("if (!handler__et) ");
                }
              }
              String _exitCodeOperationName = this._codegenHelpers.getExitCodeOperationName(state_1);
              _builder.append(_exitCodeOperationName, "\t\t\t\t");
              _builder.append("(");
              String _selfPointer_1 = this.langExt.selfPointer(false);
              _builder.append(_selfPointer_1, "\t\t\t\t");
              _builder.append(");");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("\t");
          String _parentStateId = this._codegenHelpers.getParentStateId(state_1);
          String _genStateId_1 = this._codegenHelpers.getGenStateId(state_1);
          String _setHistory = this.setHistory(_parentStateId, _genStateId_1);
          _builder.append(_setHistory, "\t\t\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("\t");
          _builder.append("current__et = ");
          String _parentStateId_1 = this._codegenHelpers.getParentStateId(state_1);
          _builder.append(_parentStateId_1, "\t\t\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("\t");
          _builder.append("break;");
          _builder.newLine();
        }
      }
      _builder.append("\t\t\t");
      _builder.append("default:");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("/* should not occur */");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* calls action, entry and exit codes along a transition chain. The generic data are cast to typed data");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* matching the trigger of this chain. The ID of the final state is returned");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param chain__et - the chain ID");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param generic_data__et - the generic data pointer");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @return the +/- ID of the final state either with a positive sign, that indicates to execute the state\'s entry code, or a negative sign vice versa");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append(privAccess, "");
      String _stateType_2 = this.stateType();
      _builder.append(_stateType_2, "");
      _builder.append(" ");
      _builder.append(opScopePriv, "");
      _builder.append("executeTransitionChain(");
      _builder.append(selfPtr, "");
      _builder.append("int chain__et");
      {
        if (handleEvents) {
          _builder.append(", ");
          _builder.append(constIfItemPtr, "");
          _builder.append(" ifitem, ");
          String _voidPointer = this.langExt.voidPointer();
          _builder.append(_voidPointer, "");
          _builder.append(" generic_data__et");
        }
      }
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("switch (chain__et) {");
      _builder.newLine();
      _builder.append("\t\t");
      EList<TransitionChain> allchains = xpac.getTransitionChains();
      _builder.newLineIfNotEmpty();
      {
        for(final TransitionChain tc : allchains) {
          _builder.append("\t\t");
          _builder.append("case ");
          String _genChainId = this._codegenHelpers.getGenChainId(tc);
          _builder.append(_genChainId, "\t\t");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          String _generateExecuteChain = this.transitionChainGenerator.generateExecuteChain(xpac, tc);
          _builder.append(_generateExecuteChain, "\t\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t\t\t");
      _builder.append("default:");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("/* should not occur */");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return NO_STATE;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* calls entry codes while entering a state\'s history. The ID of the final leaf state is returned");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param state__et - the state which is entered");
      _builder.newLine();
      {
        if (usesHdlr) {
          _builder.append(" ");
          _builder.append("* @param handler__et - entry code is executed if not handler");
          _builder.newLine();
        }
      }
      _builder.append(" ");
      _builder.append("* @return - the ID of the final leaf state");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append(privAccess, "");
      String _stateType_3 = this.stateType();
      _builder.append(_stateType_3, "");
      _builder.append(" ");
      _builder.append(opScopePriv, "");
      _builder.append("enterHistory(");
      _builder.append(selfPtr, "");
      String _stateType_4 = this.stateType();
      _builder.append(_stateType_4, "");
      _builder.append(" state__et");
      {
        if (usesHdlr) {
          _builder.append(", ");
          String _boolType_1 = this.boolType();
          _builder.append(_boolType_1, "");
          _builder.append(" handler__et");
        }
      }
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      String _boolType_2 = this.boolType();
      _builder.append(_boolType_2, "\t");
      _builder.append(" skip_entry__et = ");
      String _booleanConstant = this.langExt.booleanConstant(false);
      _builder.append(_booleanConstant, "\t");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("if (state__et >= STATE_MAX) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("state__et = ");
      {
        boolean _usesInheritance_5 = this.langExt.usesInheritance();
        boolean _not_2 = (!_usesInheritance_5);
        if (_not_2) {
          _builder.append("(");
          String _stateType_5 = this.stateType();
          _builder.append(_stateType_5, "\t\t");
          _builder.append(")");
        }
      }
      _builder.append(" (state__et - STATE_MAX);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("skip_entry__et = ");
      String _booleanConstant_1 = this.langExt.booleanConstant(true);
      _builder.append(_booleanConstant_1, "\t\t");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("while (");
      String _booleanConstant_2 = this.langExt.booleanConstant(true);
      _builder.append(_booleanConstant_2, "\t");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("switch (state__et) {");
      _builder.newLine();
      {
        StateGraph _stateMachine_3 = xpac.getStateMachine();
        List<State> _baseStateList_1 = this._roomHelpers.getBaseStateList(_stateMachine_3);
        for(final State state_2 : _baseStateList_1) {
          _builder.append("\t\t\t");
          _builder.append("case ");
          String _genStateId_2 = this._codegenHelpers.getGenStateId(state_2);
          _builder.append(_genStateId_2, "\t\t\t");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("\t");
          {
            boolean _hasEntryCode = this._roomHelpers.hasEntryCode(state_2, true);
            if (_hasEntryCode) {
              _builder.append("if (!(skip_entry__et");
              {
                if (usesHdlr) {
                  _builder.append(" || handler__et");
                }
              }
              _builder.append(")) ");
              String _entryCodeOperationName = this._codegenHelpers.getEntryCodeOperationName(state_2);
              _builder.append(_entryCodeOperationName, "\t\t\t\t");
              _builder.append("(");
              String _selfPointer_2 = this.langExt.selfPointer(false);
              _builder.append(_selfPointer_2, "\t\t\t\t");
              _builder.append(");");
            }
          }
          _builder.newLineIfNotEmpty();
          {
            boolean _isLeaf = this._roomHelpers.isLeaf(state_2);
            if (_isLeaf) {
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("/* in leaf state: return state id */");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("return ");
              String _genStateId_3 = this._codegenHelpers.getGenStateId(state_2);
              _builder.append(_genStateId_3, "\t\t\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("/* state has a sub graph */");
              _builder.newLine();
              {
                StateGraph _subgraph = state_2.getSubgraph();
                boolean _hasInitTransition = this._roomHelpers.hasInitTransition(_subgraph);
                if (_hasInitTransition) {
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("/* with init transition */");
                  _builder.newLine();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("if (");
                  String _genStateId_4 = this._codegenHelpers.getGenStateId(state_2);
                  String _history = this.getHistory(_genStateId_4);
                  _builder.append(_history, "\t\t\t\t");
                  _builder.append("==NO_STATE) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  StateGraph _subgraph_1 = state_2.getSubgraph();
                  Transition sub_initt = this._roomHelpers.getInitTransition(_subgraph_1);
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("state__et = executeTransitionChain(");
                  String _selfPointer_3 = this.langExt.selfPointer(true);
                  _builder.append(_selfPointer_3, "\t\t\t\t\t");
                  TransitionChain _chain_1 = xpac.getChain(sub_initt);
                  String _genChainId_1 = this._codegenHelpers.getGenChainId(_chain_1);
                  _builder.append(_genChainId_1, "\t\t\t\t\t");
                  {
                    if (handleEvents) {
                      _builder.append(", ");
                      String _nullPointer = this.langExt.nullPointer();
                      _builder.append(_nullPointer, "\t\t\t\t\t");
                      _builder.append(", ");
                      String _nullPointer_1 = this.langExt.nullPointer();
                      _builder.append(_nullPointer_1, "\t\t\t\t\t");
                    }
                  }
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("else {");
                  _builder.newLine();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("state__et = ");
                  String _genStateId_5 = this._codegenHelpers.getGenStateId(state_2);
                  String _history_1 = this.getHistory(_genStateId_5);
                  _builder.append(_history_1, "\t\t\t\t\t");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                } else {
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("/* without init transition */");
                  _builder.newLine();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("state__et = ");
                  String _genStateId_6 = this._codegenHelpers.getGenStateId(state_2);
                  String _history_2 = this.getHistory(_genStateId_6);
                  _builder.append(_history_2, "\t\t\t\t");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("break;");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\t\t\t");
      _builder.append("case STATE_TOP:");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("state__et = ");
      String _history_3 = this.getHistory("STATE_TOP");
      _builder.append(_history_3, "\t\t\t\t");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("default:");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("/* should not occur */");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("skip_entry__et = ");
      String _booleanConstant_3 = this.langExt.booleanConstant(false);
      _builder.append(_booleanConstant_3, "\t\t");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      String _unreachableReturn = this.unreachableReturn();
      _builder.append(_unreachableReturn, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append(publicIf, "");
      _builder.append("void ");
      _builder.append(opScope, "");
      _builder.append("executeInitTransition(");
      _builder.append(selfOnly, "");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      StateGraph _stateMachine_4 = xpac.getStateMachine();
      Transition initt = this._roomHelpers.getInitTransition(_stateMachine_4);
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("int chain__et = ");
      TransitionChain _chain_2 = xpac.getChain(initt);
      String _genChainId_2 = this._codegenHelpers.getGenChainId(_chain_2);
      _builder.append(_genChainId_2, "\t");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      String _stateType_6 = this.stateType();
      _builder.append(_stateType_6, "\t");
      _builder.append(" next__et = ");
      _builder.append(opScopePriv, "\t");
      _builder.append("executeTransitionChain(");
      String _selfPointer_4 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_4, "\t");
      _builder.append("chain__et");
      {
        if (handleEvents) {
          _builder.append(", ");
          String _nullPointer_2 = this.langExt.nullPointer();
          _builder.append(_nullPointer_2, "\t");
          _builder.append(", ");
          String _nullPointer_3 = this.langExt.nullPointer();
          _builder.append(_nullPointer_3, "\t");
        }
      }
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("next__et = ");
      _builder.append(opScopePriv, "\t");
      _builder.append("enterHistory(");
      String _selfPointer_5 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_5, "\t");
      _builder.append("next__et");
      {
        if (usesHdlr) {
          _builder.append(", ");
          String _booleanConstant_4 = this.langExt.booleanConstant(false);
          _builder.append(_booleanConstant_4, "\t");
        }
      }
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("setState(");
      String _selfPointer_6 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_6, "\t");
      _builder.append("next__et);");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* receiveEvent contains the main implementation of the FSM */");
      _builder.newLine();
      _builder.append(publicIf, "");
      _builder.append("void ");
      _builder.append(opScope, "");
      _builder.append("receiveEvent(");
      String _name_4 = ac.getName();
      String _selfPointer_7 = this.langExt.selfPointer(_name_4, handleEvents);
      _builder.append(_selfPointer_7, "");
      {
        if (handleEvents) {
          _builder.append(ifItemPtr, "");
          _builder.append(" ifitem, int evt, ");
          String _voidPointer_1 = this.langExt.voidPointer();
          _builder.append(_voidPointer_1, "");
          _builder.append(" generic_data__et");
        }
      }
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      {
        if (async) {
          _builder.append("\t");
          _builder.append("int trigger__et = (ifitem==");
          String _nullPointer_4 = this.langExt.nullPointer();
          _builder.append(_nullPointer_4, "\t");
          _builder.append(")? POLLING : ifitem");
          _builder.append(getLocalId, "\t");
          _builder.append(" + EVT_SHIFT*evt;");
          _builder.newLineIfNotEmpty();
        } else {
          if (eventDriven) {
            _builder.append("\t");
            _builder.append("int trigger__et = ifitem");
            _builder.append(getLocalId, "\t");
            _builder.append(" + EVT_SHIFT*evt;");
            _builder.newLineIfNotEmpty();
          }
        }
      }
      _builder.append("\t");
      _builder.append("int chain__et = NOT_CAUGHT;");
      _builder.newLine();
      _builder.append("\t");
      String _stateType_7 = this.stateType();
      _builder.append(_stateType_7, "\t");
      _builder.append(" catching_state__et = NO_STATE;");
      _builder.newLineIfNotEmpty();
      {
        if (usesHdlr) {
          _builder.append("\t");
          String _boolType_3 = this.boolType();
          _builder.append(_boolType_3, "\t");
          _builder.append(" is_handler__et = ");
          String _booleanConstant_5 = this.langExt.booleanConstant(false);
          _builder.append(_booleanConstant_5, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        boolean _or_3 = false;
        if (async) {
          _or_3 = true;
        } else {
          _or_3 = eventDriven;
        }
        if (_or_3) {
          _builder.append("\t");
          CharSequence _markVariableUsed = this.markVariableUsed("trigger__et");
          _builder.append(_markVariableUsed, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      {
        if (handleEvents) {
          _builder.append("\t");
          _builder.append("if (!handleSystemEvent(ifitem, evt, generic_data__et)) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          CharSequence _genStateSwitch = this.genStateSwitch(xpac, usesHdlr);
          _builder.append(_genStateSwitch, "\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        } else {
          _builder.append("\t");
          CharSequence _genStateSwitch_1 = this.genStateSwitch(xpac, usesHdlr);
          _builder.append(_genStateSwitch_1, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("if (chain__et != NOT_CAUGHT) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append(opScopePriv, "\t\t");
      _builder.append("exitTo(");
      String _selfPointer_8 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_8, "\t\t");
      _builder.append("getState(");
      String _selfPointer_9 = this.langExt.selfPointer(false);
      _builder.append(_selfPointer_9, "\t\t");
      _builder.append("), catching_state__et");
      {
        if (usesHdlr) {
          _builder.append(", is_handler__et");
        }
      }
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t");
      String _stateType_8 = this.stateType();
      _builder.append(_stateType_8, "\t\t\t");
      _builder.append(" next__et = ");
      _builder.append(opScopePriv, "\t\t\t");
      _builder.append("executeTransitionChain(");
      String _selfPointer_10 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_10, "\t\t\t");
      _builder.append("chain__et");
      {
        if (handleEvents) {
          _builder.append(", ifitem, generic_data__et");
        }
      }
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("next__et = ");
      _builder.append(opScopePriv, "\t\t\t");
      _builder.append("enterHistory(");
      String _selfPointer_11 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_11, "\t\t\t");
      _builder.append("next__et");
      {
        if (usesHdlr) {
          _builder.append(", is_handler__et");
        }
      }
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("setState(");
      String _selfPointer_12 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_12, "\t\t\t");
      _builder.append("next__et);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      CharSequence _finalAction = this.finalAction();
      _builder.append(_finalAction, "\t\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * empty, but may be overridden
   */
  public CharSequence finalAction() {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  /**
   * empty, but may be overridden
   */
  public CharSequence markVariableUsed(final String varname) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  /**
   * helper method which generates the state switch.
   * Asynchronous, data driven and event driven state machines are distinguished
   * 
   * @param xpac the {@link ExpandedActorClass}
   * @param usesHdlr if the state machine uses no handler {@link TransitionPoint}s
   * 		at all then unused variables can be avoided by passing <code>true</code>
   * @return the generated code
   */
  protected CharSequence genStateSwitch(final ExpandedActorClass xpac, final boolean usesHdlr) {
    CharSequence _xblockexpression = null;
    {
      ActorClass _actorClass = xpac.getActorClass();
      ComponentCommunicationType _commType = _actorClass.getCommType();
      boolean async = Objects.equal(_commType, ComponentCommunicationType.ASYNCHRONOUS);
      ActorClass _actorClass_1 = xpac.getActorClass();
      ComponentCommunicationType _commType_1 = _actorClass_1.getCommType();
      boolean eventDriven = Objects.equal(_commType_1, ComponentCommunicationType.EVENT_DRIVEN);
      ActorClass _actorClass_2 = xpac.getActorClass();
      ComponentCommunicationType _commType_2 = _actorClass_2.getCommType();
      boolean dataDriven = Objects.equal(_commType_2, ComponentCommunicationType.DATA_DRIVEN);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch (getState(");
      String _selfPointer = this.langExt.selfPointer(false);
      _builder.append(_selfPointer, "");
      _builder.append(")) {");
      _builder.newLineIfNotEmpty();
      {
        StateGraph _stateMachine = xpac.getStateMachine();
        List<State> _leafStateList = this._roomHelpers.getLeafStateList(_stateMachine);
        for(final State state : _leafStateList) {
          _builder.append("\t");
          _builder.append("case ");
          String _genStateId = this._codegenHelpers.getGenStateId(state);
          _builder.append(_genStateId, "\t");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          {
            if (async) {
              _builder.append("\t");
              _builder.append("\t");
              EList<ActiveTrigger> atlist = xpac.getActiveTriggers(state);
              _builder.newLineIfNotEmpty();
              {
                boolean _isEmpty = atlist.isEmpty();
                boolean _not = (!_isEmpty);
                if (_not) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("switch(trigger__et) {");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("case POLLING:");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t\t");
                  CharSequence _genDataDrivenTriggers = this.genDataDrivenTriggers(xpac, state, usesHdlr);
                  _builder.append(_genDataDrivenTriggers, "\t\t\t\t");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t\t");
                  _builder.append("break;");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  CharSequence _genEventDrivenTriggers = this.genEventDrivenTriggers(xpac, state, atlist, usesHdlr);
                  _builder.append(_genEventDrivenTriggers, "\t\t\t");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                } else {
                  _builder.append("\t");
                  _builder.append("\t");
                  CharSequence _genDataDrivenTriggers_1 = this.genDataDrivenTriggers(xpac, state, usesHdlr);
                  _builder.append(_genDataDrivenTriggers_1, "\t\t");
                  _builder.newLineIfNotEmpty();
                }
              }
            } else {
              if (dataDriven) {
                _builder.append("\t");
                _builder.append("\t");
                CharSequence _genDataDrivenTriggers_2 = this.genDataDrivenTriggers(xpac, state, usesHdlr);
                _builder.append(_genDataDrivenTriggers_2, "\t\t");
                _builder.newLineIfNotEmpty();
              } else {
                if (eventDriven) {
                  _builder.append("\t");
                  _builder.append("\t");
                  EList<ActiveTrigger> atlist_1 = xpac.getActiveTriggers(state);
                  _builder.newLineIfNotEmpty();
                  {
                    boolean _isEmpty_1 = atlist_1.isEmpty();
                    boolean _not_1 = (!_isEmpty_1);
                    if (_not_1) {
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("switch(trigger__et) {");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("\t\t");
                      CharSequence _genEventDrivenTriggers_1 = this.genEventDrivenTriggers(xpac, state, atlist_1, usesHdlr);
                      _builder.append(_genEventDrivenTriggers_1, "\t\t\t\t");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("}");
                      _builder.newLine();
                    }
                  }
                }
              }
            }
          }
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("break;");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("default:");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("/* should not occur */");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * helper method which generates the data driven triggers
   * 
   * @param xpac the {@link ExpandedActorClass}
   * @param state the {@link State} for which the trigger if-else switch should be generated
   * @param usesHdlr if the state machine uses no handler {@link TransitionPoints}
   * 		at all then unused variables can be avoided by passing <code>true</code>
   * @return the generated code
   */
  protected CharSequence genDataDrivenTriggers(final ExpandedActorClass xpac, final State state, final boolean usesHdlr) {
    StringConcatenation _builder = new StringConcatenation();
    String _genDoCodes = this.genDoCodes(state);
    _builder.append(_genDoCodes, "");
    _builder.newLineIfNotEmpty();
    List<Transition> _outgoingTransitionsHierarchical = this._roomExtensions.getOutgoingTransitionsHierarchical(xpac, state);
    final Function1<Transition, Boolean> _function = new Function1<Transition, Boolean>() {
      public Boolean apply(final Transition t) {
        return Boolean.valueOf((t instanceof GuardedTransition));
      }
    };
    Iterable<Transition> transitions = IterableExtensions.<Transition>filter(_outgoingTransitionsHierarchical, _function);
    _builder.newLineIfNotEmpty();
    {
      for(final Transition tr : transitions) {
        _builder.append("if (");
        AbstractGenerator _instance = AbstractGenerator.getInstance();
        DetailCode _guard = ((GuardedTransition) tr).getGuard();
        String _translatedCode = _instance.getTranslatedCode(_guard);
        _builder.append(_translatedCode, "");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        TransitionChain chain = xpac.getChain(tr);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("chain__et = ");
        String _genChainId = this._codegenHelpers.getGenChainId(chain);
        _builder.append(_genChainId, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("catching_state__et = ");
        State _stateContext = chain.getStateContext();
        String _genStateId = this._codegenHelpers.getGenStateId(_stateContext);
        _builder.append(_genStateId, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        {
          boolean _and = false;
          boolean _isHandler = chain.isHandler();
          if (!_isHandler) {
            _and = false;
          } else {
            _and = usesHdlr;
          }
          if (_and) {
            _builder.append("\t");
            _builder.append("is_handler__et = ET_TRUE;");
            _builder.newLine();
          }
        }
        _builder.append("}");
        _builder.newLine();
        {
          Transition _last = IterableExtensions.<Transition>last(transitions);
          boolean _notEquals = (!Objects.equal(tr, _last));
          if (_notEquals) {
            _builder.append("else ");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  /**
   * helper method which generates the event driven triggers
   * 
   * @param xpac the {@link ExpandedActorClass}
   * @param state the {@link State} for which the trigger switch should be generated
   * @param atlist the list of {@link ActiveTrigger}s of this state
   * @param usesHdlr if the state machine uses no handler {@link TransitionPoints}
   * 		at all then unused variables can be avoided by passing <code>true</code>
   * @return the generated code
   */
  protected CharSequence genEventDrivenTriggers(final ExpandedActorClass xpac, final State state, final List<ActiveTrigger> atlist, final boolean usesHdlr) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final ActiveTrigger at : atlist) {
        _builder.append("case ");
        String _triggerCodeName = xpac.getTriggerCodeName(at);
        _builder.append(_triggerCodeName, "");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        boolean needData = this._eTriceGenUtil.hasGuard(at);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          if (needData) {
            _builder.append("{ ");
            EObject _msg = at.getMsg();
            String _typedDataDefinition = this.langExt.getTypedDataDefinition(((Message) _msg));
            _builder.append(_typedDataDefinition, "\t");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          EList<TriggeredTransition> _transitions = at.getTransitions();
          boolean _hasElements = false;
          for(final TriggeredTransition tt : _transitions) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(" else ", "\t");
            }
            _builder.append("\t");
            TransitionChain chain = xpac.getChain(tt);
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            Transition _transition = chain.getTransition();
            String _trigger = at.getTrigger();
            CharSequence _guard = this.guard(_transition, _trigger, xpac);
            _builder.append(_guard, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("{");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("chain__et = ");
            String _genChainId = this._codegenHelpers.getGenChainId(chain);
            _builder.append(_genChainId, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("catching_state__et = ");
            State _stateContext = chain.getStateContext();
            String _genStateId = this._codegenHelpers.getGenStateId(_stateContext);
            _builder.append(_genStateId, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            {
              boolean _and = false;
              boolean _isHandler = chain.isHandler();
              if (!_isHandler) {
                _and = false;
              } else {
                _and = usesHdlr;
              }
              if (_and) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("is_handler__et = ");
                String _booleanConstant = this.langExt.booleanConstant(true);
                _builder.append(_booleanConstant, "\t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        {
          if (needData) {
            _builder.append("}");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("break;");
        _builder.newLine();
      }
    }
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* should not occur */");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("break;");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * getter for history array
   * 
   * @param state the ID of the history state
   * @return the generated code
   */
  protected String getHistory(final String state) {
    String _memberAccess = this.langExt.memberAccess();
    String _plus = (_memberAccess + "history[");
    String _plus_1 = (_plus + state);
    return (_plus_1 + "]");
  }
  
  /**
   * setter for history array
   * 
   * @param state the ID of the state whose history should be set
   * @param historyState the ID of the state that should be assigned
   * @return the generated code
   */
  protected String setHistory(final String state, final String historyState) {
    String _memberAccess = this.langExt.memberAccess();
    String _plus = (_memberAccess + "history[");
    String _plus_1 = (_plus + state);
    String _plus_2 = (_plus_1 + "] = ");
    return (_plus_2 + historyState);
  }
  
  /**
   * @return the type of (temporary) state variables (defaults to "int")
   * and has to be signed
   */
  protected String stateType() {
    return "int";
  }
  
  /**
   * allow target language dependent generation of unreachable return in generated enterHistory method.
   * The default is just a comment.
   * @return the generated code
   */
  protected String unreachableReturn() {
    return "/* return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true) */";
  }
  
  /**
   * type of (temporary) boolean variables (defaults to "boolean")
   * @return the generated code
   */
  protected String boolType() {
    return "boolean";
  }
  
  /**
   * let derived class add extra code after definition of constants
   * 
   * @param xpac an expanded actor class
   * @return the generated code
   */
  protected CharSequence genExtra(final ExpandedActorClass xpac) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  /**
   * let derived class add extra code after definition of constants in header (if applicable)
   * 
   * @param xpac an expanded actor class
   * @return the generated code
   */
  protected CharSequence genExtraDecl(final ExpandedActorClass xpac) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  /**
   * generate a transition guard if applicable
   * 
   * @param tt a {@link TriggeredTransition}
   * @param trigger a trigger string
   * @param xpac an expanded actor class
   * @return the generated code
   */
  protected CharSequence _guard(final TriggeredTransition tt, final String trigger, final ExpandedActorClass ac) {
    CharSequence _xblockexpression = null;
    {
      EList<Trigger> _triggers = tt.getTriggers();
      final Function1<Trigger, Boolean> _function = new Function1<Trigger, Boolean>() {
        public Boolean apply(final Trigger e) {
          return Boolean.valueOf(ac.isMatching(e, trigger));
        }
      };
      final Trigger tr = IterableExtensions.<Trigger>findFirst(_triggers, _function);
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _hasGuard = this._roomHelpers.hasGuard(tr);
        if (_hasGuard) {
          _builder.append("if (");
          AbstractGenerator _instance = AbstractGenerator.getInstance();
          Guard _guard = tr.getGuard();
          DetailCode _guard_1 = _guard.getGuard();
          String _translatedCode = _instance.getTranslatedCode(_guard_1);
          _builder.append(_translatedCode, "");
          _builder.append(")");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * (necessary for completeness of the dispatching, never called)
   */
  protected CharSequence _guard(final Transition t, final String trigger, final ExpandedActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* error */");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * generate the do code calls for a given state
   * 
   * @param state the {@link State}
   * @return the generated code
   */
  protected String genDoCodes(final State state) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasDoCode = this._roomHelpers.hasDoCode(state, true);
      if (_hasDoCode) {
        String _doCodeOperationName = this._codegenHelpers.getDoCodeOperationName(state);
        _builder.append(_doCodeOperationName, "");
        _builder.append("(");
        String _selfPointer = this.langExt.selfPointer(false);
        _builder.append(_selfPointer, "");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EObject _eContainer = state.eContainer();
      EObject _eContainer_1 = _eContainer.eContainer();
      if ((_eContainer_1 instanceof State)) {
        EObject _eContainer_2 = state.eContainer();
        EObject _eContainer_3 = _eContainer_2.eContainer();
        String _genDoCodes = this.genDoCodes(((State) _eContainer_3));
        _builder.append(_genDoCodes, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  /**
   * generate action code method implementations
   * 
   * @param xpac the {@link ExpandedActorClass}
   * @param state the {@link State}
   * @return the generated code
   */
  protected CharSequence genActionCodeMethods(final ExpandedActorClass xpac, final State state) {
    return this.genActionCodeMethods(xpac, state, true);
  }
  
  /**
   * generate action code method implementations or declarations
   * 
   * @param xpax the {@link ExpandedActorClass}
   * @param state the {@link State}
   * @param generateImplementation if only declarations should be generated then <code>false</code> has to be passed
   * @return the generated code
   */
  protected CharSequence genActionCodeMethods(final ExpandedActorClass xpac, final State state, final boolean generateImplementation) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      ActorClass _actorClass = xpac.getActorClass();
      String _name = _actorClass.getName();
      final String selfPtr = this.langExt.selfPointer(_name, false);
      String _name_1 = ac.getName();
      final String opScope = this.langExt.operationScope(_name_1, false);
      String _xifexpression = null;
      boolean _usesInheritance = this.langExt.usesInheritance();
      if (_usesInheritance) {
        _xifexpression = opScope;
      } else {
        _xifexpression = "";
      }
      final String opScopePriv = _xifexpression;
      final String entryOp = this._codegenHelpers.getEntryCodeOperationName(state);
      final String exitOp = this._codegenHelpers.getExitCodeOperationName(state);
      final String doOp = this._codegenHelpers.getDoCodeOperationName(state);
      AbstractGenerator _instance = AbstractGenerator.getInstance();
      DetailCode _entryCode = state.getEntryCode();
      String entry = _instance.getTranslatedCode(_entryCode);
      AbstractGenerator _instance_1 = AbstractGenerator.getInstance();
      DetailCode _exitCode = state.getExitCode();
      String exit = _instance_1.getTranslatedCode(_exitCode);
      AbstractGenerator _instance_2 = AbstractGenerator.getInstance();
      DetailCode _doCode = state.getDoCode();
      String docode = _instance_2.getTranslatedCode(_doCode);
      if ((state instanceof ExpandedRefinedState)) {
        final ExpandedRefinedState rs = ((ExpandedRefinedState) state);
        AbstractGenerator _instance_3 = AbstractGenerator.getInstance();
        DetailCode _inheritedEntry = rs.getInheritedEntry();
        final String inhEntry = _instance_3.getTranslatedCode(_inheritedEntry);
        AbstractGenerator _instance_4 = AbstractGenerator.getInstance();
        DetailCode _inheritedExit = rs.getInheritedExit();
        final String inhExit = _instance_4.getTranslatedCode(_inheritedExit);
        AbstractGenerator _instance_5 = AbstractGenerator.getInstance();
        DetailCode _inheritedDo = rs.getInheritedDo();
        final String inhDo = _instance_5.getTranslatedCode(_inheritedDo);
        boolean _usesInheritance_1 = this.langExt.usesInheritance();
        if (_usesInheritance_1) {
          ActorClass _actorClass_1 = xpac.getActorClass();
          ActorClass _actorBase = _actorClass_1.getActorBase();
          final String baseName = _actorBase.getName();
          DetailCode _inheritedEntry_1 = rs.getInheritedEntry();
          boolean _hasDetailCode = this._roomHelpers.hasDetailCode(_inheritedEntry_1);
          if (_hasDetailCode) {
            String _superCall = this.langExt.superCall(baseName, entryOp, "");
            String _plus = (_superCall + entry);
            entry = _plus;
          }
          DetailCode _inheritedExit_1 = rs.getInheritedExit();
          boolean _hasDetailCode_1 = this._roomHelpers.hasDetailCode(_inheritedExit_1);
          if (_hasDetailCode_1) {
            String _superCall_1 = this.langExt.superCall(baseName, exitOp, "");
            String _plus_1 = (exit + _superCall_1);
            exit = _plus_1;
          }
          DetailCode _inheritedDo_1 = rs.getInheritedDo();
          boolean _hasDetailCode_2 = this._roomHelpers.hasDetailCode(_inheritedDo_1);
          if (_hasDetailCode_2) {
            String _superCall_2 = this.langExt.superCall(baseName, doOp, "");
            String _plus_2 = (_superCall_2 + docode);
            docode = _plus_2;
          }
        } else {
          entry = (inhEntry + entry);
          exit = (exit + inhExit);
          docode = (inhDo + docode);
        }
      }
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isEmpty = entry.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          {
            if (generateImplementation) {
              String _accessLevelProtected = this.langExt.accessLevelProtected();
              _builder.append(_accessLevelProtected, "");
              _builder.append("void ");
              _builder.append(opScopePriv, "");
              _builder.append(entryOp, "");
              _builder.append("(");
              _builder.append(selfPtr, "");
              _builder.append(") {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append(entry, "\t");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            } else {
              String _accessLevelProtected_1 = this.langExt.accessLevelProtected();
              _builder.append(_accessLevelProtected_1, "");
              _builder.append("void ");
              _builder.append(entryOp, "");
              _builder.append("(");
              _builder.append(selfPtr, "");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      {
        boolean _isEmpty_1 = exit.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          {
            if (generateImplementation) {
              String _accessLevelProtected_2 = this.langExt.accessLevelProtected();
              _builder.append(_accessLevelProtected_2, "");
              _builder.append("void ");
              _builder.append(opScopePriv, "");
              _builder.append(exitOp, "");
              _builder.append("(");
              _builder.append(selfPtr, "");
              _builder.append(") {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append(exit, "\t");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            } else {
              String _accessLevelProtected_3 = this.langExt.accessLevelProtected();
              _builder.append(_accessLevelProtected_3, "");
              _builder.append("void ");
              _builder.append(exitOp, "");
              _builder.append("(");
              _builder.append(selfPtr, "");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      {
        boolean _isEmpty_2 = docode.isEmpty();
        boolean _not_2 = (!_isEmpty_2);
        if (_not_2) {
          {
            if (generateImplementation) {
              String _accessLevelProtected_4 = this.langExt.accessLevelProtected();
              _builder.append(_accessLevelProtected_4, "");
              _builder.append(" void ");
              _builder.append(opScopePriv, "");
              _builder.append(doOp, "");
              _builder.append("(");
              _builder.append(selfPtr, "");
              _builder.append(") {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append(docode, "\t");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            } else {
              String _accessLevelProtected_5 = this.langExt.accessLevelProtected();
              _builder.append(_accessLevelProtected_5, "");
              _builder.append("void ");
              _builder.append(doOp, "");
              _builder.append("(");
              _builder.append(selfPtr, "");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * @param classname the name of the type
   * @return the type name for a constant pointer
   */
  protected String constPointer(final String classname) {
    return classname;
  }
  
  /**
   * generate all method declarations
   * 
   * @param xpax the {@link ExpandedActorClass}
   * @return the generated code
   */
  public CharSequence genStateMachineMethodDeclarations(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      ComponentCommunicationType _commType = ac.getCommType();
      final boolean async = Objects.equal(_commType, ComponentCommunicationType.ASYNCHRONOUS);
      ComponentCommunicationType _commType_1 = ac.getCommType();
      final boolean eventDriven = Objects.equal(_commType_1, ComponentCommunicationType.EVENT_DRIVEN);
      boolean _or = false;
      if (async) {
        _or = true;
      } else {
        _or = eventDriven;
      }
      final boolean handleEvents = _or;
      String _name = ac.getName();
      final String selfPtr = this.langExt.selfPointer(_name, true);
      final boolean usesHdlr = this.usesHandlerTrPoints(xpac);
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("/* state IDs */");
      _builder.newLine();
      String _genStateIdConstants = this.genStateIdConstants(xpac);
      _builder.append(_genStateIdConstants, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* transition chains */");
      _builder.newLine();
      String _genTransitionChainConstants = this.genTransitionChainConstants(xpac);
      _builder.append(_genTransitionChainConstants, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* triggers */");
      _builder.newLine();
      String _genTriggerConstants = this.genTriggerConstants(xpac);
      _builder.append(_genTriggerConstants, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _genExtraDecl = this.genExtraDecl(xpac);
      _builder.append(_genExtraDecl, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* Entry and Exit Codes */");
      _builder.newLine();
      {
        StateGraph _stateMachine = xpac.getStateMachine();
        List<State> _stateList = this._roomHelpers.getStateList(_stateMachine);
        for(final State state : _stateList) {
          {
            boolean _or_1 = false;
            boolean _usesInheritance = this.langExt.usesInheritance();
            boolean _not = (!_usesInheritance);
            if (_not) {
              _or_1 = true;
            } else {
              boolean _isOwnObject = xpac.isOwnObject(state);
              _or_1 = _isOwnObject;
            }
            if (_or_1) {
              CharSequence _genActionCodeMethods = this.genActionCodeMethods(xpac, state, false);
              _builder.append(_genActionCodeMethods, "");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("/* Action Codes */");
      _builder.newLine();
      {
        StateGraph _stateMachine_1 = xpac.getStateMachine();
        List<Transition> _allTransitionsRecursive = this._roomHelpers.getAllTransitionsRecursive(_stateMachine_1);
        for(final Transition tr : _allTransitionsRecursive) {
          {
            boolean _and = false;
            boolean _or_2 = false;
            boolean _usesInheritance_1 = this.langExt.usesInheritance();
            boolean _not_1 = (!_usesInheritance_1);
            if (_not_1) {
              _or_2 = true;
            } else {
              boolean _isOwnObject_1 = xpac.isOwnObject(tr);
              _or_2 = _isOwnObject_1;
            }
            if (!_or_2) {
              _and = false;
            } else {
              DetailCode _action = tr.getAction();
              boolean _hasDetailCode = this._roomHelpers.hasDetailCode(_action);
              _and = _hasDetailCode;
            }
            if (_and) {
              TransitionChain _chain = xpac.getChain(tr);
              Transition start = _chain.getTransition();
              _builder.newLineIfNotEmpty();
              boolean _and_1 = false;
              if (!(start instanceof NonInitialTransition)) {
                _and_1 = false;
              } else {
                _and_1 = (!(start instanceof GuardedTransition));
              }
              boolean hasArgs = _and_1;
              _builder.newLineIfNotEmpty();
              String _accessLevelProtected = this.langExt.accessLevelProtected();
              _builder.append(_accessLevelProtected, "");
              _builder.append("void ");
              String _actionCodeOperationName = this._codegenHelpers.getActionCodeOperationName(tr);
              _builder.append(_actionCodeOperationName, "");
              _builder.append("(");
              String _name_1 = ac.getName();
              String _selfPointer = this.langExt.selfPointer(_name_1, hasArgs);
              _builder.append(_selfPointer, "");
              {
                if (hasArgs) {
                  String _constPointer = this.constPointer("etRuntime::InterfaceItemBase");
                  _builder.append(_constPointer, "");
                  _builder.append(" ifitem");
                  String _generateArgumentList = this.transitionChainGenerator.generateArgumentList(xpac, tr);
                  _builder.append(_generateArgumentList, "");
                }
              }
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("private:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* calls exit codes while exiting from the current state to one of its");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* parent states while remembering the history");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param current - the current state");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param to - the final parent state");
      _builder.newLine();
      {
        if (usesHdlr) {
          _builder.append("\t ");
          _builder.append("* @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)");
          _builder.newLine();
        }
      }
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("void exitTo(");
      _builder.append(selfPtr, "\t");
      _builder.append("int current, int to");
      {
        if (usesHdlr) {
          _builder.append(", ");
          String _boolType = this.boolType();
          _builder.append(_boolType, "\t");
          _builder.append(" handler");
        }
      }
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* calls action, entry and exit codes along a transition chain. The generic data are cast to typed data");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* matching the trigger of this chain. The ID of the final state is returned");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param chain - the chain ID");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param generic_data__et - the generic data pointer");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @return the ID of the final state");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int executeTransitionChain(");
      _builder.append(selfPtr, "\t");
      _builder.append("int chain");
      {
        if (handleEvents) {
          _builder.append(", ");
          String _constPointer_1 = this.constPointer("etRuntime::InterfaceItemBase");
          _builder.append(_constPointer_1, "\t");
          _builder.append(" ifitem, ");
          String _voidPointer = this.langExt.voidPointer();
          _builder.append(_voidPointer, "\t");
          _builder.append(" generic_data__et");
        }
      }
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* calls entry codes while entering a state\'s history. The ID of the final leaf state is returned");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param state - the state which is entered");
      _builder.newLine();
      {
        if (usesHdlr) {
          _builder.append("\t ");
          _builder.append("* @param handler - entry code is executed if not handler");
          _builder.newLine();
        }
      }
      _builder.append("\t ");
      _builder.append("* @return - the ID of the final leaf state");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int enterHistory(");
      _builder.append(selfPtr, "\t");
      _builder.append("int state");
      {
        if (usesHdlr) {
          _builder.append(", ");
          String _boolType_1 = this.boolType();
          _builder.append(_boolType_1, "\t");
          _builder.append(" handler");
        }
      }
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("public:");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("void executeInitTransition(");
      String _name_2 = ac.getName();
      String _selfPointer_1 = this.langExt.selfPointer(_name_2, false);
      _builder.append(_selfPointer_1, "\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* receiveEvent contains the main implementation of the FSM */");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("void receiveEvent(");
      String _name_3 = ac.getName();
      String _selfPointer_2 = this.langExt.selfPointer(_name_3, handleEvents);
      _builder.append(_selfPointer_2, "\t");
      {
        if (handleEvents) {
          _builder.append("etRuntime::InterfaceItemBase* ifitem, int evt, ");
          String _voidPointer_1 = this.langExt.voidPointer();
          _builder.append(_voidPointer_1, "\t");
          _builder.append(" generic_data__et");
        }
      }
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * helper method to determine whether this state machine uses handler transitions
   * points at all
   * 
   * @param xpax the {@link ExpandedActorClass}
   * @return <code>true</code> if the state machine uses handler transition points
   */
  private boolean usesHandlerTrPoints(final ExpandedActorClass xpac) {
    boolean _xblockexpression = false;
    {
      StateGraph _stateMachine = xpac.getStateMachine();
      boolean _isEmpty = this._roomHelpers.isEmpty(_stateMachine);
      if (_isEmpty) {
        return false;
      }
      StateGraph _stateMachine_1 = xpac.getStateMachine();
      List<TrPoint> _allTrPointsRecursive = this._roomHelpers.getAllTrPointsRecursive(_stateMachine_1);
      final Function1<TrPoint, Boolean> _function = new Function1<TrPoint, Boolean>() {
        public Boolean apply(final TrPoint t) {
          boolean _and = false;
          if (!(t instanceof TransitionPoint)) {
            _and = false;
          } else {
            boolean _isHandler = ((TransitionPoint) t).isHandler();
            _and = _isHandler;
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterable<TrPoint> _filter = IterableExtensions.<TrPoint>filter(_allTrPointsRecursive, _function);
      boolean _isEmpty_1 = IterableExtensions.isEmpty(_filter);
      _xblockexpression = (!_isEmpty_1);
    }
    return _xblockexpression;
  }
  
  protected CharSequence guard(final Transition tt, final String trigger, final ExpandedActorClass ac) {
    if (tt instanceof TriggeredTransition) {
      return _guard((TriggeredTransition)tt, trigger, ac);
    } else if (tt != null) {
      return _guard(tt, trigger, ac);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(tt, trigger, ac).toString());
    }
  }
}
