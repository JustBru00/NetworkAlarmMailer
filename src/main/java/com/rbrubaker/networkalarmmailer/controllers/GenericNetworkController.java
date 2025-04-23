package com.rbrubaker.networkalarmmailer.controllers;

public abstract class GenericNetworkController {

    private String name;
    private String ipAddress;

    public GenericNetworkController(String _ipAddress) {
        ipAddress = _ipAddress;
    }

    /**
     * Contacts the NetworkController to poll the variables required for an alarm check.
     */
    public abstract void poll();

    public String getIp() {
        return ipAddress;
    }

    public String getName() {
        return name;
    }

}
