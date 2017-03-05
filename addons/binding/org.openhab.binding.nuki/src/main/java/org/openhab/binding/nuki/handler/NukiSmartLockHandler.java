/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki.handler;

import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.ThingStatusDetail;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.openhab.binding.nuki.NukiBindingConstants;
import org.openhab.binding.nuki.dataexchange.BridgeLockStateResponse;
import org.openhab.binding.nuki.dataexchange.NukiHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link NukiSmartLockHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 * @author Markus Katter - Initial contribution
 */
public class NukiSmartLockHandler extends BaseThingHandler {

    private final static Logger logger = LoggerFactory.getLogger(NukiSmartLockHandler.class);

    private NukiHttpClient nukiHttpClient;

    public NukiSmartLockHandler(Thing thing) {
        super(thing);
    }

    @Override
    public void initialize() {
        logger.debug("NukiSmartLockHandler:initialize");
        String nukiId = (String) this.getConfig().get(NukiBindingConstants.CONFIG_NUKIID);
        if (nukiHttpClient == null) {
            nukiHttpClient = getNukiHttpClient();
        }
        BridgeLockStateResponse bridgeLockStateResponse = nukiHttpClient.getBridgeLockState(nukiId);
        if (bridgeLockStateResponse.getStatus() == 200) {
            updateStatus(ThingStatus.ONLINE, ThingStatusDetail.NONE,
                    "Nuki Smart Lock is " + bridgeLockStateResponse.getBridgeLockState().getStateName());
        } else {
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR,
                    bridgeLockStateResponse.getMessage());
        }
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        logger.debug("NukiSmartLockHandler:handleCommand({}, {})", channelUID, command);
        if (channelUID.getId().equals(NukiBindingConstants.CHANNEL_SMARTLOCKOPENCLOSE)) {
            logger.warn("Smart Lock Open/Close not yet implemented!");
        }
    }

    private NukiHttpClient getNukiHttpClient() {
        if (this.getBridge() != null && this.getBridge().getHandler() instanceof NukiBridgeHandler) {
            return ((NukiBridgeHandler) this.getBridge().getHandler()).getNukiHttpClient();
        }
        logger.error("Could not get NukiHttpClient from NukiBridgeHandler!");
        return null;
    }

}
