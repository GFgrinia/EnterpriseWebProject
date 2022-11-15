package com.academy.constant;

public enum RequestStatuses {
    APPROVAL ("Awaiting approval"),
    PAYMENT ("Awaiting payment"),
    ACTIVE ("Active"),
    COMPLETED ("Completed"),
    OVERDUE ("Overdue"),
    REJECTED ("Rejected");

    public final String label;

    RequestStatuses(String label) {
        this.label =  label;
    }
}
