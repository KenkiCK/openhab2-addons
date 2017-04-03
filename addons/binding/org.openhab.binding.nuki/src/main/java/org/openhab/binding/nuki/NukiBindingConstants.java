/**
 * Copyright (c) 2014-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki;

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.Collections;
import java.util.Set;

import org.eclipse.smarthome.core.thing.ThingTypeUID;

/**
 * The {@link NukiBinding} class defines common constants, which are
 * used across the whole binding.
 *
=======
=======
import java.util.Collections;
import java.util.Set;

>>>>>>> 2a58c752c... Nuki NoOp Implementation
import org.eclipse.smarthome.core.thing.ThingTypeUID;

/**
 * The {@link NukiBinding} class defines common constants, which are
 * used across the whole binding.
<<<<<<< HEAD
 * 
>>>>>>> 32e822771... Initial commit of the Nuki Binding
=======
 *
>>>>>>> 2a58c752c... Nuki NoOp Implementation
 * @author Markus Katter - Initial contribution
 */
public class NukiBindingConstants {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public final static String BINDING_ID = "nuki";

    // List of all Thing Type UIDs
    public final static ThingTypeUID THING_TYPE_BRIDGE = new ThingTypeUID(BINDING_ID, "bridge");
    public final static ThingTypeUID THING_TYPE_SMARTLOCK = new ThingTypeUID(BINDING_ID, "smartLock");

    public final static Set<ThingTypeUID> THING_TYPE_BRIDGE_UIDS = Collections.singleton(THING_TYPE_BRIDGE);
    public final static Set<ThingTypeUID> THING_TYPE_SMARTLOCK_UIDS = Collections.singleton(THING_TYPE_SMARTLOCK);

    // List of all Channel ids
    public final static String CHANNEL_SMARTLOCKOPENCLOSE = "smartLockOpenClose";

    // List of all config-description parameters
    public final static String CONFIG_IP = "IP";
    public final static String CONFIG_PORT = "PORT";
    public final static String CONFIG_APITOKEN = "APITOKEN";
    public final static String CONFIG_NUKIID = "NUKIID";
    public final static String CONFIG_CALLBACK_PORT = "CALLBACK_PORT";

    // Nuki Bridge API REST Endpoints
    public final static String URI_INFO = "http://%s:%s/info?token=%s";
    public final static String URI_LOCKSTATE = "http://%s:%s/lockState?token=%s&nukiId=%s";
    public final static String URI_LOCKACTION = "http://%s:%s/lockAction?token=%s&nukiId=%s&action=%s";
    // NukiHttpClient
    public final static long CLIENT_CONNECTTIMEOUT = 5000;
    // Nuki Bridge API Lock Actions
    public final static int LOCKACTIONS_UNLOCK = 1;
    public final static int LOCKACTIONS_LOCK = 2;
=======
    public static final String BINDING_ID = "nuki";
=======
    public final static String BINDING_ID = "nuki";
>>>>>>> 0a5308483... Implemented NukiBridgeHandler initialize
=======
    public static final String BINDING_ID = "nuki";
>>>>>>> d79dc40ae... Incorporated various pull request review comments (#2019).

    // List of all Thing Type UIDs
    public static final ThingTypeUID THING_TYPE_BRIDGE = new ThingTypeUID(BINDING_ID, "bridge");
    public static final ThingTypeUID THING_TYPE_SMARTLOCK = new ThingTypeUID(BINDING_ID, "smartLock");

    public static final Set<ThingTypeUID> THING_TYPE_BRIDGE_UIDS = Collections.singleton(THING_TYPE_BRIDGE);
    public static final Set<ThingTypeUID> THING_TYPE_SMARTLOCK_UIDS = Collections.singleton(THING_TYPE_SMARTLOCK);

    // List of all Channel ids
<<<<<<< HEAD
<<<<<<< HEAD
    public final static String CHANNEL_1 = "channel1";
>>>>>>> 32e822771... Initial commit of the Nuki Binding
=======
    public final static String CHANNEL_SMARTLOCKOPENCLOSE = "smartLockOpenClose";
=======
    public static final String CHANNEL_SMARTLOCK_OPEN_CLOSE = "smartLockOpenClose";
<<<<<<< HEAD
>>>>>>> d79dc40ae... Incorporated various pull request review comments (#2019).
=======
    public static final String CHANNEL_SMARTLOCK_UNLATCH_CLOSE = "smartLockUnlatchClose";
>>>>>>> d4ea03b13... Incorporated various pull request review comments - Number 4 (#2019).

    // List of all config-description parameters
    public static final String CONFIG_IP = "ip";
    public static final String CONFIG_PORT = "port";
    public static final String CONFIG_API_TOKEN = "apiToken";
    public static final String CONFIG_NUKI_ID = "nukiId";

    // Nuki Bridge API REST Endpoints
    public static final String URI_INFO = "http://%s:%s/info?token=%s";
    public static final String URI_LOCKSTATE = "http://%s:%s/lockState?token=%s&nukiId=%s";
    public static final String URI_LOCKACTION = "http://%s:%s/lockAction?token=%s&nukiId=%s&action=%s";

    // NukiHttpClient
    public static final long CLIENT_CONNECT_TIMEOUT = 5000;

    // Nuki Bridge API Lock Actions
<<<<<<< HEAD
    public final static int LOCKACTIONS_UNLOCK = 1;
    public final static int LOCKACTIONS_LOCK = 2;
>>>>>>> 2a58c752c... Nuki NoOp Implementation
=======
    public static final int LOCK_ACTIONS_UNLOCK = 1;
    public static final int LOCK_ACTIONS_LOCK = 2;
<<<<<<< HEAD
>>>>>>> d79dc40ae... Incorporated various pull request review comments (#2019).

=======
    public static final int LOCK_ACTIONS_UNLATCH = 3;
    public static final int LOCK_ACTIONS_LOCK_N_GO = 4;
    public static final int LOCK_ACTIONS_LOCK_N_GO_UNLATCH = 5;

    // Nuki Bridge API Lock States
    public static final int LOCK_STATES_LOCKED = 1;
    public static final int LOCK_STATES_UNLOCKED = 3;
<<<<<<< HEAD
>>>>>>> b71f5105c... Incorporated various pull request review comments - Number 2 (#2019).
=======

>>>>>>> d4ea03b13... Incorporated various pull request review comments - Number 4 (#2019).
}
