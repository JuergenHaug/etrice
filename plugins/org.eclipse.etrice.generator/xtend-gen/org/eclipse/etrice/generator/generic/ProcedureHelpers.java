package org.eclipse.etrice.generator.generic;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class ProcedureHelpers {
  @Inject
  private ILanguageExtension languageExt;
  
  @Inject
  private TypeHelpers _typeHelpers;
  
  @Inject
  private ILogger logger;
  
  public StringConcatenation UserCode(final DetailCode dc) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(dc, null);
      if (_operator_notEquals) {
        _builder.append("//--------------------- begin user code");
        _builder.newLine();
        {
          EList<String> _commands = dc.getCommands();
          for(final String command : _commands) {
            _builder.append("\t");
            _builder.append(command, "");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("//--------------------- end user code");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  /**
   * TODO: add ref type
   */
  public StringConcatenation Attributes(final List<Attribute> attribs) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//--------------------- attributes");
    _builder.newLine();
    {
      for(final Attribute attribute : attribs) {
        {
          int _size = attribute.getSize();
          boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_size), ((Integer)0));
          if (_operator_equals) {
            String _accessLevelProtected = this.languageExt.accessLevelProtected();
            _builder.append(_accessLevelProtected, "");
            RefableType _refType = attribute.getRefType();
            DataType _type = _refType.getType();
            String _typeName = this._typeHelpers.typeName(_type);
            _builder.append(_typeName, "");
            _builder.append(" ");
            String _name = attribute.getName();
            _builder.append(_name, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          } else {
            String _accessLevelProtected_1 = this.languageExt.accessLevelProtected();
            _builder.append(_accessLevelProtected_1, "");
            RefableType _refType_1 = attribute.getRefType();
            DataType _type_1 = _refType_1.getType();
            String _typeName_1 = this._typeHelpers.typeName(_type_1);
            _builder.append(_typeName_1, "");
            _builder.append("[] ");
            String _name_1 = attribute.getName();
            _builder.append(_name_1, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public String arrayInitializer(final Attribute att) {
      String _xifexpression = null;
      String _defaultValueLiteral = att.getDefaultValueLiteral();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_defaultValueLiteral, null);
      if (_operator_notEquals) {
        String _defaultValueLiteral_1 = att.getDefaultValueLiteral();
        _xifexpression = _defaultValueLiteral_1;
      } else {
        RefableType _refType = att.getRefType();
        DataType _type = _refType.getType();
        String _defaultValue = this._typeHelpers.defaultValue(_type);
        _xifexpression = _defaultValue;
      }
      String dflt = _xifexpression;
      boolean _startsWith = dflt.startsWith("{");
      if (_startsWith) {
        {
          String[] _split = dflt.split(",");
          int _size = ((List<String>)Conversions.doWrapArray(_split)).size();
          int _size_1 = att.getSize();
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(((Integer)_size), ((Integer)_size_1));
          if (_operator_notEquals_1) {
            String _name = att.getName();
            String _operator_plus = StringExtensions.operator_plus("WARNING: array size determined by initializer differs from attribute size (", _name);
            String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "[");
            int _size_2 = att.getSize();
            String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, ((Integer)_size_2));
            String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, "] <-> ");
            String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, dflt);
            String _operator_plus_5 = StringExtensions.operator_plus(_operator_plus_4, ")");
            this.logger.logInfo(_operator_plus_5);
          }
          return dflt;
        }
      }
      String result = "{";
      int i = 0;
      int _size_3 = att.getSize();
      boolean _operator_lessThan = ComparableExtensions.<Integer>operator_lessThan(((Integer)i), ((Integer)_size_3));
      Boolean _xwhileexpression = _operator_lessThan;
      while (_xwhileexpression) {
        {
          String _operator_plus_6 = StringExtensions.operator_plus(result, dflt);
          result = _operator_plus_6;
          int _operator_plus_7 = IntegerExtensions.operator_plus(((Integer)i), ((Integer)1));
          i = _operator_plus_7;
          int _size_4 = att.getSize();
          boolean _operator_lessThan_1 = ComparableExtensions.<Integer>operator_lessThan(((Integer)i), ((Integer)_size_4));
          if (_operator_lessThan_1) {
            String _operator_plus_8 = StringExtensions.operator_plus(result, ", ");
            result = _operator_plus_8;
          }
        }
        int _size_5 = att.getSize();
        boolean _operator_lessThan_2 = ComparableExtensions.<Integer>operator_lessThan(((Integer)i), ((Integer)_size_5));
        _xwhileexpression = _operator_lessThan_2;
      }
      String _operator_plus_9 = StringExtensions.operator_plus(result, "}");
      return _operator_plus_9;
  }
  
  public StringConcatenation attributeInitialization(final List<Attribute> attribs) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// initialize attributes");
    _builder.newLine();
    {
      for(final Attribute a : attribs) {
        {
          String _defaultValueLiteral = a.getDefaultValueLiteral();
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_defaultValueLiteral, null);
          if (_operator_notEquals) {
            {
              int _size = a.getSize();
              boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_size), ((Integer)0));
              if (_operator_equals) {
                String _name = a.getName();
                _builder.append(_name, "");
                _builder.append(" = ");
                String _defaultValueLiteral_1 = a.getDefaultValueLiteral();
                _builder.append(_defaultValueLiteral_1, "");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                String _defaultValueLiteral_2 = a.getDefaultValueLiteral();
                boolean _startsWith = _defaultValueLiteral_2.startsWith("{");
                if (_startsWith) {
                  String _name_1 = a.getName();
                  _builder.append(_name_1, "");
                  _builder.append(" = new ");
                  RefableType _refType = a.getRefType();
                  DataType _type = _refType.getType();
                  String _typeName = this._typeHelpers.typeName(_type);
                  _builder.append(_typeName, "");
                  _builder.append("[] ");
                  String _defaultValueLiteral_3 = a.getDefaultValueLiteral();
                  _builder.append(_defaultValueLiteral_3, "");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                } else {
                  String _name_2 = a.getName();
                  _builder.append(_name_2, "");
                  _builder.append(" = new ");
                  RefableType _refType_1 = a.getRefType();
                  DataType _type_1 = _refType_1.getType();
                  String _typeName_1 = this._typeHelpers.typeName(_type_1);
                  _builder.append(_typeName_1, "");
                  _builder.append("[");
                  int _size_1 = a.getSize();
                  _builder.append(_size_1, "");
                  _builder.append("];");
                  _builder.newLineIfNotEmpty();
                  _builder.append("for (int i=0;i<");
                  int _size_2 = a.getSize();
                  _builder.append(_size_2, "");
                  _builder.append(";i++){");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  String _name_3 = a.getName();
                  _builder.append(_name_3, "	");
                  _builder.append("[i] = ");
                  String _defaultValueLiteral_4 = a.getDefaultValueLiteral();
                  _builder.append(_defaultValueLiteral_4, "	");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          } else {
            {
              int _size_3 = a.getSize();
              boolean _operator_equals_1 = ObjectExtensions.operator_equals(((Integer)_size_3), ((Integer)0));
              if (_operator_equals_1) {
                String _name_4 = a.getName();
                _builder.append(_name_4, "");
                _builder.append(" = ");
                RefableType _refType_2 = a.getRefType();
                DataType _type_2 = _refType_2.getType();
                String _defaultValue = this._typeHelpers.defaultValue(_type_2);
                _builder.append(_defaultValue, "");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                String _name_5 = a.getName();
                _builder.append(_name_5, "");
                _builder.append(" = new ");
                RefableType _refType_3 = a.getRefType();
                DataType _type_3 = _refType_3.getType();
                String _typeName_2 = this._typeHelpers.typeName(_type_3);
                _builder.append(_typeName_2, "");
                _builder.append("[");
                int _size_4 = a.getSize();
                _builder.append(_size_4, "");
                _builder.append("];");
                _builder.newLineIfNotEmpty();
                _builder.append("for (int i=0;i<");
                int _size_5 = a.getSize();
                _builder.append(_size_5, "");
                _builder.append(";i++){");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                String _name_6 = a.getName();
                _builder.append(_name_6, "	");
                _builder.append("[i] = ");
                RefableType _refType_4 = a.getRefType();
                DataType _type_4 = _refType_4.getType();
                String _defaultValue_1 = this._typeHelpers.defaultValue(_type_4);
                _builder.append(_defaultValue_1, "	");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public StringConcatenation AttributeSettersGettersDeclaration(final List<Attribute> attribs, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//--------------------- attribute setters and getters");
    _builder.newLine();
    {
      for(final Attribute attribute : attribs) {
        StringConcatenation _SetterHeader = this.SetterHeader(attribute, classname);
        _builder.append(_SetterHeader, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        StringConcatenation _GetterHeader = this.GetterHeader(attribute, classname);
        _builder.append(_GetterHeader, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public StringConcatenation AttributeSettersGettersImplementation(final List<Attribute> attribs, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//--------------------- attribute setters and getters");
    _builder.newLine();
    {
      for(final Attribute attribute : attribs) {
        StringConcatenation _SetterHeader = this.SetterHeader(attribute, classname);
        _builder.append(_SetterHeader, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        String _memberAccess = this.languageExt.memberAccess();
        _builder.append(_memberAccess, "	 ");
        String _name = attribute.getName();
        _builder.append(_name, "	 ");
        _builder.append(" = ");
        String _name_1 = attribute.getName();
        _builder.append(_name_1, "	 ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        StringConcatenation _GetterHeader = this.GetterHeader(attribute, classname);
        _builder.append(_GetterHeader, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("return ");
        String _memberAccess_1 = this.languageExt.memberAccess();
        _builder.append(_memberAccess_1, "	");
        String _name_2 = attribute.getName();
        _builder.append(_name_2, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private StringConcatenation SetterHeader(final Attribute attribute, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    _builder.append("void set");
    String _name = attribute.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append(" (");
    String _selfPointer = this.languageExt.selfPointer(classname, 1);
    _builder.append(_selfPointer, "");
    RefableType _refType = attribute.getRefType();
    DataType _type = _refType.getType();
    String _typeName = this._typeHelpers.typeName(_type);
    _builder.append(_typeName, "");
    {
      int _size = attribute.getSize();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(((Integer)_size), ((Integer)0));
      if (_operator_notEquals) {
        _builder.append("[]");
      }
    }
    _builder.append(" ");
    String _name_1 = attribute.getName();
    _builder.append(_name_1, "");
    _builder.append(")");
    return _builder;
  }
  
  private StringConcatenation GetterHeader(final Attribute attribute, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    RefableType _refType = attribute.getRefType();
    DataType _type = _refType.getType();
    String _typeName = this._typeHelpers.typeName(_type);
    _builder.append(_typeName, "");
    {
      int _size = attribute.getSize();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(((Integer)_size), ((Integer)0));
      if (_operator_notEquals) {
        _builder.append("[]");
      }
    }
    _builder.append(" get");
    String _name = attribute.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append(" (");
    String _selfPointer = this.languageExt.selfPointer(classname, 0);
    _builder.append(_selfPointer, "");
    _builder.append(")");
    return _builder;
  }
  
  public StringConcatenation argList(final List<Attribute> attributes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean hasAnyElements = false;
      for(final Attribute a : attributes) {
        if (!hasAnyElements) {
          hasAnyElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        RefableType _refType = a.getRefType();
        DataType _type = _refType.getType();
        String _typeName = this._typeHelpers.typeName(_type);
        _builder.append(_typeName, "");
        {
          int _size = a.getSize();
          boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_size), ((Integer)1));
          if (_operator_greaterThan) {
            _builder.append("[]");
          }
        }
        _builder.append(" ");
        String _name = a.getName();
        _builder.append(_name, "");
      }
    }
    return _builder;
  }
  
  public StringConcatenation OperationsDeclaration(final List<? extends Operation> operations, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//--------------------- operations");
    _builder.newLine();
    {
      for(final Operation operation : operations) {
        StringConcatenation _OperationSignature = this.OperationSignature(operation, classname, true);
        _builder.append(_OperationSignature, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public StringConcatenation OperationsImplementation(final List<? extends Operation> operations, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//--------------------- operations");
    _builder.newLine();
    {
      for(final Operation operation : operations) {
        StringConcatenation _OperationSignature = this.OperationSignature(operation, classname, false);
        _builder.append(_OperationSignature, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        {
          DetailCode _detailCode = operation.getDetailCode();
          EList<String> _commands = _detailCode.getCommands();
          for(final String command : _commands) {
            _builder.append("\t");
            _builder.append(command, "");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private StringConcatenation OperationSignature(final Operation operation, final String classname, final boolean isDeclaration) {
    String _name = operation.getName();
    EList<VarDecl> _arguments = operation.getArguments();
    StringConcatenation _BuildArgumentList = this.BuildArgumentList(_arguments);
    String _string = _BuildArgumentList.toString();
    RefableType _returntype = operation.getReturntype();
    String _DataTypeToString = this.DataTypeToString(_returntype);
    StringConcatenation _ClassOperationSignature = this.ClassOperationSignature(classname, _name, _string, _DataTypeToString, isDeclaration);
    return _ClassOperationSignature;
  }
  
  private String DataTypeToString(final RefableType type) {
    boolean _operator_equals = ObjectExtensions.operator_equals(type, null);
    if (_operator_equals) {
      return "void";
    } else {
      DataType _type = type.getType();
      String _typeName = this._typeHelpers.typeName(_type);
      return _typeName;
    }
  }
  
  /**
   * builds comma separated argument list as string from EList<VarDecl> arguments
   */
  private StringConcatenation BuildArgumentList(final EList<VarDecl> arguments) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean hasAnyElements = false;
      for(final VarDecl argument : arguments) {
        if (!hasAnyElements) {
          hasAnyElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        RefableType _refType = argument.getRefType();
        DataType _type = _refType.getType();
        String _typeName = this._typeHelpers.typeName(_type);
        _builder.append(_typeName, "");
        _builder.append(" ");
        String _name = argument.getName();
        _builder.append(_name, "");
      }
    }
    return _builder;
  }
  
  public StringConcatenation ClassOperationSignature(final String classname, final String operationname, final String argumentList, final String returnType, final boolean isDeclaration) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    {
      boolean _operator_equals = ObjectExtensions.operator_equals(returnType, "");
      if (_operator_equals) {
        _builder.append("void");
      } else {
        _builder.append(returnType, "");
      }
    }
    _builder.append(" ");
    String _operationScope = this.languageExt.operationScope(classname, isDeclaration);
    _builder.append(_operationScope, "");
    _builder.append(operationname, "");
    _builder.append("(");
    int _length = argumentList.length();
    String _selfPointer = this.languageExt.selfPointer(classname, _length);
    _builder.append(_selfPointer, "");
    _builder.append(argumentList, "");
    _builder.append(")");
    return _builder;
  }
}
