package org.eclipse.etrice.generator.c.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.etricegen.SubSystemInstance;
import org.eclipse.etrice.generator.extensions.RoomExtensions;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class SubSystemRunnerGen {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private RoomExtensions roomExt;
  
  public void doGenerate(final Root root) {
    EList<SubSystemInstance> _subSystemInstances = root.getSubSystemInstances();
    for (final SubSystemInstance sc : _subSystemInstances) {
      {
        SubSystemClass _subSystemClass = sc.getSubSystemClass();
        String _generationTargetPath = this.roomExt.getGenerationTargetPath(_subSystemClass);
        SubSystemClass _subSystemClass_1 = sc.getSubSystemClass();
        String _path = this.roomExt.getPath(_subSystemClass_1);
        String _operator_plus = StringExtensions.operator_plus(_generationTargetPath, _path);
        this.fileAccess.setOutputPath(_operator_plus);
        String _name = sc.getName();
        String _operator_plus_1 = StringExtensions.operator_plus(_name, "_Runner.c");
        SubSystemClass _subSystemClass_2 = sc.getSubSystemClass();
        StringConcatenation _generateSourceFile = this.generateSourceFile(root, sc, _subSystemClass_2);
        this.fileAccess.generateFile(_operator_plus_1, _generateSourceFile);
      }
    }
  }
  
  public StringConcatenation generateSourceFile(final Root root, final SubSystemInstance ssi, final SubSystemClass ssc) {
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
    String _name = ssi.getName();
    _builder.append(_name, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* it instantiates ");
    String _name_1 = ssi.getName();
    _builder.append(_name_1, " ");
    _builder.append(" and starts and ends the lifecycle");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("#include \"");
    String _name_2 = ssi.getName();
    _builder.append(_name_2, "");
    _builder.append(".h\"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include \"debugging/etLogger.h\"");
    _builder.newLine();
    _builder.append("#include \"debugging/etMSCLogger.h\"");
    _builder.newLine();
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
    _builder.append("int main(void) {");
    _builder.newLine();
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
    String _name_3 = ssi.getName();
    _builder.append(_name_3, "	");
    _builder.append("_init(); \t\t/* lifecycle init */");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _name_4 = ssi.getName();
    _builder.append(_name_4, "	");
    _builder.append("_start(); \t/* lifecycle start */");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* run Scheduler */");
    _builder.newLine();
    _builder.append("\t");
    String _name_5 = ssi.getName();
    _builder.append(_name_5, "	");
    _builder.append("_run();");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* shutdown sequence of lifecycle */");
    _builder.newLine();
    _builder.append("\t");
    String _name_6 = ssi.getName();
    _builder.append(_name_6, "	");
    _builder.append("_stop(); \t\t/* lifecycle stop */");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _name_7 = ssi.getName();
    _builder.append(_name_7, "	");
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
    _builder.append("return 0;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
}
