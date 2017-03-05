/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki.dataexchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.smarthome.config.core.Configuration;
import org.openhab.binding.nuki.NukiBindingConstants;
import org.openhab.binding.nuki.dto.BridgeApiLockStateRequestDto;
import org.openhab.binding.nuki.handler.NukiBridgeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

/**
 * The {@link NukiHttpServer} class is responsible for handling the callbacks from the Nuki Bridge.
 *
 * @author Markus Katter - Initial contribution
 */
public class NukiHttpServer extends AbstractHandler {

    private final static Logger logger = LoggerFactory.getLogger(NukiHttpServer.class);

    private static NukiHttpServer instance;
    private Server server;
    private NukiBridgeHandler listener;

    public static NukiHttpServer getInstance(Configuration configuration, NukiBridgeHandler listener) {
<<<<<<< HEAD
<<<<<<< HEAD
        logger.trace("Getting NukiHttpServer instance[{}]", instance);
=======
        logger.debug("Requesting NukiHttpServer instance.");
>>>>>>> 3662262e1... Implemented NukiHttpServer for Nuki Bridge callbacks
=======
        logger.trace("Getting NukiHttpServer instance[{}]", instance);
>>>>>>> 9964fbb2e... Tweaked Logging
        if (instance == null) {
            instance = new NukiHttpServer(configuration, listener);
        }
        return instance;
    }

    protected NukiHttpServer(Configuration configuration, NukiBridgeHandler listener) {
<<<<<<< HEAD
<<<<<<< HEAD
        logger.trace("Instantiating NukiHttpServer({})", configuration);
=======
>>>>>>> 3662262e1... Implemented NukiHttpServer for Nuki Bridge callbacks
=======
        logger.trace("Instantiating NukiHttpServer({})", configuration);
>>>>>>> 9964fbb2e... Tweaked Logging
        this.listener = listener;
        BigDecimal configCallbackPort = (BigDecimal) configuration.get(NukiBindingConstants.CONFIG_CALLBACK_PORT);
        server = new Server(configCallbackPort.intValue());
        server.setHandler(this);
        try {
<<<<<<< HEAD
<<<<<<< HEAD
            server.start();
            logger.debug("Started new NukiHttpServer instance on PORT[{}]", configCallbackPort);
=======
            logger.debug("Creating new NukiHttpServer instance on PORT[{}]", configCallbackPort);
            server.start();
>>>>>>> 3662262e1... Implemented NukiHttpServer for Nuki Bridge callbacks
=======
            server.start();
            logger.debug("Started new NukiHttpServer instance on PORT[{}]", configCallbackPort);
>>>>>>> 9964fbb2e... Tweaked Logging
        } catch (Exception e) {
            logger.error("Could not start NukiHttpServer! ERROR: {}", e.getMessage());
            e.printStackTrace();
        }
    }

    public void stopServer() {
        try {
            if (server.isStarted()) {
                server.stop();
<<<<<<< HEAD
<<<<<<< HEAD
                NukiHttpServer.instance = null;
                logger.trace("Stopped NukiHttpServer");
=======
>>>>>>> 3662262e1... Implemented NukiHttpServer for Nuki Bridge callbacks
=======
                logger.trace("Stopped NukiHttpServer");
>>>>>>> 9964fbb2e... Tweaked Logging
            }
        } catch (Exception e) {
            logger.error("Could not stop NukiHttpServer! ERROR: {}", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        logger.debug("NukiHttpServer:handle request[{}]", request.toString());
        StringBuffer requestContent = new StringBuffer();
        String line = null;
        try {
            BufferedReader bufferedReader = request.getReader();
            while ((line = bufferedReader.readLine()) != null) {
                requestContent.append(line);
            }
        } catch (Exception e) {
            logger.error("Could not handle request! Message[{}]", e.getMessage());
            e.printStackTrace();
        }
<<<<<<< HEAD
<<<<<<< HEAD
        logger.trace("requestContent[{}]", requestContent);
=======
        logger.debug("requestContent[{}]", requestContent);
>>>>>>> 3662262e1... Implemented NukiHttpServer for Nuki Bridge callbacks
=======
        logger.trace("requestContent[{}]", requestContent);
>>>>>>> 9964fbb2e... Tweaked Logging
        BridgeApiLockStateRequestDto bridgeApiLockStateRequestDto = new Gson().fromJson(requestContent.toString(),
                BridgeApiLockStateRequestDto.class);
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        response.getWriter().println("{\"status\":\"OK\"}");
        response.flushBuffer();
        listener.handleBridgeLockStateChange(bridgeApiLockStateRequestDto);
    }

}
