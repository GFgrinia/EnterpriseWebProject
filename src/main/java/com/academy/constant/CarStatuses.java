package com.academy.constant;

public enum CarStatuses {
    FREE ("free"),
    SERVICE ("service"),
    RESERVED ("reserved"),
    REPAIR ("repair"),
    INUSE ("in use");

    public final String label;

    CarStatuses(String label) {
        this.label =  label;
    }
}
