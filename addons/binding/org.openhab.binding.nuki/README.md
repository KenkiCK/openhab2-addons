# Nuki Binding

This is the binding for the [Nuki Smart Lock](https://nuki.io).  
This binding allows you to integrate, view, control and configure the Nuki Bridge and Nuki Smart Locks in the openHAB2 environment.  
**Please note:** A [Nuki Bridge](https://nuki.io/en/bridge/) and a [Nuki Smart Lock](https://nuki.io/en/smart-lock/) or the [Nuki Combo](https://nuki.io/en/shop/nuki-combo/) is needed for this binding to work correctly.

## Supported Bridges

This binding was tested with the [Nuki Bridge](https://nuki.io/en/bridge/).  
It might also work with the [Nuki Software Bridge](https://play.google.com/store/apps/details?id=io.nuki.bridge&hl=en) - Feedback is really appreciated!  

## Supported Things

Nuki Smart Lock(s) which is/are paired via Bluetooth with the Nuki Bridge.

## Discovery

There is no automatic discovery yet implemented.

## Configuration

It is absolutely recommended to configure static IP addresses for both, the openHAB2 server and the Nuki Bridge!

### Nuki Bridge Configuration

**Please note:** At the moment you still need to manually configure a callback URL on the Nuki Bridge which points to your openHAB2 server.  
See [Bridge HTTP-API](https://nuki.io/en/api/), Section */callback* and */callback/add*.  

For example, if your openHAB2 server's IP address is 192.168.0.100 and your Nuki Bridge's IP address is 192.168.0.50, add a callback URI to **http://192.168.0.100/nuki/bcb** on the Nuki Bridge via the [Bridge HTTP-API](https://nuki.io/en/api/) like this:
```
http://192.168.0.50:8080/callback/add?token=1a2b3c4d5e&url=http%3A%2F%2F192.168.0.100%3A8080%2Fnuki%2Fbcb
```
The callback URL has to be /nuki/bcb


### Bridge Configuration (in openHAB2)

There are several configuration parameters for a bridge:
- **IP Address** (required)  
The static IP address of the Nuki Bridge.

- **Port** (required)  
The Port on which the Nuki Bridge REST API runs.

- **API Token** (required)  
The API Token configured via the Nuki App when enabling the API/IFTTT.

The syntax for a bridge is:
```
Bridge nuki:bridge:<UNIQUENAME> [ <CONFIGURATION_PARAMETERS> ]
```

### Thing Configuration
There is just one configuration parameter for a thing:  
- **Nuki ID** (required)  
Nuki ID
The ID of the Nuki Smart Lock.

The syntax for a thing is:
```
Thing smartLock <UNIQUENAME> "<DISPLAYNAME>" @ "<LOCATION>" [ <CONFIGURATION_PARAMETER> ]
```

### Manual configuration of Bridge and Thing (.things file)
To manually configure a Nuki Bridge and a Nuki Smart Lock in your .items file you can do the following:
```
Bridge nuki:bridge:NB1 [ ip="192.168.0.50", port=8080, apiToken="1a2b3c4d5e" ] {
    Thing smartLock SL1 [ nukiId="123456789" ]
}

```

### Items Configuration (.items file)
In the .items file you can define e.g. a Switch.  
Following the Manual configuration example from above you can do the following:
```
Switch Frontdoor_OpenClose      "Frontdoor (Open / Close)"      <switch> { channel="nuki:smartLock:NB1:SL1:smartLockOpenClose" }
Switch Frontdoor_UnlatchClose   "Frontdoor (Unlatch / Close)"   <switch> { channel="nuki:smartLock:NB1:SL1:smartLockUnlatchClose" }
```

### Sitemap Configuration (.sitemap file)
In the .sitemap file you can define e.g. a Switch.  
Following the Manual configuration example from above you can do the following:
```
sitemap nuki label="Nuki Smart Lock" {
    Switch item=Frontdoor_OpenClose    label="Frontdoor (Open / Close)"
    Switch item=Frontdoor_UnlatchClose label="Frontdoor (Unlatch / Close)"
}
```


## Troubleshooting, Debugging and Tracing

Switch the loglevel in the Karaf console to see what's going on.  
```
log:set DEBUG org.openhab.binding.nuki
```

To see also the request/response data and more, use:
```
log:set TRACE org.openhab.binding.nuki
```

Set the logging back to standard:
```
log:set INFO org.openhab.binding.nuki
```

If you open an issue, please post a full startup TRACE log.
```
stop org.openhab.binding.nuki
log:set TRACE org.openhab.binding.nuki
start org.openhab.binding.nuki
```

Have fun & Feedback is really appreciated! :)
