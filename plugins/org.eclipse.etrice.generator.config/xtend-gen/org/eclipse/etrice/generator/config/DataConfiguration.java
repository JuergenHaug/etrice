/**
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 */
package org.eclipse.etrice.generator.config;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.ConfigStandaloneSetup;
import org.eclipse.etrice.core.config.AttrClassConfig;
import org.eclipse.etrice.core.config.AttrInstanceConfig;
import org.eclipse.etrice.core.config.BooleanLiteral;
import org.eclipse.etrice.core.config.ConfigModel;
import org.eclipse.etrice.core.config.DynamicConfig;
import org.eclipse.etrice.core.config.Import;
import org.eclipse.etrice.core.config.IntLiteral;
import org.eclipse.etrice.core.config.Literal;
import org.eclipse.etrice.core.config.LiteralArray;
import org.eclipse.etrice.core.config.NumberLiteral;
import org.eclipse.etrice.core.config.RealLiteral;
import org.eclipse.etrice.core.config.StringLiteral;
import org.eclipse.etrice.core.config.SubSystemConfig;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.base.IResourceURIAcceptor;
import org.eclipse.etrice.generator.config.util.DataConfigurationHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DataConfiguration implements IDataConfiguration {
  @Inject
  protected ILogger logger;
  
  @Inject
  protected ImportUriResolver uriResolver;
  
  public void doSetup() {
    ConfigStandaloneSetup.doSetup();
  }
  
  public boolean setResources(final ResourceSet resource, final ILogger logger) {
    boolean _setConfigModels = DataConfigurationHelper.setConfigModels(resource, logger);
    return _setConfigModels;
  }
  
  public String getAttrClassConfigValue(final ActorClass actor, final List<Attribute> path) {
    AttrClassConfig _attrClassConfig = this.getAttrClassConfig(actor, path);
    LiteralArray _value = _attrClassConfig==null?(LiteralArray)null:_attrClassConfig.getValue();
    String _stringExpr = _value==null?(String)null:this.toStringExpr(_value);
    return _stringExpr;
  }
  
  public String getAttrClassConfigMaxValue(final ActorClass actor, final List<Attribute> path) {
    AttrClassConfig _attrClassConfig = this.getAttrClassConfig(actor, path);
    NumberLiteral _max = _attrClassConfig==null?(NumberLiteral)null:_attrClassConfig.getMax();
    String _stringExpr = _max==null?(String)null:this.toStringExpr(_max);
    return _stringExpr;
  }
  
  public String getAttrClassConfigMinValue(final ActorClass actor, final List<Attribute> path) {
    AttrClassConfig _attrClassConfig = this.getAttrClassConfig(actor, path);
    NumberLiteral _min = _attrClassConfig==null?(NumberLiteral)null:_attrClassConfig.getMin();
    String _stringExpr = _min==null?(String)null:this.toStringExpr(_min);
    return _stringExpr;
  }
  
  private AttrClassConfig getAttrClassConfig(final ActorClass actor, final List<Attribute> path) {
    AttrClassConfig _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/");
      String _name = actor.getName();
      _builder.append(_name, "");
      _builder.append("/");
      String _stringPath = this.toStringPath(path);
      _builder.append(_stringPath, "");
      String id = _builder.toString();
      AttrClassConfig _get = DataConfigurationHelper.actorClassAttrMap.get(id);
      _xblockexpression = (_get);
    }
    return _xblockexpression;
  }
  
  public String getAttrClassConfigValue(final ProtocolClass pc, final boolean regular, final List<Attribute> path) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/");
      String _name = pc.getName();
      _builder.append(_name, "");
      _builder.append("/");
      {
        if (regular) {
          _builder.append("regular");
        } else {
          _builder.append("conjugated");
        }
      }
      _builder.append("/");
      String _stringPath = this.toStringPath(path);
      _builder.append(_stringPath, "");
      String id = _builder.toString();
      AttrClassConfig _get = DataConfigurationHelper.protocolClassAttrMap.get(id);
      LiteralArray _value = _get==null?(LiteralArray)null:_get.getValue();
      String _stringExpr = _value==null?(String)null:this.toStringExpr(_value);
      _xblockexpression = (_stringExpr);
    }
    return _xblockexpression;
  }
  
  private String toStringPath(final List<Attribute> path) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final Attribute a : path) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("/", "");
        }
        String _name = a.getName();
        _builder.append(_name, "");
      }
    }
    String _string = _builder.toString();
    return _string;
  }
  
  public String getAttrInstanceConfigValue(final ActorInstance ai, final List<Attribute> path) {
    String _xblockexpression = null;
    {
      String _path = ai.getPath();
      String _plus = (_path + "/");
      String _stringPath = this.toStringPath(path);
      String id = (_plus + _stringPath);
      AttrInstanceConfig _get = DataConfigurationHelper.actorInstanceAttrMap.get(id);
      LiteralArray _value = _get==null?(LiteralArray)null:_get.getValue();
      String _stringExpr = _value==null?(String)null:this.toStringExpr(_value);
      _xblockexpression = (_stringExpr);
    }
    return _xblockexpression;
  }
  
  public String getAttrInstanceConfigValue(final InterfaceItemInstance item, final List<Attribute> path) {
    String _path = item.getPath();
    String _plus = (_path + "/");
    String _stringPath = this.toStringPath(path);
    String _plus_1 = (_plus + _stringPath);
    AttrInstanceConfig _get = DataConfigurationHelper.actorInstanceAttrMap.get(_plus_1);
    LiteralArray _value = _get==null?(LiteralArray)null:_get.getValue();
    String _stringExpr = _value==null?(String)null:this.toStringExpr(_value);
    return _stringExpr;
  }
  
  public int getPollingTimerUser(final SubSystemInstance subsystem) {
    int _xblockexpression = (int) 0;
    {
      SubSystemConfig _config = this.getConfig(subsystem);
      final DynamicConfig dynConf = _config==null?(DynamicConfig)null:_config.getDynConfig();
      int _xifexpression = (int) 0;
      boolean _equals = Objects.equal(dynConf, null);
      if (_equals) {
        _xifexpression = 0;
      } else {
        int _polling = dynConf.getPolling();
        _xifexpression = _polling;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String getUserCode1(final SubSystemInstance subsystem) {
    SubSystemConfig _config = this.getConfig(subsystem);
    DynamicConfig dynConfig = _config==null?(DynamicConfig)null:_config.getDynConfig();
    String _xifexpression = null;
    String _filePath = dynConfig==null?(String)null:dynConfig.getFilePath();
    boolean _notEquals = (!Objects.equal(_filePath, null));
    if (_notEquals) {
      _xifexpression = "import org.eclipse.etrice.runtime.java.config.ConfigSourceFile;";
    } else {
      String _userCode1 = dynConfig==null?(String)null:dynConfig.getUserCode1();
      _xifexpression = _userCode1;
    }
    return _xifexpression;
  }
  
  public String getUserCode2(final SubSystemInstance subsystem) {
    SubSystemConfig _config = this.getConfig(subsystem);
    DynamicConfig dynConfig = _config==null?(DynamicConfig)null:_config.getDynConfig();
    String _xifexpression = null;
    String _filePath = dynConfig==null?(String)null:dynConfig.getFilePath();
    boolean _notEquals = (!Objects.equal(_filePath, null));
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new ConfigSourceFile(\"");
      String _filePath_1 = dynConfig.getFilePath();
      _builder.append(_filePath_1, "");
      _builder.append("\")");
      _xifexpression = _builder.toString();
    } else {
      String _userCode2 = dynConfig==null?(String)null:dynConfig.getUserCode2();
      _xifexpression = _userCode2;
    }
    return _xifexpression;
  }
  
  public List<Attribute> getDynConfigReadAttributes(final ActorInstance ai) {
    ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
    final ArrayList<Attribute> result = _arrayList;
    String _path = ai.getPath();
    List<AttrInstanceConfig> configs = DataConfigurationHelper.dynActorInstanceAttrMap.get(_path);
    final Procedure1<AttrInstanceConfig> _function = new Procedure1<AttrInstanceConfig>() {
        public void apply(final AttrInstanceConfig c) {
          boolean _isReadOnly = c.isReadOnly();
          if (_isReadOnly) {
            Attribute _attribute = c.getAttribute();
            result.add(_attribute);
          }
        }
      };
    if (configs!=null) IterableExtensions.<AttrInstanceConfig>forEach(configs, _function);
    return result;
  }
  
  public List<Attribute> getDynConfigWriteAttributes(final ActorInstance ai) {
    ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
    final ArrayList<Attribute> result = _arrayList;
    String _path = ai.getPath();
    List<AttrInstanceConfig> configs = DataConfigurationHelper.dynActorInstanceAttrMap.get(_path);
    final Procedure1<AttrInstanceConfig> _function = new Procedure1<AttrInstanceConfig>() {
        public void apply(final AttrInstanceConfig c) {
          boolean _isReadOnly = c.isReadOnly();
          boolean _not = (!_isReadOnly);
          if (_not) {
            Attribute _attribute = c.getAttribute();
            result.add(_attribute);
          }
        }
      };
    if (configs!=null) IterableExtensions.<AttrInstanceConfig>forEach(configs, _function);
    return result;
  }
  
  public boolean hasVariableService(final SubSystemInstance subsystem) {
    SubSystemConfig _config = this.getConfig(subsystem);
    DynamicConfig _dynConfig = _config==null?(DynamicConfig)null:_config.getDynConfig();
    boolean _notEquals = (!Objects.equal(_dynConfig, null));
    return _notEquals;
  }
  
  private String toStringExpr(final LiteralArray literal) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Literal> _literals = literal.getLiterals();
      boolean _hasElements = false;
      for(final Literal l : _literals) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        String _stringExpr = this.toStringExpr(l);
        _builder.append(_stringExpr, "");
      }
    }
    String _string = _builder.toString();
    return _string;
  }
  
  private String toStringExpr(final Literal literal) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (literal instanceof BooleanLiteral) {
        final BooleanLiteral _booleanLiteral = (BooleanLiteral)literal;
        _matched=true;
        boolean _isIsTrue = _booleanLiteral.isIsTrue();
        String _string = Boolean.valueOf(_isIsTrue).toString();
        _switchResult = _string;
      }
    }
    if (!_matched) {
      if (literal instanceof IntLiteral) {
        final IntLiteral _intLiteral = (IntLiteral)literal;
        _matched=true;
        long _value = _intLiteral.getValue();
        String _string = Long.valueOf(_value).toString();
        _switchResult = _string;
      }
    }
    if (!_matched) {
      if (literal instanceof RealLiteral) {
        final RealLiteral _realLiteral = (RealLiteral)literal;
        _matched=true;
        double _value = _realLiteral.getValue();
        String _string = Double.valueOf(_value).toString();
        _switchResult = _string;
      }
    }
    if (!_matched) {
      if (literal instanceof StringLiteral) {
        final StringLiteral _stringLiteral = (StringLiteral)literal;
        _matched=true;
        String _value = _stringLiteral.getValue();
        String _string = _value.toString();
        _switchResult = _string;
      }
    }
    return _switchResult;
  }
  
  private SubSystemConfig getConfig(final SubSystemInstance cc) {
    String _path = cc.getPath();
    SubSystemConfig _get = DataConfigurationHelper.subSystemConfigMap.get(_path);
    return _get;
  }
  
  public List<Attribute> getDynConfigReadAttributes(final ActorClass actor) {
    ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
    final ArrayList<Attribute> result = _arrayList;
    List<AttrInstanceConfig> configs = DataConfigurationHelper.dynActorClassAttrMap.get(actor);
    final Procedure1<AttrInstanceConfig> _function = new Procedure1<AttrInstanceConfig>() {
        public void apply(final AttrInstanceConfig c) {
          boolean _isReadOnly = c.isReadOnly();
          if (_isReadOnly) {
            Attribute _attribute = c.getAttribute();
            result.add(_attribute);
          }
        }
      };
    if (configs!=null) IterableExtensions.<AttrInstanceConfig>forEach(configs, _function);
    return result;
  }
  
  public List<Attribute> getDynConfigWriteAttributes(final ActorClass actor) {
    ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
    final ArrayList<Attribute> result = _arrayList;
    List<AttrInstanceConfig> configs = DataConfigurationHelper.dynActorClassAttrMap.get(actor);
    final Procedure1<AttrInstanceConfig> _function = new Procedure1<AttrInstanceConfig>() {
        public void apply(final AttrInstanceConfig c) {
          boolean _isReadOnly = c.isReadOnly();
          boolean _not = (!_isReadOnly);
          if (_not) {
            Attribute _attribute = c.getAttribute();
            result.add(_attribute);
          }
        }
      };
    if (configs!=null) IterableExtensions.<AttrInstanceConfig>forEach(configs, _function);
    return result;
  }
  
  public void addReferencedModels(final IResourceURIAcceptor acceptor, final EObject root) {
    if ((root instanceof ConfigModel)) {
      EList<Import> _imports = ((ConfigModel) root).getImports();
      for (final Import imp : _imports) {
        {
          final String importURI = this.uriResolver.resolve(imp);
          acceptor.addResourceURI(importURI);
        }
      }
    }
  }
}
