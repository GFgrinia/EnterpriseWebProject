package com.academy.constant;

public enum RequestStatuses {
    APPROVAL ("Awaiting approval"),
    PAYMENT ("Awaiting payment"),
    ACTIVE ("Active"),
    COMPLETED ("Completed"),
    OVERDUE ("Overdue"),
    REJECTED ("Rejected"),
    CANCELED ("Canceled"),
    DAMAGED ("Damaged");

    public final String label;

    RequestStatuses(String label) {
        this.label =  label;
    }
}
