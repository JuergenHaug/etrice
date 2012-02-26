package org.eclipse.etrice.generator.c.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.c.gen.CExtensions;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.extensions.RoomExtensions;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class DataClassGen {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private CExtensions stdExt;
  
  @Inject
  private RoomExtensions roomExt;
  
  @Inject
  private ProcedureHelpers helpers;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<DataClass> _usedDataClasses = root.getUsedDataClasses();
    for (final DataClass dc : _usedDataClasses) {
      {
        String _generationTargetPath = this.roomExt.getGenerationTargetPath(dc);
        String _path = this.roomExt.getPath(dc);
        String _operator_plus = StringExtensions.operator_plus(_generationTargetPath, _path);
        String path = _operator_plus;
        String _cHeaderFileName = this.stdExt.getCHeaderFileName(dc);
        String _operator_plus_1 = StringExtensions.operator_plus("generating DataClass header \'", _cHeaderFileName);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "\' in \'");
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, path);
        String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "\'");
        this.logger.logInfo(_operator_plus_4);
        this.fileAccess.setOutputPath(path);
        String _cHeaderFileName_1 = this.stdExt.getCHeaderFileName(dc);
        StringConcatenation _generateHeaderFile = this.generateHeaderFile(root, dc);
        this.fileAccess.generateFile(_cHeaderFileName_1, _generateHeaderFile);
        String _cSourceFileName = this.stdExt.getCSourceFileName(dc);
        String _operator_plus_5 = StringExtensions.operator_plus("generating DataClass source \'", _cSourceFileName);
        String _operator_plus_6 = StringExtensions.operator_plus(_operator_plus_5, "\' in \'");
        String _operator_plus_7 = StringExtensions.operator_plus(_operator_plus_6, path);
        String _operator_plus_8 = StringExtensions.operator_plus(_operator_plus_7, "\'");
        this.logger.logInfo(_operator_plus_8);
        this.fileAccess.setOutputPath(path);
        String _cSourceFileName_1 = this.stdExt.getCSourceFileName(dc);
        StringConcatenation _generateSourceFile = this.generateSourceFile(root, dc);
        this.fileAccess.generateFile(_cSourceFileName_1, _generateSourceFile);
      }
    }
  }
  
  public StringConcatenation generateHeaderFile(final Root root, final DataClass dc) {
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
    _builder.append("* Header File of DataClass ");
    String _name = dc.getName();
    _builder.append(_name, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    String _name_1 = dc.getName();
    StringConcatenation _generateIncludeGuardBegin = this.stdExt.generateIncludeGuardBegin(_name_1);
    _builder.append(_generateIncludeGuardBegin, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include \"etDatatypes.h\"");
    _builder.newLine();
    _builder.newLine();
    {
      HashSet<DataClass> _referencedDataClasses = root.getReferencedDataClasses(dc);
      for(final DataClass dataClass : _referencedDataClasses) {
        _builder.append("#include \"");
        String _name_2 = dataClass.getName();
        _builder.append(_name_2, "");
        _builder.append(".h\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    DetailCode _userCode1 = dc.getUserCode1();
    StringConcatenation _userCode = this.helpers.userCode(_userCode1);
    _builder.append(_userCode, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("typedef struct {");
    _builder.newLine();
    _builder.append("\t");
    List<Attribute> _allAttributes = this.roomExt.getAllAttributes(dc);
    StringConcatenation _attributes = this.helpers.attributes(_allAttributes);
    _builder.append(_attributes, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("} ");
    String _name_3 = dc.getName();
    _builder.append(_name_3, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    EList<StandardOperation> _operations = dc.getOperations();
    String _name_4 = dc.getName();
    StringConcatenation _operationsDeclaration = this.helpers.operationsDeclaration(_operations, _name_4);
    _builder.append(_operationsDeclaration, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/* deep copy */");
    _builder.newLine();
    _builder.append("void ");
    String _name_5 = dc.getName();
    _builder.append(_name_5, "");
    _builder.append("_deepCopy(");
    String _name_6 = dc.getName();
    _builder.append(_name_6, "");
    _builder.append("* source, ");
    String _name_7 = dc.getName();
    _builder.append(_name_7, "");
    _builder.append("* target);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    DetailCode _userCode2 = dc.getUserCode2();
    StringConcatenation _userCode_1 = this.helpers.userCode(_userCode2);
    _builder.append(_userCode_1, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _name_8 = dc.getName();
    StringConcatenation _generateIncludeGuardEnd = this.stdExt.generateIncludeGuardEnd(_name_8);
    _builder.append(_generateIncludeGuardEnd, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generateSourceFile(final Root root, final DataClass dc) {
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
    _builder.append("* Source File of DataClass ");
    String _name = dc.getName();
    _builder.append(_name, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#include \"");
    String _cHeaderFileName = this.stdExt.getCHeaderFileName(dc);
    _builder.append(_cHeaderFileName, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include <string.h>");
    _builder.newLine();
    _builder.newLine();
    DetailCode _userCode3 = dc.getUserCode3();
    StringConcatenation _userCode = this.helpers.userCode(_userCode3);
    _builder.append(_userCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    EList<StandardOperation> _operations = dc.getOperations();
    String _name_1 = dc.getName();
    StringConcatenation _operationsImplementation = this.helpers.operationsImplementation(_operations, _name_1);
    _builder.append(_operationsImplementation, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// deep copy");
    _builder.newLine();
    _builder.append("void ");
    String _name_2 = dc.getName();
    _builder.append(_name_2, "");
    _builder.append("_deepCopy(");
    String _name_3 = dc.getName();
    _builder.append(_name_3, "");
    _builder.append("* source, ");
    String _name_4 = dc.getName();
    _builder.append(_name_4, "");
    _builder.append("* target) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("memcpy(target, source, sizeof(");
    String _name_5 = dc.getName();
    _builder.append(_name_5, "	");
    _builder.append("));");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
}
