/*******************************************************************************
 * Copyright (c) 2012 tieto deutschland gmbh (http://www.tieto.com)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thomas Jung
 *******************************************************************************/ 


package org.eclipse.etrice.tutorials.simulators.trafficlight;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.IOException;

public class ButtonActionListener 
implements ActionListener {

	private OutputStream out;
	private String cmd1 = "requestGreen";
	
	public ButtonActionListener(OutputStream out){
		this.out = out;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String s = arg0.getActionCommand();
		
		if (s.equals("REQUEST")) {
			System.out.println("Taste gedr�ckt");
			try {
				out.write(cmd1.getBytes());
				out.flush();
			}
			catch (IOException e){
				System.out.println(e.toString());
			}
		//	out.write(cmd1.getBytes());
		}
	}
}
