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

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Collection;
import java.util.List;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.c.gen.CExtensions;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Extension;

@Singleton
@SuppressWarnings("all")
public class NodeRunnerGen {
  @Inject
  @Extension
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  @Extension
  private CExtensions _cExtensions;
  
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  public void doGenerate(final Root root) {
    boolean first = true;
    Collection<NodeRef> _nodeRefs = ETMapUtil.getNodeRefs();
    for (final NodeRef nr : _nodeRefs) {
      List<String> _subSystemInstancePaths = ETMapUtil.getSubSystemInstancePaths(nr);
      for (final String instpath : _subSystemInstancePaths) {
        {
          StructureInstance _instance = root.getInstance(instpath);
          final SubSystemInstance ssi = ((SubSystemInstance) _instance);
          String _name = nr.getName();
          String _plus = (_name + "_");
          String _name_1 = ssi.getName();
          final String clsname = (_plus + _name_1);
          SubSystemClass _subSystemClass = ssi.getSubSystemClass();
          String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(_subSystemClass);
          SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
          String _path = this._roomExtensions.getPath(_subSystemClass_1);
          String _plus_1 = (_generationTargetPath + _path);
          this.fileAccess.setOutputPath(_plus_1);
          String _plus_2 = (clsname + "_Runner.c");
          CharSequence _generateSourceFile = this.generateSourceFile(root, ssi, first);
          this.fileAccess.generateFile(_plus_2, _generateSourceFile);
          first = false;
        }
      }
    }
  }
  
  public CharSequence generateSourceFile(final Root root, final SubSystemInstance ssi, final boolean first) {
    CharSequence _xblockexpression = null;
    {
      final NodeRef nr = ETMapUtil.getNodeRef(ssi);
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
      _builder.append("* this class contains the main function running Node ");
      String _name_2 = nr.getName();
      _builder.append(_name_2, " ");
      _builder.append(" with SubSystem ");
      String _name_3 = ssi.getName();
      _builder.append(_name_3, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* it instantiates Node ");
      String _name_4 = nr.getName();
      _builder.append(_name_4, " ");
      _builder.append(" with SubSystem ");
      String _name_5 = ssi.getName();
      _builder.append(_name_5, " ");
      _builder.append(" and starts and ends the lifecycle");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*/");
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
      _builder.newLine();
      _builder.append("#include \"osal/etPlatformLifecycle.h\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* main function");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* creates component and starts and stops the lifecycle");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.append("int main(int argc, char** argv) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("etBool runAsTest = FALSE;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (argc>1 && strcmp(argv[1], \"-headless\")==0)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("runAsTest = TRUE;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (argc>1 && strcmp(argv[1], \"-run_as_test\")==0)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("runAsTest = TRUE;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("etUserEntry(); /* platform specific */");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("etLogger_logInfo(\"***   T H E   B E G I N   ***\");");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_OPEN(\"main\");");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* startup sequence  of lifecycle */");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(clsname, "	");
      _builder.append("_init(); \t\t/* lifecycle init */");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append(clsname, "	");
      _builder.append("_start(); \t/* lifecycle start */");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("etUserPreRun(); /* platform specific */");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* run Scheduler */");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(clsname, "	");
      _builder.append("_run(runAsTest);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("etUserPostRun(); /* platform specific */");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* shutdown sequence of lifecycle */");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(clsname, "	");
      _builder.append("_stop(); \t\t/* lifecycle stop */");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append(clsname, "	");
      _builder.append("_destroy(); \t/* lifecycle destroy */");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_CLOSE");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("etLogger_logInfo(\"***   T H E   E N D   ***\");");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("etUserExit(); /* platform specific */");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return 0;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}
