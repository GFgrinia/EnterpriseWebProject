package com.academy.constant;

public enum MessageManager {
    DELETE_SUCCESS("Element was deleted successfully."),
    DELETE_ERROR("Error deleting element. No such element."),

    ADD_CAR_ERROR("Error adding new car."),

    ADD_CAR_SUCCESS("Car added successfully.");

    public final String label;

    MessageManager(String label) {
        this.label =  label;
    }
}
