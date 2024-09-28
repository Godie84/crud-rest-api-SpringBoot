package com.example.ms_card.model;

import lombok.Data;

/**
 * The ServiceResponse class encapsulates the response sent from the service layer
 * to the controller, indicating the success or failure of an operation.
 */
@Data
public class ServiceResponse {

    /**
     * Indicates whether the operation was successful.
     */
    private Boolean success;

    /**
     * A message providing additional details about the operation's outcome.
     */
    private String message;

    /**
     * Constructor to create a ServiceResponse with a success status and a message.
     *
     * @param success Indicates if the operation was successful.
     * @param message Provides details about the operation.
     */
    public ServiceResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    /**
     * Default constructor initializing the response with a default message.
     */
    public ServiceResponse() {
        this.success = false; // Default to failure
        this.message = "Operation failed"; // Default message
    }
}


