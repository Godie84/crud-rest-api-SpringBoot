package com.example.ms_card.controller;

import com.example.ms_card.model.Card;
import com.example.ms_card.model.ServiceResponse;
import com.example.ms_card.service.ICardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CardController is responsible for handling all HTTP requests
 * related to Card operations such as listing, saving, updating, and deleting.
 */
@RestController
@RequestMapping("api/v1/card")
@CrossOrigin(origins = "*") // Allow requests from any client
public class CardController {

    private final ICardService iCardService;

    /**
     * Constructor-based dependency injection for the CardService.
     *
     * @param iCardService the service handling business logic for Cards
     */
    @Autowired
    public CardController(ICardService iCardService) {
        this.iCardService = iCardService;
    }

    /**
     * GET /list
     * Retrieves a list of all cards.
     *
     * @return a ResponseEntity containing the list of cards and an HTTP status code
     */
    @GetMapping("/list")
    public ResponseEntity<List<Card>> list() {
        List<Card> result = iCardService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * POST /save
     * Saves a new card to the database.
     *
     * @param card the Card object to be saved
     * @return a ResponseEntity containing a ServiceResponse and an HTTP status code
     */
    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@Valid @RequestBody Card card) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.save(card);

        if (result == 1) {
            serviceResponse.setSuccess(true);
            serviceResponse.setMessage("Card saved successfully");
            return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
        } else {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("Error saving card");
            return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * POST /update
     * Updates an existing card in the database.
     *
     * @param card the Card object with updated information
     * @return a ResponseEntity containing a ServiceResponse and an HTTP status code
     */
    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Card card) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.update(card);

        if (result == 1) {
            serviceResponse.setMessage("Card updated successfully");
        } else {
            serviceResponse.setMessage("Error updating card");
            return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    /**
     * DELETE /delete/{id}
     * Deletes a card from the database by its ID.
     *
     * @param id the ID of the card to be deleted
     * @return a ResponseEntity containing a ServiceResponse and an HTTP status code
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.deleteById(id);

        if (result == 1) {
            serviceResponse.setMessage("Card removed successfully");
        } else {
            serviceResponse.setMessage("Error removing card");
            return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
