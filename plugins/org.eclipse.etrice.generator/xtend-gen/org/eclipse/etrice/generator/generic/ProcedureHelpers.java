package org.eclipse.etrice.generator.generic;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ComplexType;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.generic.ConfigExtension;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@Singleton
@SuppressWarnings("all")
public class ProcedureHelpers {
  @Inject
  private ILanguageExtension languageExt;
  
  @Inject
  private ConfigExtension _configExtension;
  
  @Inject
  private TypeHelpers _typeHelpers;
  
  @Inject
  private ILogger logger;
  
  public CharSequence userCode(final DataClass dc, final int id) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(id,1)) {
        _matched=true;
        String _deepUserCode1 = RoomHelpers.getDeepUserCode1(dc);
        CharSequence _userCode = this.userCode(_deepUserCode1);
        _switchResult = _userCode;
      }
    }
    if (!_matched) {
      if (Objects.equal(id,2)) {
        _matched=true;
        String _deepUserCode2 = RoomHelpers.getDeepUserCode2(dc);
        CharSequence _userCode_1 = this.userCode(_deepUserCode2);
        _switchResult = _userCode_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(id,3)) {
        _matched=true;
        String _deepUserCode3 = RoomHelpers.getDeepUserCode3(dc);
        CharSequence _userCode_2 = this.userCode(_deepUserCode3);
        _switchResult = _userCode_2;
      }
    }
    return _switchResult;
  }
  
  public CharSequence userCode(final ProtocolClass pc, final int id) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(id,1)) {
        _matched=true;
        String _deepUserCode1 = RoomHelpers.getDeepUserCode1(pc);
        CharSequence _userCode = this.userCode(_deepUserCode1);
        _switchResult = _userCode;
      }
    }
    if (!_matched) {
      if (Objects.equal(id,2)) {
        _matched=true;
        String _deepUserCode2 = RoomHelpers.getDeepUserCode2(pc);
        CharSequence _userCode_1 = this.userCode(_deepUserCode2);
        _switchResult = _userCode_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(id,3)) {
        _matched=true;
        String _deepUserCode3 = RoomHelpers.getDeepUserCode3(pc);
        CharSequence _userCode_2 = this.userCode(_deepUserCode3);
        _switchResult = _userCode_2;
      }
    }
    return _switchResult;
  }
  
  public CharSequence userCode(final ActorContainerClass ac, final int id) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(id,1)) {
        _matched=true;
        String _deepUserCode1 = RoomHelpers.getDeepUserCode1(ac);
        CharSequence _userCode = this.userCode(_deepUserCode1);
        _switchResult = _userCode;
      }
    }
    if (!_matched) {
      if (Objects.equal(id,2)) {
        _matched=true;
        String _deepUserCode2 = RoomHelpers.getDeepUserCode2(ac);
        CharSequence _userCode_1 = this.userCode(_deepUserCode2);
        _switchResult = _userCode_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(id,3)) {
        _matched=true;
        String _deepUserCode3 = RoomHelpers.getDeepUserCode3(ac);
        CharSequence _userCode_2 = this.userCode(_deepUserCode3);
        _switchResult = _userCode_2;
      }
    }
    return _switchResult;
  }
  
  public CharSequence userCode(final DetailCode dc) {
    String _detailCode = RoomHelpers.getDetailCode(dc);
    CharSequence _userCode = this.userCode(_detailCode);
    return _userCode;
  }
  
  private CharSequence userCode(final String code) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(code, null));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _isEmpty = code.isEmpty();
        boolean _not = (!_isEmpty);
        _and = (_notEquals && _not);
      }
      if (_and) {
        _builder.append("/*--------------------- begin user code ---------------------*/");
        _builder.newLine();
        _builder.append(code, "");
        _builder.newLineIfNotEmpty();
        _builder.append("/*--------------------- end user code ---------------------*/");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  /**
   * TODO: add ref type
   */
  public CharSequence attributes(final List<Attribute> attribs) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*--------------------- attributes ---------------------*/");
    _builder.newLine();
    {
      for(final Attribute attribute : attribs) {
        CharSequence _attributeDeclaration = this.attributeDeclaration(attribute);
        _builder.append(_attributeDeclaration, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence attributeDeclaration(final Attribute attribute) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = attribute.getSize();
      boolean _equals = (_size == 0);
      if (_equals) {
        RefableType _refType = attribute.getRefType();
        DataType _type = _refType.getType();
        String _typeName = this._typeHelpers.typeName(_type);
        _builder.append(_typeName, "");
        {
          RefableType _refType_1 = attribute.getRefType();
          boolean _isRef = _refType_1.isRef();
          if (_isRef) {
            String _pointerLiteral = this.languageExt.pointerLiteral();
            _builder.append(_pointerLiteral, "");
          }
        }
        _builder.append(" ");
        String _name = attribute.getName();
        _builder.append(_name, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      } else {
        RefableType _refType_2 = attribute.getRefType();
        DataType _type_1 = _refType_2.getType();
        String _typeName_1 = this._typeHelpers.typeName(_type_1);
        int _size_1 = attribute.getSize();
        String _name_1 = attribute.getName();
        RefableType _refType_3 = attribute.getRefType();
        boolean _isRef_1 = _refType_3.isRef();
        String _arrayDeclaration = this.languageExt.arrayDeclaration(_typeName_1, _size_1, _name_1, _isRef_1);
        _builder.append(_arrayDeclaration, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public String arrayInitializer(final Attribute att) {
    String _xifexpression = null;
    String _defaultValueLiteral = att.getDefaultValueLiteral();
    boolean _notEquals = (!Objects.equal(_defaultValueLiteral, null));
    if (_notEquals) {
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
      String[] _split = dflt.split(",");
      int _size = ((List<String>)Conversions.doWrapArray(_split)).size();
      int _size_1 = att.getSize();
      boolean _notEquals_1 = (_size != _size_1);
      if (_notEquals_1) {
        String _name = att.getName();
        String _plus = ("WARNING: array size determined by initializer differs from attribute size (" + _name);
        String _plus_1 = (_plus + "[");
        int _size_2 = att.getSize();
        String _plus_2 = (_plus_1 + Integer.valueOf(_size_2));
        String _plus_3 = (_plus_2 + "] <-> ");
        String _plus_4 = (_plus_3 + dflt);
        String _plus_5 = (_plus_4 + ")");
        this.logger.logInfo(_plus_5);
      }
      return dflt;
    }
    String result = "{";
    int i = 0;
    int _size_3 = att.getSize();
    boolean _lessThan = (i < _size_3);
    boolean _while = _lessThan;
    while (_while) {
      {
        String _plus_6 = (result + dflt);
        result = _plus_6;
        int _plus_7 = (i + 1);
        i = _plus_7;
        int _size_4 = att.getSize();
        boolean _lessThan_1 = (i < _size_4);
        if (_lessThan_1) {
          String _plus_8 = (result + ", ");
          result = _plus_8;
        }
      }
      int _size_4 = att.getSize();
      boolean _lessThan_1 = (i < _size_4);
      _while = _lessThan_1;
    }
    return (result + "}");
  }
  
  public CharSequence attributeInitialization(final List<Attribute> attribs, final boolean useClassDefaultsOnly) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// initialize attributes");
    _builder.newLine();
    {
      for(final Attribute a : attribs) {
        RefableType _refType = a.getRefType();
        DataType aType = _refType.getType();
        _builder.newLineIfNotEmpty();
        String value = this._configExtension.getInitValueLiteral(a);
        _builder.newLineIfNotEmpty();
        {
          boolean _notEquals = (!Objects.equal(value, null));
          if (_notEquals) {
            {
              boolean _or = false;
              int _size = a.getSize();
              boolean _equals = (_size == 0);
              if (_equals) {
                _or = true;
              } else {
                boolean _isCharacterType = this._typeHelpers.isCharacterType(aType);
                _or = (_equals || _isCharacterType);
              }
              if (_or) {
                String _name = a.getName();
                _builder.append(_name, "");
                _builder.append(" = ");
                _builder.append(value, "");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                boolean _startsWith = value.startsWith("{");
                if (_startsWith) {
                  String _name_1 = a.getName();
                  _builder.append(_name_1, "");
                  _builder.append(" = new ");
                  String _typeName = this._typeHelpers.typeName(aType);
                  _builder.append(_typeName, "");
                  _builder.append("[] ");
                  _builder.append(value, "");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                } else {
                  String _name_2 = a.getName();
                  _builder.append(_name_2, "");
                  _builder.append(" = new ");
                  String _typeName_1 = this._typeHelpers.typeName(aType);
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
                  _builder.append(value, "	");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          } else {
            boolean _or_1 = false;
            boolean _or_2 = false;
            if ((aType instanceof ComplexType)) {
              _or_2 = true;
            } else {
              int _size_3 = a.getSize();
              boolean _greaterThan = (_size_3 > 1);
              _or_2 = ((aType instanceof ComplexType) || _greaterThan);
            }
            if (_or_2) {
              _or_1 = true;
            } else {
              boolean _not = (!useClassDefaultsOnly);
              _or_1 = (_or_2 || _not);
            }
            if (_or_1) {
              {
                int _size_4 = a.getSize();
                boolean _equals_1 = (_size_4 == 0);
                if (_equals_1) {
                  {
                    RefableType _refType_1 = a.getRefType();
                    boolean _isRef = _refType_1.isRef();
                    if (_isRef) {
                      String _name_4 = a.getName();
                      _builder.append(_name_4, "");
                      _builder.append(" = ");
                      String _nullPointer = this.languageExt.nullPointer();
                      _builder.append(_nullPointer, "");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                    } else {
                      String _name_5 = a.getName();
                      _builder.append(_name_5, "");
                      _builder.append(" = ");
                      String _defaultValue = this._typeHelpers.defaultValue(aType);
                      _builder.append(_defaultValue, "");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                } else {
                  String _name_6 = a.getName();
                  _builder.append(_name_6, "");
                  _builder.append(" = new ");
                  String _typeName_2 = this._typeHelpers.typeName(aType);
                  _builder.append(_typeName_2, "");
                  _builder.append("[");
                  int _size_5 = a.getSize();
                  _builder.append(_size_5, "");
                  _builder.append("];");
                  _builder.newLineIfNotEmpty();
                  {
                    boolean _not_1 = (!useClassDefaultsOnly);
                    if (_not_1) {
                      _builder.append("for (int i=0;i<");
                      int _size_6 = a.getSize();
                      _builder.append(_size_6, "");
                      _builder.append(";i++){");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      String _name_7 = a.getName();
                      _builder.append(_name_7, "	");
                      _builder.append("[i] = ");
                      {
                        RefableType _refType_2 = a.getRefType();
                        boolean _isRef_1 = _refType_2.isRef();
                        if (_isRef_1) {
                          String _nullPointer_1 = this.languageExt.nullPointer();
                          _builder.append(_nullPointer_1, "	");
                        } else {
                          String _defaultValue_1 = this._typeHelpers.defaultValue(aType);
                          _builder.append(_defaultValue_1, "	");
                        }
                      }
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
        }
      }
    }
    return _builder;
  }
  
  public CharSequence attributeSettersGettersDeclaration(final List<Attribute> attribs, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//--------------------- attribute setters and getters");
    _builder.newLine();
    {
      for(final Attribute attribute : attribs) {
        CharSequence _setterHeader = this.setterHeader(attribute, classname);
        _builder.append(_setterHeader, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        CharSequence _terHeader = this.getterHeader(attribute, classname);
        _builder.append(_terHeader, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence attributeSettersGettersImplementation(final List<Attribute> attribs, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//--------------------- attribute setters and getters");
    _builder.newLine();
    {
      for(final Attribute attribute : attribs) {
        CharSequence _setterHeader = this.setterHeader(attribute, classname);
        _builder.append(_setterHeader, "");
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
        CharSequence _terHeader = this.getterHeader(attribute, classname);
        _builder.append(_terHeader, "");
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
  
  private CharSequence setterHeader(final Attribute attribute, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    _builder.append("void set");
    String _name = attribute.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append(" (");
    String _selfPointer = this.languageExt.selfPointer(classname, true);
    _builder.append(_selfPointer, "");
    RefableType _refType = attribute.getRefType();
    DataType _type = _refType.getType();
    String _typeName = this._typeHelpers.typeName(_type);
    _builder.append(_typeName, "");
    {
      int _size = attribute.getSize();
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        _builder.append("[]");
      }
    }
    _builder.append(" ");
    String _name_1 = attribute.getName();
    _builder.append(_name_1, "");
    _builder.append(")");
    return _builder;
  }
  
  private CharSequence getterHeader(final Attribute attribute, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    RefableType _refType = attribute.getRefType();
    DataType _type = _refType.getType();
    String _typeName = this._typeHelpers.typeName(_type);
    _builder.append(_typeName, "");
    {
      int _size = attribute.getSize();
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        _builder.append("[]");
      }
    }
    _builder.append(" get");
    String _name = attribute.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append(" (");
    String _selfPointer = this.languageExt.selfPointer(classname, false);
    _builder.append(_selfPointer, "");
    _builder.append(")");
    return _builder;
  }
  
  public CharSequence argList(final List<Attribute> attributes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final Attribute a : attributes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        RefableType _refType = a.getRefType();
        DataType _type = _refType.getType();
        String _typeName = this._typeHelpers.typeName(_type);
        _builder.append(_typeName, "");
        {
          int _size = a.getSize();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
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
  
  public CharSequence getterImplementation(final String typeName, final String name, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    _builder.append(typeName, "");
    _builder.append(" get");
    String _firstUpper = StringExtensions.toFirstUpper(name);
    _builder.append(_firstUpper, "");
    _builder.append(" (");
    String _selfPointer = this.languageExt.selfPointer(classname, false);
    _builder.append(_selfPointer, "");
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return ");
    String _memberAccess = this.languageExt.memberAccess();
    _builder.append(_memberAccess, "	");
    _builder.append(name, "	");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder;
  }
  
  public CharSequence invokeGetter(final String name, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get");
    String _firstUpper = StringExtensions.toFirstUpper(name);
    _builder.append(_firstUpper, "");
    _builder.append("(");
    String _selfPointer = this.languageExt.selfPointer(classname, true);
    _builder.append(_selfPointer, "");
    _builder.append(")");
    return _builder;
  }
  
  public CharSequence invokeSetter(final String name, final String classname, final String value) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("set");
    String _firstUpper = StringExtensions.toFirstUpper(name);
    _builder.append(_firstUpper, "");
    _builder.append("(");
    String _selfPointer = this.languageExt.selfPointer(classname, true);
    _builder.append(_selfPointer, "");
    _builder.append(value, "");
    _builder.append(")");
    return _builder;
  }
  
  public CharSequence operationsDeclaration(final List<? extends Operation> operations, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*--------------------- operations ---------------------*/");
    _builder.newLine();
    {
      for(final Operation operation : operations) {
        {
          boolean _and = false;
          boolean _usesInheritance = this.languageExt.usesInheritance();
          if (!_usesInheritance) {
            _and = false;
          } else {
            boolean _isConstructor = RoomHelpers.isConstructor(operation);
            _and = (_usesInheritance && _isConstructor);
          }
          boolean _not = (!_and);
          if (_not) {
            CharSequence _operationSignature = this.operationSignature(operation, classname, true);
            _builder.append(_operationSignature, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence operationsImplementation(final List<? extends Operation> operations, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*--------------------- operations ---------------------*/");
    _builder.newLine();
    {
      for(final Operation operation : operations) {
        {
          boolean _and = false;
          boolean _usesInheritance = this.languageExt.usesInheritance();
          if (!_usesInheritance) {
            _and = false;
          } else {
            boolean _isConstructor = RoomHelpers.isConstructor(operation);
            _and = (_usesInheritance && _isConstructor);
          }
          boolean _not = (!_and);
          if (_not) {
            CharSequence _operationSignature = this.operationSignature(operation, classname, false);
            _builder.append(_operationSignature, "");
            _builder.append(" {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            AbstractGenerator _instance = AbstractGenerator.getInstance();
            DetailCode _detailCode = operation.getDetailCode();
            String _translatedCode = _instance.getTranslatedCode(_detailCode);
            _builder.append(_translatedCode, "	");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence operationsImplementation(final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*--------------------- operations ---------------------*/");
    _builder.newLine();
    {
      EList<StandardOperation> _operations = ac.getOperations();
      for(final StandardOperation operation : _operations) {
        {
          boolean _and = false;
          boolean _usesInheritance = this.languageExt.usesInheritance();
          if (!_usesInheritance) {
            _and = false;
          } else {
            boolean _isConstructor = RoomHelpers.isConstructor(operation);
            _and = (_usesInheritance && _isConstructor);
          }
          boolean _not = (!_and);
          if (_not) {
            String _name = ac.getName();
            CharSequence _operationSignature = this.operationSignature(operation, _name, false);
            _builder.append(_operationSignature, "");
            _builder.append(" {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            AbstractGenerator _instance = AbstractGenerator.getInstance();
            DetailCode _detailCode = operation.getDetailCode();
            String _translatedCode = _instance.getTranslatedCode(_detailCode);
            _builder.append(_translatedCode, "	");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  private CharSequence operationSignature(final Operation operation, final String classname, final boolean isDeclaration) {
    CharSequence _xifexpression = null;
    boolean _isConstructor = RoomHelpers.isConstructor(operation);
    if (_isConstructor) {
      String _constructorName = this.languageExt.constructorName(classname);
      String _constructorReturnType = this.languageExt.constructorReturnType();
      CharSequence _classOperationSignature = this.classOperationSignature(classname, _constructorName, "", _constructorReturnType, isDeclaration);
      _xifexpression = _classOperationSignature;
    } else {
      CharSequence _xifexpression_1 = null;
      boolean _isDestructor = RoomHelpers.isDestructor(operation);
      if (_isDestructor) {
        String _destructorName = this.languageExt.destructorName(classname);
        String _destructorReturnType = this.languageExt.destructorReturnType();
        CharSequence _classOperationSignature_1 = this.classOperationSignature(classname, _destructorName, "", _destructorReturnType, isDeclaration);
        _xifexpression_1 = _classOperationSignature_1;
      } else {
        String _name = operation.getName();
        EList<VarDecl> _arguments = operation.getArguments();
        CharSequence _BuildArgumentList = this.BuildArgumentList(_arguments);
        String _string = _BuildArgumentList.toString();
        RefableType _returntype = operation.getReturntype();
        String _dataTypeToString = this.dataTypeToString(_returntype);
        CharSequence _classOperationSignature_2 = this.classOperationSignature(classname, _name, _string, _dataTypeToString, isDeclaration);
        _xifexpression_1 = _classOperationSignature_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  private String dataTypeToString(final RefableType type) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(type, null);
    if (_equals) {
      _xifexpression = "void";
    } else {
      String _xifexpression_1 = null;
      boolean _isRef = type.isRef();
      if (_isRef) {
        DataType _type = type.getType();
        String _typeName = this._typeHelpers.typeName(_type);
        String _pointerLiteral = this.languageExt.pointerLiteral();
        String _plus = (_typeName + _pointerLiteral);
        _xifexpression_1 = _plus;
      } else {
        DataType _type_1 = type.getType();
        String _typeName_1 = this._typeHelpers.typeName(_type_1);
        _xifexpression_1 = _typeName_1;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  /**
   * builds comma separated argument list as string from EList<VarDecl> arguments
   */
  private CharSequence BuildArgumentList(final EList<VarDecl> arguments) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final VarDecl argument : arguments) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        RefableType _refType = argument.getRefType();
        DataType _type = _refType.getType();
        String _typeName = this._typeHelpers.typeName(_type);
        _builder.append(_typeName, "");
        {
          RefableType _refType_1 = argument.getRefType();
          boolean _isRef = _refType_1.isRef();
          if (_isRef) {
            String _pointerLiteral = this.languageExt.pointerLiteral();
            _builder.append(_pointerLiteral, "");
          }
        }
        _builder.append(" ");
        String _name = argument.getName();
        _builder.append(_name, "");
      }
    }
    return _builder;
  }
  
  private CharSequence classOperationSignature(final String classname, final String operationname, final String argumentList, final String returnType, final boolean isDeclaration) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    _builder.append(returnType, "");
    _builder.append(" ");
    String _memberInDeclaration = this.languageExt.memberInDeclaration(classname, operationname);
    _builder.append(_memberInDeclaration, "");
    _builder.append("(");
    boolean _isEmpty = argumentList.isEmpty();
    boolean _not = (!_isEmpty);
    String _selfPointer = this.languageExt.selfPointer(classname, _not);
    _builder.append(_selfPointer, "");
    _builder.append(argumentList, "");
    _builder.append(")");
    return _builder;
  }
}
