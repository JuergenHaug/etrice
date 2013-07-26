package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.generator.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class OptionalActorFactoryGen {
  @Inject
  private IGeneratorFileIo fileIO;
  
  @Inject
  @Extension
  private JavaExtensions _javaExtensions;
  
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  public void doGenerate(final Root root) {
    EList<OptionalActorInstance> _optionalInstances = root.getOptionalInstances();
    for (final OptionalActorInstance oi : _optionalInstances) {
      {
        final ActorClass ac = oi.getActorClass();
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(ac);
        String _path = this._roomExtensions.getPath(ac);
        final String path = (_generationTargetPath + _path);
        String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(ac);
        String _path_1 = this._roomExtensions.getPath(ac);
        final String infopath = (_generationInfoPath + _path_1);
        final String file = this._javaExtensions.getJavaFactoryFileName(ac);
        CharSequence _generate = this.generate(root, oi);
        this.fileIO.generateFile("generating ActorClass Interface implementation", path, infopath, file, _generate);
      }
    }
  }
  
  public CharSequence generate(final Root root, final OptionalActorInstance oi) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = oi.getActorClass();
      final String clsname = this._javaExtensions.getJavaFactoryName(ac);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _package = this._roomExtensions.getPackage(ac);
      _builder.append(_package, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import ");
      String _package_1 = this._roomExtensions.getPackage(ac);
      _builder.append(_package_1, "");
      _builder.append(".");
      String _name = ac.getName();
      _builder.append(_name, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.PathToPeers;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(clsname, "");
      _builder.append(" implements IOptionalActorFactory {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private PathToPeers path2peers = new PathToPeers();");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      String _name_1 = ac.getName();
      _builder.append(_name_1, "	");
      _builder.append(" create(OptionalActorInterfaceBase ai, String name) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("// set port mappings of this sub tree");
      _builder.newLine();
      {
        BasicEList<AbstractInstance> _allSubInstances = this._roomExtensions.getAllSubInstances(oi);
        for(final AbstractInstance ai : _allSubInstances) {
          _builder.append("\t\t");
          EList<? extends InterfaceItemInstance> _xifexpression = null;
          if ((ai instanceof ActorInstance)) {
            EList<InterfaceItemInstance> _orderedIfItemInstances = ((ActorInstance) ai).getOrderedIfItemInstances();
            _xifexpression = _orderedIfItemInstances;
          } else {
            EList<PortInstance> _ports = ai.getPorts();
            _xifexpression = _ports;
          }
          final EList<? extends InterfaceItemInstance> ports = _xifexpression;
          _builder.newLineIfNotEmpty();
          {
            for(final InterfaceItemInstance pi : ports) {
              {
                EList<InterfaceItemInstance> _peers = pi.getPeers();
                int _size = _peers.size();
                boolean _greaterThan = (_size > 0);
                if (_greaterThan) {
                  _builder.append("\t\t");
                  _builder.append("path2peers.put(\"");
                  String _relPath = this.relPath(oi, pi);
                  _builder.append(_relPath, "		");
                  _builder.append("\", ");
                  {
                    EList<InterfaceItemInstance> _peers_1 = pi.getPeers();
                    boolean _hasElements = false;
                    for(final InterfaceItemInstance peer : _peers_1) {
                      if (!_hasElements) {
                        _hasElements = true;
                      } else {
                        _builder.appendImmediate(",", "		");
                      }
                      _builder.append("\"");
                      String _relPath_1 = this.relPath(oi, peer);
                      _builder.append(_relPath_1, "		");
                      _builder.append("\"");
                    }
                  }
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        }
      }
      _builder.append("\t\t");
      _builder.append("ai.setPath2peers(path2peers);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// instantiate sub tree");
      _builder.newLine();
      _builder.append("\t\t");
      String _name_2 = ac.getName();
      _builder.append(_name_2, "		");
      _builder.append(" actor = new ");
      String _name_3 = ac.getName();
      _builder.append(_name_3, "		");
      _builder.append("(ai, name);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("ai.setPath2peers(null);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return actor;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private String relPath(final OptionalActorInstance oi, final InterfaceItemInstance pi) {
    String _path = pi.getPath();
    ActorClass _actorClass = oi.getActorClass();
    String _name = _actorClass.getName();
    int _length = _name.length();
    int _plus = (_length + 1);
    String path = _path.substring(_plus);
    return path;
  }
}
