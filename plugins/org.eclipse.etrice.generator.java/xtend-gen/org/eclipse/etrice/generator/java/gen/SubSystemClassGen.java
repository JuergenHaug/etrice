package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.config.AttrInstanceConfig;
import org.eclipse.etrice.core.config.LiteralArray;
import org.eclipse.etrice.core.config.PortInstanceConfig;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.base.Indexed;
import org.eclipse.etrice.generator.generic.ConfigExtension;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class SubSystemClassGen {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private JavaExtensions _javaExtensions;
  
  @Inject
  private RoomExtensions _roomExtensions;
  
  @Inject
  private ConfigExtension _configExtension;
  
  @Inject
  private ProcedureHelpers _procedureHelpers;
  
  @Inject
  private TypeHelpers _typeHelpers;
  
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
        String _operator_plus = StringExtensions.operator_plus(_generationTargetPath, _path);
        String path = _operator_plus;
        SubSystemClass _subSystemClass_2 = ssi.getSubSystemClass();
        String _javaFileName = this._javaExtensions.getJavaFileName(_subSystemClass_2);
        String file = _javaFileName;
        String _operator_plus_1 = StringExtensions.operator_plus("generating SubSystemClass implementation: \'", file);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "\' in \'");
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, path);
        String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "\'");
        this.logger.logInfo(_operator_plus_4);
        this.fileAccess.setOutputPath(path);
        SubSystemClass _subSystemClass_3 = ssi.getSubSystemClass();
        StringConcatenation _generate = this.generate(root, ssi, _subSystemClass_3);
        this.fileAccess.generateFile(file, _generate);
      }
    }
  }
  
  public StringConcatenation generate(final Root root, final SubSystemInstance comp, final SubSystemClass cc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _package = this._roomExtensions.getPackage(cc);
    _builder.append(_package, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.MessageService;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.RTServices;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.Address;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.IRTObject;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.RTSystemServicesProtocol.*;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;");
    _builder.newLine();
    _builder.newLine();
    EList<RoomModel> _referencedModels = root.getReferencedModels(cc);
    EList<RoomModel> models = _referencedModels;
    _builder.newLineIfNotEmpty();
    {
      for(final RoomModel model : models) {
        _builder.append("import ");
        String _name = model.getName();
        _builder.append(_name, "");
        _builder.append(".*;");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    StringConcatenation _userCode = this._procedureHelpers.userCode(cc, 1);
    _builder.append(_userCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _name_1 = comp.getName();
    _builder.append(_name_1, "");
    _builder.append(" extends SubSystemClassBase{");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    StringConcatenation _userCode_1 = this._procedureHelpers.userCode(cc, 2);
    _builder.append(_userCode_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _name_2 = comp.getName();
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
    _builder.append("public void instantiateMessageServices(){");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, new Address(0, 0, 0),\"MessageService_Main\"));");
    _builder.newLine();
    {
      EList<LogicalThread> _threads = cc.getThreads();
      for(final LogicalThread thread : _threads) {
        _builder.append("\t\t");
        _builder.append("RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, new Address(0, ");
        EList<LogicalThread> _threads_1 = cc.getThreads();
        int _indexOf = _threads_1.indexOf(thread);
        int _operator_plus = IntegerExtensions.operator_plus(((Integer)_indexOf), ((Integer)1));
        _builder.append(_operator_plus, "		");
        _builder.append(", 0),\"MessageService_");
        String _name_3 = thread.getName();
        _builder.append(_name_3, "		");
        _builder.append("\", ");
        int _prio = thread.getPrio();
        _builder.append(_prio, "		");
        _builder.append("));");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void instantiateActors(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// all addresses");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// Addresses for the Subsystem Systemport");
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances = comp.getAllContainedInstances();
      int _maxObjId = comp.getMaxObjId();
      Iterable<Indexed<ActorInstance>> _indexed = Indexed.<ActorInstance>indexed(_allContainedInstances, _maxObjId);
      for(final Indexed<ActorInstance> ai : _indexed) {
        _builder.append("\t\t");
        _builder.append("Address addr_item_SystemPort_");
        EList<ActorInstance> _allContainedInstances_1 = comp.getAllContainedInstances();
        ActorInstance _value = ai.getValue();
        int _indexOf_1 = _allContainedInstances_1.indexOf(_value);
        _builder.append(_indexOf_1, "		");
        _builder.append(" = new Address(0,0,");
        int _index1 = ai.getIndex1();
        _builder.append(_index1, "		");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances_2 = comp.getAllContainedInstances();
      for(final ActorInstance ai_1 : _allContainedInstances_2) {
        _builder.append("\t\t");
        _builder.append("// actor instance ");
        String _path = ai_1.getPath();
        _builder.append(_path, "		");
        _builder.append(" itself => Systemport Address");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("Address addr_item_");
        String _path_1 = ai_1.getPath();
        String _pathName = this._roomExtensions.getPathName(_path_1);
        _builder.append(_pathName, "		");
        _builder.append(" = new Address(0,");
        int _threadId = ai_1.getThreadId();
        _builder.append(_threadId, "		");
        _builder.append(",");
        int _objId = ai_1.getObjId();
        _builder.append(_objId, "		");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("// interface items of ");
        String _path_2 = ai_1.getPath();
        _builder.append(_path_2, "		");
        _builder.newLineIfNotEmpty();
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances = ai_1.getOrderedIfItemInstances();
          for(final InterfaceItemInstance pi : _orderedIfItemInstances) {
            {
              boolean _isReplicated = pi.isReplicated();
              if (_isReplicated) {
                {
                  EList<InterfaceItemInstance> _peers = pi.getPeers();
                  for(final InterfaceItemInstance peer : _peers) {
                    _builder.append("\t\t");
                    EList<InterfaceItemInstance> _peers_1 = pi.getPeers();
                    int _indexOf_2 = _peers_1.indexOf(peer);
                    int i = _indexOf_2;
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("Address addr_item_");
                    String _path_3 = pi.getPath();
                    String _pathName_1 = this._roomExtensions.getPathName(_path_3);
                    _builder.append(_pathName_1, "		");
                    _builder.append("_");
                    _builder.append(i, "		");
                    _builder.append(" = new Address(0,");
                    int _threadId_1 = pi.getThreadId();
                    _builder.append(_threadId_1, "		");
                    _builder.append(",");
                    int _objId_1 = pi.getObjId();
                    int _operator_plus_1 = IntegerExtensions.operator_plus(((Integer)_objId_1), ((Integer)i));
                    _builder.append(_operator_plus_1, "		");
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                _builder.append("\t\t");
                _builder.append("Address addr_item_");
                String _path_4 = pi.getPath();
                String _pathName_2 = this._roomExtensions.getPathName(_path_4);
                _builder.append(_pathName_2, "		");
                _builder.append(" = new Address(0,");
                int _threadId_2 = ai_1.getThreadId();
                _builder.append(_threadId_2, "		");
                _builder.append(",");
                int _objId_2 = pi.getObjId();
                _builder.append(_objId_2, "		");
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
    _builder.append("// instantiate all actor instances");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("instances = new ActorClassBase[");
    EList<ActorInstance> _allContainedInstances_3 = comp.getAllContainedInstances();
    int _size = _allContainedInstances_3.size();
    _builder.append(_size, "		");
    _builder.append("];");
    _builder.newLineIfNotEmpty();
    {
      EList<ActorInstance> _allContainedInstances_4 = comp.getAllContainedInstances();
      for(final ActorInstance ai_2 : _allContainedInstances_4) {
        _builder.append("\t\t");
        _builder.append("instances[");
        EList<ActorInstance> _allContainedInstances_5 = comp.getAllContainedInstances();
        int _indexOf_3 = _allContainedInstances_5.indexOf(ai_2);
        _builder.append(_indexOf_3, "		");
        _builder.append("] = new ");
        ActorClass _actorClass = ai_2.getActorClass();
        String _name_4 = _actorClass.getName();
        _builder.append(_name_4, "		");
        _builder.append("(");
        _builder.newLineIfNotEmpty();
        {
          EObject _eContainer = ai_2.eContainer();
          if ((_eContainer instanceof SubSystemInstance)) {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("this,");
            _builder.newLine();
          } else {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("instances[");
            EList<ActorInstance> _allContainedInstances_6 = comp.getAllContainedInstances();
            EObject _eContainer_1 = ai_2.eContainer();
            int _indexOf_4 = _allContainedInstances_6.indexOf(_eContainer_1);
            _builder.append(_indexOf_4, "			");
            _builder.append("],");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("\"");
        String _name_5 = ai_2.getName();
        _builder.append(_name_5, "			");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("// own interface item addresses");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("new Address[][] {{addr_item_");
        String _path_5 = ai_2.getPath();
        String _pathName_3 = this._roomExtensions.getPathName(_path_5);
        _builder.append(_pathName_3, "			");
        _builder.append("}");
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances_1 = ai_2.getOrderedIfItemInstances();
          boolean _isEmpty = _orderedIfItemInstances_1.isEmpty();
          boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
          if (_operator_not) {
            _builder.append(",");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances_2 = ai_2.getOrderedIfItemInstances();
          boolean hasAnyElements = false;
          for(final InterfaceItemInstance pi_1 : _orderedIfItemInstances_2) {
            if (!hasAnyElements) {
              hasAnyElements = true;
            } else {
              _builder.appendImmediate(",", "				");
            }
            {
              boolean _isReplicated_1 = pi_1.isReplicated();
              if (_isReplicated_1) {
                {
                  EList<InterfaceItemInstance> _peers_2 = pi_1.getPeers();
                  boolean _isEmpty_1 = _peers_2.isEmpty();
                  if (_isEmpty_1) {
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("null");
                    _builder.newLine();
                  } else {
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("{");
                    _builder.newLine();
                    {
                      EList<InterfaceItemInstance> _peers_3 = pi_1.getPeers();
                      boolean hasAnyElements_1 = false;
                      for(final InterfaceItemInstance peer_1 : _peers_3) {
                        if (!hasAnyElements_1) {
                          hasAnyElements_1 = true;
                        } else {
                          _builder.appendImmediate(",", "					");
                        }
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("addr_item_");
                        String _path_6 = pi_1.getPath();
                        String _pathName_4 = this._roomExtensions.getPathName(_path_6);
                        _builder.append(_pathName_4, "					");
                        _builder.append("_");
                        EList<InterfaceItemInstance> _peers_4 = pi_1.getPeers();
                        int _indexOf_5 = _peers_4.indexOf(peer_1);
                        _builder.append(_indexOf_5, "					");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              } else {
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("{");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("addr_item_");
                String _path_7 = pi_1.getPath();
                String _pathName_5 = this._roomExtensions.getPathName(_path_7);
                _builder.append(_pathName_5, "					");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("},");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("// peer interface item addresses");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("new Address[][] {{addr_item_SystemPort_");
        EList<ActorInstance> _allContainedInstances_7 = comp.getAllContainedInstances();
        int _indexOf_6 = _allContainedInstances_7.indexOf(ai_2);
        _builder.append(_indexOf_6, "			");
        _builder.append("}");
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances_3 = ai_2.getOrderedIfItemInstances();
          boolean _isEmpty_2 = _orderedIfItemInstances_3.isEmpty();
          boolean _operator_not_1 = BooleanExtensions.operator_not(_isEmpty_2);
          if (_operator_not_1) {
            _builder.append(",");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances_4 = ai_2.getOrderedIfItemInstances();
          boolean hasAnyElements_2 = false;
          for(final InterfaceItemInstance pi_2 : _orderedIfItemInstances_4) {
            if (!hasAnyElements_2) {
              hasAnyElements_2 = true;
            } else {
              _builder.appendImmediate(",", "				");
            }
            {
              boolean _operator_and = false;
              boolean _isReplicated_2 = pi_2.isReplicated();
              if (!_isReplicated_2) {
                _operator_and = false;
              } else {
                EList<InterfaceItemInstance> _peers_5 = pi_2.getPeers();
                boolean _isEmpty_3 = _peers_5.isEmpty();
                _operator_and = BooleanExtensions.operator_and(_isReplicated_2, _isEmpty_3);
              }
              if (_operator_and) {
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("null");
                _builder.newLine();
              } else {
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("{");
                _builder.newLine();
                {
                  EList<InterfaceItemInstance> _peers_6 = pi_2.getPeers();
                  boolean _isEmpty_4 = _peers_6.isEmpty();
                  if (_isEmpty_4) {
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("null");
                    _builder.newLine();
                  } else {
                    {
                      EList<InterfaceItemInstance> _peers_7 = pi_2.getPeers();
                      boolean hasAnyElements_3 = false;
                      for(final InterfaceItemInstance pp : _peers_7) {
                        if (!hasAnyElements_3) {
                          hasAnyElements_3 = true;
                        } else {
                          _builder.appendImmediate(",", "					");
                        }
                        {
                          boolean _isReplicated_3 = pp.isReplicated();
                          if (_isReplicated_3) {
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("addr_item_");
                            String _path_8 = pp.getPath();
                            String _pathName_6 = this._roomExtensions.getPathName(_path_8);
                            _builder.append(_pathName_6, "					");
                            _builder.append("_");
                            EList<InterfaceItemInstance> _peers_8 = pp.getPeers();
                            int _indexOf_7 = _peers_8.indexOf(pi_2);
                            _builder.append(_indexOf_7, "					");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("addr_item_");
                            String _path_9 = pp.getPath();
                            String _pathName_7 = this._roomExtensions.getPathName(_path_9);
                            _builder.append(_pathName_7, "					");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                  }
                }
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("); ");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// apply instance attribute configurations");
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances_8 = comp.getAllContainedInstances();
      for(final ActorInstance ai_3 : _allContainedInstances_8) {
        _builder.append("\t\t");
        List<AttrInstanceConfig> _configAttributes = this._configExtension.getConfigAttributes(ai_3);
        List<AttrInstanceConfig> attrConfigs = _configAttributes;
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        List<PortInstanceConfig> _configPorts = this._configExtension.getConfigPorts(ai_3);
        List<PortInstanceConfig> portConfigs = _configPorts;
        _builder.newLineIfNotEmpty();
        {
          boolean _operator_or = false;
          boolean _isEmpty_5 = attrConfigs.isEmpty();
          boolean _operator_not_2 = BooleanExtensions.operator_not(_isEmpty_5);
          if (_operator_not_2) {
            _operator_or = true;
          } else {
            boolean _isEmpty_6 = portConfigs.isEmpty();
            boolean _operator_not_3 = BooleanExtensions.operator_not(_isEmpty_6);
            _operator_or = BooleanExtensions.operator_or(_operator_not_2, _operator_not_3);
          }
          if (_operator_or) {
            _builder.append("\t\t");
            _builder.append("{");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            String aiName = "inst";
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            ActorClass _actorClass_1 = ai_3.getActorClass();
            String _name_6 = _actorClass_1.getName();
            _builder.append(_name_6, "			");
            _builder.append(" ");
            _builder.append(aiName, "			");
            _builder.append(" = (");
            ActorClass _actorClass_2 = ai_3.getActorClass();
            String _name_7 = _actorClass_2.getName();
            _builder.append(_name_7, "			");
            _builder.append(") instances[");
            EList<ActorInstance> _allContainedInstances_9 = comp.getAllContainedInstances();
            int _indexOf_8 = _allContainedInstances_9.indexOf(ai_3);
            _builder.append(_indexOf_8, "			");
            _builder.append("];");
            _builder.newLineIfNotEmpty();
            {
              for(final AttrInstanceConfig attrConfig : attrConfigs) {
                _builder.append("\t\t");
                _builder.append("\t");
                Attribute _attribute = attrConfig.getAttribute();
                Attribute a = _attribute;
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                LiteralArray _value_1 = attrConfig.getValue();
                String _stringValue = this._configExtension.stringValue(_value_1, a);
                String value = _stringValue;
                _builder.newLineIfNotEmpty();
                {
                  boolean _isArray = this._configExtension.isArray(a);
                  boolean _operator_not_4 = BooleanExtensions.operator_not(_isArray);
                  if (_operator_not_4) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append(aiName, "			");
                    _builder.append(".");
                    String _name_8 = a.getName();
                    ActorClass _actorClass_3 = ai_3.getActorClass();
                    String _name_9 = _actorClass_3.getName();
                    StringConcatenation _invokeSetter = this._procedureHelpers.invokeSetter(_name_8, _name_9, value);
                    _builder.append(_invokeSetter, "			");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  } else {
                    boolean _startsWith = value.startsWith("{");
                    if (_startsWith) {
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append(aiName, "			");
                      _builder.append(".");
                      String _name_10 = a.getName();
                      ActorClass _actorClass_4 = ai_3.getActorClass();
                      String _name_11 = _actorClass_4.getName();
                      RefableType _refType = a.getRefType();
                      DataType _type = _refType.getType();
                      String _typeName = this._typeHelpers.typeName(_type);
                      String _operator_plus_2 = StringExtensions.operator_plus("new ", _typeName);
                      String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, "[]");
                      String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, value);
                      StringConcatenation _invokeSetter_1 = this._procedureHelpers.invokeSetter(_name_10, _name_11, _operator_plus_4);
                      _builder.append(_invokeSetter_1, "			");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                    } else {
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("{");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      RefableType _refType_1 = a.getRefType();
                      DataType _type_1 = _refType_1.getType();
                      String _typeName_1 = this._typeHelpers.typeName(_type_1);
                      _builder.append(_typeName_1, "				");
                      _builder.append("[] array = ");
                      _builder.append(aiName, "				");
                      _builder.append(".");
                      String _name_12 = a.getName();
                      ActorClass _actorClass_5 = ai_3.getActorClass();
                      String _name_13 = _actorClass_5.getName();
                      StringConcatenation _invokeGetter = this._procedureHelpers.invokeGetter(_name_12, _name_13);
                      _builder.append(_invokeGetter, "				");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("for (int i=0;i<");
                      int _size_1 = a.getSize();
                      _builder.append(_size_1, "				");
                      _builder.append(";i++){");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("\t\t");
                      _builder.append("array[i] = ");
                      _builder.append(value, "					");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("}");
                      _builder.newLine();
                    }
                  }
                }
              }
            }
            {
              for(final PortInstanceConfig portConfig : portConfigs) {
                _builder.append("\t\t");
                _builder.append("\t");
                String portName = "port";
                InterfaceItem _item = portConfig.getItem();
                InterfaceItem item = _item;
                _builder.newLineIfNotEmpty();
                {
                  EList<AttrInstanceConfig> _attributes = portConfig.getAttributes();
                  for(final AttrInstanceConfig attrConfig_1 : _attributes) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    Attribute _attribute_1 = attrConfig_1.getAttribute();
                    Attribute a_1 = _attribute_1;
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    LiteralArray _value_2 = attrConfig_1.getValue();
                    String _stringValue_1 = this._configExtension.stringValue(_value_2, a_1);
                    String value_1 = _stringValue_1;
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    String _operator_plus_5 = StringExtensions.operator_plus(aiName, ".");
                    String _name_14 = item.getName();
                    String _portClassName = this._roomExtensions.getPortClassName(item);
                    StringConcatenation _invokeGetter_1 = this._procedureHelpers.invokeGetter(_name_14, _portClassName);
                    String _operator_plus_6 = StringExtensions.operator_plus(_operator_plus_5, _invokeGetter_1);
                    String refToItem = _operator_plus_6;
                    _builder.newLineIfNotEmpty();
                    {
                      boolean _isArray_1 = this._configExtension.isArray(a_1);
                      boolean _operator_not_5 = BooleanExtensions.operator_not(_isArray_1);
                      if (_operator_not_5) {
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append(refToItem, "			");
                        _builder.append(".");
                        String _name_15 = a_1.getName();
                        String _portClassName_1 = this._roomExtensions.getPortClassName(item);
                        StringConcatenation _invokeSetter_2 = this._procedureHelpers.invokeSetter(_name_15, _portClassName_1, value_1);
                        _builder.append(_invokeSetter_2, "			");
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                      } else {
                        boolean _startsWith_1 = value_1.startsWith("{");
                        if (_startsWith_1) {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append(refToItem, "			");
                          _builder.append(".");
                          String _name_16 = a_1.getName();
                          ActorClass _actorClass_6 = ai_3.getActorClass();
                          String _name_17 = _actorClass_6.getName();
                          RefableType _refType_2 = a_1.getRefType();
                          DataType _type_2 = _refType_2.getType();
                          String _typeName_2 = this._typeHelpers.typeName(_type_2);
                          String _operator_plus_7 = StringExtensions.operator_plus("new ", _typeName_2);
                          String _operator_plus_8 = StringExtensions.operator_plus(_operator_plus_7, "[]");
                          String _operator_plus_9 = StringExtensions.operator_plus(_operator_plus_8, value_1);
                          StringConcatenation _invokeSetter_3 = this._procedureHelpers.invokeSetter(_name_16, _name_17, _operator_plus_9);
                          _builder.append(_invokeSetter_3, "			");
                          _builder.append(";");
                          _builder.newLineIfNotEmpty();
                        } else {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("{");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          RefableType _refType_3 = a_1.getRefType();
                          DataType _type_3 = _refType_3.getType();
                          String _typeName_3 = this._typeHelpers.typeName(_type_3);
                          _builder.append(_typeName_3, "				");
                          _builder.append("[] array = ");
                          _builder.append(refToItem, "				");
                          _builder.append(".");
                          String _name_18 = a_1.getName();
                          ActorClass _actorClass_7 = ai_3.getActorClass();
                          String _name_19 = _actorClass_7.getName();
                          StringConcatenation _invokeGetter_2 = this._procedureHelpers.invokeGetter(_name_18, _name_19);
                          _builder.append(_invokeGetter_2, "				");
                          _builder.append(";");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("for (int i=0;i<");
                          int _size_2 = a_1.getSize();
                          _builder.append(_size_2, "				");
                          _builder.append(";i++){");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t\t");
                          _builder.append("array[i] = ");
                          _builder.append(value_1, "					");
                          _builder.append(";");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("}");
                          _builder.newLine();
                        }
                      }
                    }
                  }
                }
              }
            }
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// create the subsystem system port\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("RTSystemPort = new RTSystemServicesProtocolConjPortRepl(this, \"RTSystemPort\",");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("0, //local ID");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("// own addresses");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("new Address[]{");
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances_10 = comp.getAllContainedInstances();
      boolean hasAnyElements_4 = false;
      for(final ActorInstance ai_4 : _allContainedInstances_10) {
        if (!hasAnyElements_4) {
          hasAnyElements_4 = true;
        } else {
          _builder.appendImmediate(",", "					");
        }
        _builder.append("\t\t\t\t\t");
        _builder.append("addr_item_SystemPort_");
        EList<ActorInstance> _allContainedInstances_11 = comp.getAllContainedInstances();
        int _indexOf_9 = _allContainedInstances_11.indexOf(ai_4);
        _builder.append(_indexOf_9, "					");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t\t");
    _builder.append("},");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("// peer addresses");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("new Address[]{");
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances_12 = comp.getAllContainedInstances();
      boolean hasAnyElements_5 = false;
      for(final ActorInstance ai_5 : _allContainedInstances_12) {
        if (!hasAnyElements_5) {
          hasAnyElements_5 = true;
        } else {
          _builder.appendImmediate(",", "					");
        }
        _builder.append("\t\t\t\t\t");
        _builder.append("addr_item_");
        String _path_10 = ai_5.getPath();
        String _pathName_8 = this._roomExtensions.getPathName(_path_10);
        _builder.append(_pathName_8, "					");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    return _builder;
  }
}
