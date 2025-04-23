package com.rbrubaker.networkalarmmailer.enums;

public enum AlarmType {

    VALUE, ALARM_TYPE, UNKNOWN;

    public static AlarmType getValueOf(String value) {
        if (value.equalsIgnoreCase("VALUE")) {
            return VALUE;
        } else if (value.equalsIgnoreCase("ALARM_TYPE")) {
            return ALARM_TYPE;
        } else {
            return UNKNOWN;
        }
    }

}
