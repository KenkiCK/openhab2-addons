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
<<<<<<< HEAD
import java.util.List;

import org.eclipse.smarthome.core.library.types.OnOffType;
=======
>>>>>>> d4ea03b13... Incorporated various pull request review comments - Number 4 (#2019).
=======
import org.eclipse.jetty.http.HttpStatus;
>>>>>>> 330cf6474... Incorporated various pull request review comments - Number 5 (#2019).
import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.ThingStatusDetail;
import org.eclipse.smarthome.core.thing.binding.BaseBridgeHandler;
import org.eclipse.smarthome.core.types.Command;
<<<<<<< HEAD
import org.openhab.binding.nuki.dataexchange.BridgeInfoResponse;
import org.openhab.binding.nuki.dataexchange.NukiHttpClient;
<<<<<<< HEAD
import org.openhab.binding.nuki.dataexchange.NukiHttpServer;
import org.openhab.binding.nuki.dataexchange.NukiHttpServerListener;
import org.openhab.binding.nuki.dto.BridgeApiLockStateRequestDto;
=======
=======
import java.util.List;

import org.eclipse.smarthome.core.library.types.OnOffType;
>>>>>>> 3662262e1... Implemented NukiHttpServer for Nuki Bridge callbacks
import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.Channel;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.ThingStatusDetail;
import org.eclipse.smarthome.core.thing.binding.BaseBridgeHandler;
import org.eclipse.smarthome.core.types.Command;
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 2a58c752c... Nuki NoOp Implementation
=======
import org.openhab.binding.nuki.dataexchange.BridgeInfoResponse;
import org.openhab.binding.nuki.dataexchange.NukiHttpClient;
>>>>>>> 0a5308483... Implemented NukiBridgeHandler initialize
=======
import org.eclipse.smarthome.core.types.State;
import org.openhab.binding.nuki.NukiBindingConstants;
import org.openhab.binding.nuki.dataexchange.BridgeInfoResponse;
import org.openhab.binding.nuki.dataexchange.NukiHttpClient;
import org.openhab.binding.nuki.dataexchange.NukiHttpServer;
import org.openhab.binding.nuki.dataexchange.NukiHttpServerListener;
import org.openhab.binding.nuki.dto.BridgeApiLockStateRequestDto;
>>>>>>> 3662262e1... Implemented NukiHttpServer for Nuki Bridge callbacks
=======
>>>>>>> d4ea03b13... Incorporated various pull request review comments - Number 4 (#2019).
=======
import org.openhab.binding.nuki.internal.dataexchange.BridgeInfoResponse;
import org.openhab.binding.nuki.internal.dataexchange.NukiHttpClient;
>>>>>>> 330cf6474... Incorporated various pull request review comments - Number 5 (#2019).
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link NukiBridgeHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 * @author Markus Katter - Initial contribution
 */
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
public class NukiBridgeHandler extends BaseBridgeHandler implements NukiHttpServerListener {
=======
public class NukiBridgeHandler extends BaseBridgeHandler {
>>>>>>> d4ea03b13... Incorporated various pull request review comments - Number 4 (#2019).

    private final Logger logger = LoggerFactory.getLogger(NukiBridgeHandler.class);

    private NukiHttpClient nukiHttpClient;

    public NukiBridgeHandler(Bridge bridge) {
        super(bridge);
        logger.trace("Instantiating NukiBridgeHandler({})", bridge);
<<<<<<< HEAD
    }

    public NukiHttpClient getNukiHttpClient() {
        return nukiHttpClient;
=======
public class NukiBridgeHandler extends BaseBridgeHandler {
=======
public class NukiBridgeHandler extends BaseBridgeHandler implements NukiHttpServerListener {
>>>>>>> 3662262e1... Implemented NukiHttpServer for Nuki Bridge callbacks

    private final static Logger logger = LoggerFactory.getLogger(NukiBridgeHandler.class);

    private NukiHttpClient nukiHttpClient;
    private NukiHttpServer nukiHttpServer;

    public NukiBridgeHandler(Bridge bridge) {
        super(bridge);
>>>>>>> 2a58c752c... Nuki NoOp Implementation
=======
>>>>>>> 9964fbb2e... Tweaked Logging
    }

    public NukiHttpClient getNukiHttpClient() {
        return nukiHttpClient;
    }

    @Override
    public void initialize() {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        logger.debug("NukiBridgeHandler:initialize()");
        BridgeInfoResponse bridgeInfoResponse = new NukiHttpClient(this.getConfig()).getBridgeInfo();
        if (bridgeInfoResponse.getStatus() == 200) {
            updateStatus(ThingStatus.ONLINE);
        } else {
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR, bridgeInfoResponse.getMessage());
        }
=======
        logger.debug("NukiBridgeHandler:initialize");
<<<<<<< HEAD
        updateStatus(ThingStatus.ONLINE);
>>>>>>> 2a58c752c... Nuki NoOp Implementation
=======
=======
        logger.debug("NukiBridgeHandler:initialize()");
>>>>>>> 9964fbb2e... Tweaked Logging
        nukiHttpClient = new NukiHttpClient(this.getConfig());
        nukiHttpServer = NukiHttpServer.getInstance(this.getConfig(), this);
        BridgeInfoResponse bridgeInfoResponse = nukiHttpClient.getBridgeInfo();
        if (bridgeInfoResponse.getStatus() == 200) {
            updateStatus(ThingStatus.ONLINE, ThingStatusDetail.NONE,
                    "Found " + bridgeInfoResponse.getBridgeInfo().getScanResults().size() + " Nuki Smart Locks.");
        } else {
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR, bridgeInfoResponse.getMessage());
        }
>>>>>>> 0a5308483... Implemented NukiBridgeHandler initialize
=======
        scheduler.execute(() -> initializeHandler());
>>>>>>> 330cf6474... Incorporated various pull request review comments - Number 5 (#2019).
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        logger.debug("NukiBridgeHandler:handleCommand({}, {})", channelUID, command);
    }

<<<<<<< HEAD
<<<<<<< HEAD
    @Override
    public void dispose() {
        logger.debug("NukiBridgeHandler:dispose");
        nukiHttpClient.stopClient();
        nukiHttpServer.stopServer();
    }

    @Override
    public void handleBridgeLockStateChange(BridgeApiLockStateRequestDto bridgeApiLockStateRequestDto) {
        logger.debug("NukiBridgeHandler:handleBridgeLockStateChange({})", bridgeApiLockStateRequestDto);
        String nukiId = String.valueOf(bridgeApiLockStateRequestDto.getNukiId());
        Bridge bridge = this.getThing();
        List<Thing> things = bridge.getThings();
        for (Thing thing : things) {
            String nukiIdThing = (String) thing.getConfiguration().get(NukiBindingConstants.CONFIG_NUKIID);
            if (nukiId.equals(nukiIdThing)) {
                Channel channel = thing.getChannel(NukiBindingConstants.CHANNEL_SMARTLOCKOPENCLOSE);
                State state = bridgeApiLockStateRequestDto.getState() == 1 ? OnOffType.ON : OnOffType.OFF;
                thing.getHandler().handleUpdate(channel.getUID(), state);
                logger.trace("Updated Nuki Smart Lock[{}] to state[{}]", nukiId, state);
                return;
            }
        }
        logger.error("Could not find and update Smart Lock[{}]", nukiId);
    }

=======
>>>>>>> 2a58c752c... Nuki NoOp Implementation
=======
    @Override
    public void dispose() {
        logger.debug("NukiBridgeHandler:dispose()");
        nukiHttpClient.stopClient();
        // nukiHttpClient = null;
    }

    private void initializeHandler() {
        logger.debug("NukiBridgeHandler:initializeHandler()");
        nukiHttpClient = new NukiHttpClient(getConfig());
        BridgeInfoResponse bridgeInfoResponse = nukiHttpClient.getBridgeInfo();
        if (bridgeInfoResponse.getStatus() == HttpStatus.OK_200) {
            updateStatus(ThingStatus.ONLINE);
        } else {
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR, bridgeInfoResponse.getMessage());
        }
    }

>>>>>>> 0a5308483... Implemented NukiBridgeHandler initialize
}
