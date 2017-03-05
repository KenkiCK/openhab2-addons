/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki.handler;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 114939dac... Implemented NukiSmartLockHandler handleCommand REFRESH
import org.eclipse.smarthome.core.library.types.OnOffType;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.ThingStatusDetail;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.RefreshType;
<<<<<<< HEAD
<<<<<<< HEAD
import org.eclipse.smarthome.core.types.State;
=======
>>>>>>> 114939dac... Implemented NukiSmartLockHandler handleCommand REFRESH
=======
import org.eclipse.smarthome.core.types.State;
>>>>>>> 3662262e1... Implemented NukiHttpServer for Nuki Bridge callbacks
import org.openhab.binding.nuki.NukiBindingConstants;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 2a4e8a643... Implemented NukiSmartLockHandler handleCommand OFF/ON
import org.openhab.binding.nuki.dataexchange.BridgeLockActionResponse;
import org.openhab.binding.nuki.dataexchange.BridgeLockStateResponse;
import org.openhab.binding.nuki.dataexchange.NukiHttpClient;
=======
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.openhab.binding.nuki.NukiBindingConstants;
>>>>>>> 2a58c752c... Nuki NoOp Implementation
=======
import org.openhab.binding.nuki.dataexchange.BridgeLockStateResponse;
import org.openhab.binding.nuki.dataexchange.NukiHttpClient;
>>>>>>> a3d389951... Implemented NukiSmartLockHandlerHandler initialize
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link NukiSmartLockHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 * @author Markus Katter - Initial contribution
 */
public class NukiSmartLockHandler extends BaseThingHandler {

<<<<<<< HEAD
<<<<<<< HEAD
    private final static Logger logger = LoggerFactory.getLogger(NukiSmartLockHandler.class);

    private NukiHttpClient nukiHttpClient;

    public NukiSmartLockHandler(Thing thing) {
        super(thing);
        logger.trace("Instantiating NukiSmartLockHandler({})", thing);
=======
    private Logger logger = LoggerFactory.getLogger(NukiSmartLockHandler.class);
=======
    private final static Logger logger = LoggerFactory.getLogger(NukiSmartLockHandler.class);

    private NukiHttpClient nukiHttpClient;
>>>>>>> a3d389951... Implemented NukiSmartLockHandlerHandler initialize

    public NukiSmartLockHandler(Thing thing) {
        super(thing);
>>>>>>> 2a58c752c... Nuki NoOp Implementation
    }

    @Override
    public void initialize() {
<<<<<<< HEAD
        logger.debug("NukiSmartLockHandler:initialize()");
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
=======
        logger.debug("NukiSmartLockHandler:initialize");
<<<<<<< HEAD
        updateStatus(ThingStatus.ONLINE);
>>>>>>> 2a58c752c... Nuki NoOp Implementation
=======
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
>>>>>>> a3d389951... Implemented NukiSmartLockHandlerHandler initialize
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        logger.debug("NukiSmartLockHandler:handleCommand({}, {})", channelUID, command);
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 114939dac... Implemented NukiSmartLockHandler handleCommand REFRESH
        String nukiId = (String) this.getConfig().get(NukiBindingConstants.CONFIG_NUKIID);
        if (nukiHttpClient == null) {
            nukiHttpClient = getNukiHttpClient();
        }
        if (command.equals(RefreshType.REFRESH)) {
            BridgeLockStateResponse bridgeLockStateResponse = nukiHttpClient.getBridgeLockState(nukiId);
            if (bridgeLockStateResponse.getStatus() == 200) {
                updateState(channelUID,
                        (bridgeLockStateResponse.getBridgeLockState().getState() == 1 ? OnOffType.ON : OnOffType.OFF));
            } else {
                logger.error("Could not refresh Nuki Smart Lock[{}]! Message: {}", nukiId,
                        bridgeLockStateResponse.getMessage());
            }
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 2a4e8a643... Implemented NukiSmartLockHandler handleCommand OFF/ON
        } else if (channelUID.getId().equals(NukiBindingConstants.CHANNEL_SMARTLOCKOPENCLOSE)
                && (command.equals(OnOffType.ON) || command.equals(OnOffType.OFF))) {
            int lockAction = (command.equals(OnOffType.OFF) ? NukiBindingConstants.LOCKACTIONS_UNLOCK
                    : NukiBindingConstants.LOCKACTIONS_LOCK);
            BridgeLockActionResponse bridgeLockActionResponse = nukiHttpClient.getBridgeLockAction(nukiId, lockAction);
            if (bridgeLockActionResponse.getStatus() != 200) {
                logger.error("Could not execute command[{}] on Nuki Smart Lock[{}]", command, nukiId);
            }
        } else {
            logger.warn("NukiSmartLockHandler:handleCommand({}, {}) not implemented!", channelUID, command);
<<<<<<< HEAD
        }
    }

    @Override
    public void handleUpdate(ChannelUID channelUID, State newState) {
        logger.debug("NukiSmartLockHandler:handleUpdate({}, {})", channelUID, newState);
        updateState(channelUID, newState);
    }

    @Override
    public void dispose() {
        logger.debug("NukiSmartLockHandler:dispose()");
    }

    private NukiHttpClient getNukiHttpClient() {
        if (this.getBridge() != null && this.getBridge().getHandler() instanceof NukiBridgeHandler) {
            return ((NukiBridgeHandler) this.getBridge().getHandler()).getNukiHttpClient();
        }
        logger.error("Could not get NukiHttpClient from NukiBridgeHandler! Did you configure a Bridge for this Thing?");
        return null;
=======
=======
        }
>>>>>>> 114939dac... Implemented NukiSmartLockHandler handleCommand REFRESH
        if (channelUID.getId().equals(NukiBindingConstants.CHANNEL_SMARTLOCKOPENCLOSE)) {
            logger.warn("Smart Lock Open/Close not yet implemented!");
=======
>>>>>>> 2a4e8a643... Implemented NukiSmartLockHandler handleCommand OFF/ON
        }
>>>>>>> 2a58c752c... Nuki NoOp Implementation
    }

    @Override
    public void handleUpdate(ChannelUID channelUID, State newState) {
        logger.debug("NukiSmartLockHandler:handleUpdate({}, {})", channelUID, newState);
        updateState(channelUID, newState);
    }

    private NukiHttpClient getNukiHttpClient() {
        if (this.getBridge() != null && this.getBridge().getHandler() instanceof NukiBridgeHandler) {
            return ((NukiBridgeHandler) this.getBridge().getHandler()).getNukiHttpClient();
        }
        logger.error("Could not get NukiHttpClient from NukiBridgeHandler!");
        return null;
    }

}
