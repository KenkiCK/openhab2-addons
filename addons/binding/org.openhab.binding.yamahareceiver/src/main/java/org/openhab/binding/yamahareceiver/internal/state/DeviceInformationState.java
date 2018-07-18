/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.yamahareceiver.internal.state;

import java.util.*;

import org.openhab.binding.yamahareceiver.YamahaReceiverBindingConstants;

/**
 * Basic AVR state (name, version, available zones, etc)
 *
 * @author David Graeff - Initial contribution
 * @author Tomasz Maruszak - DAB support, Spotify support, better feature detection
 */
public class DeviceInformationState implements Invalidateable {
    public String host;
    // Some AVR information
    public String name;
    public String id;
    public String version;
    public final Set<YamahaReceiverBindingConstants.Zone> zones = new HashSet<>();
    public final Set<YamahaReceiverBindingConstants.Feature> features = new HashSet<>();
    /**
     * Stores additional properties for the device (protocol specific)
     */
    public final Map<String, Object> properties = new HashMap<>();

    public DeviceInformationState() {
        invalidate();
    }

    // If we lost the connection, invalidate the state.
    @Override
    public void invalidate() {
        host = null;
        name = "N/A";
        id = "";
        version = "0.0";
        zones.clear();
        features.clear();
        properties.clear();
    }

}
