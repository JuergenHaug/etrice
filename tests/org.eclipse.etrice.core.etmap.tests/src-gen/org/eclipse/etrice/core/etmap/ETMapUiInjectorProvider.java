/*
 * generated by Xtext
 */
package org.eclipse.etrice.core.etmap;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class ETMapUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return org.eclipse.etrice.core.etmap.ui.internal.ETMapActivator.getInstance().getInjector("org.eclipse.etrice.core.etmap.ETMap");
	}

}
