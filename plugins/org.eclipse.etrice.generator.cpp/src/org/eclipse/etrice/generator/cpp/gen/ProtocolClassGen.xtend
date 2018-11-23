/*******************************************************************************
 * Copyright (c) 2011 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

package org.eclipse.etrice.generator.cpp.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.room.CommunicationType
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.PortClass
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.SAP
import org.eclipse.etrice.core.room.SPP
import org.eclipse.etrice.generator.cpp.Main
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO
import org.eclipse.etrice.generator.generic.GenericProtocolClassGenerator
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.TypeHelpers
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician
import org.eclipse.etrice.generator.cpp.setup.GeneratorOptionsHelper

@Singleton
class ProtocolClassGen extends GenericProtocolClassGenerator {

	@Inject IGeneratorFileIO fileIO
	@Inject extension CppExtensions stdExt
	@Inject extension RoomExtensions roomExt
	@Inject extension ProcedureHelpers helpers
	@Inject extension TypeHelpers
	@Inject extension FileSystemHelpers
	@Inject extension GeneratorOptionsHelper
	@Inject Initialization initHelper
	@Inject IDiagnostician diagnostician

	def doGenerate(Root root) {

		for (pc: root.protocolClasses.filter(cl|cl.isValidGenerationLocation)) {
			val path = pc.getPath
			switch (pc.commType) {
				case CommunicationType::EVENT_DRIVEN:{
					fileIO.generateFile("generating ProtocolClass declaration", path + pc.cppHeaderFileName, root.generateHeaderFile(pc))
					fileIO.generateFile("generating ProtocolClass implementation", path + pc.cppSourceFileName, root.generateSourceFile(pc))
				}
				case CommunicationType::DATA_DRIVEN:{
					fileIO.generateFile("generating ProtocolClass declaration", path + pc.cppHeaderFileName, root.generateDataDrivenHeaderFile(pc))
					fileIO.generateFile("generating ProtocolClass implementation", path + pc.cppSourceFileName, root.generateDataDrivenSourceFile(pc))
				}
				case CommunicationType::SYNCHRONOUS:
					diagnostician.error("synchronous protocols not supported yet", pc, null)
			}
		}
	}


	def protected generateHeaderFile(Root root, ProtocolClass pc) {'''
		/**
		 * @author generated by eTrice
		 *
		 * Header File of ProtocolClass �pc.name�
		 *
		 */

		�generateIncludeGuardBegin(pc, '')�

		#include "common/modelbase/InterfaceItemBase.h"
		#include "common/modelbase/PortBase.h"
		#include "common/modelbase/ReplicatedInterfaceItemBase.h"
		#include "common/modelbase/ReplicatedPortBase.h"
		#include "common/etDatatypesCpp.hpp"

		�FOR dataClass : root.getReferencedDataClasses(pc)�
			#include "�dataClass.path��dataClass.name�.h"
		�ENDFOR�

		�pc.userCode1.userCode�

		�pc.generateNamespaceBegin�

		class �pc.name� {
		   public:
				/* message IDs */
				�genMessageIDs(pc)�

				�pc.userCode(2)�

				static bool isValidEvtID(int evtId) {
					return ((MSG_MIN < evtId) && (evtId < MSG_MAX));
				}
				static bool isValidOutgoingEvtID(int evtId) {
					return ((MSG_MIN < evtId) && (evtId < �IF pc.incomingMessages.size == 0�MSG_MAX�ELSE�IN_�pc.incomingMessages.get(0).name��ENDIF�));
				}
				static bool isValidIncomingEvtID(int evtId) {
					return ((�IF pc.incomingMessages.size == 0�MSG_MAX�ELSE�IN_�pc.incomingMessages.get(0).name��ENDIF� <= evtId) && (evtId < MSG_MAX));
				}
				static const etRuntime::String& getMessageString(int msg_id);

			private:
				static const etRuntime::String s_messageStrings[];

		};

		�portClassDeclaration(pc, false)�
		�portClassDeclaration(pc, true)�

		�pc.generateNamespaceEnd�

		�generateIncludeGuardEnd(pc, '')�
	'''
	}

	def protected portClassDeclaration(ProtocolClass pc, boolean conj) {
		var pclass = pc.getPortClass(conj)
		var portClassName = pc.getPortClassName(conj)
		var replPortClassName = pc.getPortClassName(conj, true)
	'''
	//------------------------------------------------------------------------------------------------------------
	// �IF conj�conjugated �ENDIF�port class
	//------------------------------------------------------------------------------------------------------------
	class �portClassName� : public etRuntime::PortBase {
		�IF pclass!==null�
			�pclass.userCode.userCode�
		�ENDIF�
	   public:
		 �portClassName�(etRuntime::IInterfaceItemOwner* actor, const etRuntime::String& name, int localId);
		 �portClassName�(etRuntime::IInterfaceItemOwner* actor, const etRuntime::String& name, int localId, int idx);

		�IF Main::settings.generateMSCInstrumentation�
			virtual void destroy();
		�ENDIF�

		 virtual void receive(const etRuntime::Message* m);

		�IF pclass!==null�
			�pclass.attributes.attributes�
			�pclass.operations.operationsDeclaration(portClassName)�
		�ENDIF�

		 // sent messages
		�FOR m : pc.getAllMessages(conj)�
		  	�messageSignature(m, false)�;
		  	�messageSignature(m, true)�;
		�ENDFOR�
	};

	//------------------------------------------------------------------------------------------------------------
	// �IF conj�conjugated �ENDIF�replicated port class
	//------------------------------------------------------------------------------------------------------------
	class �replPortClassName� : public etRuntime::ReplicatedPortBase {

		public:
			�replPortClassName�(etRuntime::IInterfaceItemOwner* actor, const etRuntime::String& name, int localId);

			int getReplication() const { return getNInterfaceItems(); }
			int getIndexOf(const etRuntime::InterfaceItemBase& ifitem) const { return ifitem.getIdx(); }
			�portClassName�& get(int idx) const { return *dynamic_cast<�portClassName�*>(getInterfaceItem(idx)); }

			�IF conj�
				// incoming messages
				�FOR m : pc.getAllIncomingMessages()�
					�messageSignature(m, false)�;
				�ENDFOR�
			�ELSE�
				// outgoing messages
				�FOR m : pc.getAllOutgoingMessages()�
					�messageSignature(m, false)�;
				�ENDFOR�
			�ENDIF�

		protected:
			virtual etRuntime::InterfaceItemBase* createInterfaceItem(etRuntime::IInterfaceItemOwner* rcv, const etRuntime::String& name, int lid, int idx) {
				return new �portClassName�(rcv, name, lid, idx);
			}

	};
	'''
	}

	def protected generateSourceFile(Root root, ProtocolClass pc) {'''
		/**
		 * @author generated by eTrice
		 *
		 * Source File of ProtocolClass �pc.name�
		 *
		 */

		#include "�pc.getCppHeaderFileName�"

		#include "common/debugging/DebuggingService.h"
		#include "common/debugging/MSCFunctionObject.h"
		#include "common/messaging/AbstractMessageReceiver.h"
		#include "common/messaging/Address.h"
		#include "common/messaging/Message.h"
		#include "common/modelbase/IEventReceiver.h"

		using namespace etRuntime;

		�pc.generateNamespaceBegin�

		�pc.userCode(3)�

		/* message names as strings for debugging (generate MSC) */
		const String �pc.name�::s_messageStrings[] = {"MIN", �FOR m : pc.getAllOutgoingMessages()�"�m.name�",�ENDFOR� �FOR m : pc.getAllIncomingMessages()�"�m.name�",�ENDFOR�"MAX"};

		const String& �pc.name�::getMessageString(int msg_id) {
			if ((MSG_MIN < msg_id ) && ( msg_id < MSG_MAX )) {
				return s_messageStrings[msg_id];
			} else {
				// id out of range
				static const String errorMsg = "Message ID out of range";
				return errorMsg;
			}
		}

		�portClassImplementation(pc, false)�
		�portClassImplementation(pc, true)�

		�pc.generateNamespaceEnd�

	'''
	}


	def protected portClassImplementation(ProtocolClass pc, boolean conj) {
		var pclass = pc.getPortClass(conj)
		var portClassName = pc.getPortClassName(conj)
		var replPortClassName = pc.getPortClassName(conj, true)
	'''
	//------------------------------------------------------------------------------------------------------------
	// �IF conj�conjugated �ENDIF�port class
	//------------------------------------------------------------------------------------------------------------

	�portClassName�::�portClassName�(IInterfaceItemOwner* actor, const String& name, int localId)
		�pclass.generateConstructorInitalizerList('0')�
	{
	}

	�portClassName�::�portClassName�(IInterfaceItemOwner* actor, const String& name, int localId, int idx)
		�pclass.generateConstructorInitalizerList('idx')�
	{
		�IF pclass !== null��initHelper.genExtraInitializers(pclass.attributes)��ENDIF�
	}
	�IF Main::settings.generateMSCInstrumentation�

		void �portClassName�::destroy() {
			DebuggingService::getInstance().removePortInstance(*this);
			PortBase::destroy();
		}
	�ENDIF�

	void �portClassName�::receive(const Message* msg) {
		// TODO JH further
		if (! �pc.name�::�IF conj�isValidOutgoingEvtID�ELSE�isValidIncomingEvtID�ENDIF�(msg->getEvtId())) {
			//std::cout << "unknown" << std::endl;
		}

		�IF Main::settings.generateMSCInstrumentation�
			DebuggingService::getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), �pc.name�::getMessageString(msg->getEvtId()).c_str());
		�ENDIF�

		�IF pc.handlesReceive(conj)�
			switch (msg->getEvtId()) {
				�FOR hdlr : pc.getReceiveHandlers(conj)�
				case �pc.name�::�hdlr.msg.getCodeName()�:
					{
						�FOR command : hdlr.detailCode.lines�
						�command�
						�ENDFOR�
					}
					break;
				�ENDFOR�
				default:
			�ENDIF�
		getActor()->receiveEvent(this, msg->getEvtId(),	msg->getData());
		�IF pc.handlesReceive(conj)�
					break;
			}
		�ENDIF�
	}

	�IF pclass!==null�
		�pclass.operations.operationsImplementation(portClassName)�
	�ENDIF�

	// sent messages
	�FOR m : pc.getAllMessages(conj)�
		�sendMessage(m, pc.name, portClassName, conj)�
	�ENDFOR�

	//------------------------------------------------------------------------------------------------------------
	// �IF conj�conjugated �ENDIF�replicated port class
	//------------------------------------------------------------------------------------------------------------
	�replPortClassName�::�replPortClassName�(IInterfaceItemOwner* actor, const String& name, int localId) :
			ReplicatedPortBase(actor, name, localId)
	{
	}

	�IF conj�
		// incoming messages
		�FOR m : pc.getAllIncomingMessages()�
			�messageSignatureDefinition(m, replPortClassName, false)�{
				for (Vector<etRuntime::InterfaceItemBase*>::iterator it = getItems().begin(); it != getItems().end(); ++it) {
					(dynamic_cast<�portClassName�*>(*it))->�messageCall(m, false)�;
				}
			}
		�ENDFOR�
	�ELSE�
		// outgoing messages
		�FOR m : pc.getAllOutgoingMessages()�
			�messageSignatureDefinition(m, replPortClassName, false)�{
				for (Vector<etRuntime::InterfaceItemBase*>::iterator it = getItems().begin(); it != getItems().end(); ++it) {
					(dynamic_cast<�portClassName�*>(*it))->�messageCall(m, false)�;
				}
			}
		�ENDFOR�
	�ENDIF�
	'''
	}

	def private generateConstructorInitalizerList(PortClass pc, String index) {
		val extension initHelper = initHelper
		val List<CharSequence> initList = newArrayList

		initList += '''PortBase(actor, name, localId, �index�)'''
		if(pc !== null)
			initList += pc.attributes.map['''�name�(�initializerListValue�)''']

		initList.generateCtorInitializerList
	}

	def protected messageCall(Message m, boolean impl) {
		'''�m.name��IF impl�_impl�ENDIF�(�IF m.data!==null� �ILanguageExtension.GENERIC_DATA_NAME��ENDIF�)'''
	}


	def protected messageSignature(Message m, boolean impl) {
		'''�IF m.priv||impl�private:�ELSE�public:�ENDIF� void �m.name��IF impl�_impl�ENDIF�(�IF m.data!==null��m.data.refType.signatureString� �ILanguageExtension.GENERIC_DATA_NAME��ENDIF�)'''
	}

	def protected messageSignatureDefinition(Message m, String classPrefix, boolean impl) {
		'''void �classPrefix�::�m.name��IF impl�_impl�ENDIF�(�IF m.data!==null��m.data.refType.signatureString� �ILanguageExtension.GENERIC_DATA_NAME��ENDIF�)'''
	}

	def protected sendMessage(Message m, String portClassName, String classPrefix, boolean conj) {
		var dir = if (conj) "IN" else "OUT"
		var hdlr = m.getSendHandler(conj)
		val dataArg = if(m.data !== null) ''', �ILanguageExtension.GENERIC_DATA_NAME�'''
		val messageType = if(m.data !== null && !m.data.refType.ref) '''DataMessage<�m.data.refType.type.typeName�>''' else '''Message'''
		val message = '''new (buffer) �messageType�(getPeerAddress(), �portClassName�::�dir�_�m.name��dataArg?:''�)'''
		'''
			�messageSignatureDefinition(m, classPrefix, false)� {
				�IF hdlr!==null�
					�FOR command : hdlr.detailCode.lines�	�command�
					�ENDFOR�
				�ELSE�
					�messageCall(m, true)�;
				�ENDIF�
			}
			
			�messageSignatureDefinition(m, classPrefix, true)� {
				�IF Main::settings.generateMSCInstrumentation�
					DebuggingService::getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(),
						�portClassName�::getMessageString(�portClassName�::�dir�_�m.name�).c_str());
				�ENDIF�
				if (getPeerAddress().isValid()) {
���					we have to use a dynamic cast here because we have a virtual base class
					Message* buffer = dynamic_cast<IMessageService*>(getPeerMsgReceiver())->getMessageBuffer(sizeof(�messageType�));
���					// TODO JB: Handle buffer == NULL
					if (buffer) {
						getPeerMsgReceiver()->receive(�message�);
					}
				}
			}
		'''
	}


	def protected generateDataDrivenHeaderFile(Root root, ProtocolClass pc) {
		val sentMsgs = pc.allIncomingMessages.filter(m|m.data!==null)
		'''
			/**
			 * @author generated by eTrice
			 *
			 * Header File of ProtocolClass �pc.name�
			 *
			 */

			�pc.generateIncludeGuardBegin('')�

			#include "common/etDatatypesCpp.hpp"
			#include "common/modelbase/DataPort.h"
			�FOR dataClass : root.getReferencedDataClasses(pc)�
				#include "�dataClass.path��dataClass.name�.h"
			�ENDFOR�

			�pc.userCode1.userCode�

			�pc.generateNamespaceBegin�

			class �pc.name� {

				�pc.userCode2.userCode�

			};

			// send port holds data
			class �pc.getPortClassName(true)� : public etRuntime::DataSendPort {

			public:
				�pc.getPortClassName(true)�(etRuntime::IRTObject* parent, const etRuntime::String& name, int localId);

				// getters and setters
				�FOR msg : sentMsgs�
					void �msg.name�(�msg.data.refType.type.typeName� �msg.name�) {
						m_�msg.name� = �msg.name�;
					}
					�msg.data.refType.type.typeName� �msg.name�() const {
						return m_�msg.name�;
					}
				�ENDFOR�

			private:
				�FOR msg : sentMsgs�
					�msg.data.refType.type.typeName� m_�msg.name�;
				�ENDFOR�
			};

			// receive port accesses send port
			class �pc.getPortClassName(false)� : public etRuntime::DataReceivePort {

			public:
				�pc.getPortClassName(false)�(etRuntime::IRTObject* parent, const etRuntime::String& name, int localId);

				// getters
				�FOR msg : sentMsgs�
					�msg.data.refType.type.typeName� �msg.name�() const;
				�ENDFOR�

			protected:
				virtual void connect(etRuntime::DataSendPort* dataSendPort);

			private:
				�pc.getPortClassName(true)�* m_peer;

			};

			�pc.generateNamespaceEnd�

			�pc.generateIncludeGuardEnd('')�
		'''
	}

	def protected generateDataDrivenSourceFile(Root root, ProtocolClass pc) {
		val sentMsgs = pc.allIncomingMessages.filter(m|m.data!==null)
		'''
			/**
			 * @author generated by eTrice
			 *
			 * Source File of ProtocolClass �pc.name�
			 *
			 */

			#include "�pc.getCppHeaderFileName�"

			using namespace etRuntime;

			�pc.generateNamespaceBegin�

			�pc.userCode3.userCode�

���			�FOR model : models�
���				import �model.name�.*;
���			�ENDFOR�
			// send port holds data

			// constructor
			�pc.getPortClassName(true)�::�pc.getPortClassName(true)�(IRTObject* parent, const String& name, int localId) :
					DataSendPort(parent, name, localId)
			{
			}

			// receive port accesses send port

			// constructor
			�pc.getPortClassName(false)�::�pc.getPortClassName(false)�(IRTObject* parent, const String& name, int localId) :
					DataReceivePort(parent, name, localId),
					m_peer(0)
			{

			}

			// getters
			�FOR msg : sentMsgs�
				�msg.data.refType.type.typeName� �pc.getPortClassName(false)�::�msg.name�() const {
					// TODO needs default value
					//if (m_peer == 0)
					/*	return �msg.data.refType.type.defaultValue�; */
					return m_peer->�msg.name�();
				}
			�ENDFOR�

			void �pc.getPortClassName(false)�::connect(DataSendPort* dataSendPort) {
				�pc.getPortClassName(true)�* peer = dynamic_cast<�pc.getPortClassName(true)�*>(dataSendPort);
				if (peer != 0)
					m_peer = peer;
			}

			�pc.generateNamespaceEnd�

		'''
	}

	override getMessageID(Message msg, InterfaceItem item) {
		if (item instanceof Port) {
			var direction = if (item.isConjugated())"OUT_" else "IN_"
			return enumInUse(item.getProtocol().getName(), direction+msg.getName())
		}
		else if (item instanceof SAP) {
			return enumInUse(item.getProtocol().getName(), "OUT_"+msg.getName())
		}
		else if (item instanceof SPP) {
			return enumInUse(item.getProtocol().getName(), "IN_"+msg.getName())
		}

		return "unknown interface item";
	}

	def protected String enumInUse(String namespace, String member) {
		return namespace+"::"+member
	}
}