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

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SystemInstance;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@Singleton
@SuppressWarnings("all")
public class SubSystemRunnerGen {
  @Inject
  private IGeneratorFileIo fileIO;
  
  @Inject
  @Extension
  private RoomExtensions roomExt;
  
  public void doGenerate(final Root root) {
    EList<SubSystemInstance> _subSystemInstances = root.getSubSystemInstances();
    for (final SubSystemInstance sc : _subSystemInstances) {
      {
        SubSystemClass _subSystemClass = sc.getSubSystemClass();
        String _generationTargetPath = this.roomExt.getGenerationTargetPath(_subSystemClass);
        SubSystemClass _subSystemClass_1 = sc.getSubSystemClass();
        String _path = this.roomExt.getPath(_subSystemClass_1);
        final String path = (_generationTargetPath + _path);
        SubSystemClass _subSystemClass_2 = sc.getSubSystemClass();
        String _generationInfoPath = this.roomExt.getGenerationInfoPath(_subSystemClass_2);
        SubSystemClass _subSystemClass_3 = sc.getSubSystemClass();
        String _path_1 = this.roomExt.getPath(_subSystemClass_3);
        final String infopath = (_generationInfoPath + _path_1);
        SubSystemClass _subSystemClass_4 = sc.getSubSystemClass();
        String _name = _subSystemClass_4.getName();
        final String file = (_name + "Runner.java");
        CharSequence _generate = this.generate(root, sc);
        this.fileIO.generateFile("generating SubSystemRunner implementation", path, infopath, file, _generate);
      }
    }
  }
  
  public CharSequence generate(final Root root, final SubSystemInstance ssc) {
    CharSequence _xblockexpression = null;
    {
      final SubSystemClass cc = ssc.getSubSystemClass();
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
      _builder.append("* this class contains the main function running component ");
      String _name = ssc.getName();
      _builder.append(_name, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* it instantiates ");
      String _name_1 = ssc.getName();
      _builder.append(_name_1, " ");
      _builder.append(" and starts and ends the lifecycle");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.append("package ");
      String _package = this.roomExt.getPackage(cc);
      _builder.append(_package, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.RTSystem;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.SubSystemRunnerBase;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class ");
      String _name_2 = cc.getName();
      String _plus = (_name_2 + "Runner");
      _builder.append(_plus, "");
      _builder.append(" extends SubSystemRunnerBase {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("* main function");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("* creates the main component and starts and stops the lifecycle");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static void main(String[] args) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// instantiate the main component");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("RTSystem sys = ");
      {
        EObject _eContainer = ssc.eContainer();
        if ((_eContainer instanceof SystemInstance)) {
          _builder.append("new RTSystem(\"");
          EObject _eContainer_1 = ssc.eContainer();
          String _name_3 = ((SystemInstance) _eContainer_1).getName();
          _builder.append(_name_3, "		");
          _builder.append("\")");
        } else {
          _builder.append("null");
        }
      }
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      String _name_4 = cc.getName();
      _builder.append(_name_4, "		");
      _builder.append(" main_component = new ");
      String _name_5 = cc.getName();
      _builder.append(_name_5, "		");
      _builder.append("(sys, \"");
      String _name_6 = ssc.getName();
      _builder.append(_name_6, "		");
      _builder.append("\");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("run(main_component, args);");
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
}
