/**
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 */
package org.eclipse.etrice.core.genmodel.fsm.tests;

import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionBase;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.genmodel.fsm.NullLogger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.etrice.core.genmodel.fsm.tests.FsmGenTestBase;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class TestStatesTriggers extends FsmGenTestBase {
  private RoomNameProvider roomNameProvider = new RoomNameProvider();
  
  private GraphContainer gc;
  
  @Before
  public void SetUp() {
    this.gc = this.getGraphContainer("StatesTriggersExample.room", "TestActor");
    Assert.assertNotNull("graph context was created", this.gc);
    final NullLogger logger = new NullLogger();
    FsmGenChecker.check(this.gc, logger);
    Assert.assertFalse("logger has no errors", logger.hasErrors());
    this.builder.withCommonData(this.builder.withChainHeads(this.builder.withTriggersInStates(this.gc)));
    Assert.assertFalse("diagnostician has no errors", this.diagnostician.isFailed());
  }
  
  @Test
  public void testNoTrigger() {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("State3"));
      }
    };
    final Node s = IteratorExtensions.<Node>head(IteratorExtensions.<Node>filter(FsmGenExtensions.getAllStateNodes(this.gc.getGraph()), _function));
    Assert.assertNotNull("state found", s);
    Assert.assertEquals("non-leave state has no caught triggers", 0, s.getCaughtTriggers().size());
  }
  
  @Test
  public void testObjectNumbers() {
    Assert.assertEquals("Number of states", 7, IteratorExtensions.size(FsmGenExtensions.getAllStateNodes(this.gc.getGraph())));
    Assert.assertEquals("Number of choice points", 1, IteratorExtensions.size(FsmGenExtensions.getAllChoicePointNodes(this.gc.getGraph())));
    Assert.assertEquals("Number of transition points", 4, IteratorExtensions.size(FsmGenExtensions.getAllTransitionPointNodes(this.gc.getGraph())));
    Assert.assertEquals("Number of entry points", 1, IteratorExtensions.size(FsmGenExtensions.getAllEntryPointNodes(this.gc.getGraph())));
    Assert.assertEquals("Number of exit points", 1, IteratorExtensions.size(FsmGenExtensions.getAllExitPointNodes(this.gc.getGraph())));
    Assert.assertEquals("Number of initial transitions", 2, IteratorExtensions.size(FsmGenExtensions.getAllInitialTranisitionLinks(this.gc.getGraph())));
    Assert.assertEquals("Number of triggered transitions", 11, IteratorExtensions.size(FsmGenExtensions.getAllTriggeredTranisitionLinks(this.gc.getGraph())));
    Assert.assertEquals("Number of continuation transitions", 3, IteratorExtensions.size(FsmGenExtensions.getAllContinuationTranisitionLinks(this.gc.getGraph())));
    Assert.assertEquals("Number of cpbranch transitions", 2, IteratorExtensions.size(FsmGenExtensions.getAllCPBranchTranisitionLinks(this.gc.getGraph())));
  }
  
  @Test
  public void testChainsAndTriggers() {
    Assert.assertEquals("transition chains", 13, IteratorExtensions.size(FsmGenExtensions.getAllChainHeads(this.gc.getGraph())));
  }
  
  @Test
  public void testGraph() {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("State3"));
      }
    };
    Node s = IterableExtensions.<Node>head(IterableExtensions.<Node>filter(this.gc.getGraph().getNodes(), _function));
    final Function1<Node, Boolean> _function_1 = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("State3"));
      }
    };
    s = IterableExtensions.<Node>head(IterableExtensions.<Node>filter(s.getSubgraph().getNodes(), _function_1));
    Assert.assertNotNull("state found", s);
    Assert.assertEquals("number of incoming transitions", 3, s.getIncoming().size());
    Assert.assertEquals("number of outgoing transitions", 2, s.getOutgoing().size());
    Assert.assertEquals("active triggers", 6, s.getCaughtTriggers().size());
    final Function1<Node, Boolean> _function_2 = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("State2"));
      }
    };
    s = IterableExtensions.<Node>head(IterableExtensions.<Node>filter(this.gc.getGraph().getNodes(), _function_2));
    Assert.assertNotNull("state found", s);
    Assert.assertEquals("number of incoming transitions", 4, s.getIncoming().size());
    Assert.assertEquals("number of outgoing transitions", 1, s.getOutgoing().size());
    Assert.assertEquals("active triggers", 3, s.getCaughtTriggers().size());
    final Function1<Node, Boolean> _function_3 = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("CP1"));
      }
    };
    final Node cp = IterableExtensions.<Node>head(IterableExtensions.<Node>filter(this.gc.getGraph().getNodes(), _function_3));
    Assert.assertNotNull("cp found", cp);
    Assert.assertEquals("number of incoming transitions", 1, cp.getIncoming().size());
    Assert.assertEquals("number of outgoing transitions", 3, cp.getOutgoing().size());
    final Function1<Link, Boolean> _function_4 = new Function1<Link, Boolean>() {
      @Override
      public Boolean apply(final Link it) {
        TransitionBase _transition = it.getTransition();
        return Boolean.valueOf((_transition instanceof ContinuationTransition));
      }
    };
    final Iterable<Link> cts = IterableExtensions.<Link>filter(cp.getOutgoing(), _function_4);
    Assert.assertEquals("Exactly one continuation (=default) transition", 1, IterableExtensions.size(cts));
  }
  
  @Test
  public void testChains() {
    final Function1<Link, Boolean> _function = new Function1<Link, Boolean>() {
      @Override
      public Boolean apply(final Link it) {
        TransitionBase _transition = it.getTransition();
        return Boolean.valueOf(TestStatesTriggers.this.roomNameProvider.getFullPath(((Transition) _transition)).equals("State3_TRANS_tr1_FROM_tp1_TO_State3"));
      }
    };
    final Link tr = IteratorExtensions.<Link>head(IteratorExtensions.<Link>filter(FsmGenExtensions.getAllLinks(this.gc.getGraph()), _function));
    Assert.assertNotNull("transition found", tr);
    Assert.assertEquals("one chain head", 1, tr.getChainHeads().size());
    TransitionBase _transition = IterableExtensions.<Link>head(tr.getChainHeads()).getTransition();
    Assert.assertEquals("correct chain head", "TRANS_tr5_FROM_tp0_TO_State3_tp1_BY_afct", this.roomNameProvider.getFullPath(((Transition) _transition)));
  }
}
