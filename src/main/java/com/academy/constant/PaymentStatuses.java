package com.academy.constant;

public enum PaymentStatuses {
    WAIT ("Waiting"),
    REJECTED ("Rejected"),
    COMPLETED ("Completed");

    public final String label;

    PaymentStatuses(String label) {
        this.label =  label;
    }
}
