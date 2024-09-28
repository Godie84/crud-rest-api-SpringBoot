package com.example.ms_card.repository;

import com.example.ms_card.model.Card;

import java.util.List;

/**
 * Repository interface for managing Card entities.
 */
public interface ICardRepository {

    /**
     * Retrieves a list of all Card entities.
     *
     * @return a List of Card objects.
     */
    List<Card> findAll();

    /**
     * Saves a new Card entity.
     *
     * @param card the Card entity to save.
     * @return the number of rows affected.
     */
    int save(Card card);

    /**
     * Updates an existing Card entity.
     *
     * @param card the Card entity with updated values.
     * @return the number of rows affected.
     */
    int update(Card card);

    /**
     * Marks a Card entity as inactive (status = 0).
     *
     * @param id the ID of the Card entity to delete.
     * @return the number of rows affected.
     */
    int deleteById(int id);
}
