package com.rbrubaker.networkalarmmailer.alarms;

import com.rbrubaker.networkalarmmailer.controllers.GenericNetworkController;
import com.rbrubaker.networkalarmmailer.enums.AlarmType;

import java.time.Instant;
import java.util.List;

public abstract class GenericAlarmSettings {

    private GenericNetworkController controller;
    private String name;
    private AlarmType type;
    private List<String> emailAddresses;
    private int delayInMinutes;
    private Instant tripStart;
    private String description;

    public GenericAlarmSettings(GenericNetworkController _controller, String _name, AlarmType _type,
                                List<String> _emailAddresses, int _delayInMinutes, String _description) {
        controller = _controller;
        name = _name;
        type = _type;
        emailAddresses = _emailAddresses;
        delayInMinutes = _delayInMinutes;
        description = _description;
    }

    public abstract void checkAlarm();

    public abstract boolean isInAlarm();

    public GenericNetworkController getController() {
        return controller;
    }

    public boolean isUseGlobalReceiverEmailAddresses() {
        return emailAddresses == null || emailAddresses.isEmpty();
    }

    public String getName() {
        return name;
    }

    public List<String> getEmailAddresses() {
        return emailAddresses;
    }

    public int getDelayInMinutes() {
        return delayInMinutes;
    }

    public Instant getTripStart() {
        return tripStart;
    }

    public void setTripStart(Instant _tripStart) {
        tripStart = _tripStart;
    }

    public String getDescription() {
        return description;
    }

}
