package com.example.ms_card.repository;

import com.example.ms_card.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository class for managing Card entities in the database.
 */
@Repository
public class CardRepository implements ICardRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Retrieves a list of all active cards (status = 1).
     *
     * @return List of active Card entities.
     */
    @Override
    public List<Card> findAll() {
        String SQL = "SELECT * FROM cards WHERE status = 1";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Card.class));
    }

    /**
     * Saves a new Card entity in the database.
     *
     * @param card the Card entity to save.
     * @return the number of rows affected.
     */
    @Override
    public int save(Card card) {
        String SQL = "INSERT INTO cards (name, number, type, cvv, status) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(SQL, card.getName(), card.getNumber(), card.getType(), card.getCvv(), card.getStatus());
    }

    /**
     * Updates an existing Card entity in the database.
     *
     * @param card the Card entity with updated values.
     * @return the number of rows affected.
     */
    @Override
    public int update(Card card) {
        String SQL = "UPDATE cards SET name = ?, number = ?, type = ?, cvv = ? WHERE id_card = ?";
        return jdbcTemplate.update(SQL, card.getName(), card.getNumber(), card.getType(), card.getCvv(), card.getIdCard());
    }


    /**
     * Marks a Card entity as inactive (status = 0) in the database.
     *
     * @param id the ID of the Card entity to delete.
     * @return the number of rows affected.
     */
    @Override
    public int deleteById(int id) {
        String SQL = "UPDATE cards SET status = 0 WHERE id_card = ?";
        return jdbcTemplate.update(SQL, id);
    }
}
