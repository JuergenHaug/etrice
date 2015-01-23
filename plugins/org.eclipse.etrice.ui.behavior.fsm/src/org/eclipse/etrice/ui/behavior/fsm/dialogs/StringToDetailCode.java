package org.eclipse.etrice.ui.behavior.fsm.dialogs;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.FSMFactory;

public class StringToDetailCode extends Converter {

	private boolean emptyIsNull;

	public StringToDetailCode(boolean emptyIsNull) {
		super(String.class, DetailCode.class);
		this.emptyIsNull = emptyIsNull;
	}

	public StringToDetailCode() {
		this(true);
	}

	@Override
	public Object convert(Object fromObject) {
		if (fromObject instanceof String) {
			String code = (String) fromObject;
			if (code.isEmpty())
				return emptyIsNull? null:createEmptyDetailCode();

			String trimmed = code.trim();
			if (trimmed.isEmpty())
				return emptyIsNull? null:createEmptyDetailCode();
			
			// first check for Windows line endings, if not present then split by Unix line ending
			String[] cmds = code.indexOf("\r\n")>=0 ? code.split("\r\n") : code.split("\n");
			DetailCode dc = FSMFactory.eINSTANCE.createDetailCode();
			for (int i = 0; i < cmds.length; i++) {
				dc.getLines().add(cmds[i]);
			}
			// trim last command if empty
			if (cmds[cmds.length-1].isEmpty())
				dc.getLines().remove(cmds.length-1);
			
			dc.setUsed(true);
			
			return dc;
		}
		return null;
	}

	/**
	 * @return
	 */
	private DetailCode createEmptyDetailCode() {
		DetailCode dc = FSMFactory.eINSTANCE.createDetailCode();
		dc.getLines().add("");
		dc.setUsed(false);
		return dc;
	}

}
