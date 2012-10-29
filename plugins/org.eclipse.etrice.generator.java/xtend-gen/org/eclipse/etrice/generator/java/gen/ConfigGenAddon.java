package org.eclipse.etrice.generator.java.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ConfigGenAddon {
  @Inject
  private JavaExtensions stdExt;
  
  @Inject
  private TypeHelpers typeHelpers;
  
  @Inject
  private ProcedureHelpers helpers;
  
  @Inject
  private IDataConfiguration dataConfigExt;
  
  @Inject
  private RoomExtensions _roomExtensions;
  
  public CharSequence genActorInstanceConfig(final ActorInstance ai) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ActorClass _actorClass = ai.getActorClass();
      EList<Attribute> _attributes = _actorClass.getAttributes();
      for(final Attribute a : _attributes) {
        String _path = ai.getPath();
        String _plus = (_path + "/");
        String _name = a.getName();
        String _plus_1 = (_plus + _name);
        CharSequence _applyInstanceConfig = this.applyInstanceConfig(ai, "inst", _plus_1, a);
        _builder.append(_applyInstanceConfig, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence applyInstanceConfig(final ActorInstance ai, final String invokes, final String instancePath, final Attribute a) {
    CharSequence _xblockexpression = null;
    {
      RefableType _refType = a.getRefType();
      DataType aType = _refType.getType();
      CharSequence _xifexpression = null;
      boolean _isPrimitive = this.typeHelpers.isPrimitive(aType);
      if (_isPrimitive) {
        CharSequence _xblockexpression_1 = null;
        {
          String value = this.dataConfigExt.getAttrInstanceConfigValue(ai, instancePath);
          CharSequence _xifexpression_1 = null;
          boolean _equals = Objects.equal(value, null);
          if (_equals) {
            StringConcatenation _builder = new StringConcatenation();
            _xifexpression_1 = _builder;
          } else {
            CharSequence _xifexpression_2 = null;
            boolean _or = false;
            int _size = a.getSize();
            boolean _equals_1 = (_size == 0);
            if (_equals_1) {
              _or = true;
            } else {
              boolean _isCharacterType = this.typeHelpers.isCharacterType(aType);
              _or = (_equals_1 || _isCharacterType);
            }
            if (_or) {
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append(invokes, "");
              _builder_1.append(".");
              String _name = a.getName();
              String _valueLiteral = this.stdExt.toValueLiteral(((PrimitiveType) aType), value);
              CharSequence _invokeSetter = this.helpers.invokeSetter(_name, null, _valueLiteral);
              _builder_1.append(_invokeSetter, "");
              _builder_1.append(";");
              _xifexpression_2 = _builder_1;
            } else {
              CharSequence _xifexpression_3 = null;
              int _size_1 = a.getSize();
              String[] _split = value.split(",");
              int _size_2 = ((List<String>)Conversions.doWrapArray(_split)).size();
              boolean _equals_2 = (_size_1 == _size_2);
              if (_equals_2) {
                CharSequence _xblockexpression_2 = null;
                {
                  StringConcatenation _builder_2 = new StringConcatenation();
                  {
                    String[] _split_1 = value.split(",");
                    boolean _hasElements = false;
                    for(final String s : _split_1) {
                      if (!_hasElements) {
                        _hasElements = true;
                      } else {
                        _builder_2.appendImmediate(",", "");
                      }
                      String _trim = s.trim();
                      String _valueLiteral_1 = this.stdExt.toValueLiteral(((PrimitiveType) aType), _trim);
                      _builder_2.append(_valueLiteral_1, "");
                    }
                  }
                  CharSequence arrayExpr = _builder_2;
                  StringConcatenation _builder_3 = new StringConcatenation();
                  _builder_3.append(invokes, "");
                  _builder_3.append(".");
                  String _name_1 = a.getName();
                  StringConcatenation _builder_4 = new StringConcatenation();
                  _builder_4.append("new ");
                  String _typeName = this.typeHelpers.typeName(aType);
                  _builder_4.append(_typeName, "");
                  _builder_4.append("[]");
                  _builder_4.append(arrayExpr, "");
                  String _string = _builder_4.toString();
                  CharSequence _invokeSetter_1 = this.helpers.invokeSetter(_name_1, null, _string);
                  _builder_3.append(_invokeSetter_1, "");
                  _xblockexpression_2 = (_builder_3);
                }
                _xifexpression_3 = _xblockexpression_2;
              } else {
                StringConcatenation _builder_2 = new StringConcatenation();
                _builder_2.append("{");
                _builder_2.newLine();
                _builder_2.append("\t\t\t\t\t\t");
                String _typeName = this.typeHelpers.typeName(aType);
                _builder_2.append(_typeName, "						");
                _builder_2.append("[] array = ");
                _builder_2.append(invokes, "						");
                _builder_2.append(".");
                String _name_1 = a.getName();
                CharSequence _invokeGetter = this.helpers.invokeGetter(_name_1, null);
                _builder_2.append(_invokeGetter, "						");
                _builder_2.append(";");
                _builder_2.newLineIfNotEmpty();
                _builder_2.append("\t\t\t\t\t\t");
                _builder_2.append("for (int i=0;i<");
                int _size_3 = a.getSize();
                _builder_2.append(_size_3, "						");
                _builder_2.append(";i++){");
                _builder_2.newLineIfNotEmpty();
                _builder_2.append("\t\t\t\t\t\t\t");
                _builder_2.append("array[i] = ");
                String _valueLiteral_1 = this.stdExt.toValueLiteral(((PrimitiveType) aType), value);
                _builder_2.append(_valueLiteral_1, "							");
                _builder_2.append(";");
                _builder_2.newLineIfNotEmpty();
                _builder_2.append("\t\t\t\t\t");
                _builder_2.append("}");
                _xifexpression_3 = _builder_2;
              }
              _xifexpression_2 = _xifexpression_3;
            }
            _xifexpression_1 = _xifexpression_2;
          }
          _xblockexpression_1 = (_xifexpression_1);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        CharSequence _xifexpression_1 = null;
        boolean _isDataClass = this.typeHelpers.isDataClass(aType);
        if (_isDataClass) {
          StringConcatenation _builder = new StringConcatenation();
          {
            EList<Attribute> _attributes = ((DataClass) aType).getAttributes();
            for(final Attribute e : _attributes) {
              _builder.newLineIfNotEmpty();
              String _plus = (invokes + ".");
              String _name = a.getName();
              CharSequence _invokeGetter = this.helpers.invokeGetter(_name, null);
              String _plus_1 = (_plus + _invokeGetter);
              String _plus_2 = (instancePath + "/");
              String _name_1 = e.getName();
              String _plus_3 = (_plus_2 + _name_1);
              CharSequence _applyInstanceConfig = this.applyInstanceConfig(ai, _plus_1, _plus_3, e);
              _builder.append(_applyInstanceConfig, "");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t\t");
            }
          }
          _xifexpression_1 = _builder;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public Object genDynConfigGetterSetter(final ActorClass ac) {
    return null;
  }
  
  public CharSequence genMinMaxConstants(final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Attribute> _attributes = ac.getAttributes();
      for(final Attribute a : _attributes) {
        String _name = a.getName();
        ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
        List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
        CharSequence _genMinMaxConstantsRec = this.genMinMaxConstantsRec(ac, _name, _union);
        _builder.append(_genMinMaxConstantsRec, "");
        _builder.newLineIfNotEmpty();
      }
    }
    CharSequence result = _builder;
    int _length = result.length();
    boolean _notEquals = (_length != 0);
    if (_notEquals) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("//--------------------- Attribute Specifications");
      String _plus = (result + _builder_1.toString());
      result = _plus;
    }
    return result;
  }
  
  private CharSequence genMinMaxConstantsRec(final ActorClass ac, final String varNamePath, final List<Attribute> path) {
    CharSequence _xblockexpression = null;
    {
      String temp = ((String) null);
      CharSequence _xifexpression = null;
      Attribute _last = IterableExtensions.<Attribute>last(path);
      RefableType _refType = _last.getRefType();
      DataType _type = _refType.getType();
      boolean _isDataClass = this.typeHelpers.isDataClass(_type);
      if (_isDataClass) {
        StringConcatenation _builder = new StringConcatenation();
        {
          Attribute _last_1 = IterableExtensions.<Attribute>last(path);
          RefableType _refType_1 = _last_1.getRefType();
          DataType _type_1 = _refType_1.getType();
          List<Attribute> _allAttributes = this._roomExtensions.getAllAttributes(((DataClass) _type_1));
          for(final Attribute e : _allAttributes) {
            String _plus = (varNamePath + "_");
            String _name = e.getName();
            String _plus_1 = (_plus + _name);
            List<Attribute> _union = this._roomExtensions.<Attribute>union(path, e);
            CharSequence _genMinMaxConstantsRec = this.genMinMaxConstantsRec(ac, _plus_1, _union);
            _builder.append(_genMinMaxConstantsRec, "");
            _builder.newLineIfNotEmpty();
          }
        }
        _xifexpression = _builder;
      } else {
        CharSequence _xblockexpression_1 = null;
        {
          Attribute _last_2 = IterableExtensions.<Attribute>last(path);
          RefableType _refType_2 = _last_2.getRefType();
          DataType _type_2 = _refType_2.getType();
          PrimitiveType aType = ((PrimitiveType) _type_2);
          StringConcatenation _builder_1 = new StringConcatenation();
          {
            String _attrClassConfigMinValue = this.dataConfigExt.getAttrClassConfigMinValue(ac, path);
            String _temp = temp = _attrClassConfigMinValue;
            boolean _notEquals = (!Objects.equal(_temp, null));
            if (_notEquals) {
              _builder_1.append("public static ");
              String _minMaxType = this.getMinMaxType(aType);
              _builder_1.append(_minMaxType, "");
              _builder_1.append(" MIN_");
              _builder_1.append(varNamePath, "");
              _builder_1.append(" = ");
              String _valueLiteral = this.stdExt.toValueLiteral(aType, temp);
              _builder_1.append(_valueLiteral, "");
              _builder_1.append(";");
              _builder_1.newLineIfNotEmpty();
            }
          }
          {
            String _attrClassConfigMaxValue = this.dataConfigExt.getAttrClassConfigMaxValue(ac, path);
            String _temp_1 = temp = _attrClassConfigMaxValue;
            boolean _notEquals_1 = (!Objects.equal(_temp_1, null));
            if (_notEquals_1) {
              _builder_1.append("public static ");
              String _minMaxType_1 = this.getMinMaxType(aType);
              _builder_1.append(_minMaxType_1, "");
              _builder_1.append(" MAX_");
              _builder_1.append(varNamePath, "");
              _builder_1.append(" = ");
              String _valueLiteral_1 = this.stdExt.toValueLiteral(aType, temp);
              _builder_1.append(_valueLiteral_1, "");
              _builder_1.append(";");
              _builder_1.newLineIfNotEmpty();
            }
          }
          _xblockexpression_1 = (_builder_1);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  private String getMinMaxType(final PrimitiveType type) {
    String _switchResult = null;
    String _typeName = this.typeHelpers.typeName(type);
    final String _switchValue = _typeName;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,"byte")) {
        _matched=true;
        _switchResult = "int";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"short")) {
        _matched=true;
        _switchResult = "int";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"float")) {
        _matched=true;
        _switchResult = "double";
      }
    }
    if (!_matched) {
      String _typeName_1 = this.typeHelpers.typeName(type);
      _switchResult = _typeName_1;
    }
    return _switchResult;
  }
}
