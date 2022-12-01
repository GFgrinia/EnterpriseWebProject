package com.academy.constant;

public enum MessageManager {
    DELETE_SUCCESS("Element was deleted successfully."),
    DELETE_ERROR("Error deleting element. No such element."),
    ADD_CAR_ERROR("Error adding new car."),
    REGISTRATION_SUCCESSFUL("Successful new user registration."),
    WRONG_CREDENTIALS("Check input data."),
    USERNAME_EXIST("Username exist"),
    ADD_CAR_SUCCESS("Car updated successfully."),
    ADD_REQUEST_SUCCESS("New request placed successfully"),
    REJECT_REASON("Request rejected by admin because of .....");

    public final String label;

    MessageManager(String label) {
        this.label =  label;
    }
}
