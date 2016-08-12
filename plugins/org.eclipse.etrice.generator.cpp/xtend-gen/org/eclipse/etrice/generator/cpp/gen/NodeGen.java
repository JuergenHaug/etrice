/**
 * Copyright (c) 2011 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 */
package org.eclipse.etrice.generator.cpp.gen;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.common.converter.TimeConverter;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.etphys.eTPhys.ExecMode;
import org.eclipse.etrice.core.etphys.eTPhys.NodeClass;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.genmodel.builder.GenmodelConstants;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Wire;
import org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass;
import org.eclipse.etrice.core.genmodel.etricegen.WiredSubSystemClass;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.IDiagnostician;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.base.GlobalGeneratorSettings;
import org.eclipse.etrice.generator.cpp.Main;
import org.eclipse.etrice.generator.cpp.gen.CppExtensions;
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers;
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.fsm.base.Indexed;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Singleton
@SuppressWarnings("all")
public class NodeGen {
  @Inject
  @Extension
  private CppExtensions _cppExtensions;
  
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  @Inject
  @Extension
  private ProcedureHelpers _procedureHelpers;
  
  @Inject
  @Extension
  private FileSystemHelpers _fileSystemHelpers;
  
  @Inject
  private IGeneratorFileIo fileIO;
  
  @Inject
  private IDiagnostician diagnostician;
  
  public void doGenerate(final Root root) {
    final Map<SubSystemClass, WiredSubSystemClass> sscc2wired = CollectionLiterals.<SubSystemClass, WiredSubSystemClass>newHashMap();
    EList<WiredStructureClass> _wiredInstances = root.getWiredInstances();
    Iterable<WiredSubSystemClass> _filter = Iterables.<WiredSubSystemClass>filter(_wiredInstances, WiredSubSystemClass.class);
    final Procedure1<WiredSubSystemClass> _function = new Procedure1<WiredSubSystemClass>() {
      public void apply(final WiredSubSystemClass it) {
        SubSystemClass _subSystemClass = it.getSubSystemClass();
        sscc2wired.put(_subSystemClass, it);
      }
    };
    IterableExtensions.<WiredSubSystemClass>forEach(_filter, _function);
    Collection<NodeRef> _nodeRefs = ETMapUtil.getNodeRefs();
    for (final NodeRef nr : _nodeRefs) {
      List<String> _subSystemInstancePaths = ETMapUtil.getSubSystemInstancePaths(nr);
      for (final String instpath : _subSystemInstancePaths) {
        {
          StructureInstance _instance = root.getInstance(instpath);
          final SubSystemInstance ssi = ((SubSystemInstance) _instance);
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(ssi, null));
          if (!_notEquals) {
            _and = false;
          } else {
            SubSystemClass _subSystemClass = ssi.getSubSystemClass();
            boolean _isValidGenerationLocation = this._fileSystemHelpers.isValidGenerationLocation(_subSystemClass);
            _and = _isValidGenerationLocation;
          }
          if (_and) {
            SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
            final WiredSubSystemClass wired = sscc2wired.get(_subSystemClass_1);
            SubSystemClass _subSystemClass_2 = ssi.getSubSystemClass();
            String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(_subSystemClass_2);
            SubSystemClass _subSystemClass_3 = ssi.getSubSystemClass();
            String _path = this._roomExtensions.getPath(_subSystemClass_3);
            final String path = (_generationTargetPath + _path);
            SubSystemClass _subSystemClass_4 = ssi.getSubSystemClass();
            String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(_subSystemClass_4);
            SubSystemClass _subSystemClass_5 = ssi.getSubSystemClass();
            String _path_1 = this._roomExtensions.getPath(_subSystemClass_5);
            final String infopath = (_generationInfoPath + _path_1);
            final Set<PhysicalThread> usedThreads = ETMapUtil.getUsedThreads(nr, ssi);
            String _cppHeaderFileName = this._cppExtensions.getCppHeaderFileName(nr, ssi);
            CharSequence _generateHeaderFile = this.generateHeaderFile(root, ssi, wired, usedThreads);
            this.fileIO.generateFile("generating Node declaration", path, infopath, _cppHeaderFileName, _generateHeaderFile);
            String _cppSourceFileName = this._cppExtensions.getCppSourceFileName(nr, ssi);
            CharSequence _generateSourceFile = this.generateSourceFile(root, ssi, wired, usedThreads);
            this.fileIO.generateFile("generating Node implementation", path, infopath, _cppSourceFileName, _generateSourceFile);
          }
        }
      }
    }
  }
  
  public CharSequence generateHeaderFile(final Root root, final SubSystemInstance comp, final WiredSubSystemClass wired, final Collection<PhysicalThread> usedThreads) {
    CharSequence _xblockexpression = null;
    {
      final SubSystemClass cc = comp.getSubSystemClass();
      final EList<RoomModel> models = root.getReferencedModels(cc);
      final NodeRef nr = ETMapUtil.getNodeRef(comp);
      final String clsname = this._cppExtensions.getCppClassName(nr, comp);
      NodeClass _type = nr.getType();
      EList<PhysicalThread> _threads = _type.getThreads();
      final Function1<PhysicalThread, Boolean> _function = new Function1<PhysicalThread, Boolean>() {
        public Boolean apply(final PhysicalThread t) {
          return Boolean.valueOf(usedThreads.contains(t));
        }
      };
      final Iterable<PhysicalThread> threads = IterableExtensions.<PhysicalThread>filter(_threads, _function);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @author generated by eTrice");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Header File of SubSystemClass ");
      _builder.append(clsname, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      CharSequence _generateIncludeGuardBegin = this._cppExtensions.generateIncludeGuardBegin(cc, "");
      _builder.append(_generateIncludeGuardBegin, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"common/modelbase/SubSystemClassBase.h\"");
      _builder.newLine();
      _builder.newLine();
      DetailCode _userCode1 = cc.getUserCode1();
      CharSequence _userCode = this._procedureHelpers.userCode(_userCode1);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      String _generateNamespaceBegin = this._cppExtensions.generateNamespaceBegin(cc);
      _builder.append(_generateNamespaceBegin, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("class ");
      _builder.append(clsname, "");
      _builder.append(" : public etRuntime::SubSystemClassBase{");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      DetailCode _userCode2 = cc.getUserCode2();
      CharSequence _userCode_1 = this._procedureHelpers.userCode(_userCode2);
      _builder.append(_userCode_1, "\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public:");
      _builder.newLine();
      _builder.newLine();
      {
        Iterable<Indexed<PhysicalThread>> _indexed = Indexed.<PhysicalThread>indexed(threads);
        for(final Indexed<PhysicalThread> thread : _indexed) {
          _builder.append("\t\t");
          _builder.append("static const int ");
          PhysicalThread _value = thread.getValue();
          String _threadId = this.getThreadId(_value);
          _builder.append(_threadId, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append(clsname, "\t\t");
      _builder.append("(IRTObject* parent, const std::string& name);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("virtual void receiveEvent(etRuntime::InterfaceItemBase* ifitem, int evt, void* data);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("virtual void instantiateMessageServices();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("virtual void instantiateActors();");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("virtual void init();");
      _builder.newLine();
      _builder.newLine();
      {
        GlobalGeneratorSettings _settings = Main.getSettings();
        boolean _isGenerateMSCInstrumentation = _settings.isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation) {
          _builder.append("\t\t");
          _builder.append("etBool hasGeneratedMSCInstrumentation() const { return true; }");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("virtual void destroy();");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private:");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append(clsname, "\t\t");
      _builder.append("();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append(clsname, "\t\t");
      _builder.append("(");
      _builder.append(clsname, "\t\t");
      _builder.append(" const&);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append(clsname, "\t\t");
      _builder.append("& operator=(");
      _builder.append(clsname, "\t\t");
      _builder.append(" const&);");
      _builder.newLineIfNotEmpty();
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      String _generateNamespaceEnd = this._cppExtensions.generateNamespaceEnd(cc);
      _builder.append(_generateNamespaceEnd, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _generateIncludeGuardEnd = this._cppExtensions.generateIncludeGuardEnd(cc, "");
      _builder.append(_generateIncludeGuardEnd, "");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private String getThreadId(final PhysicalThread thread) {
    String _name = thread.getName();
    String _upperCase = _name.toUpperCase();
    return ("THREAD_" + _upperCase);
  }
  
  public CharSequence generateSourceFile(final Root root, final SubSystemInstance comp, final WiredSubSystemClass wired, final Collection<PhysicalThread> usedThreads) {
    CharSequence _xblockexpression = null;
    {
      final SubSystemClass cc = comp.getSubSystemClass();
      final EList<RoomModel> models = root.getReferencedModels(cc);
      final NodeRef nr = ETMapUtil.getNodeRef(comp);
      final String clsname = this._cppExtensions.getCppClassName(nr, comp);
      NodeClass _type = nr.getType();
      EList<PhysicalThread> _threads = _type.getThreads();
      final Function1<PhysicalThread, Boolean> _function = new Function1<PhysicalThread, Boolean>() {
        public Boolean apply(final PhysicalThread t) {
          return Boolean.valueOf(usedThreads.contains(t));
        }
      };
      final Iterable<PhysicalThread> threads = IterableExtensions.<PhysicalThread>filter(_threads, _function);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @author generated by eTrice");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Source File of SubsystemClass ");
      _builder.append(clsname, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.append("#include \"");
      String _cppHeaderFileName = this._cppExtensions.getCppHeaderFileName(nr, comp);
      _builder.append(_cppHeaderFileName, "");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"common/debugging/DebuggingService.h\"");
      _builder.newLine();
      _builder.append("#include \"common/messaging/IMessageService.h\"");
      _builder.newLine();
      _builder.append("#include \"common/messaging/MessageService.h\"");
      _builder.newLine();
      _builder.append("#include \"common/messaging/MessageServiceController.h\"");
      _builder.newLine();
      _builder.append("#include \"common/messaging/RTServices.h\"");
      _builder.newLine();
      _builder.append("#include \"common/modelbase/InterfaceItemBase.h\"");
      _builder.newLine();
      _builder.newLine();
      {
        EList<ActorInstance> _actorInstances = comp.getActorInstances();
        for(final ActorInstance ai : _actorInstances) {
          _builder.append("#include \"");
          ActorClass _actorClass = ai.getActorClass();
          String _actorIncludePath = this._cppExtensions.getActorIncludePath(_actorClass);
          _builder.append(_actorIncludePath, "");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("using namespace etRuntime;");
      _builder.newLine();
      _builder.newLine();
      String _generateNamespaceBegin = this._cppExtensions.generateNamespaceBegin(cc);
      _builder.append(_generateNamespaceBegin, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        Iterable<Indexed<PhysicalThread>> _indexed = Indexed.<PhysicalThread>indexed(threads);
        for(final Indexed<PhysicalThread> thread : _indexed) {
          _builder.append("const int ");
          _builder.append(clsname, "");
          _builder.append("::");
          PhysicalThread _value = thread.getValue();
          String _threadId = this.getThreadId(_value);
          _builder.append(_threadId, "");
          _builder.append(" = ");
          int _index0 = thread.getIndex0();
          _builder.append(_index0, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append(clsname, "");
      _builder.append("::");
      _builder.append(clsname, "");
      _builder.append("(IRTObject* parent, const std::string& name) :");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("SubSystemClassBase(parent, name)");
      _builder.newLine();
      _builder.append("{");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname, "");
      _builder.append("::receiveEvent(InterfaceItemBase* ifitem, int evt, void* data){");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname, "");
      _builder.append("::instantiateMessageServices(){");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("IMessageService* msgService;");
      _builder.newLine();
      {
        for(final PhysicalThread thread_1 : threads) {
          _builder.append("\t");
          _builder.append("{");
          _builder.newLine();
          {
            boolean _or = false;
            ExecMode _execmode = thread_1.getExecmode();
            boolean _equals = Objects.equal(_execmode, ExecMode.POLLED);
            if (_equals) {
              _or = true;
            } else {
              ExecMode _execmode_1 = thread_1.getExecmode();
              boolean _equals_1 = Objects.equal(_execmode_1, ExecMode.MIXED);
              _or = _equals_1;
            }
            if (_or) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("etTime interval;");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("interval.sec = ");
              long _time = thread_1.getTime();
              long _split = TimeConverter.split(_time, TimeConverter.SEC, true);
              _builder.append(_split, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("interval.nSec = ");
              long _time_1 = thread_1.getTime();
              long _split_1 = TimeConverter.split(_time_1, TimeConverter.MILLI_SEC, false);
              _builder.append(_split_1, "\t\t");
              _builder.append("L;");
              _builder.newLineIfNotEmpty();
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("msgService = new MessageService(this, IMessageService::");
              ExecMode _execmode_2 = thread_1.getExecmode();
              String _name = _execmode_2.getName();
              _builder.append(_name, "\t\t");
              _builder.append(", interval, 0, ");
              String _threadId_1 = this.getThreadId(thread_1);
              _builder.append(_threadId_1, "\t\t");
              _builder.append(", \"MessageService_");
              String _name_1 = thread_1.getName();
              _builder.append(_name_1, "\t\t");
              _builder.append("\", ");
              int _prio = thread_1.getPrio();
              _builder.append(_prio, "\t\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("msgService = new MessageService(this, IMessageService::");
              ExecMode _execmode_3 = thread_1.getExecmode();
              String _name_2 = _execmode_3.getName();
              _builder.append(_name_2, "\t\t");
              _builder.append(", 0, ");
              String _threadId_2 = this.getThreadId(thread_1);
              _builder.append(_threadId_2, "\t\t");
              _builder.append(", \"MessageService_");
              String _name_3 = thread_1.getName();
              _builder.append(_name_3, "\t\t");
              _builder.append("\", ");
              int _prio_1 = thread_1.getPrio();
              _builder.append(_prio_1, "\t\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("RTServices::getInstance().getMsgSvcCtrl().addMsgSvc(*msgService);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname, "");
      _builder.append("::instantiateActors(){");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// thread mappings");
      _builder.newLine();
      {
        EList<ActorInstance> _allContainedInstances = comp.getAllContainedInstances();
        for(final ActorInstance ai_1 : _allContainedInstances) {
          _builder.append("\t");
          final ETMapUtil.MappedThread mapped = ETMapUtil.getMappedThread(ai_1);
          _builder.newLineIfNotEmpty();
          {
            boolean _or_1 = false;
            boolean _isImplicit = mapped.isImplicit();
            if (_isImplicit) {
              _or_1 = true;
            } else {
              boolean _isAsParent = mapped.isAsParent();
              _or_1 = _isAsParent;
            }
            boolean _not = (!_or_1);
            if (_not) {
              _builder.append("\t");
              _builder.append("addPathToThread(\"");
              String _path = ai_1.getPath();
              _builder.append(_path, "\t");
              _builder.append("\", ");
              PhysicalThread _thread = mapped.getThread();
              String _threadId_3 = this.getThreadId(_thread);
              _builder.append(_threadId_3, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// sub actors");
      _builder.newLine();
      {
        EList<ActorRef> _actorRefs = cc.getActorRefs();
        for(final ActorRef sub : _actorRefs) {
          {
            int _multiplicity = sub.getMultiplicity();
            boolean _greaterThan = (_multiplicity > 1);
            if (_greaterThan) {
              _builder.append("\t");
              _builder.append("for (int i=0; i<");
              int _multiplicity_1 = sub.getMultiplicity();
              _builder.append(_multiplicity_1, "\t");
              _builder.append("; ++i) {");
              _builder.newLineIfNotEmpty();
              {
                GlobalGeneratorSettings _settings = Main.getSettings();
                boolean _isGenerateMSCInstrumentation = _settings.isGenerateMSCInstrumentation();
                if (_isGenerateMSCInstrumentation) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("DebuggingService::getInstance().addMessageActorCreate(*this, \"");
                  String _name_4 = sub.getName();
                  _builder.append(_name_4, "\t\t");
                  _builder.append(GenmodelConstants.INDEX_SEP, "\t\t");
                  _builder.append("\"+i);");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("new ");
              ActorClass _type_1 = sub.getType();
              String _implementationClassName = this._cppExtensions.getImplementationClassName(_type_1);
              _builder.append(_implementationClassName, "\t\t");
              _builder.append("(this, \"");
              String _name_5 = sub.getName();
              _builder.append(_name_5, "\t\t");
              _builder.append(GenmodelConstants.INDEX_SEP, "\t\t");
              _builder.append("\"+i);");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            } else {
              {
                GlobalGeneratorSettings _settings_1 = Main.getSettings();
                boolean _isGenerateMSCInstrumentation_1 = _settings_1.isGenerateMSCInstrumentation();
                if (_isGenerateMSCInstrumentation_1) {
                  _builder.append("\t");
                  _builder.append("DebuggingService::getInstance().addMessageActorCreate(*this, \"");
                  String _name_6 = sub.getName();
                  _builder.append(_name_6, "\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("new ");
              ActorClass _type_2 = sub.getType();
              String _implementationClassName_1 = this._cppExtensions.getImplementationClassName(_type_2);
              _builder.append(_implementationClassName_1, "\t");
              _builder.append("(this, \"");
              String _name_7 = sub.getName();
              _builder.append(_name_7, "\t");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// wiring");
      _builder.newLine();
      {
        EList<Wire> _wires = wired.getWires();
        for(final Wire wire : _wires) {
          _builder.append("\t");
          String _xifexpression = null;
          boolean _isDataDriven = wire.isDataDriven();
          if (_isDataDriven) {
            _xifexpression = "DataPortBase";
          } else {
            _xifexpression = "InterfaceItemBase";
          }
          _builder.append(_xifexpression, "\t");
          _builder.append("::connect(this, \"");
          EList<String> _path1 = wire.getPath1();
          String _join = IterableExtensions.join(_path1, "/");
          _builder.append(_join, "\t");
          _builder.append("\", \"");
          EList<String> _path2 = wire.getPath2();
          String _join_1 = IterableExtensions.join(_path2, "/");
          _builder.append(_join_1, "\t");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname, "");
      _builder.append("::init(){");
      _builder.newLineIfNotEmpty();
      {
        GlobalGeneratorSettings _settings_2 = Main.getSettings();
        boolean _isGenerateMSCInstrumentation_2 = _settings_2.isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_2) {
          _builder.append("\t");
          _builder.append("DebuggingService::getInstance().addVisibleComment(\"begin sub system initialization\");");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("SubSystemClassBase::init();");
      _builder.newLine();
      {
        GlobalGeneratorSettings _settings_3 = Main.getSettings();
        boolean _isGenerateMSCInstrumentation_3 = _settings_3.isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_3) {
          _builder.append("\t");
          _builder.append("DebuggingService::getInstance().addVisibleComment(\"done sub system initialization\");");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      {
        GlobalGeneratorSettings _settings_4 = Main.getSettings();
        boolean _isGenerateMSCInstrumentation_4 = _settings_4.isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_4) {
          _builder.newLine();
          _builder.append("void ");
          _builder.append(clsname, "");
          _builder.append("::destroy() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("DebuggingService::getInstance().addVisibleComment(\"begin sub system destruction\");");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("SubSystemClassBase::destroy();");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("DebuggingService::getInstance().addVisibleComment(\"done sub system destruction\");");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      String _generateNamespaceEnd = this._cppExtensions.generateNamespaceEnd(cc);
      _builder.append(_generateNamespaceEnd, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
