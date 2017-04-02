/**
 * Copyright (c) 2014-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki.handler;

/**
 * The {@link NukiBridgeHandlerNotAvailableException} indicates that the NukiBridgeHandler is not available.
 *
 * @author Markus Katter - Initial contribution
 */
public class NukiBridgeHandlerNotAvailableException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -2791902845507557593L;

    public NukiBridgeHandlerNotAvailableException(String message) {
        super(message);
    }

}
