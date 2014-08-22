package org.eclipse.etrice.generator.fsm.base;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.fsm.base.ILogger;

public class NullLogger implements ILogger {

    @Override
    public void logInfo(String text) {
    }

    @Override
    public void logError(String text, EObject obj) {
    }

}
