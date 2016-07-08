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

import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.Guard;
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedRefinedState;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.TransitionChain;
import org.eclipse.etrice.generator.fsm.generic.AbstractStateMachineGenerator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * A target language independent generator of the state machine implementation
 */
@SuppressWarnings("all")
public class GenericStateMachineGenerator extends AbstractStateMachineGenerator {
  /**
   * generates the code of the whole state machine, consisting of constants + methods
   * 
   * @param xpmc the {@link ExpandedModelComponent}
   * @return the generated code
   */
  public CharSequence genStateMachine(final ExpandedModelComponent xpmc) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _genStateMachineConstants = this.genStateMachineConstants(xpmc);
    _builder.append(_genStateMachineConstants, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _genStateMachineMethods = this.genStateMachineMethods(xpmc, true);
    _builder.append(_genStateMachineMethods, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  /**
   * generates the constants for the state machine
   */
  public CharSequence genStateMachineConstants(final ExpandedModelComponent xpmc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* state IDs */");
    _builder.newLine();
    String _genStateIdConstants = this.genStateIdConstants(xpmc);
    _builder.append(_genStateIdConstants, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/* transition chains */");
    _builder.newLine();
    String _genTransitionChainConstants = this.genTransitionChainConstants(xpmc);
    _builder.append(_genTransitionChainConstants, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/* triggers */");
    _builder.newLine();
    String _genTriggerConstants = this.genTriggerConstants(xpmc);
    _builder.append(_genTriggerConstants, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  /**
   * generates the methods for the state machine codes and state switching
   * 
   * @param xpmc the {@link ExpandedModelComponent}
   * @param generateImplemenation or declaration only
   * @return the generated code
   */
  public CharSequence genStateMachineMethods(final ExpandedModelComponent xpmc, final boolean generateImplementation) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _genExtra = this.genExtra(xpmc, generateImplementation);
    _builder.append(_genExtra, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/* Entry and Exit Codes */");
    _builder.newLine();
    String _genEntryAndExitCodes = this.genEntryAndExitCodes(xpmc, generateImplementation);
    _builder.append(_genEntryAndExitCodes, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/* Action Codes */");
    _builder.newLine();
    String _genActionCodes = this.genActionCodes(xpmc, generateImplementation);
    _builder.append(_genActionCodes, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/* State Switch Methods */");
    _builder.newLine();
    String _genStateSwitchMethods = this.genStateSwitchMethods(xpmc, generateImplementation);
    _builder.append(_genStateSwitchMethods, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  /**
   * generate a transition guard if applicable
   * 
   * @param tt a {@link TriggeredTransition}
   * @param trigger a trigger string
   * @param xpmc an expanded actor class
   * @return the generated code
   */
  public String guard(final TriggeredTransition tt, final String trigger, final ExpandedModelComponent mc) {
    String _xblockexpression = null;
    {
      EList<Trigger> _triggers = tt.getTriggers();
      final Function1<Trigger, Boolean> _function = new Function1<Trigger, Boolean>() {
        public Boolean apply(final Trigger e) {
          return Boolean.valueOf(mc.isMatching(e, trigger));
        }
      };
      final Trigger tr = IterableExtensions.<Trigger>findFirst(_triggers, _function);
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _hasGuard = this._fSMHelpers.hasGuard(tr);
        if (_hasGuard) {
          _builder.append("if (");
          Guard _guard = tr.getGuard();
          DetailCode _guard_1 = _guard.getGuard();
          String _translatedCode = this.translator.getTranslatedCode(_guard_1);
          _builder.append(_translatedCode, "");
          _builder.append(")");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  public String guard(final GuardedTransition tt, final String trigger, final ExpandedModelComponent mc) {
    StringConcatenation _builder = new StringConcatenation();
    DetailCode _guard = tt.getGuard();
    String _translatedCode = this.translator.getTranslatedCode(_guard);
    _builder.append(_translatedCode, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String genActionCodeMethod(final ExpandedModelComponent xpmc, final Transition tr, final boolean generateImplementation) {
    String _xblockexpression = null;
    {
      EList<TransitionChain> chain = xpmc.getChains(tr);
      boolean _and = false;
      boolean _isEmpty = chain.isEmpty();
      boolean _not = (!_isEmpty);
      if (!_not) {
        _and = false;
      } else {
        final Function1<TransitionChain, Boolean> _function = new Function1<TransitionChain, Boolean>() {
          public Boolean apply(final TransitionChain it) {
            boolean _and = false;
            Transition _transition = it.getTransition();
            if (!(_transition instanceof NonInitialTransition)) {
              _and = false;
            } else {
              _and = (!(it.getTransition() instanceof GuardedTransition));
            }
            return Boolean.valueOf(_and);
          }
        };
        boolean _forall = IterableExtensions.<TransitionChain>forall(chain, _function);
        _and = _forall;
      }
      boolean hasArgs = _and;
      String _className = this.getClassName(xpmc);
      final String opScope = this.langExt.operationScope(_className, false);
      String _xifexpression = null;
      boolean _usesInheritance = this.langExt.usesInheritance();
      if (_usesInheritance) {
        _xifexpression = opScope;
      } else {
        _xifexpression = "";
      }
      final String opScopePriv = _xifexpression;
      String _pointerLiteral = this.langExt.pointerLiteral();
      final String ifItemPtr = ("InterfaceItemBase" + _pointerLiteral);
      String _xifexpression_1 = null;
      boolean _usesPointers = this.langExt.usesPointers();
      if (_usesPointers) {
        _xifexpression_1 = ("const " + ifItemPtr);
      } else {
        _xifexpression_1 = ifItemPtr;
      }
      final String constIfItemPtr = _xifexpression_1;
      String _xifexpression_2 = null;
      if (generateImplementation) {
        StringConcatenation _builder = new StringConcatenation();
        String _accessLevelProtected = this.langExt.accessLevelProtected();
        _builder.append(_accessLevelProtected, "");
        _builder.append("void ");
        _builder.append(opScopePriv, "");
        String _actionCodeOperationName = this._codegenHelpers.getActionCodeOperationName(tr);
        _builder.append(_actionCodeOperationName, "");
        _builder.append("(");
        String _className_1 = this.getClassName(xpmc);
        String _selfPointer = this.langExt.selfPointer(_className_1, hasArgs);
        _builder.append(_selfPointer, "");
        {
          if (hasArgs) {
            _builder.append(constIfItemPtr, "");
            _builder.append(" ifitem");
            String _generateArgumentList = this.transitionChainGenerator.generateArgumentList(xpmc, tr);
            _builder.append(_generateArgumentList, "");
          }
        }
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        DetailCode _action = tr.getAction();
        String _translatedCode = this.translator.getTranslatedCode(_action);
        _builder.append(_translatedCode, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _xifexpression_2 = _builder.toString();
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _accessLevelProtected_1 = this.langExt.accessLevelProtected();
        _builder_1.append(_accessLevelProtected_1, "");
        String _makeOverridable = this.langExt.makeOverridable();
        _builder_1.append(_makeOverridable, "");
        _builder_1.append("void ");
        String _actionCodeOperationName_1 = this._codegenHelpers.getActionCodeOperationName(tr);
        _builder_1.append(_actionCodeOperationName_1, "");
        _builder_1.append("(");
        String _className_2 = this.getClassName(xpmc);
        String _selfPointer_1 = this.langExt.selfPointer(_className_2, hasArgs);
        _builder_1.append(_selfPointer_1, "");
        {
          if (hasArgs) {
            _builder_1.append(constIfItemPtr, "");
            _builder_1.append(" ifitem");
            String _generateArgumentList_1 = this.transitionChainGenerator.generateArgumentList(xpmc, tr);
            _builder_1.append(_generateArgumentList_1, "");
          }
        }
        _builder_1.append(");");
        _builder_1.newLineIfNotEmpty();
        _xifexpression_2 = _builder_1.toString();
      }
      _xblockexpression = _xifexpression_2;
    }
    return _xblockexpression;
  }
  
  /**
   * generate action code method implementations or declarations
   * 
   * @param xpax the {@link ExpandedModelComponent}
   * @param state the {@link State}
   * @param generateImplementation if only declarations should be generated then <code>false</code> has to be passed
   * @return the generated code
   */
  public String genActionCodeMethods(final ExpandedModelComponent xpmc, final State state, final boolean generateImplementation) {
    String _xblockexpression = null;
    {
      final ModelComponent mc = xpmc.getModelComponent();
      String _className = this.getClassName(mc);
      final String selfPtr = this.langExt.selfPointer(_className, false);
      String _className_1 = this.getClassName(mc);
      final String opScope = this.langExt.operationScope(_className_1, false);
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
      DetailCode _entryCode = state.getEntryCode();
      String entry = this.translator.getTranslatedCode(_entryCode);
      DetailCode _exitCode = state.getExitCode();
      String exit = this.translator.getTranslatedCode(_exitCode);
      DetailCode _doCode = state.getDoCode();
      String docode = this.translator.getTranslatedCode(_doCode);
      if ((state instanceof ExpandedRefinedState)) {
        final ExpandedRefinedState rs = ((ExpandedRefinedState) state);
        DetailCode _inheritedEntry = rs.getInheritedEntry();
        final String inhEntry = this.translator.getTranslatedCode(_inheritedEntry);
        DetailCode _inheritedExit = rs.getInheritedExit();
        final String inhExit = this.translator.getTranslatedCode(_inheritedExit);
        DetailCode _inheritedDo = rs.getInheritedDo();
        final String inhDo = this.translator.getTranslatedCode(_inheritedDo);
        boolean _usesInheritance_1 = this.langExt.usesInheritance();
        if (_usesInheritance_1) {
          ModelComponent _base = mc.getBase();
          final String baseName = this.getClassName(_base);
          DetailCode _inheritedEntry_1 = rs.getInheritedEntry();
          boolean _hasDetailCode = this._fSMHelpers.hasDetailCode(_inheritedEntry_1);
          if (_hasDetailCode) {
            String _superCall = this.langExt.superCall(baseName, entryOp, "");
            String _plus = (_superCall + entry);
            entry = _plus;
          }
          DetailCode _inheritedExit_1 = rs.getInheritedExit();
          boolean _hasDetailCode_1 = this._fSMHelpers.hasDetailCode(_inheritedExit_1);
          if (_hasDetailCode_1) {
            String _superCall_1 = this.langExt.superCall(baseName, exitOp, "");
            String _plus_1 = (exit + _superCall_1);
            exit = _plus_1;
          }
          DetailCode _inheritedDo_1 = rs.getInheritedDo();
          boolean _hasDetailCode_2 = this._fSMHelpers.hasDetailCode(_inheritedDo_1);
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
              String _makeOverridable = this.langExt.makeOverridable();
              _builder.append(_makeOverridable, "");
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
              String _makeOverridable_1 = this.langExt.makeOverridable();
              _builder.append(_makeOverridable_1, "");
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
              String _makeOverridable_2 = this.langExt.makeOverridable();
              _builder.append(_makeOverridable_2, "");
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
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  /**
   * let derived class add extra code after definition of constants
   * 
   * @param xpmc an expanded actor class
   * @param generateImplementation or declaration only
   * @return the generated code
   */
  public CharSequence genExtra(final ExpandedModelComponent xpmc, final boolean generateImplementation) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
}
