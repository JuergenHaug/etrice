package org.eclipse.etrice.generator.generic;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

@SuppressWarnings("all")
public class GenericProtocolClassGenerator {
  @Inject
  private ILanguageExtension langExt;
  
  @Inject
  private RoomExtensions roomExt;
  
  public String genMessageIDs(final ProtocolClass pc) {
    int offset = 0;
    ArrayList<Pair<String,String>> _arrayList = new ArrayList<Pair<String,String>>();
    ArrayList<Pair<String,String>> list = _arrayList;
    String _name = pc.getName();
    String _memberInDeclaration = this.langExt.memberInDeclaration(_name, "MSG_MIN");
    String _string = Integer.valueOf(offset).toString();
    Pair<String,String> _pair = Tuples.<String, String>pair(_memberInDeclaration, _string);
    list.add(_pair);
    List<Message> _allOutgoingMessages = this.roomExt.getAllOutgoingMessages(pc);
    for (final Message msg : _allOutgoingMessages) {
      {
        int _plus = (offset + 1);
        offset = _plus;
        String _name_1 = pc.getName();
        String _name_2 = msg.getName();
        String _plus_1 = ("OUT_" + _name_2);
        String _memberInDeclaration_1 = this.langExt.memberInDeclaration(_name_1, _plus_1);
        String _string_1 = Integer.valueOf(offset).toString();
        Pair<String,String> _pair_1 = Tuples.<String, String>pair(_memberInDeclaration_1, _string_1);
        list.add(_pair_1);
      }
    }
    List<Message> _allIncomingMessages = this.roomExt.getAllIncomingMessages(pc);
    for (final Message msg_1 : _allIncomingMessages) {
      {
        int _plus = (offset + 1);
        offset = _plus;
        String _name_1 = pc.getName();
        String _name_2 = msg_1.getName();
        String _plus_1 = ("IN_" + _name_2);
        String _memberInDeclaration_1 = this.langExt.memberInDeclaration(_name_1, _plus_1);
        String _string_1 = Integer.valueOf(offset).toString();
        Pair<String,String> _pair_1 = Tuples.<String, String>pair(_memberInDeclaration_1, _string_1);
        list.add(_pair_1);
      }
    }
    int _plus = (offset + 1);
    offset = _plus;
    String _name_1 = pc.getName();
    String _memberInDeclaration_1 = this.langExt.memberInDeclaration(_name_1, "MSG_MAX");
    String _string_1 = Integer.valueOf(offset).toString();
    Pair<String,String> _pair_1 = Tuples.<String, String>pair(_memberInDeclaration_1, _string_1);
    list.add(_pair_1);
    String _name_2 = pc.getName();
    String _memberInDeclaration_2 = this.langExt.memberInDeclaration(_name_2, "msg_ids");
    return this.langExt.genEnumeration(_memberInDeclaration_2, list);
  }
  
  public String getMessageID(final MessageFromIf mif) {
    Message _message = mif.getMessage();
    InterfaceItem _from = mif.getFrom();
    return this.getMessageID(_message, _from);
  }
  
  public String getMessageID(final Message msg, final InterfaceItem item) {
    if ((item instanceof Port)) {
      Port p = ((Port) item);
      String _xifexpression = null;
      boolean _isConjugated = p.isConjugated();
      if (_isConjugated) {
        _xifexpression = "OUT_";
      } else {
        _xifexpression = "IN_";
      }
      String direction = _xifexpression;
      GeneralProtocolClass _protocol = p.getProtocol();
      String _name = _protocol.getName();
      String _name_1 = msg.getName();
      String _plus = (direction + _name_1);
      return this.langExt.memberInUse(_name, _plus);
    } else {
      if ((item instanceof SAPRef)) {
        SAPRef sap = ((SAPRef) item);
        ProtocolClass _protocol_1 = sap.getProtocol();
        String _name_2 = _protocol_1.getName();
        String _name_3 = msg.getName();
        String _plus_1 = ("OUT_" + _name_3);
        return this.langExt.memberInUse(_name_2, _plus_1);
      } else {
        if ((item instanceof SPPRef)) {
          SPPRef spp = ((SPPRef) item);
          ProtocolClass _protocol_2 = spp.getProtocol();
          String _name_4 = _protocol_2.getName();
          String _name_5 = msg.getName();
          String _plus_2 = ("IN_" + _name_5);
          return this.langExt.memberInUse(_name_4, _plus_2);
        }
      }
    }
    return "unknown interface item";
  }
}
