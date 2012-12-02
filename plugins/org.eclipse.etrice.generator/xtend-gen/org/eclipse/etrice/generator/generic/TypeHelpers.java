package org.eclipse.etrice.generator.generic;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.LiteralType;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.xtext.xbase.lib.Conversions;

@Singleton
@SuppressWarnings("all")
public class TypeHelpers {
  @Inject
  private ILanguageExtension languageExt;
  
  @Inject
  private IDataConfiguration dataConfigExt;
  
  public String typeName(final DataType type) {
    if ((type instanceof PrimitiveType)) {
      return ((PrimitiveType) type).getTargetName();
    } else {
      if ((type instanceof ExternalType)) {
        return ((ExternalType) type).getTargetName();
      } else {
        return type.getName();
      }
    }
  }
  
  public String defaultValue(final VarDecl a) {
    RefableType _refType = a.getRefType();
    DataType _type = _refType.getType();
    return this.languageExt.defaultValue(_type);
  }
  
  public String getArgumentList(final VarDecl data) {
    String[] _generateArglistAndTypedData = this.languageExt.generateArglistAndTypedData(data);
    String _get = ((List<String>)Conversions.doWrapArray(_generateArglistAndTypedData)).get(0);
    return _get;
  }
  
  public String getTypedDataDefinition(final VarDecl data) {
    String[] _generateArglistAndTypedData = this.languageExt.generateArglistAndTypedData(data);
    String _get = ((List<String>)Conversions.doWrapArray(_generateArglistAndTypedData)).get(1);
    return _get;
  }
  
  public String generateTypedArgumentList(final VarDecl data) {
    String[] _generateArglistAndTypedData = this.languageExt.generateArglistAndTypedData(data);
    String _get = ((List<String>)Conversions.doWrapArray(_generateArglistAndTypedData)).get(2);
    return _get;
  }
  
  public boolean isPrimitive(final DataType type) {
    return (type instanceof PrimitiveType);
  }
  
  public boolean isDataClass(final DataType type) {
    return (type instanceof DataClass);
  }
  
  public boolean isCharacterType(final PrimitiveType type) {
    LiteralType _type = type.getType();
    boolean _equals = Objects.equal(_type, LiteralType.CHAR);
    return _equals;
  }
  
  public boolean isCharacterType(final DataType type) {
    boolean _and = false;
    boolean _isPrimitive = this.isPrimitive(type);
    if (!_isPrimitive) {
      _and = false;
    } else {
      boolean _isCharacterType = this.isCharacterType(((PrimitiveType) type));
      _and = (_isPrimitive && _isCharacterType);
    }
    return _and;
  }
  
  public String getAttrInstanceConfigValue(final List<Attribute> attributePath, final InstanceBase instance) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (instance instanceof ActorInstance) {
        final ActorInstance _actorInstance = (ActorInstance)instance;
        _matched=true;
        String _attrInstanceConfigValue = this.dataConfigExt.getAttrInstanceConfigValue(_actorInstance, attributePath);
        _switchResult = _attrInstanceConfigValue;
      }
    }
    if (!_matched) {
      if (instance instanceof InterfaceItemInstance) {
        final InterfaceItemInstance _interfaceItemInstance = (InterfaceItemInstance)instance;
        _matched=true;
        String _attrInstanceConfigValue = this.dataConfigExt.getAttrInstanceConfigValue(_interfaceItemInstance, attributePath);
        _switchResult = _attrInstanceConfigValue;
      }
    }
    return _switchResult;
  }
  
  public String getAttrClassConfigValue(final List<Attribute> attributePath, final ActorClass actor, final boolean inherite) {
    String result = this.dataConfigExt.getAttrClassConfigValue(actor, attributePath);
    boolean _and = false;
    boolean _equals = Objects.equal(result, null);
    if (!_equals) {
      _and = false;
    } else {
      _and = (_equals && inherite);
    }
    if (_and) {
      ActorClass base = actor.getBase();
      boolean _and_1 = false;
      boolean _notEquals = (!Objects.equal(base, null));
      if (!_notEquals) {
        _and_1 = false;
      } else {
        boolean _equals_1 = Objects.equal(result, null);
        _and_1 = (_notEquals && _equals_1);
      }
      boolean _while = _and_1;
      while (_while) {
        {
          String _attrClassConfigValue = this.dataConfigExt.getAttrClassConfigValue(base, attributePath);
          result = _attrClassConfigValue;
          ActorClass _base = base.getBase();
          base = _base;
        }
        boolean _and_2 = false;
        boolean _notEquals_1 = (!Objects.equal(base, null));
        if (!_notEquals_1) {
          _and_2 = false;
        } else {
          boolean _equals_2 = Objects.equal(result, null);
          _and_2 = (_notEquals_1 && _equals_2);
        }
        _while = _and_2;
      }
    }
    return result;
  }
  
  public String getAttrClassConfigValue(final List<Attribute> attributePath, final PortClass port) {
    ProtocolClass pc = RoomHelpers.getProtocolClass(port);
    boolean _equals = Objects.equal(pc, null);
    if (_equals) {
      return null;
    }
    PortClass _regular = pc.getRegular();
    boolean _equals_1 = port.equals(_regular);
    return this.dataConfigExt.getAttrClassConfigValue(pc, _equals_1, attributePath);
  }
}
