package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.base.Indexed;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.java.gen.ConfigGenAddon;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.etrice.generator.java.gen.VariableServiceGen;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;

@Singleton
@SuppressWarnings("all")
public class SubSystemClassGen {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private JavaExtensions _javaExtensions;
  
  @Inject
  private RoomExtensions _roomExtensions;
  
  @Inject
  private IDataConfiguration dataConfigExt;
  
  @Inject
  private ConfigGenAddon configGenAddon;
  
  @Inject
  private ProcedureHelpers _procedureHelpers;
  
  @Inject
  private VariableServiceGen varService;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<SubSystemInstance> _subSystemInstances = root.getSubSystemInstances();
    for (final SubSystemInstance ssi : _subSystemInstances) {
      {
        SubSystemClass _subSystemClass = ssi.getSubSystemClass();
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(_subSystemClass);
        SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
        String _path = this._roomExtensions.getPath(_subSystemClass_1);
        String path = (_generationTargetPath + _path);
        SubSystemClass _subSystemClass_2 = ssi.getSubSystemClass();
        String file = this._javaExtensions.getJavaFileName(_subSystemClass_2);
        String _plus = ("generating SubSystemClass implementation: \'" + file);
        String _plus_1 = (_plus + "\' in \'");
        String _plus_2 = (_plus_1 + path);
        String _plus_3 = (_plus_2 + "\'");
        this.logger.logInfo(_plus_3);
        this.fileAccess.setOutputPath(path);
        CharSequence _generate = this.generate(root, ssi);
        this.fileAccess.generateFile(file, _generate);
        boolean _hasVariableService = this.dataConfigExt.hasVariableService(ssi);
        if (_hasVariableService) {
          this.varService.doGenerate(root, ssi);
        }
      }
    }
  }
  
  public CharSequence generate(final Root root, final SubSystemInstance comp) {
    CharSequence _xblockexpression = null;
    {
      final SubSystemClass cc = comp.getSubSystemClass();
      final EList<RoomModel> models = root.getReferencedModels(cc);
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
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.MessageService;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.RTServices;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;");
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
      String _name_1 = cc.getName();
      _builder.append(_name_1, "");
      _builder.append(" extends SubSystemClassBase {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public final int THREAD__DEFAULT = 0;");
      _builder.newLine();
      {
        EList<LogicalThread> _threads = cc.getThreads();
        Iterable<Indexed<LogicalThread>> _indexed = Indexed.<LogicalThread>indexed(_threads);
        for(final Indexed<LogicalThread> thread : _indexed) {
          _builder.append("\t");
          _builder.append("public final int ");
          LogicalThread _value = thread.getValue();
          String _threadId = this.getThreadId(_value);
          _builder.append(_threadId, "	");
          _builder.append(" = ");
          int _index1 = thread.getIndex1();
          _builder.append(_index1, "	");
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
      String _name_2 = cc.getName();
      _builder.append(_name_2, "	");
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
      _builder.append("RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, 0, THREAD__DEFAULT, \"MessageService_Main\"));");
      _builder.newLine();
      {
        EList<LogicalThread> _threads_1 = cc.getThreads();
        for(final LogicalThread thread_1 : _threads_1) {
          _builder.append("\t\t");
          _builder.append("RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, 0, ");
          String _threadId_1 = this.getThreadId(thread_1);
          _builder.append(_threadId_1, "		");
          _builder.append(", \"MessageService_");
          String _name_3 = thread_1.getName();
          _builder.append(_name_3, "		");
          _builder.append("\" /*, thread_prio */));");
          _builder.newLineIfNotEmpty();
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
      _builder.append("MessageServiceController msgSvcCtrl = RTServices.getInstance().getMsgSvcCtrl();");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// thread mappings");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("msgSvcCtrl.addPathToThread(\"");
      String _path = comp.getPath();
      _builder.append(_path, "		");
      _builder.append("\", THREAD__DEFAULT);");
      _builder.newLineIfNotEmpty();
      {
        EList<ActorInstance> _allContainedInstances = comp.getAllContainedInstances();
        for(final ActorInstance ai : _allContainedInstances) {
          _builder.append("\t\t");
          String _xifexpression = null;
          int _threadId_2 = ai.getThreadId();
          boolean _equals = (_threadId_2 == 0);
          if (_equals) {
            _xifexpression = "THREAD__DEFAULT";
          } else {
            EList<LogicalThread> _threads_2 = cc.getThreads();
            int _threadId_3 = ai.getThreadId();
            int _minus = (_threadId_3 - 1);
            LogicalThread _get = _threads_2.get(_minus);
            String _threadId_4 = this.getThreadId(_get);
            _xifexpression = _threadId_4;
          }
          final String threadId = _xifexpression;
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("msgSvcCtrl.addPathToThread(\"");
          String _path_1 = ai.getPath();
          _builder.append(_path_1, "		");
          _builder.append("\", ");
          _builder.append(threadId, "		");
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
              _builder.append("\t\t");
              final String path = pi.getPath();
              _builder.newLineIfNotEmpty();
              {
                EList<InterfaceItemInstance> _peers = pi.getPeers();
                for(final InterfaceItemInstance peer : _peers) {
                  _builder.append("\t\t");
                  _builder.append("msgSvcCtrl.addPathToPeer(\"");
                  _builder.append(path, "		");
                  _builder.append("\", \"");
                  String _path_2 = peer.getPath();
                  _builder.append(_path_2, "		");
                  _builder.append("\");");
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
        EList<ActorInstance> _instances = comp.getInstances();
        Iterable<Indexed<ActorInstance>> _indexed_1 = Indexed.<ActorInstance>indexed(_instances);
        for(final Indexed<ActorInstance> ai_2 : _indexed_1) {
          _builder.append("\t\t");
          _builder.append("new ");
          ActorInstance _value_1 = ai_2.getValue();
          ActorClass _actorClass = _value_1.getActorClass();
          String _name_4 = _actorClass.getName();
          _builder.append(_name_4, "		");
          _builder.append("(this, \"");
          ActorInstance _value_2 = ai_2.getValue();
          String _name_5 = _value_2.getName();
          _builder.append(_name_5, "		");
          _builder.append("\"); ");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// apply instance attribute configurations");
      _builder.newLine();
      {
        EList<ActorInstance> _allContainedInstances_2 = comp.getAllContainedInstances();
        for(final ActorInstance ai_3 : _allContainedInstances_2) {
          _builder.append("\t\t");
          final CharSequence cfg = this.configGenAddon.genActorInstanceConfig(ai_3, "inst");
          _builder.newLineIfNotEmpty();
          {
            int _length = cfg.length();
            boolean _greaterThan = (_length > 0);
            if (_greaterThan) {
              _builder.append("\t\t");
              _builder.append("{");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              ActorClass _actorClass_1 = ai_3.getActorClass();
              String _name_6 = _actorClass_1.getName();
              _builder.append(_name_6, "			");
              _builder.append(" inst = (");
              ActorClass _actorClass_2 = ai_3.getActorClass();
              String _name_7 = _actorClass_2.getName();
              _builder.append(_name_7, "			");
              _builder.append(") getObject(\"");
              String _path_3 = ai_3.getPath();
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
          String _name_8 = cc.getName();
          _builder.append(_name_8, "		");
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
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private String getThreadId(final LogicalThread thread) {
    String _name = thread.getName();
    String _upperCase = _name.toUpperCase();
    String _plus = ("THREAD_" + _upperCase);
    return _plus;
  }
}
