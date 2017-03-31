/**
 * Copyright (c) 2014-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki.internal;

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.Set;

import org.eclipse.smarthome.core.thing.Bridge;
=======
import static org.openhab.binding.nuki.NukiBindingConstants.*;

import java.util.Collections;
import java.util.Set;

import org.openhab.binding.nuki.handler.NukiHandler;
>>>>>>> 32e822771... Initial commit of the Nuki Binding
=======
import java.util.Set;

import org.eclipse.smarthome.core.thing.Bridge;
>>>>>>> 2a58c752c... Nuki NoOp Implementation
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 2a58c752c... Nuki NoOp Implementation
import org.openhab.binding.nuki.NukiBindingConstants;
import org.openhab.binding.nuki.handler.NukiBridgeHandler;
import org.openhab.binding.nuki.handler.NukiSmartLockHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Sets;
<<<<<<< HEAD

/**
 * The {@link NukiHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author Markus Katter - Initial contribution
 */
public class NukiHandlerFactory extends BaseThingHandlerFactory {

    private final Logger logger = LoggerFactory.getLogger(NukiHandlerFactory.class);
    private static final Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Sets
            .union(NukiBindingConstants.THING_TYPE_BRIDGE_UIDS, NukiBindingConstants.THING_TYPE_SMARTLOCK_UIDS);

=======
=======
>>>>>>> 2a58c752c... Nuki NoOp Implementation

/**
 * The {@link NukiHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author Markus Katter - Initial contribution
 */
public class NukiHandlerFactory extends BaseThingHandlerFactory {
<<<<<<< HEAD
    
    private final static Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Collections.singleton(THING_TYPE_SAMPLE);
    
>>>>>>> 32e822771... Initial commit of the Nuki Binding
=======

    private final static Logger logger = LoggerFactory.getLogger(NukiHandlerFactory.class);
    private final static Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Sets
            .union(NukiBindingConstants.THING_TYPE_BRIDGE_UIDS, NukiBindingConstants.THING_TYPE_SMARTLOCK_UIDS);

>>>>>>> 2a58c752c... Nuki NoOp Implementation
    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    @Override
    protected ThingHandler createHandler(Thing thing) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        logger.trace("ThingHandler:createHandler({})", thing.toString());
        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        if (NukiBindingConstants.THING_TYPE_BRIDGE_UIDS.contains(thingTypeUID)) {
            return new NukiBridgeHandler((Bridge) thing);
        } else if (NukiBindingConstants.THING_TYPE_SMARTLOCK_UIDS.contains(thingTypeUID)) {
            return new NukiSmartLockHandler(thing);
        }
        logger.error("No valid Handler found for Thing[{}]!", thingTypeUID);
        return null;
    }

}
=======

=======
        logger.trace("ThingHandler:createHandler({})", thing.toString());
>>>>>>> 9964fbb2e... Tweaked Logging
=======
        logger.trace("ThingHandler:createHandler({})", thing);
>>>>>>> d79dc40ae... Incorporated various pull request review comments (#2019).
        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        if (NukiBindingConstants.THING_TYPE_BRIDGE_UIDS.contains(thingTypeUID)) {
            return new NukiBridgeHandler((Bridge) thing);
        } else if (NukiBindingConstants.THING_TYPE_SMARTLOCK_UIDS.contains(thingTypeUID)) {
            return new NukiSmartLockHandler(thing);
        }
        logger.error("No valid Handler found for Thing[{}]!", thingTypeUID);
        return null;
    }

<<<<<<< HEAD
>>>>>>> 32e822771... Initial commit of the Nuki Binding
=======
}
>>>>>>> 2a58c752c... Nuki NoOp Implementation
