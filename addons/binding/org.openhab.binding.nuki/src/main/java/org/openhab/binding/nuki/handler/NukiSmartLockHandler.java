/**
 * Copyright (c) 2014-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki.handler;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 114939dac... Implemented NukiSmartLockHandler handleCommand REFRESH
=======
import org.eclipse.smarthome.config.core.Configuration;
>>>>>>> c32d3861e... Using unique instance of NukiHttpClient for each request
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
<<<<<<< HEAD
    private final static Logger logger = LoggerFactory.getLogger(NukiSmartLockHandler.class);
=======
    private final Logger logger = LoggerFactory.getLogger(NukiSmartLockHandler.class);
>>>>>>> d79dc40ae... Incorporated various pull request review comments (#2019).

    public NukiSmartLockHandler(Thing thing) {
        super(thing);
        logger.trace("Instantiating NukiSmartLockHandler({})", thing);
<<<<<<< HEAD
=======
    private Logger logger = LoggerFactory.getLogger(NukiSmartLockHandler.class);
=======
    private final static Logger logger = LoggerFactory.getLogger(NukiSmartLockHandler.class);

    private NukiHttpClient nukiHttpClient;
>>>>>>> a3d389951... Implemented NukiSmartLockHandlerHandler initialize

    public NukiSmartLockHandler(Thing thing) {
        super(thing);
>>>>>>> 2a58c752c... Nuki NoOp Implementation
=======
>>>>>>> 9964fbb2e... Tweaked Logging
    }

    @Override
    public void initialize() {
<<<<<<< HEAD
<<<<<<< HEAD
        logger.debug("NukiSmartLockHandler:initialize()");
        try {
            String nukiId = (String) this.getConfig().get(NukiBindingConstants.CONFIG_NUKI_ID);
            BridgeLockStateResponse bridgeLockStateResponse = new NukiHttpClient(getBridgeConfig())
                    .getBridgeLockState(nukiId);
            if (bridgeLockStateResponse.getStatus() == 200) {
                updateStatus(ThingStatus.ONLINE);
            } else {
                updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR,
                        bridgeLockStateResponse.getMessage());
            }
        } catch (NukiBridgeHandlerNotAvailableException e) {
            logger.error("ERROR: {}", e.getMessage(), e);
        }
=======
        logger.debug("NukiSmartLockHandler:initialize");
<<<<<<< HEAD
        updateStatus(ThingStatus.ONLINE);
>>>>>>> 2a58c752c... Nuki NoOp Implementation
=======
=======
        logger.debug("NukiSmartLockHandler:initialize()");
>>>>>>> 186a95257... Fixed typo
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 114939dac... Implemented NukiSmartLockHandler handleCommand REFRESH
        String nukiId = (String) this.getConfig().get(NukiBindingConstants.CONFIG_NUKIID);
=======
        String nukiId = (String) this.getConfig().get(NukiBindingConstants.CONFIG_NUKI_ID);
>>>>>>> d79dc40ae... Incorporated various pull request review comments (#2019).
        if (command.equals(RefreshType.REFRESH)) {
            BridgeLockStateResponse bridgeLockStateResponse = new NukiHttpClient(getBridgeConfig())
                    .getBridgeLockState(nukiId);
            if (bridgeLockStateResponse.getStatus() == 200) {
                updateState(channelUID,
                        (bridgeLockStateResponse.getBridgeLockState().getState() == 1 ? OnOffType.ON : OnOffType.OFF));
            } else {
                logger.error("Could not refresh Nuki Smart Lock[{}]! Message: {}", nukiId,
                        bridgeLockStateResponse.getMessage());
            }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 2a4e8a643... Implemented NukiSmartLockHandler handleCommand OFF/ON
        } else if (channelUID.getId().equals(NukiBindingConstants.CHANNEL_SMARTLOCKOPENCLOSE)
=======
        } else if (channelUID.getId().equals(NukiBindingConstants.CHANNEL_SMARTLOCK_OPEN_CLOSE)
>>>>>>> d79dc40ae... Incorporated various pull request review comments (#2019).
                && (command.equals(OnOffType.ON) || command.equals(OnOffType.OFF))) {
            int lockAction = (command.equals(OnOffType.OFF) ? NukiBindingConstants.LOCK_ACTIONS_UNLOCK
                    : NukiBindingConstants.LOCK_ACTIONS_LOCK);
            BridgeLockActionResponse bridgeLockActionResponse = new NukiHttpClient(getBridgeConfig())
                    .getBridgeLockAction(nukiId, lockAction);
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
=======
        try {
            String nukiId = (String) this.getConfig().get(NukiBindingConstants.CONFIG_NUKI_ID);
            if (command.equals(RefreshType.REFRESH)) {
                BridgeLockStateResponse bridgeLockStateResponse = new NukiHttpClient(getBridgeConfig())
                        .getBridgeLockState(nukiId);
                if (bridgeLockStateResponse.getStatus() == 200) {
                    updateState(channelUID,
                            (bridgeLockStateResponse.getBridgeLockState()
                                    .getState() == NukiBindingConstants.LOCK_STATES_LOCKED ? OnOffType.ON
                                            : OnOffType.OFF));
                } else {
                    logger.error("Could not refresh Nuki Smart Lock[{}]! Message: {}", nukiId,
                            bridgeLockStateResponse.getMessage());
                }
            } else if (command instanceof OnOffType) {
                int lockAction = -1;
                if (channelUID.getId().equals(NukiBindingConstants.CHANNEL_SMARTLOCK_OPEN_CLOSE)) {
                    lockAction = (command == OnOffType.OFF ? NukiBindingConstants.LOCK_ACTIONS_UNLOCK
                            : NukiBindingConstants.LOCK_ACTIONS_LOCK);
                } else if (channelUID.getId().equals(NukiBindingConstants.CHANNEL_SMARTLOCK_UNLATCH_CLOSE)) {
                    lockAction = (command == OnOffType.OFF ? NukiBindingConstants.LOCK_ACTIONS_UNLATCH
                            : NukiBindingConstants.LOCK_ACTIONS_LOCK);
                } else {
                    logger.warn("ChannelUID{} for command{} not implemented!", channelUID, command);
                }
                if (lockAction != -1) {
                    BridgeLockActionResponse bridgeLockActionResponse = new NukiHttpClient(getBridgeConfig())
                            .getBridgeLockAction(nukiId, lockAction);
                    if (bridgeLockActionResponse.getStatus() != 200) {
                        logger.error("Could not execute command[{}] on Nuki Smart Lock[{}]", command, nukiId);
                    }
                }
            } else {
                logger.warn("NukiSmartLockHandler:handleCommand({}, {}) not implemented!", channelUID, command);
            }
        } catch (NukiBridgeHandlerNotAvailableException e) {
<<<<<<< HEAD
            logger.error(e.getMessage());
>>>>>>> b71f5105c... Incorporated various pull request review comments - Number 2 (#2019).
=======
            logger.error("ERROR: {}", e.getMessage(), e);
>>>>>>> d275f0cd7... Fixed Travis CI build error (ERROR found by findbugs)
        }
>>>>>>> 2a58c752c... Nuki NoOp Implementation
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

    private Configuration getBridgeConfig() throws NukiBridgeHandlerNotAvailableException {
        logger.trace("Trying to getBridgeConfig for thing[{}]", this.getThing());
        if (this.getBridge() != null && this.getBridge().getHandler() instanceof NukiBridgeHandler) {
            return this.getBridge().getConfiguration();
        } else {
            logger.error("Could not getBridgeConfig! Did you configure a bridge for this thing?");
            throw new NukiBridgeHandlerNotAvailableException("NukiBridgeHandler not yet available!");
        }
    }

}
