package com.example.ms_card.model;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * Represents a credit/debit card with associated details.
 * This class serves as a model for card information and is used
 * in the application for validating card data during creation and updates.
 */
@Data
public class Card {

    /**
     * Unique identifier for the card.
     * This field is required and cannot be null.
     */
    @NotNull(message = "ID card is required")
    private int idCard;

    /**
     * Name of the cardholder.
     * This field is required, cannot be blank, and must not exceed 100 characters.
     */
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    /**
     * Card number.
     * This field is required, must be exactly 16 digits long.
     */
    @NotBlank(message = "Number is required")
    @Size(min = 16, max = 16, message = "Number must be 16 digits")
    private String number;

    /**
     * Type of the card (e.g., VISA, MasterCard).
     * This field is required and cannot be blank.
     */
    @NotBlank(message = "Type is required")
    private String type;

    /**
     * Card Verification Value (CVV).
     * This field must be a three-digit number, with a minimum value of 100
     * and a maximum value of 999.
     */
    @Min(value = 100, message = "CVV must be at least 3 digits")
    @Max(value = 999, message = "CVV cannot exceed 3 digits")
    private int cvv;

    /**
     * Status of the card.
     * This field must be either 0 (inactive) or 1 (active).
     */
    @Min(value = 0, message = "Status must be 0 or 1")
    @Max(value = 1, message = "Status must be 0 or 1")
    private int status;
}
