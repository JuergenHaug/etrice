/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Thomas Schuetz (changed for C code generator)
 */
package org.eclipse.etrice.generator.c.gen;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.LiteralType;
import org.eclipse.etrice.core.common.base.util.BaseHelpers;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.etmap.util.ETMapUtil.MappedThread;
import org.eclipse.etrice.core.etphys.eTPhys.ExecMode;
import org.eclipse.etrice.core.etphys.eTPhys.NodeClass;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorCommunicationType;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageHandler;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.GlobalGeneratorSettings;
import org.eclipse.etrice.generator.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.base.IntelligentSeparator;
import org.eclipse.etrice.generator.c.Main;
import org.eclipse.etrice.generator.c.gen.CExtensions;
import org.eclipse.etrice.generator.c.gen.Initialization;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@Singleton
@SuppressWarnings("all")
public class NodeGen {
  @Inject
  @Extension
  private CExtensions _cExtensions;
  
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  @Inject
  @Extension
  private TypeHelpers _typeHelpers;
  
  @Inject
  @Extension
  private ProcedureHelpers helpers;
  
  @Inject
  private IGeneratorFileIo fileIO;
  
  @Inject
  private Initialization attrInitGenAddon;
  
  @Inject
  private ILanguageExtension languageExt;
  
  @Inject
  private IDiagnostician diagnostician;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    Collection<NodeRef> _nodeRefs = ETMapUtil.getNodeRefs();
    for (final NodeRef nr : _nodeRefs) {
      List<String> _subSystemInstancePaths = ETMapUtil.getSubSystemInstancePaths(nr);
      for (final String instpath : _subSystemInstancePaths) {
        {
          StructureInstance _instance = root.getInstance(instpath);
          final SubSystemInstance ssi = ((SubSystemInstance) _instance);
          boolean _notEquals = (!Objects.equal(ssi, null));
          if (_notEquals) {
            SubSystemClass _subSystemClass = ssi.getSubSystemClass();
            String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(_subSystemClass);
            SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
            String _path = this._roomExtensions.getPath(_subSystemClass_1);
            final String filepath = (_generationTargetPath + _path);
            SubSystemClass _subSystemClass_2 = ssi.getSubSystemClass();
            String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(_subSystemClass_2);
            SubSystemClass _subSystemClass_3 = ssi.getSubSystemClass();
            String _path_1 = this._roomExtensions.getPath(_subSystemClass_3);
            final String infopath = (_generationInfoPath + _path_1);
            String file = this._cExtensions.getCHeaderFileName(nr, ssi);
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
                    MappedThread _mappedThread = ETMapUtil.getMappedThread(ai);
                    PhysicalThread _thread = _mappedThread.getThread();
                    boolean _equals = Objects.equal(_thread, thread);
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
            CharSequence _generateHeaderFile = this.generateHeaderFile(root, ssi);
            this.fileIO.generateFile("generating Node declaration", filepath, infopath, file, _generateHeaderFile);
            String _cSourceFileName = this._cExtensions.getCSourceFileName(nr, ssi);
            file = _cSourceFileName;
            CharSequence _generateSourceFile = this.generateSourceFile(root, ssi, usedThreads);
            this.fileIO.generateFile("generating Node implementation", filepath, infopath, file, _generateSourceFile);
            String _instSourceFileName = this._cExtensions.getInstSourceFileName(nr, ssi);
            file = _instSourceFileName;
            CharSequence _generateInstanceFile = this.generateInstanceFile(root, ssi, usedThreads);
            this.fileIO.generateFile("generating Node instance file", filepath, infopath, file, _generateInstanceFile);
            String _dispSourceFileName = this._cExtensions.getDispSourceFileName(nr, ssi);
            file = _dispSourceFileName;
            CharSequence _generateDispatcherFile = this.generateDispatcherFile(root, ssi, usedThreads);
            this.fileIO.generateFile("generating Node dispatcher file", filepath, infopath, file, _generateDispatcherFile);
          }
        }
      }
    }
  }
  
  private CharSequence generateHeaderFile(final Root root, final SubSystemInstance ssi) {
    CharSequence _xblockexpression = null;
    {
      final NodeRef nr = ETMapUtil.getNodeRef(ssi);
      final SubSystemClass ssc = ssi.getSubSystemClass();
      String _name = nr.getName();
      String _plus = (_name + "_");
      String _name_1 = ssi.getName();
      final String clsname = (_plus + _name_1);
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
      _builder.append("* Header File of Node ");
      String _name_2 = nr.getName();
      _builder.append(_name_2, " ");
      _builder.append(" with SubSystem ");
      String _name_3 = ssi.getName();
      _builder.append(_name_3, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* ");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      CharSequence _generateIncludeGuardBegin = this._cExtensions.generateIncludeGuardBegin(clsname);
      _builder.append(_generateIncludeGuardBegin, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"etDatatypes.h\"");
      _builder.newLine();
      _builder.newLine();
      DetailCode _userCode1 = ssc.getUserCode1();
      CharSequence _userCode = this.helpers.userCode(_userCode1);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* lifecycle functions");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* init -> start -> run (loop) -> stop -> destroy");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname, "");
      _builder.append("_init(void);\t\t/* lifecycle init  \t */");
      _builder.newLineIfNotEmpty();
      _builder.append("void ");
      _builder.append(clsname, "");
      _builder.append("_start(void);\t/* lifecycle start \t */");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname, "");
      _builder.append("_run(etBool runAsTest);\t\t/* lifecycle run \t */");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname, "");
      _builder.append("_stop(void); \t/* lifecycle stop\t */");
      _builder.newLineIfNotEmpty();
      _builder.append("void ");
      _builder.append(clsname, "");
      _builder.append("_destroy(void); \t/* lifecycle destroy */");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname, "");
      _builder.append("_shutdown(void);  /* shutdown the dispatcher loop */");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      DetailCode _userCode2 = ssc.getUserCode2();
      CharSequence _userCode_1 = this.helpers.userCode(_userCode2);
      _builder.append(_userCode_1, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _generateIncludeGuardEnd = this._cExtensions.generateIncludeGuardEnd(clsname);
      _builder.append(_generateIncludeGuardEnd, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateSourceFile(final Root root, final SubSystemInstance ssi, final HashSet<PhysicalThread> usedThreads) {
    CharSequence _xblockexpression = null;
    {
      final NodeRef nr = ETMapUtil.getNodeRef(ssi);
      final SubSystemClass ssc = ssi.getSubSystemClass();
      String _name = nr.getName();
      String _plus = (_name + "_");
      String _name_1 = ssi.getName();
      final String clsname = (_plus + _name_1);
      NodeClass _type = nr.getType();
      EList<PhysicalThread> _threads = _type.getThreads();
      final Function1<PhysicalThread,Boolean> _function = new Function1<PhysicalThread,Boolean>() {
        public Boolean apply(final PhysicalThread t) {
          boolean _contains = usedThreads.contains(t);
          return Boolean.valueOf(_contains);
        }
      };
      final Iterable<PhysicalThread> threads = IterableExtensions.<PhysicalThread>filter(_threads, _function);
      EList<Annotation> _annotations = ssc.getAnnotations();
      final boolean logData = BaseHelpers.isAnnotationPresent(_annotations, "DataLogging");
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
      _builder.append("* Source File of Node ");
      String _name_2 = nr.getName();
      _builder.append(_name_2, " ");
      _builder.append(" with SubSystem ");
      String _name_3 = ssi.getName();
      _builder.append(_name_3, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* ");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.append("#include <stdio.h>");
      _builder.newLine();
      _builder.append("#include <string.h>");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("#include \"");
      String _cHeaderFileName = this._cExtensions.getCHeaderFileName(nr, ssi);
      _builder.append(_cHeaderFileName, "");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"debugging/etLogger.h\"");
      _builder.newLine();
      _builder.append("#include \"debugging/etMSCLogger.h\"");
      _builder.newLine();
      _builder.append("#include \"debugging/etDataLogger.h\"");
      _builder.newLine();
      _builder.append("#include \"messaging/etSystemProtocol.h\"");
      _builder.newLine();
      _builder.append("#include \"osal/etTimer.h\"");
      _builder.newLine();
      _builder.append("#include \"osal/etSema.h\"");
      _builder.newLine();
      _builder.append("#include \"runtime/etRuntime.h\"");
      _builder.newLine();
      _builder.append("#include \"etRuntimeConfig.h\"");
      _builder.newLine();
      _builder.newLine();
      DetailCode _userCode3 = ssc.getUserCode3();
      CharSequence _userCode = this.helpers.userCode(_userCode3);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* data for Node ");
      String _name_4 = nr.getName();
      _builder.append(_name_4, "");
      _builder.append(" with SubSystem ");
      String _name_5 = ssi.getName();
      _builder.append(_name_5, "");
      _builder.append(" */");
      _builder.newLineIfNotEmpty();
      _builder.append("typedef struct ");
      _builder.append(clsname, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("char *name;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("volatile int shutdownRequest;");
      _builder.newLine();
      _builder.append("} ");
      _builder.append(clsname, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("static ");
      _builder.append(clsname, "");
      _builder.append(" ");
      _builder.append(clsname, "");
      _builder.append("Inst = {\"");
      _builder.append(clsname, "");
      _builder.append("\", 0};");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("static void ");
      _builder.append(clsname, "");
      _builder.append("_initActorInstances(void);");
      _builder.newLineIfNotEmpty();
      _builder.append("static void ");
      _builder.append(clsname, "");
      _builder.append("_constructActorInstances(void);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* include instances for all classes */");
      _builder.newLine();
      _builder.append("#include \"");
      String _instSourceFileName = this._cExtensions.getInstSourceFileName(nr, ssi);
      _builder.append(_instSourceFileName, "");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("#include \"");
      String _dispSourceFileName = this._cExtensions.getDispSourceFileName(nr, ssi);
      _builder.append(_dispSourceFileName, "");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("static void ");
      _builder.append(clsname, "");
      _builder.append("_initMessageServices(void) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "	");
      _builder.append("\", \"initMessageServices\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("etTime interval;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("/* initialization of all message services */");
      _builder.newLine();
      {
        for(final PhysicalThread thread : threads) {
          {
            boolean _or = false;
            ExecMode _execmode = thread.getExecmode();
            boolean _equals = Objects.equal(_execmode, ExecMode.POLLED);
            if (_equals) {
              _or = true;
            } else {
              ExecMode _execmode_1 = thread.getExecmode();
              boolean _equals_1 = Objects.equal(_execmode_1, ExecMode.MIXED);
              _or = (_equals || _equals_1);
            }
            if (_or) {
              _builder.append("\t\t");
              _builder.append("interval.sec = 0;");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("interval.nSec = ");
              int _time = thread.getTime();
              _builder.append(_time, "		");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t\t");
          _builder.append("etMessageService_init(");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("&msgService_");
          String _name_6 = thread.getName();
          _builder.append(_name_6, "			");
          _builder.append(",");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("msgBuffer_");
          String _name_7 = thread.getName();
          _builder.append(_name_7, "			");
          _builder.append(",");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          String _name_8 = thread.getName();
          String _upperCase = _name_8.toUpperCase();
          _builder.append(_upperCase, "			");
          _builder.append("_POOL_SIZE,");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          String _name_9 = thread.getName();
          String _upperCase_1 = _name_9.toUpperCase();
          _builder.append(_upperCase_1, "			");
          _builder.append("_BLOCK_SIZE,");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          int _stacksize = thread.getStacksize();
          _builder.append(_stacksize, "			");
          _builder.append(",");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          int _prio = thread.getPrio();
          _builder.append(_prio, "			");
          _builder.append(",");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("interval,");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("MsgDispatcher_");
          String _name_10 = thread.getName();
          _builder.append(_name_10, "			");
          _builder.append("_receiveMessage,");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("EXECMODE_");
          ExecMode _execmode_2 = thread.getExecmode();
          String _string = _execmode_2.toString();
          String _upperCase_2 = _string.toUpperCase();
          _builder.append(_upperCase_2, "			");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("static void ");
      _builder.append(clsname, "");
      _builder.append("_startMessageServices(void) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "	");
      _builder.append("\", \"startMessageServices\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        for(final PhysicalThread thread_1 : threads) {
          _builder.append("\t");
          _builder.append("etMessageService_start(&msgService_");
          String _name_11 = thread_1.getName();
          _builder.append(_name_11, "	");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("static void ");
      _builder.append(clsname, "");
      _builder.append("_stopMessageServices(void) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "	");
      _builder.append("\", \"stopMessageServices\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        for(final PhysicalThread thread_2 : threads) {
          _builder.append("\t");
          _builder.append("etMessageService_stop(&msgService_");
          String _name_12 = thread_2.getName();
          _builder.append(_name_12, "	");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("static void ");
      _builder.append(clsname, "");
      _builder.append("_destroyMessageServices(void) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "	");
      _builder.append("\", \"destroyMessageServices\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        for(final PhysicalThread thread_3 : threads) {
          _builder.append("\t");
          _builder.append("etMessageService_destroy(&msgService_");
          String _name_13 = thread_3.getName();
          _builder.append(_name_13, "	");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname, "");
      _builder.append("_init(void) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "	");
      _builder.append("\", \"init\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("etLogger_logInfoF(\"%s_init\", ");
      _builder.append(clsname, "	");
      _builder.append("Inst.name);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* construct all actors */");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(clsname, "	");
      _builder.append("_constructActorInstances();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* initialization of all message services */");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(clsname, "	");
      _builder.append("_initMessageServices();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* init all actors */");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(clsname, "	");
      _builder.append("_initActorInstances();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        if (logData) {
          {
            for(final PhysicalThread thread_4 : threads) {
              _builder.append("\t");
              _builder.append("MsgDispatcher_");
              String _name_14 = thread_4.getName();
              _builder.append(_name_14, "	");
              _builder.append("_logDataHeaders();");
              _builder.newLineIfNotEmpty();
            }
          }
          {
            for(final PhysicalThread thread_5 : threads) {
              _builder.append("\t");
              _builder.append("MsgDispatcher_");
              String _name_15 = thread_5.getName();
              _builder.append(_name_15, "	");
              _builder.append("_logData();");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname, "");
      _builder.append("_start(void) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "	");
      _builder.append("\", \"start\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("etLogger_logInfoF(\"%s_start\", ");
      _builder.append(clsname, "	");
      _builder.append("Inst.name);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append(clsname, "	");
      _builder.append("_startMessageServices();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname, "");
      _builder.append("_run(etBool runAsTest) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "	");
      _builder.append("\", \"run\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (runAsTest) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("etSema_waitForWakeup(etRuntime_getTerminateSemaphore());");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("printf(\"type quit to exit\\n\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("fflush(stdout);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("while (TRUE) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("char line[64];");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (fgets(line, 64, stdin) != NULL) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("if (strncmp(line, \"quit\", 4)==0)");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname, "");
      _builder.append("_stop(void){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "	");
      _builder.append("\", \"stop\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("etLogger_logInfoF(\"%s_stop\", ");
      _builder.append(clsname, "	");
      _builder.append("Inst.name);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append(clsname, "	");
      _builder.append("_stopMessageServices();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname, "");
      _builder.append("_destroy(void){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "	");
      _builder.append("\", \"destroy\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("etLogger_logInfoF(\"%s_destroy\", ");
      _builder.append(clsname, "	");
      _builder.append("Inst.name);");
      _builder.newLineIfNotEmpty();
      {
        EList<ActorInstance> _allContainedInstances = ssi.getAllContainedInstances();
        List<ActorInstance> _reverseView = ListExtensions.<ActorInstance>reverseView(_allContainedInstances);
        for(final ActorInstance ai : _reverseView) {
          {
            ActorClass _actorClass = ai.getActorClass();
            EList<StandardOperation> _operations = _actorClass.getOperations();
            final Function1<StandardOperation,Boolean> _function_1 = new Function1<StandardOperation,Boolean>() {
              public Boolean apply(final StandardOperation op) {
                boolean _isDestructor = op.isDestructor();
                return Boolean.valueOf(_isDestructor);
              }
            };
            Iterable<StandardOperation> _filter = IterableExtensions.<StandardOperation>filter(_operations, _function_1);
            boolean _isEmpty = IterableExtensions.isEmpty(_filter);
            boolean _not = (!_isEmpty);
            if (_not) {
              _builder.append("\t");
              ActorClass _actorClass_1 = ai.getActorClass();
              String _name_16 = _actorClass_1.getName();
              ActorClass _actorClass_2 = ai.getActorClass();
              String _name_17 = _actorClass_2.getName();
              String _destructorName = this.languageExt.destructorName(_name_17);
              String _memberInUse = this.languageExt.memberInUse(_name_16, _destructorName);
              _builder.append(_memberInUse, "	");
              _builder.append("(&");
              String _path = ai.getPath();
              String _pathName = this._roomExtensions.getPathName(_path);
              _builder.append(_pathName, "	");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(clsname, "	");
      _builder.append("_destroyMessageServices();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname, "");
      _builder.append("_shutdown(void){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "	");
      _builder.append("\", \"shutdown\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("etLogger_logInfoF(\"%s_shutdown\", ");
      _builder.append(clsname, "	");
      _builder.append("Inst.name);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(clsname, "	");
      _builder.append("Inst.shutdownRequest = 1;");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("static void ");
      _builder.append(clsname, "");
      _builder.append("_constructActorInstances(void){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "	");
      _builder.append("\", \"constructActorInstances\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        EList<ActorInstance> _allContainedInstances_1 = ssi.getAllContainedInstances();
        for(final ActorInstance ai_1 : _allContainedInstances_1) {
          {
            ActorClass _actorClass_3 = ai_1.getActorClass();
            EList<StandardOperation> _operations_1 = _actorClass_3.getOperations();
            final Function1<StandardOperation,Boolean> _function_2 = new Function1<StandardOperation,Boolean>() {
              public Boolean apply(final StandardOperation op) {
                boolean _isConstructor = RoomHelpers.isConstructor(op);
                return Boolean.valueOf(_isConstructor);
              }
            };
            Iterable<StandardOperation> _filter_1 = IterableExtensions.<StandardOperation>filter(_operations_1, _function_2);
            boolean _isEmpty_1 = IterableExtensions.isEmpty(_filter_1);
            boolean _not_1 = (!_isEmpty_1);
            if (_not_1) {
              _builder.append("\t");
              ActorClass _actorClass_4 = ai_1.getActorClass();
              String _name_18 = _actorClass_4.getName();
              ActorClass _actorClass_5 = ai_1.getActorClass();
              String _name_19 = _actorClass_5.getName();
              String _constructorName = this.languageExt.constructorName(_name_19);
              String _memberInUse_1 = this.languageExt.memberInUse(_name_18, _constructorName);
              _builder.append(_memberInUse_1, "	");
              _builder.append("(&");
              String _path_1 = ai_1.getPath();
              String _pathName_1 = this._roomExtensions.getPathName(_path_1);
              _builder.append(_pathName_1, "	");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("static void ");
      _builder.append(clsname, "");
      _builder.append("_initActorInstances(void){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "	");
      _builder.append("\", \"initActorInstances\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        EList<ActorInstance> _allContainedInstances_2 = ssi.getAllContainedInstances();
        for(final ActorInstance ai_2 : _allContainedInstances_2) {
          _builder.append("\t");
          ActorClass _actorClass_6 = ai_2.getActorClass();
          String _name_20 = _actorClass_6.getName();
          _builder.append(_name_20, "	");
          _builder.append("_init(&");
          String _path_2 = ai_2.getPath();
          String _pathName_2 = this._roomExtensions.getPathName(_path_2);
          _builder.append(_pathName_2, "	");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateInstanceFile(final Root root, final SubSystemInstance ssi, final HashSet<PhysicalThread> usedThreads) {
    CharSequence _xblockexpression = null;
    {
      final NodeRef nr = ETMapUtil.getNodeRef(ssi);
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
      _builder.append("* Instance File of Node ");
      String _name = nr.getName();
      _builder.append(_name, " ");
      _builder.append(" with SubSystem ");
      String _name_1 = ssi.getName();
      _builder.append(_name_1, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* - instantiation of all actor instances and port instances");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* - configuration of data and connection of ports");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.append("#include \"messaging/etMessageService.h\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* include all referenced ActorClasses */");
      _builder.newLine();
      {
        SubSystemClass _subSystemClass = ssi.getSubSystemClass();
        EList<ActorClass> _referencedActorClasses = root.getReferencedActorClasses(_subSystemClass);
        for(final ActorClass actorClass : _referencedActorClasses) {
          _builder.append("#include ");
          String _includePath = this._cExtensions.getIncludePath(actorClass);
          _builder.append(_includePath, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("/* include all referenced ProtcolClasses */");
      _builder.newLine();
      {
        SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
        EList<ProtocolClass> _referencedProtocolClasses = root.getReferencedProtocolClasses(_subSystemClass_1);
        for(final ProtocolClass protocolClass : _referencedProtocolClasses) {
          _builder.append("#include ");
          String _includePath_1 = this._cExtensions.getIncludePath(protocolClass);
          _builder.append(_includePath_1, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("/* instantiation of message services and message buffers */");
      _builder.newLine();
      {
        NodeClass _type = nr.getType();
        EList<PhysicalThread> _threads = _type.getThreads();
        final Function1<PhysicalThread,Boolean> _function = new Function1<PhysicalThread,Boolean>() {
          public Boolean apply(final PhysicalThread t) {
            boolean _contains = usedThreads.contains(t);
            return Boolean.valueOf(_contains);
          }
        };
        Iterable<PhysicalThread> _filter = IterableExtensions.<PhysicalThread>filter(_threads, _function);
        for(final PhysicalThread thread : _filter) {
          _builder.append("/* ");
          String _name_2 = thread.getName();
          _builder.append(_name_2, "");
          _builder.append(" */");
          _builder.newLineIfNotEmpty();
          _builder.append("#define ");
          String _name_3 = thread.getName();
          String _upperCase = _name_3.toUpperCase();
          _builder.append(_upperCase, "");
          _builder.append("_POOL_SIZE\t\t");
          int _msgpoolsize = thread.getMsgpoolsize();
          _builder.append(_msgpoolsize, "");
          _builder.newLineIfNotEmpty();
          _builder.append("#define ");
          String _name_4 = thread.getName();
          String _upperCase_1 = _name_4.toUpperCase();
          _builder.append(_upperCase_1, "");
          _builder.append("_BLOCK_SIZE\t");
          int _msgblocksize = thread.getMsgblocksize();
          _builder.append(_msgblocksize, "");
          _builder.newLineIfNotEmpty();
          _builder.append("static uint8 msgBuffer_");
          String _name_5 = thread.getName();
          _builder.append(_name_5, "");
          _builder.append("[");
          String _name_6 = thread.getName();
          String _upperCase_2 = _name_6.toUpperCase();
          _builder.append(_upperCase_2, "");
          _builder.append("_POOL_SIZE * ");
          String _name_7 = thread.getName();
          String _upperCase_3 = _name_7.toUpperCase();
          _builder.append(_upperCase_3, "");
          _builder.append("_BLOCK_SIZE]; ");
          _builder.newLineIfNotEmpty();
          _builder.append("static etMessageService msgService_");
          String _name_8 = thread.getName();
          _builder.append(_name_8, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("/* declarations of all ActorClass instances (const and variable structs) */");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* forward declaration of variable actor structs */");
      _builder.newLine();
      {
        EList<ActorInstance> _allContainedInstances = ssi.getAllContainedInstances();
        for(final ActorInstance ai : _allContainedInstances) {
          _builder.append("static ");
          ActorClass _actorClass = ai.getActorClass();
          String _name_9 = _actorClass.getName();
          _builder.append(_name_9, "");
          _builder.append(" ");
          String _path = ai.getPath();
          String _pathName = this._roomExtensions.getPathName(_path);
          _builder.append(_pathName, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("/* forward declaration of variable port structs */");
      _builder.newLine();
      {
        EList<ActorInstance> _allContainedInstances_1 = ssi.getAllContainedInstances();
        for(final ActorInstance ai_1 : _allContainedInstances_1) {
          {
            EList<InterfaceItemInstance> _orderedIfItemInstances = ai_1.getOrderedIfItemInstances();
            boolean _isEmpty = _orderedIfItemInstances.isEmpty();
            if (_isEmpty) {
              _builder.append("/* nothing to do */");
              _builder.newLine();
            } else {
              {
                EList<InterfaceItemInstance> _orderedIfItemInstances_1 = ai_1.getOrderedIfItemInstances();
                for(final InterfaceItemInstance pi : _orderedIfItemInstances_1) {
                  {
                    ProtocolClass _protocol = pi.getProtocol();
                    boolean _isConjugated = this._roomExtensions.isConjugated(pi);
                    PortClass _portClass = this._roomExtensions.getPortClass(_protocol, _isConjugated);
                    EList<Attribute> _attributes = null;
                    if (_portClass!=null) {
                      _attributes=_portClass.getAttributes();
                    }
                    int _size = 0;
                    if (_attributes!=null) {
                      _size=_attributes.size();
                    }
                    boolean _greaterThan = (_size > 0);
                    if (_greaterThan) {
                      _builder.append("static ");
                      ProtocolClass _protocol_1 = pi.getProtocol();
                      boolean _isConjugated_1 = this._roomExtensions.isConjugated(pi);
                      String _portClassName = this._roomExtensions.getPortClassName(_protocol_1, _isConjugated_1);
                      _builder.append(_portClassName, "");
                      _builder.append("_var ");
                      String _path_1 = pi.getPath();
                      String _pathName_1 = this._roomExtensions.getPathName(_path_1);
                      _builder.append(_pathName_1, "");
                      _builder.append("_var");
                      {
                        boolean _isReplicated = pi.isReplicated();
                        if (_isReplicated) {
                          _builder.append("[");
                          EList<InterfaceItemInstance> _peers = pi.getPeers();
                          int _size_1 = _peers.size();
                          _builder.append(_size_1, "");
                          _builder.append("]");
                        }
                      }
                      _builder.append("={");
                      _builder.newLineIfNotEmpty();
                      {
                        int _xifexpression = (int) 0;
                        EList<InterfaceItemInstance> _peers_1 = pi.getPeers();
                        int _size_2 = _peers_1.size();
                        boolean _equals = (_size_2 == 0);
                        if (_equals) {
                          _xifexpression = 1;
                        } else {
                          EList<InterfaceItemInstance> _peers_2 = pi.getPeers();
                          int _size_3 = _peers_2.size();
                          _xifexpression = _size_3;
                        }
                        IntegerRange _upTo = new IntegerRange(1, _xifexpression);
                        boolean _hasElements = false;
                        for(final Integer i : _upTo) {
                          if (!_hasElements) {
                            _hasElements = true;
                          } else {
                            _builder.appendImmediate(", ", "	");
                          }
                          _builder.append("\t");
                          InterfaceItem _interfaceItem = pi.getInterfaceItem();
                          PortClass _portClass_1 = RoomHelpers.getPortClass(_interfaceItem);
                          EList<Attribute> _attributes_1 = _portClass_1.getAttributes();
                          CharSequence _generateAttributeInit = this.attrInitGenAddon.generateAttributeInit(pi, _attributes_1);
                          _builder.append(_generateAttributeInit, "	");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t\t\t\t\t\t");
                        }
                      }
                      _builder.append("};");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              }
            }
          }
        }
      }
      _builder.newLine();
      {
        EList<ActorInstance> _allContainedInstances_2 = ssi.getAllContainedInstances();
        for(final ActorInstance ai_2 : _allContainedInstances_2) {
          _builder.newLine();
          _builder.append("/* instance ");
          String _path_2 = ai_2.getPath();
          String _pathName_2 = this._roomExtensions.getPathName(_path_2);
          _builder.append(_pathName_2, "");
          _builder.append(" */");
          _builder.newLineIfNotEmpty();
          {
            boolean _and = false;
            GlobalGeneratorSettings _settings = Main.getSettings();
            boolean _generateMSCInstrumentation = _settings.generateMSCInstrumentation();
            boolean _not = (!_generateMSCInstrumentation);
            if (!_not) {
              _and = false;
            } else {
              EList<InterfaceItemInstance> _orderedIfItemInstances_2 = ai_2.getOrderedIfItemInstances();
              boolean _isEmpty_1 = _orderedIfItemInstances_2.isEmpty();
              _and = (_not && _isEmpty_1);
            }
            if (_and) {
              _builder.append("/* no ports/saps/services - nothing to initialize statically */");
              _builder.newLine();
            } else {
              CharSequence _genActorInstanceInitializer = this.genActorInstanceInitializer(root, ai_2);
              _builder.append(_genActorInstanceInitializer, "");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence genActorInstanceInitializer(final Root root, final ActorInstance ai) {
    CharSequence _xblockexpression = null;
    {
      String _path = ai.getPath();
      final String instName = this._roomExtensions.getPathName(_path);
      ArrayList<InterfaceItemInstance> _arrayList = new ArrayList<InterfaceItemInstance>();
      final ArrayList<InterfaceItemInstance> replEventItems = _arrayList;
      EList<InterfaceItemInstance> _orderedIfItemInstances = ai.getOrderedIfItemInstances();
      final Function1<InterfaceItemInstance,Boolean> _function = new Function1<InterfaceItemInstance,Boolean>() {
        public Boolean apply(final InterfaceItemInstance e) {
          boolean _isReplicated = e.isReplicated();
          return Boolean.valueOf(_isReplicated);
        }
      };
      Iterable<InterfaceItemInstance> _filter = IterableExtensions.<InterfaceItemInstance>filter(_orderedIfItemInstances, _function);
      Iterables.<InterfaceItemInstance>addAll(replEventItems, _filter);
      final Function1<InterfaceItemInstance,Boolean> _function_1 = new Function1<InterfaceItemInstance,Boolean>() {
        public Boolean apply(final InterfaceItemInstance e) {
          EList<InterfaceItemInstance> _peers = e.getPeers();
          boolean _isEmpty = _peers.isEmpty();
          boolean _not = (!_isEmpty);
          return Boolean.valueOf(_not);
        }
      };
      InterfaceItemInstance _findFirst = IterableExtensions.<InterfaceItemInstance>findFirst(replEventItems, _function_1);
      final boolean haveReplSubItems = (!Objects.equal(_findFirst, null));
      final Function1<InterfaceItemInstance,Boolean> _function_2 = new Function1<InterfaceItemInstance,Boolean>() {
        public Boolean apply(final InterfaceItemInstance i) {
          InterfaceItem _interfaceItem = i.getInterfaceItem();
          return Boolean.valueOf((_interfaceItem instanceof Port));
        }
      };
      final Iterable<InterfaceItemInstance> replEventPorts = IterableExtensions.<InterfaceItemInstance>filter(replEventItems, _function_2);
      final Function1<InterfaceItemInstance,Boolean> _function_3 = new Function1<InterfaceItemInstance,Boolean>() {
        public Boolean apply(final InterfaceItemInstance i) {
          InterfaceItem _interfaceItem = i.getInterfaceItem();
          return Boolean.valueOf((_interfaceItem instanceof SPP));
        }
      };
      final Iterable<InterfaceItemInstance> replEventSPPs = IterableExtensions.<InterfaceItemInstance>filter(replEventItems, _function_3);
      EList<InterfaceItemInstance> _orderedIfItemInstances_1 = ai.getOrderedIfItemInstances();
      final Function1<InterfaceItemInstance,Boolean> _function_4 = new Function1<InterfaceItemInstance,Boolean>() {
        public Boolean apply(final InterfaceItemInstance e) {
          boolean _isSimple = e.isSimple();
          return Boolean.valueOf(_isSimple);
        }
      };
      final Iterable<InterfaceItemInstance> simplePorts = IterableExtensions.<InterfaceItemInstance>filter(_orderedIfItemInstances_1, _function_4);
      ArrayList<InterfaceItemInstance> _arrayList_1 = new ArrayList<InterfaceItemInstance>();
      final ArrayList<InterfaceItemInstance> simpleEventItems = _arrayList_1;
      final Function1<InterfaceItemInstance,Boolean> _function_5 = new Function1<InterfaceItemInstance,Boolean>() {
        public Boolean apply(final InterfaceItemInstance p) {
          ProtocolClass _protocol = p.getProtocol();
          CommunicationType _commType = _protocol.getCommType();
          boolean _equals = Objects.equal(_commType, CommunicationType.EVENT_DRIVEN);
          return Boolean.valueOf(_equals);
        }
      };
      Iterable<InterfaceItemInstance> _filter_1 = IterableExtensions.<InterfaceItemInstance>filter(simplePorts, _function_5);
      Iterables.<InterfaceItemInstance>addAll(simpleEventItems, _filter_1);
      final Function1<InterfaceItemInstance,Boolean> _function_6 = new Function1<InterfaceItemInstance,Boolean>() {
        public Boolean apply(final InterfaceItemInstance i) {
          InterfaceItem _interfaceItem = i.getInterfaceItem();
          return Boolean.valueOf((_interfaceItem instanceof Port));
        }
      };
      final Iterable<InterfaceItemInstance> simpleEventPorts = IterableExtensions.<InterfaceItemInstance>filter(simpleEventItems, _function_6);
      final Function1<InterfaceItemInstance,Boolean> _function_7 = new Function1<InterfaceItemInstance,Boolean>() {
        public Boolean apply(final InterfaceItemInstance i) {
          InterfaceItem _interfaceItem = i.getInterfaceItem();
          return Boolean.valueOf((_interfaceItem instanceof SAP));
        }
      };
      final Iterable<InterfaceItemInstance> simpleEventSAPs = IterableExtensions.<InterfaceItemInstance>filter(simpleEventItems, _function_7);
      final Function1<InterfaceItemInstance,Boolean> _function_8 = new Function1<InterfaceItemInstance,Boolean>() {
        public Boolean apply(final InterfaceItemInstance p) {
          ProtocolClass _protocol = p.getProtocol();
          CommunicationType _commType = _protocol.getCommType();
          boolean _equals = Objects.equal(_commType, CommunicationType.DATA_DRIVEN);
          return Boolean.valueOf(_equals);
        }
      };
      final Iterable<InterfaceItemInstance> dataPorts = IterableExtensions.<InterfaceItemInstance>filter(simplePorts, _function_8);
      final Function1<InterfaceItemInstance,Boolean> _function_9 = new Function1<InterfaceItemInstance,Boolean>() {
        public Boolean apply(final InterfaceItemInstance p) {
          boolean _and = false;
          if (!(p instanceof PortInstance)) {
            _and = false;
          } else {
            Port _port = ((PortInstance) p).getPort();
            boolean _isConjugated = _port.isConjugated();
            boolean _not = (!_isConjugated);
            _and = ((p instanceof PortInstance) && _not);
          }
          return Boolean.valueOf(_and);
        }
      };
      final Iterable<InterfaceItemInstance> recvPorts = IterableExtensions.<InterfaceItemInstance>filter(dataPorts, _function_9);
      final Function1<InterfaceItemInstance,Boolean> _function_10 = new Function1<InterfaceItemInstance,Boolean>() {
        public Boolean apply(final InterfaceItemInstance p) {
          boolean _and = false;
          if (!(p instanceof PortInstance)) {
            _and = false;
          } else {
            Port _port = ((PortInstance) p).getPort();
            boolean _isConjugated = _port.isConjugated();
            _and = ((p instanceof PortInstance) && _isConjugated);
          }
          return Boolean.valueOf(_and);
        }
      };
      final Iterable<InterfaceItemInstance> sendPorts = IterableExtensions.<InterfaceItemInstance>filter(dataPorts, _function_10);
      HashMap<InterfaceItemInstance,Integer> _hashMap = new HashMap<InterfaceItemInstance, Integer>();
      final HashMap<InterfaceItemInstance,Integer> offsets = _hashMap;
      int offset = 0;
      for (final InterfaceItemInstance p : replEventItems) {
        {
          offsets.put(p, Integer.valueOf(offset));
          EList<InterfaceItemInstance> _peers = p.getPeers();
          int _size = _peers.size();
          int _plus = (offset + _size);
          offset = _plus;
        }
      }
      String _xifexpression = null;
      if (haveReplSubItems) {
        String _plus = (instName + "_repl_sub_ports");
        _xifexpression = _plus;
      } else {
        _xifexpression = "NULL";
      }
      String replSubPortsArray = _xifexpression;
      boolean _or = false;
      boolean _or_1 = false;
      boolean _or_2 = false;
      boolean _isEmpty = simpleEventItems.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _or_2 = true;
      } else {
        boolean _isEmpty_1 = IterableExtensions.isEmpty(recvPorts);
        boolean _not_1 = (!_isEmpty_1);
        _or_2 = (_not || _not_1);
      }
      if (_or_2) {
        _or_1 = true;
      } else {
        boolean _isEmpty_2 = replEventItems.isEmpty();
        boolean _not_2 = (!_isEmpty_2);
        _or_1 = (_or_2 || _not_2);
      }
      if (_or_1) {
        _or = true;
      } else {
        GlobalGeneratorSettings _settings = Main.getSettings();
        boolean _generateMSCInstrumentation = _settings.generateMSCInstrumentation();
        _or = (_or_1 || _generateMSCInstrumentation);
      }
      final boolean haveConstData = _or;
      IntelligentSeparator _intelligentSeparator = new IntelligentSeparator(",");
      final IntelligentSeparator sep = _intelligentSeparator;
      String _xifexpression_1 = null;
      GlobalGeneratorSettings _settings_1 = Main.getSettings();
      boolean _generateMSCInstrumentation_1 = _settings_1.generateMSCInstrumentation();
      if (_generateMSCInstrumentation_1) {
        _xifexpression_1 = "/*const*/";
      } else {
        _xifexpression_1 = "const";
      }
      final String const_ = _xifexpression_1;
      StringConcatenation _builder = new StringConcatenation();
      {
        GlobalGeneratorSettings _settings_2 = Main.getSettings();
        boolean _generateMSCInstrumentation_2 = _settings_2.generateMSCInstrumentation();
        if (_generateMSCInstrumentation_2) {
          CharSequence _genPeerPortArrays = this.genPeerPortArrays(root, ai);
          _builder.append(_genPeerPortArrays, "");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        if (haveReplSubItems) {
          _builder.append("static const etReplSubPort ");
          _builder.append(replSubPortsArray, "");
          _builder.append("[");
          _builder.append(offset, "");
          _builder.append("] = {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("/* Replicated Sub Ports: {varData, msgService, peerAddress, localId, index} */");
          _builder.newLine();
          {
            final Function1<InterfaceItemInstance,Boolean> _function_11 = new Function1<InterfaceItemInstance,Boolean>() {
              public Boolean apply(final InterfaceItemInstance e) {
                EList<InterfaceItemInstance> _peers = e.getPeers();
                boolean _isEmpty = _peers.isEmpty();
                boolean _not = (!_isEmpty);
                return Boolean.valueOf(_not);
              }
            };
            Iterable<InterfaceItemInstance> _filter_2 = IterableExtensions.<InterfaceItemInstance>filter(replEventItems, _function_11);
            boolean _hasElements = false;
            for(final InterfaceItemInstance pi : _filter_2) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(",", "	");
              }
              _builder.append("\t");
              String _genReplSubPortInitializers = this.genReplSubPortInitializers(root, ai, pi);
              _builder.append(_genReplSubPortInitializers, "	");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("};");
          _builder.newLine();
        }
      }
      {
        if (haveConstData) {
          _builder.append("static ");
          _builder.append(const_, "");
          _builder.append(" ");
          ActorClass _actorClass = ai.getActorClass();
          String _name = _actorClass.getName();
          _builder.append(_name, "");
          _builder.append("_const ");
          _builder.append(instName, "");
          _builder.append("_const = {");
          _builder.newLineIfNotEmpty();
          {
            GlobalGeneratorSettings _settings_3 = Main.getSettings();
            boolean _generateMSCInstrumentation_3 = _settings_3.generateMSCInstrumentation();
            if (_generateMSCInstrumentation_3) {
              _builder.append("\t");
              _builder.append(sep, "	");
              _builder.append("\"");
              String _path_1 = ai.getPath();
              _builder.append(_path_1, "	");
              _builder.append("\"");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("/* Ports: {varData, msgService, peerAddress, localId} */");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* simple ports */");
          _builder.newLine();
          {
            for(final InterfaceItemInstance pi_1 : simpleEventPorts) {
              _builder.append("\t");
              _builder.append(sep, "	");
              String _genPortInitializer = this.genPortInitializer(root, ai, pi_1);
              _builder.append(_genPortInitializer, "	");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* data receive ports */");
          _builder.newLine();
          {
            for(final InterfaceItemInstance pi_2 : recvPorts) {
              _builder.append("\t");
              _builder.append(sep, "	");
              String _genRecvPortInitializer = this.genRecvPortInitializer(root, ai, pi_2);
              _builder.append(_genRecvPortInitializer, "	");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* saps */");
          _builder.newLine();
          {
            for(final InterfaceItemInstance pi_3 : simpleEventSAPs) {
              _builder.append("\t");
              _builder.append(sep, "	");
              String _genPortInitializer_1 = this.genPortInitializer(root, ai, pi_3);
              _builder.append(_genPortInitializer_1, "	");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* replicated ports */");
          _builder.newLine();
          {
            for(final InterfaceItemInstance pi_4 : replEventPorts) {
              _builder.append("\t");
              _builder.append(sep, "	");
              _builder.append("{");
              EList<InterfaceItemInstance> _peers = pi_4.getPeers();
              int _size = _peers.size();
              _builder.append(_size, "	");
              _builder.append(", ");
              _builder.append(replSubPortsArray, "	");
              _builder.append("+");
              Integer _get = offsets.get(pi_4);
              _builder.append(_get, "	");
              _builder.append("}");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* services */");
          _builder.newLine();
          {
            for(final InterfaceItemInstance pi_5 : replEventSPPs) {
              _builder.append("\t");
              _builder.append(sep, "	");
              _builder.append("{");
              EList<InterfaceItemInstance> _peers_1 = pi_5.getPeers();
              int _size_1 = _peers_1.size();
              _builder.append(_size_1, "	");
              _builder.append(", ");
              _builder.append(replSubPortsArray, "	");
              _builder.append("+");
              Integer _get_1 = offsets.get(pi_5);
              _builder.append(_get_1, "	");
              _builder.append("}");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("};");
          _builder.newLine();
        }
      }
      _builder.append("static ");
      ActorClass _actorClass_1 = ai.getActorClass();
      String _name_1 = _actorClass_1.getName();
      _builder.append(_name_1, "");
      _builder.append(" ");
      _builder.append(instName, "");
      _builder.append(" = {");
      _builder.newLineIfNotEmpty();
      {
        if (haveConstData) {
          _builder.append("\t");
          _builder.append("&");
          _builder.append(instName, "	");
          _builder.append("_const,");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("/* data send ports */");
      _builder.newLine();
      {
        for(final InterfaceItemInstance pi_6 : sendPorts) {
          _builder.append("\t");
          CharSequence _genSendPortInitializer = this.genSendPortInitializer(pi_6);
          _builder.append(_genSendPortInitializer, "	");
          _builder.append(",");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* attributes */");
      _builder.newLine();
      _builder.append("\t");
      ActorClass _actorClass_2 = ai.getActorClass();
      List<Attribute> _allAttributes = RoomHelpers.getAllAttributes(_actorClass_2);
      CharSequence _generateAttributeInit = this.attrInitGenAddon.generateAttributeInit(ai, _allAttributes);
      _builder.append(_generateAttributeInit, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* state and history are initialized in init function */");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence genPeerPortArrays(final Root root, final ActorInstance ai) {
    CharSequence _xblockexpression = null;
    {
      EList<InterfaceItemInstance> _orderedIfItemInstances = ai.getOrderedIfItemInstances();
      final Function1<InterfaceItemInstance,Boolean> _function = new Function1<InterfaceItemInstance,Boolean>() {
        public Boolean apply(final InterfaceItemInstance e) {
          boolean _and = false;
          boolean _isSimple = e.isSimple();
          if (!_isSimple) {
            _and = false;
          } else {
            _and = (_isSimple && (e instanceof PortInstance));
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterable<InterfaceItemInstance> _filter = IterableExtensions.<InterfaceItemInstance>filter(_orderedIfItemInstances, _function);
      final Function1<InterfaceItemInstance,PortInstance> _function_1 = new Function1<InterfaceItemInstance,PortInstance>() {
        public PortInstance apply(final InterfaceItemInstance inst) {
          return ((PortInstance) inst);
        }
      };
      final Iterable<PortInstance> simplePorts = IterableExtensions.<InterfaceItemInstance, PortInstance>map(_filter, _function_1);
      final Function1<PortInstance,Boolean> _function_2 = new Function1<PortInstance,Boolean>() {
        public Boolean apply(final PortInstance p) {
          boolean _and = false;
          Port _port = p.getPort();
          boolean _isConjugated = _port.isConjugated();
          if (!_isConjugated) {
            _and = false;
          } else {
            ProtocolClass _protocol = p.getProtocol();
            CommunicationType _commType = _protocol.getCommType();
            boolean _equals = Objects.equal(_commType, CommunicationType.DATA_DRIVEN);
            _and = (_isConjugated && _equals);
          }
          return Boolean.valueOf(_and);
        }
      };
      final Iterable<PortInstance> sendPorts = IterableExtensions.<PortInstance>filter(simplePorts, _function_2);
      final Function1<PortInstance,Boolean> _function_3 = new Function1<PortInstance,Boolean>() {
        public Boolean apply(final PortInstance p) {
          boolean _and = false;
          EList<InterfaceItemInstance> _peers = p.getPeers();
          boolean _isEmpty = _peers.isEmpty();
          boolean _not = (!_isEmpty);
          if (!_not) {
            _and = false;
          } else {
            Port _port = p.getPort();
            List<Message> _outgoing = RoomHelpers.getOutgoing(_port);
            final Function1<Message,Boolean> _function = new Function1<Message,Boolean>() {
              public Boolean apply(final Message m) {
                VarDecl _data = m.getData();
                RefableType _refType = _data.getRefType();
                DataType _type = _refType.getType();
                boolean _isEnumeration = NodeGen.this._typeHelpers.isEnumeration(_type);
                return Boolean.valueOf(_isEnumeration);
              }
            };
            Iterable<Message> _filter = IterableExtensions.<Message>filter(_outgoing, _function);
            boolean _isEmpty_1 = IterableExtensions.isEmpty(_filter);
            boolean _not_1 = (!_isEmpty_1);
            _and = (_not && _not_1);
          }
          return Boolean.valueOf(_and);
        }
      };
      final Iterable<PortInstance> enumPortsWithPeers = IterableExtensions.<PortInstance>filter(sendPorts, _function_3);
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isEmpty = IterableExtensions.isEmpty(enumPortsWithPeers);
        boolean _not = (!_isEmpty);
        if (_not) {
          _builder.append("#ifdef ET_ASYNC_MSC_LOGGER_ACTIVATE");
          _builder.newLine();
          {
            for(final PortInstance pi : enumPortsWithPeers) {
              _builder.append("static const char* ");
              String _path = pi.getPath();
              String _pathName = this._roomExtensions.getPathName(_path);
              _builder.append(_pathName, "");
              _builder.append("_peers[");
              EList<InterfaceItemInstance> _peers = pi.getPeers();
              int _size = _peers.size();
              int _plus = (_size + 1);
              _builder.append(_plus, "");
              _builder.append("] = {");
              _builder.newLineIfNotEmpty();
              {
                EList<InterfaceItemInstance> _peers_1 = pi.getPeers();
                for(final InterfaceItemInstance peer : _peers_1) {
                  _builder.append("\t");
                  _builder.append("\"");
                  EObject _eContainer = peer.eContainer();
                  String _path_1 = ((ActorInstance) _eContainer).getPath();
                  _builder.append(_path_1, "	");
                  _builder.append("\",");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("NULL");
              _builder.newLine();
              _builder.append("};");
              _builder.newLine();
            }
          }
          _builder.append("#endif");
          _builder.newLine();
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private String genPortInitializer(final Root root, final ActorInstance ai, final InterfaceItemInstance pi) {
    String _xblockexpression = null;
    {
      int _xifexpression = (int) 0;
      EList<InterfaceItemInstance> _peers = pi.getPeers();
      boolean _isEmpty = _peers.isEmpty();
      if (_isEmpty) {
        _xifexpression = 0;
      } else {
        EList<InterfaceItemInstance> _peers_1 = pi.getPeers();
        InterfaceItemInstance _get = _peers_1.get(0);
        int _objId = _get.getObjId();
        _xifexpression = _objId;
      }
      final int objId = _xifexpression;
      int _xifexpression_1 = (int) 0;
      EList<InterfaceItemInstance> _peers_2 = pi.getPeers();
      boolean _isEmpty_1 = _peers_2.isEmpty();
      if (_isEmpty_1) {
        _xifexpression_1 = 0;
      } else {
        EList<InterfaceItemInstance> _peers_3 = pi.getPeers();
        InterfaceItemInstance _get_1 = _peers_3.get(0);
        EList<InterfaceItemInstance> _peers_4 = _get_1.getPeers();
        int _indexOf = _peers_4.indexOf(pi);
        _xifexpression_1 = _indexOf;
      }
      final int idx = _xifexpression_1;
      String _xifexpression_2 = null;
      EList<InterfaceItemInstance> _peers_5 = pi.getPeers();
      boolean _isEmpty_2 = _peers_5.isEmpty();
      if (_isEmpty_2) {
        _xifexpression_2 = "NULL";
      } else {
        EList<InterfaceItemInstance> _peers_6 = pi.getPeers();
        InterfaceItemInstance _get_2 = _peers_6.get(0);
        EObject _eContainer = _get_2.eContainer();
        MappedThread _mappedThread = ETMapUtil.getMappedThread(((ActorInstance) _eContainer));
        PhysicalThread _thread = _mappedThread.getThread();
        String _name = _thread.getName();
        String _plus = ("&msgService_" + _name);
        _xifexpression_2 = _plus;
      }
      final String msgSvc = _xifexpression_2;
      String _xifexpression_3 = null;
      GlobalGeneratorSettings _settings = Main.getSettings();
      boolean _generateMSCInstrumentation = _settings.generateMSCInstrumentation();
      if (_generateMSCInstrumentation) {
        EObject _eContainer_1 = pi.eContainer();
        String _path = ((ActorInstance) _eContainer_1).getPath();
        String _plus_1 = (",\"" + _path);
        String _plus_2 = (_plus_1 + "\",");
        _xifexpression_3 = _plus_2;
      } else {
        _xifexpression_3 = "";
      }
      final String myInst = _xifexpression_3;
      String _xifexpression_4 = null;
      boolean _and = false;
      GlobalGeneratorSettings _settings_1 = Main.getSettings();
      boolean _generateMSCInstrumentation_1 = _settings_1.generateMSCInstrumentation();
      if (!_generateMSCInstrumentation_1) {
        _and = false;
      } else {
        EList<InterfaceItemInstance> _peers_7 = pi.getPeers();
        boolean _isEmpty_3 = _peers_7.isEmpty();
        boolean _not = (!_isEmpty_3);
        _and = (_generateMSCInstrumentation_1 && _not);
      }
      if (_and) {
        EList<InterfaceItemInstance> _peers_8 = pi.getPeers();
        InterfaceItemInstance _get_3 = _peers_8.get(0);
        EObject _eContainer_2 = _get_3.eContainer();
        String _path_1 = ((ActorInstance) _eContainer_2).getPath();
        String _plus_3 = ("\"" + _path_1);
        String _plus_4 = (_plus_3 + "\"");
        _xifexpression_4 = _plus_4;
      } else {
        _xifexpression_4 = "";
      }
      final String peerInst = _xifexpression_4;
      String _interfaceItemInstanceData = this.getInterfaceItemInstanceData(pi);
      String _plus_5 = ("{" + _interfaceItemInstanceData);
      String _plus_6 = (_plus_5 + ", ");
      String _plus_7 = (_plus_6 + msgSvc);
      String _plus_8 = (_plus_7 + ", ");
      int _plus_9 = (objId + idx);
      String _plus_10 = (_plus_8 + Integer.valueOf(_plus_9));
      String _plus_11 = (_plus_10 + "+BASE_ADDRESS, ");
      ExpandedActorClass _expandedActorClass = root.getExpandedActorClass(ai);
      InterfaceItem _interfaceItem = pi.getInterfaceItem();
      int _interfaceItemLocalId = _expandedActorClass.getInterfaceItemLocalId(_interfaceItem);
      int _plus_12 = (_interfaceItemLocalId + 1);
      String _plus_13 = (_plus_11 + Integer.valueOf(_plus_12));
      String _plus_14 = (_plus_13 + myInst);
      String _plus_15 = (_plus_14 + peerInst);
      String _plus_16 = (_plus_15 + "} /* Port ");
      String _name_1 = pi.getName();
      String _plus_17 = (_plus_16 + _name_1);
      String _plus_18 = (_plus_17 + " */");
      _xblockexpression = (_plus_18);
    }
    return _xblockexpression;
  }
  
  private CharSequence genSendPortInitializer(final InterfaceItemInstance pi) {
    CharSequence _xblockexpression = null;
    {
      Port _port = ((PortInstance) pi).getPort();
      GeneralProtocolClass _protocol = _port.getProtocol();
      final ProtocolClass pc = ((ProtocolClass) _protocol);
      List<Message> _allIncomingMessages = RoomHelpers.getAllIncomingMessages(pc);
      final Function1<Message,Boolean> _function = new Function1<Message,Boolean>() {
        public Boolean apply(final Message m) {
          VarDecl _data = m.getData();
          boolean _notEquals = (!Objects.equal(_data, null));
          return Boolean.valueOf(_notEquals);
        }
      };
      Iterable<Message> messages = IterableExtensions.<Message>filter(_allIncomingMessages, _function);
      final Function1<Message,Boolean> _function_1 = new Function1<Message,Boolean>() {
        public Boolean apply(final Message m) {
          VarDecl _data = m.getData();
          RefableType _refType = _data.getRefType();
          DataType _type = _refType.getType();
          boolean _isEnumeration = NodeGen.this._typeHelpers.isEnumeration(_type);
          return Boolean.valueOf(_isEnumeration);
        }
      };
      final Iterable<Message> enumMsgs = IterableExtensions.<Message>filter(messages, _function_1);
      boolean _and = false;
      GlobalGeneratorSettings _settings = Main.getSettings();
      boolean _generateMSCInstrumentation = _settings.generateMSCInstrumentation();
      if (!_generateMSCInstrumentation) {
        _and = false;
      } else {
        boolean _isEmpty = IterableExtensions.isEmpty(enumMsgs);
        boolean _not = (!_isEmpty);
        _and = (_generateMSCInstrumentation && _not);
      }
      final boolean usesMSC = _and;
      EObject _eContainer = pi.eContainer();
      final String instName = ((ActorInstance) _eContainer).getPath();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      {
        EList<Message> _incomingMessages = pc.getIncomingMessages();
        boolean _hasElements = false;
        for(final Message m : _incomingMessages) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "	");
          }
          _builder.append("\t");
          VarDecl _data = m.getData();
          RefableType _refType = _data.getRefType();
          DataType _type = _refType.getType();
          String _defaultValue = this._cExtensions.defaultValue(_type);
          _builder.append(_defaultValue, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        if (usesMSC) {
          _builder.append("\t");
          _builder.append("#ifdef ET_ASYNC_MSC_LOGGER_ACTIVATE");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append(", \"");
          _builder.append(instName, "		");
          _builder.append("\",");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          String _path = pi.getPath();
          String _pathName = this._roomExtensions.getPathName(_path);
          _builder.append(_pathName, "		");
          _builder.append("_peers");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("#endif");
          _builder.newLine();
        }
      }
      _builder.append("} /* send port ");
      String _name = pi.getName();
      _builder.append(_name, "");
      _builder.append(" */");
      _builder.newLineIfNotEmpty();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private String getInterfaceItemInstanceData(final InterfaceItemInstance pi) {
    ProtocolClass _protocol = pi.getProtocol();
    boolean _isConjugated = this._roomExtensions.isConjugated(pi);
    PortClass _portClass = this._roomExtensions.getPortClass(_protocol, _isConjugated);
    boolean _equals = Objects.equal(_portClass, null);
    if (_equals) {
      return "NULL";
    }
    ProtocolClass _protocol_1 = pi.getProtocol();
    boolean _isConjugated_1 = this._roomExtensions.isConjugated(pi);
    PortClass _portClass_1 = this._roomExtensions.getPortClass(_protocol_1, _isConjugated_1);
    EList<Attribute> _attributes = _portClass_1.getAttributes();
    boolean _isEmpty = _attributes.isEmpty();
    if (_isEmpty) {
      return "NULL";
    } else {
      String _path = pi.getPath();
      String _pathName = this._roomExtensions.getPathName(_path);
      String _plus = ("&" + _pathName);
      return (_plus + "_var");
    }
  }
  
  private String genRecvPortInitializer(final Root root, final ActorInstance ai, final InterfaceItemInstance pi) {
    String _xblockexpression = null;
    {
      InterfaceItem _interfaceItem = pi.getInterfaceItem();
      List<Message> _incoming = RoomHelpers.getIncoming(_interfaceItem);
      final Function1<Message,Boolean> _function = new Function1<Message,Boolean>() {
        public Boolean apply(final Message m) {
          VarDecl _data = m.getData();
          boolean _notEquals = (!Objects.equal(_data, null));
          return Boolean.valueOf(_notEquals);
        }
      };
      Iterable<Message> sentMsgs = IterableExtensions.<Message>filter(_incoming, _function);
      final Function1<Message,Boolean> _function_1 = new Function1<Message,Boolean>() {
        public Boolean apply(final Message m) {
          VarDecl _data = m.getData();
          RefableType _refType = _data.getRefType();
          DataType _type = _refType.getType();
          boolean _isEnumeration = NodeGen.this._typeHelpers.isEnumeration(_type);
          return Boolean.valueOf(_isEnumeration);
        }
      };
      final Iterable<Message> enumMsgs = IterableExtensions.<Message>filter(sentMsgs, _function_1);
      boolean _and = false;
      GlobalGeneratorSettings _settings = Main.getSettings();
      boolean _generateMSCInstrumentation = _settings.generateMSCInstrumentation();
      if (!_generateMSCInstrumentation) {
        _and = false;
      } else {
        boolean _isEmpty = IterableExtensions.isEmpty(enumMsgs);
        boolean _not = (!_isEmpty);
        _and = (_generateMSCInstrumentation && _not);
      }
      final boolean usesMSC = _and;
      String _xifexpression = null;
      if (usesMSC) {
        String _path = ai.getPath();
        String _plus = ("\n#ifdef ET_ASYNC_MSC_LOGGER_ACTIVATE\n, \"" + _path);
        String _plus_1 = (_plus + "\", ");
        Message _get = ((Message[])Conversions.unwrapArray(enumMsgs, Message.class))[0];
        VarDecl _data = _get.getData();
        RefableType _refType = _data.getRefType();
        DataType _type = _refType.getType();
        String _defaultValue = this._cExtensions.defaultValue(_type);
        String _plus_2 = (_plus_1 + _defaultValue);
        String _plus_3 = (_plus_2 + "\n#endif\n");
        _xifexpression = _plus_3;
      } else {
        _xifexpression = "";
      }
      final String enumVal = _xifexpression;
      EList<InterfaceItemInstance> _peers = pi.getPeers();
      boolean _isEmpty_1 = _peers.isEmpty();
      if (_isEmpty_1) {
        String _plus_4 = ("{NULL" + enumVal);
        return (_plus_4 + "}");
      }
      EList<InterfaceItemInstance> _peers_1 = pi.getPeers();
      InterfaceItemInstance peer = _peers_1.get(0);
      EList<InterfaceItemInstance> _peers_2 = pi.getPeers();
      InterfaceItemInstance _get_1 = _peers_2.get(0);
      EObject _eContainer = _get_1.eContainer();
      ActorInstance peerInst = ((ActorInstance) _eContainer);
      String _path_1 = peerInst.getPath();
      String instName = this._roomExtensions.getPathName(_path_1);
      String _plus_5 = ("{&" + instName);
      String _plus_6 = (_plus_5 + ".");
      String _name = peer.getName();
      String _plus_7 = (_plus_6 + _name);
      String _plus_8 = (_plus_7 + enumVal);
      String _plus_9 = (_plus_8 + "}");
      _xblockexpression = (_plus_9);
    }
    return _xblockexpression;
  }
  
  private String genReplSubPortInitializers(final Root root, final ActorInstance ai, final InterfaceItemInstance pi) {
    String result = "";
    String _xifexpression = null;
    GlobalGeneratorSettings _settings = Main.getSettings();
    boolean _generateMSCInstrumentation = _settings.generateMSCInstrumentation();
    if (_generateMSCInstrumentation) {
      EObject _eContainer = pi.eContainer();
      String _path = ((ActorInstance) _eContainer).getPath();
      String _plus = ("\n#ifdef ET_ASYNC_MSC_LOGGER_ACTIVATE\n,\"" + _path);
      String _plus_1 = (_plus + "\",\n#endif\n");
      _xifexpression = _plus_1;
    } else {
      _xifexpression = "";
    }
    final String myInst = _xifexpression;
    EList<InterfaceItemInstance> _peers = pi.getPeers();
    for (final InterfaceItemInstance p : _peers) {
      {
        EList<InterfaceItemInstance> _peers_1 = pi.getPeers();
        final int idx = _peers_1.indexOf(p);
        String _xifexpression_1 = null;
        EList<InterfaceItemInstance> _peers_2 = pi.getPeers();
        int _size = _peers_2.size();
        int _minus = (_size - 1);
        boolean _lessThan = (idx < _minus);
        if (_lessThan) {
          _xifexpression_1 = ",";
        } else {
          _xifexpression_1 = "";
        }
        final String comma = _xifexpression_1;
        EObject _eContainer_1 = p.eContainer();
        MappedThread _mappedThread = ETMapUtil.getMappedThread(((ActorInstance) _eContainer_1));
        PhysicalThread _thread = _mappedThread.getThread();
        final String thread = _thread.getName();
        String iiiD = this.getInterfaceItemInstanceData(pi);
        String _xifexpression_2 = null;
        GlobalGeneratorSettings _settings_1 = Main.getSettings();
        boolean _generateMSCInstrumentation_1 = _settings_1.generateMSCInstrumentation();
        if (_generateMSCInstrumentation_1) {
          EObject _eContainer_2 = p.eContainer();
          String _path_1 = ((ActorInstance) _eContainer_2).getPath();
          String _plus_2 = ("\"" + _path_1);
          String _plus_3 = (_plus_2 + "\"");
          _xifexpression_2 = _plus_3;
        } else {
          _xifexpression_2 = "";
        }
        final String peerInst = _xifexpression_2;
        String _xifexpression_3 = null;
        boolean _equals = iiiD.equals("NULL");
        if (_equals) {
          String _plus_4 = (iiiD + ",");
          _xifexpression_3 = _plus_4;
        } else {
          String _plus_5 = (iiiD + "[");
          String _plus_6 = (_plus_5 + Integer.valueOf(idx));
          String _plus_7 = (_plus_6 + "],");
          _xifexpression_3 = _plus_7;
        }
        iiiD = _xifexpression_3;
        String _plus_8 = (result + 
          "{{");
        String _plus_9 = (_plus_8 + iiiD);
        String _plus_10 = (_plus_9 + "&msgService_");
        String _plus_11 = (_plus_10 + thread);
        String _plus_12 = (_plus_11 + ", ");
        int _objId = p.getObjId();
        String _plus_13 = (_plus_12 + Integer.valueOf(_objId));
        String _plus_14 = (_plus_13 + "+BASE_ADDRESS, ");
        ExpandedActorClass _expandedActorClass = root.getExpandedActorClass(ai);
        InterfaceItem _interfaceItem = pi.getInterfaceItem();
        int _interfaceItemLocalId = _expandedActorClass.getInterfaceItemLocalId(_interfaceItem);
        int _plus_15 = (_interfaceItemLocalId + 1);
        String _plus_16 = (_plus_14 + Integer.valueOf(_plus_15));
        String _plus_17 = (_plus_16 + myInst);
        String _plus_18 = (_plus_17 + peerInst);
        String _plus_19 = (_plus_18 + "},");
        String _plus_20 = (_plus_19 + Integer.valueOf(idx));
        String _plus_21 = (_plus_20 + "}");
        String _plus_22 = (_plus_21 + comma);
        String _plus_23 = (_plus_22 + " /* Repl Sub Port ");
        String _name = pi.getName();
        String _plus_24 = (_plus_23 + _name);
        String _plus_25 = (_plus_24 + " idx +");
        String _plus_26 = (_plus_25 + Integer.valueOf(idx));
        String _plus_27 = (_plus_26 + "*/\n");
        result = _plus_27;
      }
    }
    return result;
  }
  
  private CharSequence generateDispatcherFile(final Root root, final SubSystemInstance ssi, final HashSet<PhysicalThread> usedThreads) {
    CharSequence _xblockexpression = null;
    {
      final NodeRef nr = ETMapUtil.getNodeRef(ssi);
      final ArrayList<PortInstance> loggedPorts = this.loggedPorts(ssi);
      SubSystemClass _subSystemClass = ssi.getSubSystemClass();
      EList<Annotation> _annotations = _subSystemClass.getAnnotations();
      final boolean logData = BaseHelpers.isAnnotationPresent(_annotations, "DataLogging");
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
      _builder.append("* Dispatcher File of Node ");
      String _name = nr.getName();
      _builder.append(_name, " ");
      _builder.append(" with SubSystem ");
      String _name_1 = ssi.getName();
      _builder.append(_name_1, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* contains a generated message dispatcher (receiveMessage) for each MessageService (Thread)");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.append("#include \"messaging/etMessageReceiver.h\"");
      _builder.newLine();
      _builder.append("#include \"debugging/etLogger.h\"");
      _builder.newLine();
      _builder.append("#include \"debugging/etMSCLogger.h\"");
      _builder.newLine();
      _builder.newLine();
      {
        NodeClass _type = nr.getType();
        EList<PhysicalThread> _threads = _type.getThreads();
        final Function1<PhysicalThread,Boolean> _function = new Function1<PhysicalThread,Boolean>() {
          public Boolean apply(final PhysicalThread t) {
            boolean _contains = usedThreads.contains(t);
            return Boolean.valueOf(_contains);
          }
        };
        Iterable<PhysicalThread> _filter = IterableExtensions.<PhysicalThread>filter(_threads, _function);
        boolean _hasElements = false;
        for(final PhysicalThread thread : _filter) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate("\n", "");
          }
          EList<ActorInstance> _allContainedInstances = ssi.getAllContainedInstances();
          final Function1<ActorInstance,Boolean> _function_1 = new Function1<ActorInstance,Boolean>() {
            public Boolean apply(final ActorInstance ai) {
              MappedThread _mappedThread = ETMapUtil.getMappedThread(ai);
              PhysicalThread _thread = _mappedThread.getThread();
              boolean _equals = Objects.equal(_thread, thread);
              return Boolean.valueOf(_equals);
            }
          };
          final Iterable<ActorInstance> instancesOnThread = IterableExtensions.<ActorInstance>filter(_allContainedInstances, _function_1);
          _builder.newLineIfNotEmpty();
          final Function1<ActorInstance,Boolean> _function_2 = new Function1<ActorInstance,Boolean>() {
            public Boolean apply(final ActorInstance ai) {
              boolean _or = false;
              ActorClass _actorClass = ai.getActorClass();
              ActorCommunicationType _commType = _actorClass.getCommType();
              boolean _equals = Objects.equal(_commType, ActorCommunicationType.EVENT_DRIVEN);
              if (_equals) {
                _or = true;
              } else {
                ActorClass _actorClass_1 = ai.getActorClass();
                ActorCommunicationType _commType_1 = _actorClass_1.getCommType();
                boolean _equals_1 = Objects.equal(_commType_1, ActorCommunicationType.ASYNCHRONOUS);
                _or = (_equals || _equals_1);
              }
              return Boolean.valueOf(_or);
            }
          };
          final Iterable<ActorInstance> dispatchedInstances = IterableExtensions.<ActorInstance>filter(instancesOnThread, _function_2);
          _builder.newLineIfNotEmpty();
          final Function1<ActorInstance,Boolean> _function_3 = new Function1<ActorInstance,Boolean>() {
            public Boolean apply(final ActorInstance ai) {
              boolean _or = false;
              ActorClass _actorClass = ai.getActorClass();
              ActorCommunicationType _commType = _actorClass.getCommType();
              boolean _equals = Objects.equal(_commType, ActorCommunicationType.DATA_DRIVEN);
              if (_equals) {
                _or = true;
              } else {
                ActorClass _actorClass_1 = ai.getActorClass();
                ActorCommunicationType _commType_1 = _actorClass_1.getCommType();
                boolean _equals_1 = Objects.equal(_commType_1, ActorCommunicationType.ASYNCHRONOUS);
                _or = (_equals || _equals_1);
              }
              return Boolean.valueOf(_or);
            }
          };
          final Iterable<ActorInstance> executedInstances = IterableExtensions.<ActorInstance>filter(instancesOnThread, _function_3);
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          {
            int _size = IterableExtensions.size(executedInstances);
            boolean _greaterThan = (_size > 0);
            if (_greaterThan) {
              _builder.append("/**");
              _builder.newLine();
              _builder.append(" ");
              _builder.append("* generated execute function for all cyclic execute calls for the async or datadriven actor instances of thread \"");
              String _name_2 = thread.getName();
              _builder.append(_name_2, " ");
              _builder.append("\"");
              _builder.newLineIfNotEmpty();
              _builder.append(" ");
              _builder.append("*/");
              _builder.newLine();
              _builder.append("static void MsgDispatcher_");
              String _name_3 = thread.getName();
              _builder.append(_name_3, "");
              _builder.append("_poll(void){");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"MsgDispatcher_");
              String _name_4 = thread.getName();
              _builder.append(_name_4, "	");
              _builder.append("\", \"execute\")");
              _builder.newLineIfNotEmpty();
              {
                for(final ActorInstance ai : executedInstances) {
                  _builder.append("\t");
                  ActorClass _actorClass = ai.getActorClass();
                  String _name_5 = _actorClass.getName();
                  _builder.append(_name_5, "	");
                  _builder.append("_execute((void*)&");
                  String _path = ai.getPath();
                  String _pathName = this._roomExtensions.getPathName(_path);
                  _builder.append(_pathName, "	");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
              _builder.newLine();
              _builder.append("}");
              _builder.newLine();
              {
                if (logData) {
                  _builder.append("static void MsgDispatcher_");
                  String _name_6 = thread.getName();
                  _builder.append(_name_6, "");
                  _builder.append("_logDataHeaders(void){");
                  _builder.newLineIfNotEmpty();
                  {
                    for(final PortInstance pi : loggedPorts) {
                      _builder.append("\t");
                      _builder.append("ET_DATA_LOGGER_LOG_STRING(\"");
                      String _path_1 = pi.getPath();
                      _builder.append(_path_1, "	");
                      _builder.append("\")");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  _builder.append("\t");
                  _builder.append("ET_DATA_LOGGER_NEW_ROW");
                  _builder.newLine();
                  _builder.append("}");
                  _builder.newLine();
                  _builder.append("static void MsgDispatcher_");
                  String _name_7 = thread.getName();
                  _builder.append(_name_7, "");
                  _builder.append("_logData(void){");
                  _builder.newLineIfNotEmpty();
                  {
                    for(final PortInstance pi_1 : loggedPorts) {
                      _builder.append("\t");
                      String _createLoggerCall = this.createLoggerCall(pi_1);
                      _builder.append(_createLoggerCall, "	");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  _builder.append("\t");
                  _builder.append("ET_DATA_LOGGER_NEW_ROW");
                  _builder.newLine();
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
          _builder.append("* generated dispatch function for all messages for the thread \"");
          String _name_8 = thread.getName();
          _builder.append(_name_8, " ");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("static etBool MsgDispatcher_");
          String _name_9 = thread.getName();
          _builder.append(_name_9, "");
          _builder.append("_receiveMessage(const etMessage* msg){");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"MsgDispatcher_");
          String _name_10 = thread.getName();
          _builder.append(_name_10, "	");
          _builder.append("\", \"receiveMessage\")");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("switch(msg->address){");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("case MESSAGESERVICE_ADDRESS:");
          _builder.newLine();
          {
            boolean _isEmpty = IterableExtensions.isEmpty(executedInstances);
            boolean _not = (!_isEmpty);
            if (_not) {
              _builder.append("\t\t\t");
              _builder.append("if (msg->evtID == etSystemProtocol_IN_poll) {");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("MsgDispatcher_");
              String _name_11 = thread.getName();
              _builder.append(_name_11, "				");
              _builder.append("_poll();");
              _builder.newLineIfNotEmpty();
              {
                if (logData) {
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("MsgDispatcher_");
                  String _name_12 = thread.getName();
                  _builder.append(_name_12, "				");
                  _builder.append("_logData();");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t\t\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("else");
              _builder.newLine();
            }
          }
          _builder.append("\t\t\t");
          _builder.append("if (msg->evtID == etSystemProtocol_IN_terminate)");
          _builder.newLine();
          _builder.append("\t\t\t\t");
          _builder.append("return FALSE;");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("break;");
          _builder.newLine();
          {
            for(final ActorInstance ai_1 : dispatchedInstances) {
              _builder.append("\t\t");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("/* interface items of ");
              String _path_2 = ai_1.getPath();
              _builder.append(_path_2, "		");
              _builder.append(" */");
              _builder.newLineIfNotEmpty();
              {
                EList<InterfaceItemInstance> _orderedIfItemInstances = ai_1.getOrderedIfItemInstances();
                final Function1<InterfaceItemInstance,Boolean> _function_4 = new Function1<InterfaceItemInstance,Boolean>() {
                  public Boolean apply(final InterfaceItemInstance p) {
                    ProtocolClass _protocol = p.getProtocol();
                    CommunicationType _commType = _protocol.getCommType();
                    boolean _equals = Objects.equal(_commType, CommunicationType.EVENT_DRIVEN);
                    return Boolean.valueOf(_equals);
                  }
                };
                Iterable<InterfaceItemInstance> _filter_1 = IterableExtensions.<InterfaceItemInstance>filter(_orderedIfItemInstances, _function_4);
                for(final InterfaceItemInstance pi_2 : _filter_1) {
                  {
                    boolean _isReplicated = pi_2.isReplicated();
                    if (_isReplicated) {
                      {
                        EList<InterfaceItemInstance> _peers = pi_2.getPeers();
                        for(final InterfaceItemInstance peer : _peers) {
                          _builder.append("\t\t");
                          _builder.append("case ");
                          int _objId = pi_2.getObjId();
                          EList<InterfaceItemInstance> _peers_1 = pi_2.getPeers();
                          int _indexOf = _peers_1.indexOf(peer);
                          int _plus = (_objId + _indexOf);
                          _builder.append(_plus, "		");
                          _builder.append("+BASE_ADDRESS:");
                          _builder.newLineIfNotEmpty();
                          {
                            ProtocolClass _protocol = pi_2.getProtocol();
                            boolean _isConjugated = this._roomExtensions.isConjugated(pi_2);
                            boolean _handlesReceive = this._roomExtensions.handlesReceive(_protocol, _isConjugated);
                            if (_handlesReceive) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("switch (msg->evtID){");
                              _builder.newLine();
                              {
                                ProtocolClass _protocol_1 = pi_2.getProtocol();
                                boolean _isConjugated_1 = this._roomExtensions.isConjugated(pi_2);
                                List<MessageHandler> _receiveHandlers = this._roomExtensions.getReceiveHandlers(_protocol_1, _isConjugated_1);
                                for(final MessageHandler h : _receiveHandlers) {
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("\t");
                                  _builder.append("case ");
                                  ProtocolClass _protocol_2 = pi_2.getProtocol();
                                  String _name_13 = _protocol_2.getName();
                                  _builder.append(_name_13, "				");
                                  _builder.append("_");
                                  Message _msg = h.getMsg();
                                  String _codeName = this._roomExtensions.getCodeName(_msg);
                                  _builder.append(_codeName, "				");
                                  _builder.append(":");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("\t");
                                  _builder.append("\t");
                                  ProtocolClass _protocol_3 = pi_2.getProtocol();
                                  boolean _isConjugated_2 = this._roomExtensions.isConjugated(pi_2);
                                  String _portClassName = this._roomExtensions.getPortClassName(_protocol_3, _isConjugated_2);
                                  _builder.append(_portClassName, "					");
                                  _builder.append("_");
                                  Message _msg_1 = h.getMsg();
                                  String _name_14 = _msg_1.getName();
                                  _builder.append(_name_14, "					");
                                  _builder.append("_receiveHandler((etPort *)&");
                                  String _path_3 = ai_1.getPath();
                                  String _pathName_1 = this._roomExtensions.getPathName(_path_3);
                                  _builder.append(_pathName_1, "					");
                                  _builder.append("_const.");
                                  String _name_15 = pi_2.getName();
                                  _builder.append(_name_15, "					");
                                  _builder.append(".ports[");
                                  EList<InterfaceItemInstance> _peers_2 = pi_2.getPeers();
                                  int _indexOf_1 = _peers_2.indexOf(peer);
                                  _builder.append(_indexOf_1, "					");
                                  _builder.append("],msg,(void*)&");
                                  String _path_4 = ai_1.getPath();
                                  String _pathName_2 = this._roomExtensions.getPathName(_path_4);
                                  _builder.append(_pathName_2, "					");
                                  _builder.append(",");
                                  ActorClass _actorClass_1 = ai_1.getActorClass();
                                  String _name_16 = _actorClass_1.getName();
                                  _builder.append(_name_16, "					");
                                  _builder.append("_receiveMessage);");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("\t");
                                  _builder.append("break;");
                                  _builder.newLine();
                                }
                              }
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("default: ");
                              ActorClass _actorClass_2 = ai_1.getActorClass();
                              String _name_17 = _actorClass_2.getName();
                              _builder.append(_name_17, "				");
                              _builder.append("_receiveMessage((void*)&");
                              String _path_5 = ai_1.getPath();
                              String _pathName_3 = this._roomExtensions.getPathName(_path_5);
                              _builder.append(_pathName_3, "				");
                              _builder.append(",(etPort*)&");
                              String _path_6 = ai_1.getPath();
                              String _pathName_4 = this._roomExtensions.getPathName(_path_6);
                              _builder.append(_pathName_4, "				");
                              _builder.append("_const.");
                              String _name_18 = pi_2.getName();
                              _builder.append(_name_18, "				");
                              _builder.append(".ports[");
                              EList<InterfaceItemInstance> _peers_3 = pi_2.getPeers();
                              int _indexOf_2 = _peers_3.indexOf(peer);
                              _builder.append(_indexOf_2, "				");
                              _builder.append("], msg);");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t\t");
                              _builder.append("break;");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("}\t\t\t\t\t\t\t\t\t\t");
                              _builder.newLine();
                            } else {
                              {
                                GlobalGeneratorSettings _settings = Main.getSettings();
                                boolean _generateMSCInstrumentation = _settings.generateMSCInstrumentation();
                                if (_generateMSCInstrumentation) {
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("ET_MSC_LOGGER_ASYNC_IN(");
                                  _builder.newLine();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("\t");
                                  String _path_7 = ai_1.getPath();
                                  String _pathName_5 = this._roomExtensions.getPathName(_path_7);
                                  _builder.append(_pathName_5, "				");
                                  _builder.append("_const.");
                                  String _name_19 = pi_2.getName();
                                  _builder.append(_name_19, "				");
                                  _builder.append(".ports[");
                                  EList<InterfaceItemInstance> _peers_4 = pi_2.getPeers();
                                  int _indexOf_3 = _peers_4.indexOf(peer);
                                  _builder.append(_indexOf_3, "				");
                                  _builder.append("].port.peerInstName,");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("\t");
                                  ProtocolClass _protocol_4 = pi_2.getProtocol();
                                  String _name_20 = _protocol_4.getName();
                                  _builder.append(_name_20, "				");
                                  _builder.append("_getMessageString(msg->evtID),");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("\t");
                                  String _path_8 = ai_1.getPath();
                                  String _pathName_6 = this._roomExtensions.getPathName(_path_8);
                                  _builder.append(_pathName_6, "				");
                                  _builder.append("_const.");
                                  String _name_21 = pi_2.getName();
                                  _builder.append(_name_21, "				");
                                  _builder.append(".ports[");
                                  EList<InterfaceItemInstance> _peers_5 = pi_2.getPeers();
                                  int _indexOf_4 = _peers_5.indexOf(peer);
                                  _builder.append(_indexOf_4, "				");
                                  _builder.append("].port.myInstName");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("\t");
                                  _builder.append(")");
                                  _builder.newLine();
                                }
                              }
                              _builder.append("\t\t");
                              _builder.append("\t");
                              ActorClass _actorClass_3 = ai_1.getActorClass();
                              String _name_22 = _actorClass_3.getName();
                              _builder.append(_name_22, "			");
                              _builder.append("_receiveMessage((void*)&");
                              String _path_9 = ai_1.getPath();
                              String _pathName_7 = this._roomExtensions.getPathName(_path_9);
                              _builder.append(_pathName_7, "			");
                              _builder.append(",&");
                              String _path_10 = ai_1.getPath();
                              String _pathName_8 = this._roomExtensions.getPathName(_path_10);
                              _builder.append(_pathName_8, "			");
                              _builder.append("_const.");
                              String _name_23 = pi_2.getName();
                              _builder.append(_name_23, "			");
                              _builder.append(".ports[");
                              EList<InterfaceItemInstance> _peers_6 = pi_2.getPeers();
                              int _indexOf_5 = _peers_6.indexOf(peer);
                              _builder.append(_indexOf_5, "			");
                              _builder.append("].port, msg);");
                              _builder.newLineIfNotEmpty();
                            }
                          }
                          _builder.append("\t\t");
                          _builder.append("break;");
                          _builder.newLine();
                        }
                      }
                    } else {
                      _builder.append("\t\t");
                      _builder.append("case ");
                      int _objId_1 = pi_2.getObjId();
                      _builder.append(_objId_1, "		");
                      _builder.append("+BASE_ADDRESS:");
                      _builder.newLineIfNotEmpty();
                      {
                        ProtocolClass _protocol_5 = pi_2.getProtocol();
                        boolean _isConjugated_3 = this._roomExtensions.isConjugated(pi_2);
                        boolean _handlesReceive_1 = this._roomExtensions.handlesReceive(_protocol_5, _isConjugated_3);
                        if (_handlesReceive_1) {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("switch (msg->evtID){");
                          _builder.newLine();
                          {
                            ProtocolClass _protocol_6 = pi_2.getProtocol();
                            boolean _isConjugated_4 = this._roomExtensions.isConjugated(pi_2);
                            List<MessageHandler> _receiveHandlers_1 = this._roomExtensions.getReceiveHandlers(_protocol_6, _isConjugated_4);
                            for(final MessageHandler h_1 : _receiveHandlers_1) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("case ");
                              ProtocolClass _protocol_7 = pi_2.getProtocol();
                              String _name_24 = _protocol_7.getName();
                              _builder.append(_name_24, "				");
                              _builder.append("_");
                              Message _msg_2 = h_1.getMsg();
                              String _codeName_1 = this._roomExtensions.getCodeName(_msg_2);
                              _builder.append(_codeName_1, "				");
                              _builder.append(":");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              ProtocolClass _protocol_8 = pi_2.getProtocol();
                              boolean _isConjugated_5 = this._roomExtensions.isConjugated(pi_2);
                              String _portClassName_1 = this._roomExtensions.getPortClassName(_protocol_8, _isConjugated_5);
                              _builder.append(_portClassName_1, "					");
                              _builder.append("_");
                              Message _msg_3 = h_1.getMsg();
                              String _name_25 = _msg_3.getName();
                              _builder.append(_name_25, "					");
                              _builder.append("_receiveHandler((etPort *)&");
                              String _path_11 = ai_1.getPath();
                              String _pathName_9 = this._roomExtensions.getPathName(_path_11);
                              _builder.append(_pathName_9, "					");
                              _builder.append("_const.");
                              String _name_26 = pi_2.getName();
                              _builder.append(_name_26, "					");
                              _builder.append(",msg,(void*)&");
                              String _path_12 = ai_1.getPath();
                              String _pathName_10 = this._roomExtensions.getPathName(_path_12);
                              _builder.append(_pathName_10, "					");
                              _builder.append(",");
                              ActorClass _actorClass_4 = ai_1.getActorClass();
                              String _name_27 = _actorClass_4.getName();
                              _builder.append(_name_27, "					");
                              _builder.append("_receiveMessage);");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("break;");
                              _builder.newLine();
                            }
                          }
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("default: ");
                          ActorClass _actorClass_5 = ai_1.getActorClass();
                          String _name_28 = _actorClass_5.getName();
                          _builder.append(_name_28, "				");
                          _builder.append("_receiveMessage((void*)&");
                          String _path_13 = ai_1.getPath();
                          String _pathName_11 = this._roomExtensions.getPathName(_path_13);
                          _builder.append(_pathName_11, "				");
                          _builder.append(",(etPort*)&");
                          String _path_14 = ai_1.getPath();
                          String _pathName_12 = this._roomExtensions.getPathName(_path_14);
                          _builder.append(_pathName_12, "				");
                          _builder.append("_const.");
                          String _name_29 = pi_2.getName();
                          _builder.append(_name_29, "				");
                          _builder.append(", msg);");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t\t");
                          _builder.append("break;");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("}");
                          _builder.newLine();
                        } else {
                          {
                            GlobalGeneratorSettings _settings_1 = Main.getSettings();
                            boolean _generateMSCInstrumentation_1 = _settings_1.generateMSCInstrumentation();
                            if (_generateMSCInstrumentation_1) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("ET_MSC_LOGGER_ASYNC_IN(");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("((etPort*)&");
                              String _path_15 = ai_1.getPath();
                              String _pathName_13 = this._roomExtensions.getPathName(_path_15);
                              _builder.append(_pathName_13, "				");
                              _builder.append("_const.");
                              String _name_30 = pi_2.getName();
                              _builder.append(_name_30, "				");
                              _builder.append(")->peerInstName,");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              ProtocolClass _protocol_9 = pi_2.getProtocol();
                              String _name_31 = _protocol_9.getName();
                              _builder.append(_name_31, "				");
                              _builder.append("_getMessageString(msg->evtID),");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("((etPort*)&");
                              String _path_16 = ai_1.getPath();
                              String _pathName_14 = this._roomExtensions.getPathName(_path_16);
                              _builder.append(_pathName_14, "				");
                              _builder.append("_const.");
                              String _name_32 = pi_2.getName();
                              _builder.append(_name_32, "				");
                              _builder.append(")->myInstName");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append(")");
                              _builder.newLine();
                            }
                          }
                          _builder.append("\t\t");
                          _builder.append("\t");
                          ActorClass _actorClass_6 = ai_1.getActorClass();
                          String _name_33 = _actorClass_6.getName();
                          _builder.append(_name_33, "			");
                          _builder.append("_receiveMessage((void*)&");
                          String _path_17 = ai_1.getPath();
                          String _pathName_15 = this._roomExtensions.getPathName(_path_17);
                          _builder.append(_pathName_15, "			");
                          _builder.append(",(etPort*)&");
                          String _path_18 = ai_1.getPath();
                          String _pathName_16 = this._roomExtensions.getPathName(_path_18);
                          _builder.append(_pathName_16, "			");
                          _builder.append("_const.");
                          String _name_34 = pi_2.getName();
                          _builder.append(_name_34, "			");
                          _builder.append(", msg);");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("break;");
                      _builder.newLine();
                    }
                  }
                }
              }
            }
          }
          _builder.append("\t\t");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("default:");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("etLogger_logErrorF(\"MessageService_");
          String _name_35 = thread.getName();
          _builder.append(_name_35, "			");
          _builder.append("_receiveMessage: address %d does not exist \", msg->address);");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("break;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("return TRUE;");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private String createLoggerCall(final PortInstance pi) {
    String _xblockexpression = null;
    {
      ProtocolClass _protocol = pi.getProtocol();
      EList<Message> _incomingMessages = _protocol.getIncomingMessages();
      final Function1<Message,Boolean> _function = new Function1<Message,Boolean>() {
        public Boolean apply(final Message m) {
          boolean _and = false;
          VarDecl _data = m.getData();
          boolean _notEquals = (!Objects.equal(_data, null));
          if (!_notEquals) {
            _and = false;
          } else {
            VarDecl _data_1 = m.getData();
            RefableType _refType = _data_1.getRefType();
            DataType _type = _refType.getType();
            boolean _isEnumerationOrPrimitive = NodeGen.this._typeHelpers.isEnumerationOrPrimitive(_type);
            _and = (_notEquals && _isEnumerationOrPrimitive);
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterable<Message> _filter = IterableExtensions.<Message>filter(_incomingMessages, _function);
      final Message msg = ((Message[])Conversions.unwrapArray(_filter, Message.class))[0];
      EObject _eContainer = pi.eContainer();
      final ActorInstance ai = ((ActorInstance) _eContainer);
      String _path = ai.getPath();
      String _pathName = this._roomExtensions.getPathName(_path);
      String _plus = (_pathName + ".");
      String _name = pi.getName();
      String _plus_1 = (_plus + _name);
      String _plus_2 = (_plus_1 + ".");
      String _name_1 = msg.getName();
      final String data = (_plus_2 + _name_1);
      LiteralType _xifexpression = null;
      VarDecl _data = msg.getData();
      RefableType _refType = _data.getRefType();
      DataType _type = _refType.getType();
      if ((_type instanceof EnumerationType)) {
        _xifexpression = LiteralType.INT;
      } else {
        VarDecl _data_1 = msg.getData();
        RefableType _refType_1 = _data_1.getRefType();
        DataType _type_1 = _refType_1.getType();
        LiteralType _type_2 = ((PrimitiveType) _type_1).getType();
        _xifexpression = _type_2;
      }
      final LiteralType type = _xifexpression;
      String _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(type,LiteralType.BOOL)) {
          _matched=true;
          String _plus_3 = ("ET_DATA_LOGGER_LOG_BOOL((int)" + data);
          String _plus_4 = (_plus_3 + ")");
          _switchResult = _plus_4;
        }
      }
      if (!_matched) {
        if (Objects.equal(type,LiteralType.CHAR)) {
          _matched=true;
          String _plus_5 = ("ET_DATA_LOGGER_LOG_INT((int)" + data);
          String _plus_6 = (_plus_5 + ")");
          _switchResult = _plus_6;
        }
      }
      if (!_matched) {
        if (Objects.equal(type,LiteralType.INT)) {
          _matched=true;
          String _plus_7 = ("ET_DATA_LOGGER_LOG_INT((int)" + data);
          String _plus_8 = (_plus_7 + ")");
          _switchResult = _plus_8;
        }
      }
      if (!_matched) {
        if (Objects.equal(type,LiteralType.REAL)) {
          _matched=true;
          String _plus_9 = ("ET_DATA_LOGGER_LOG_DOUBLE((double)" + data);
          String _plus_10 = (_plus_9 + ")");
          _switchResult = _plus_10;
        }
      }
      if (!_matched) {
        _switchResult = "internal error: unknown primitive type";
      }
      _xblockexpression = (_switchResult);
    }
    return _xblockexpression;
  }
  
  private ArrayList<PortInstance> loggedPorts(final SubSystemInstance ssi) {
    final ArrayList<PortInstance> result = CollectionLiterals.<PortInstance>newArrayList();
    SubSystemClass _subSystemClass = ssi.getSubSystemClass();
    EList<Annotation> _annotations = _subSystemClass.getAnnotations();
    boolean _isAnnotationPresent = BaseHelpers.isAnnotationPresent(_annotations, "DataLogging");
    if (_isAnnotationPresent) {
      this.logger.logInfo("Data Logging is configured by annotation");
      SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
      EList<Annotation> _annotations_1 = _subSystemClass_1.getAnnotations();
      final String filters = BaseHelpers.getAttribute(_annotations_1, "DataLogging", "pathlist");
      final String[] filterList = filters.split(",");
      for (final String filter : filterList) {
        String _plus = ("  filter: " + filter);
        this.logger.logInfo(_plus);
      }
      final ArrayList<String> notLogged = CollectionLiterals.<String>newArrayList();
      this.logger.logInfo("  logged ports:");
      TreeIterator<EObject> iter = ssi.eAllContents();
      boolean _hasNext = iter.hasNext();
      boolean _while = _hasNext;
      while (_while) {
        {
          final EObject obj = iter.next();
          if ((obj instanceof PortInstance)) {
            final PortInstance pi = ((PortInstance) obj);
            Port _port = pi.getPort();
            boolean _isRelay = RoomHelpers.isRelay(_port);
            boolean _not = (!_isRelay);
            if (_not) {
              ProtocolClass _protocol = pi.getProtocol();
              CommunicationType _commType = _protocol.getCommType();
              boolean _equals = Objects.equal(_commType, CommunicationType.DATA_DRIVEN);
              if (_equals) {
                Port _port_1 = pi.getPort();
                boolean _isConjugated = _port_1.isConjugated();
                if (_isConjugated) {
                  final String path = pi.getPath();
                  boolean matched = false;
                  boolean primitive = false;
                  for (final String filter_1 : filterList) {
                    boolean _matches = path.matches(filter_1);
                    if (_matches) {
                      matched = true;
                      ProtocolClass _protocol_1 = pi.getProtocol();
                      EList<Message> _incomingMessages = _protocol_1.getIncomingMessages();
                      final Function1<Message,Boolean> _function = new Function1<Message,Boolean>() {
                        public Boolean apply(final Message m) {
                          boolean _and = false;
                          VarDecl _data = m.getData();
                          boolean _notEquals = (!Objects.equal(_data, null));
                          if (!_notEquals) {
                            _and = false;
                          } else {
                            VarDecl _data_1 = m.getData();
                            RefableType _refType = _data_1.getRefType();
                            DataType _type = _refType.getType();
                            boolean _isEnumerationOrPrimitive = NodeGen.this._typeHelpers.isEnumerationOrPrimitive(_type);
                            _and = (_notEquals && _isEnumerationOrPrimitive);
                          }
                          return Boolean.valueOf(_and);
                        }
                      };
                      Iterable<Message> _filter = IterableExtensions.<Message>filter(_incomingMessages, _function);
                      boolean _isEmpty = IterableExtensions.isEmpty(_filter);
                      boolean _not_1 = (!_isEmpty);
                      if (_not_1) {
                        result.add(pi);
                        primitive = true;
                        String _path = pi.getPath();
                        String _plus_1 = ("    data driven port " + _path);
                        String _plus_2 = (_plus_1 + " (matched ");
                        String _plus_3 = (_plus_2 + filter_1);
                        String _plus_4 = (_plus_3 + ")");
                        this.logger.logInfo(_plus_4);
                      }
                    }
                  }
                  boolean _not_2 = (!primitive);
                  if (_not_2) {
                    if (matched) {
                      String _path_1 = pi.getPath();
                      String _plus_5 = ("    data driven port " + _path_1);
                      String _plus_6 = (_plus_5 + " (matched but contains no primitive data)");
                      notLogged.add(_plus_6);
                    } else {
                      String _path_2 = pi.getPath();
                      String _plus_7 = ("    data driven port " + _path_2);
                      String _plus_8 = (_plus_7 + " (no match found)");
                      notLogged.add(_plus_8);
                    }
                  }
                } else {
                  String _path_3 = pi.getPath();
                  String _plus_9 = ("    data driven port " + _path_3);
                  String _plus_10 = (_plus_9 + " (receive port)");
                  notLogged.add(_plus_10);
                }
              }
            }
          }
        }
        boolean _hasNext_1 = iter.hasNext();
        _while = _hasNext_1;
      }
      this.logger.logInfo("  NOT logged ports:");
      for (final String nl : notLogged) {
        this.logger.logInfo(nl);
      }
    }
    return result;
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
