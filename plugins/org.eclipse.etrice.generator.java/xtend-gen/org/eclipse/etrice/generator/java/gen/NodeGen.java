/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 */
package org.eclipse.etrice.generator.java.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.etphys.eTPhys.ExecMode;
import org.eclipse.etrice.core.etphys.eTPhys.NodeClass;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.base.Indexed;
import org.eclipse.etrice.generator.base.IntelligentSeparator;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.java.gen.ConfigGenAddon;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.etrice.generator.java.gen.VariableServiceGen;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class NodeGen {
  @Inject
  @Extension
  private JavaExtensions _javaExtensions;
  
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  @Inject
  private IDataConfiguration dataConfigExt;
  
  @Inject
  private ConfigGenAddon configGenAddon;
  
  @Inject
  @Extension
  private ProcedureHelpers _procedureHelpers;
  
  @Inject
  private IGeneratorFileIo fileIO;
  
  @Inject
  private VariableServiceGen varService;
  
  @Inject
  private IDiagnostician diagnostician;
  
  public void doGenerate(final Root root) {
    Collection<NodeRef> _nodeRefs = ETMapUtil.getNodeRefs();
    for (final NodeRef nr : _nodeRefs) {
      List<String> _subSystemInstancePaths = ETMapUtil.getSubSystemInstancePaths(nr);
      for (final String instpath : _subSystemInstancePaths) {
        {
          StructureInstance _instance = root.getInstance(instpath);
          final SubSystemInstance ssi = ((SubSystemInstance) _instance);
          SubSystemClass _subSystemClass = ssi.getSubSystemClass();
          String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(_subSystemClass);
          SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
          String _path = this._roomExtensions.getPath(_subSystemClass_1);
          final String path = (_generationTargetPath + _path);
          SubSystemClass _subSystemClass_2 = ssi.getSubSystemClass();
          String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(_subSystemClass_2);
          SubSystemClass _subSystemClass_3 = ssi.getSubSystemClass();
          String _path_1 = this._roomExtensions.getPath(_subSystemClass_3);
          final String infopath = (_generationInfoPath + _path_1);
          final String file = this._javaExtensions.getJavaFileName(nr, ssi);
          this.checkDataPorts(ssi);
          HashSet<PhysicalThread> _hashSet = new HashSet<PhysicalThread>();
          final HashSet<PhysicalThread> usedThreads = _hashSet;
          NodeClass _type = nr.getType();
          EList<PhysicalThread> _threads = _type.getThreads();
          for (final PhysicalThread thread : _threads) {
            {
              EList<ActorInstance> _allContainedInstances = ssi.getAllContainedInstances();
              final Function1<ActorInstance,Boolean> _function = new Function1<ActorInstance,Boolean>() {
                  public Boolean apply(final ActorInstance ai) {
                    PhysicalThread _physicalThread = ETMapUtil.getPhysicalThread(ai);
                    boolean _equals = Objects.equal(_physicalThread, thread);
                    return Boolean.valueOf(_equals);
                  }
                };
              final Iterable<ActorInstance> instancesOnThread = IterableExtensions.<ActorInstance>filter(_allContainedInstances, _function);
              boolean _isEmpty = IterableExtensions.isEmpty(instancesOnThread);
              boolean _not = (!_isEmpty);
              if (_not) {
                usedThreads.add(thread);
              }
            }
          }
          CharSequence _generate = this.generate(root, ssi, usedThreads);
          this.fileIO.generateFile("generating Node implementation", path, infopath, file, _generate);
          boolean _hasVariableService = this.dataConfigExt.hasVariableService(ssi);
          if (_hasVariableService) {
            this.varService.doGenerate(root, ssi);
          }
        }
      }
    }
  }
  
  public CharSequence generate(final Root root, final SubSystemInstance comp, final HashSet<PhysicalThread> usedThreads) {
    CharSequence _xblockexpression = null;
    {
      final SubSystemClass cc = comp.getSubSystemClass();
      final EList<RoomModel> models = root.getReferencedModels(cc);
      final NodeRef nr = ETMapUtil.getNodeRef(comp);
      final String clsname = this._javaExtensions.getJavaClassName(nr, comp);
      NodeClass _type = nr.getType();
      EList<PhysicalThread> _threads = _type.getThreads();
      final Function1<PhysicalThread,Boolean> _function = new Function1<PhysicalThread,Boolean>() {
          public Boolean apply(final PhysicalThread t) {
            boolean _contains = usedThreads.contains(t);
            return Boolean.valueOf(_contains);
          }
        };
      final Iterable<PhysicalThread> threads = IterableExtensions.<PhysicalThread>filter(_threads, _function);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _package = this._roomExtensions.getPackage(cc);
      _builder.append(_package, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.config.IVariableService;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.IRTObject;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.IMessageService;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.MessageService;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.RTServices;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;");
      _builder.newLine();
      _builder.newLine();
      {
        for(final RoomModel model : models) {
          _builder.append("import ");
          String _name = model.getName();
          _builder.append(_name, "");
          _builder.append(".*;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      CharSequence _userCode = this._procedureHelpers.userCode(cc, 1);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(clsname, "");
      _builder.append(" extends SubSystemClassBase {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        Iterable<Indexed<PhysicalThread>> _indexed = Indexed.<PhysicalThread>indexed(threads);
        for(final Indexed<PhysicalThread> thread : _indexed) {
          _builder.append("\t");
          _builder.append("public final int ");
          PhysicalThread _value = thread.getValue();
          String _threadId = this.getThreadId(_value);
          _builder.append(_threadId, "	");
          _builder.append(" = ");
          int _index0 = thread.getIndex0();
          _builder.append(_index0, "	");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      CharSequence _userCode_1 = this._procedureHelpers.userCode(cc, 2);
      _builder.append(_userCode_1, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(clsname, "	");
      _builder.append("(IRTObject parent, String name) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(parent, name);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void instantiateMessageServices() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("IMessageService msgService;");
      _builder.newLine();
      {
        for(final PhysicalThread thread_1 : threads) {
          {
            boolean _or = false;
            ExecMode _execmode = thread_1.getExecmode();
            boolean _equals = Objects.equal(_execmode, ExecMode.POLLED);
            if (_equals) {
              _or = true;
            } else {
              ExecMode _execmode_1 = thread_1.getExecmode();
              boolean _equals_1 = Objects.equal(_execmode_1, ExecMode.MIXED);
              _or = (_equals || _equals_1);
            }
            if (_or) {
              _builder.append("\t\t");
              _builder.append("msgService = new MessageService(this, MessageService.ExecMode.");
              ExecMode _execmode_2 = thread_1.getExecmode();
              String _name_1 = _execmode_2.name();
              _builder.append(_name_1, "		");
              _builder.append(", ");
              int _time = thread_1.getTime();
              _builder.append(_time, "		");
              _builder.append(", 0, ");
              String _threadId_1 = this.getThreadId(thread_1);
              _builder.append(_threadId_1, "		");
              _builder.append(", \"MessageService_");
              String _name_2 = thread_1.getName();
              _builder.append(_name_2, "		");
              _builder.append("\" /*, thread_prio */);");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t\t");
              _builder.append("msgService = new MessageService(this, MessageService.ExecMode.");
              ExecMode _execmode_3 = thread_1.getExecmode();
              String _name_3 = _execmode_3.name();
              _builder.append(_name_3, "		");
              _builder.append(", 0, ");
              String _threadId_2 = this.getThreadId(thread_1);
              _builder.append(_threadId_2, "		");
              _builder.append(", \"MessageService_");
              String _name_4 = thread_1.getName();
              _builder.append(_name_4, "		");
              _builder.append("\" /*, thread_prio */);");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t\t");
          _builder.append("RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(msgService);");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void instantiateActors() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// thread mappings");
      _builder.newLine();
      {
        EList<ActorInstance> _allContainedInstances = comp.getAllContainedInstances();
        for(final ActorInstance ai : _allContainedInstances) {
          _builder.append("\t\t");
          _builder.append("addPathToThread(\"");
          String _path = ai.getPath();
          _builder.append(_path, "		");
          _builder.append("\", ");
          PhysicalThread _physicalThread = ETMapUtil.getPhysicalThread(ai);
          String _threadId_3 = this.getThreadId(_physicalThread);
          _builder.append(_threadId_3, "		");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// port to peer port mappings");
      _builder.newLine();
      {
        EList<ActorInstance> _allContainedInstances_1 = comp.getAllContainedInstances();
        for(final ActorInstance ai_1 : _allContainedInstances_1) {
          {
            EList<InterfaceItemInstance> _orderedIfItemInstances = ai_1.getOrderedIfItemInstances();
            for(final InterfaceItemInstance pi : _orderedIfItemInstances) {
              {
                EList<InterfaceItemInstance> _peers = pi.getPeers();
                int _size = _peers.size();
                boolean _greaterThan = (_size > 0);
                if (_greaterThan) {
                  _builder.append("\t\t");
                  _builder.append("addPathToPeers(\"");
                  String _path_1 = pi.getPath();
                  _builder.append(_path_1, "		");
                  _builder.append("\", ");
                  {
                    EList<InterfaceItemInstance> _peers_1 = pi.getPeers();
                    boolean _hasElements = false;
                    for(final InterfaceItemInstance peer : _peers_1) {
                      if (!_hasElements) {
                        _hasElements = true;
                      } else {
                        _builder.appendImmediate(",", "		");
                      }
                      _builder.append("\"");
                      String _path_2 = peer.getPath();
                      _builder.append(_path_2, "		");
                      _builder.append("\"");
                    }
                  }
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// sub actors");
      _builder.newLine();
      {
        EList<ActorRef> _actorRefs = cc.getActorRefs();
        for(final ActorRef sub : _actorRefs) {
          {
            int _size_1 = sub.getSize();
            boolean _greaterThan_1 = (_size_1 > 1);
            if (_greaterThan_1) {
              _builder.append("\t\t");
              _builder.append("for (int i=0; i<");
              int _size_2 = sub.getSize();
              _builder.append(_size_2, "		");
              _builder.append("; ++i)");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("new ");
              ActorClass _type_1 = sub.getType();
              String _name_5 = _type_1.getName();
              _builder.append(_name_5, "			");
              _builder.append("(this, \"");
              String _name_6 = sub.getName();
              _builder.append(_name_6, "			");
              _builder.append("_\"+i); ");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t\t");
              _builder.append("new ");
              ActorClass _type_2 = sub.getType();
              String _name_7 = _type_2.getName();
              _builder.append(_name_7, "		");
              _builder.append("(this, \"");
              String _name_8 = sub.getName();
              _builder.append(_name_8, "		");
              _builder.append("\"); ");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// apply instance attribute configurations");
      _builder.newLine();
      {
        EList<ActorInstance> _allContainedInstances_2 = comp.getAllContainedInstances();
        for(final ActorInstance ai_2 : _allContainedInstances_2) {
          _builder.append("\t\t");
          final CharSequence cfg = this.configGenAddon.genActorInstanceConfig(ai_2, "inst");
          _builder.newLineIfNotEmpty();
          {
            int _length = cfg.length();
            boolean _greaterThan_2 = (_length > 0);
            if (_greaterThan_2) {
              _builder.append("\t\t");
              _builder.append("{");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              ActorClass _actorClass = ai_2.getActorClass();
              String _name_9 = _actorClass.getName();
              _builder.append(_name_9, "			");
              _builder.append(" inst = (");
              ActorClass _actorClass_1 = ai_2.getActorClass();
              String _name_10 = _actorClass_1.getName();
              _builder.append(_name_10, "			");
              _builder.append(") getObject(\"");
              String _path_3 = ai_2.getPath();
              _builder.append(_path_3, "			");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("if (inst!=null) {");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t");
              _builder.append(cfg, "				");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void init(){");
      _builder.newLine();
      {
        boolean _hasVariableService = this.dataConfigExt.hasVariableService(comp);
        if (_hasVariableService) {
          _builder.append("\t\t");
          _builder.append("variableService = new ");
          _builder.append(clsname, "		");
          _builder.append("VariableService(this);");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.append("super.init();");
      _builder.newLine();
      {
        boolean _hasVariableService_1 = this.dataConfigExt.hasVariableService(comp);
        if (_hasVariableService_1) {
          _builder.append("\t\t");
          _builder.append("variableService.init();");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void stop(){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.stop();");
      _builder.newLine();
      {
        boolean _hasVariableService_2 = this.dataConfigExt.hasVariableService(comp);
        if (_hasVariableService_2) {
          _builder.append("\t\t");
          _builder.append("variableService.stop();");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public IOptionalActorFactory getFactory(String optionalActorClass, String actorClass) {");
      _builder.newLine();
      _builder.append("\t\t");
      IntelligentSeparator _intelligentSeparator = new IntelligentSeparator("else ");
      final IntelligentSeparator else1 = _intelligentSeparator;
      _builder.newLineIfNotEmpty();
      {
        EList<ActorClass> _optionalActorClasses = root.getOptionalActorClasses();
        for(final ActorClass oa : _optionalActorClasses) {
          _builder.append("\t\t");
          _builder.append(else1, "		");
          _builder.append("if (optionalActorClass.equals(\"");
          String _name_11 = oa.getName();
          _builder.append(_name_11, "		");
          _builder.append("\")) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          IntelligentSeparator _intelligentSeparator_1 = new IntelligentSeparator("else ");
          final IntelligentSeparator else2 = _intelligentSeparator_1;
          _builder.newLineIfNotEmpty();
          {
            EList<ActorClass> _subClasses = root.getSubClasses(oa);
            List<ActorClass> _union = this._roomExtensions.<ActorClass>union(_subClasses, oa);
            final Function1<ActorClass,Boolean> _function_1 = new Function1<ActorClass,Boolean>() {
                public Boolean apply(final ActorClass s) {
                  boolean _isAbstract = s.isAbstract();
                  boolean _not = (!_isAbstract);
                  return Boolean.valueOf(_not);
                }
              };
            Iterable<ActorClass> _filter = IterableExtensions.<ActorClass>filter(_union, _function_1);
            for(final ActorClass subcls : _filter) {
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append(else2, "			");
              _builder.append("if (\"");
              String _name_12 = subcls.getName();
              _builder.append(_name_12, "			");
              _builder.append("\".equals(actorClass)) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("return new ");
              String _javaFactoryName = this._javaExtensions.getJavaFactoryName(subcls);
              _builder.append(_javaFactoryName, "				");
              _builder.append("();");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            }
          }
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return null;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private String getThreadId(final PhysicalThread thread) {
    String _name = thread.getName();
    String _upperCase = _name.toUpperCase();
    String _plus = ("THREAD_" + _upperCase);
    return _plus;
  }
  
  private void checkDataPorts(final SubSystemInstance comp) {
    HashSet<String> _hashSet = new HashSet<String>();
    final HashSet<String> found = _hashSet;
    EList<ActorInstance> _allContainedInstances = comp.getAllContainedInstances();
    for (final ActorInstance ai : _allContainedInstances) {
      {
        final int thread = ai.getThreadId();
        EList<InterfaceItemInstance> _orderedIfItemInstances = ai.getOrderedIfItemInstances();
        for (final InterfaceItemInstance pi : _orderedIfItemInstances) {
          ProtocolClass _protocol = pi.getProtocol();
          CommunicationType _commType = _protocol.getCommType();
          boolean _equals = Objects.equal(_commType, CommunicationType.DATA_DRIVEN);
          if (_equals) {
            EList<InterfaceItemInstance> _peers = pi.getPeers();
            for (final InterfaceItemInstance peer : _peers) {
              {
                EObject _eContainer = peer.eContainer();
                final ActorInstance peer_ai = ((ActorInstance) _eContainer);
                final int peer_thread = peer_ai.getThreadId();
                boolean _notEquals = (thread != peer_thread);
                if (_notEquals) {
                  final String path = pi.getPath();
                  final String ppath = peer.getPath();
                  String _xifexpression = null;
                  int _compareTo = path.compareTo(ppath);
                  boolean _lessThan = (_compareTo < 0);
                  if (_lessThan) {
                    String _plus = (path + " and ");
                    String _plus_1 = (_plus + ppath);
                    _xifexpression = _plus_1;
                  } else {
                    String _plus_2 = (ppath + " and ");
                    String _plus_3 = (_plus_2 + path);
                    _xifexpression = _plus_3;
                  }
                  final String pair = _xifexpression;
                  boolean _contains = found.contains(pair);
                  boolean _not = (!_contains);
                  if (_not) {
                    found.add(pair);
                    String _plus_4 = (pair + ": data ports placed on different threads (not supported yet)");
                    InterfaceItem _interfaceItem = pi.getInterfaceItem();
                    InterfaceItem _interfaceItem_1 = pi.getInterfaceItem();
                    EStructuralFeature _eContainingFeature = _interfaceItem_1.eContainingFeature();
                    this.diagnostician.error(_plus_4, _interfaceItem, _eContainingFeature);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}
