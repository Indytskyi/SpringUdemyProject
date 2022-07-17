package com.project.indytskyi.dao;

import com.project.indytskyi.model.Book;
import com.project.indytskyi.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Optional<Person> show(String fio) {
        return jdbcTemplate.query("SELECT  * FROM person WHERE fio=?", new BeanPropertyRowMapper<>(Person.class),
                fio).stream().findAny();
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE person_id=?",  new BeanPropertyRowMapper<>(Person.class), id)
                .stream().findAny().orElse(null);

    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person(fio, yearofbirth) VALUES (?,?)",
                person.getFio(), person.getYearOfBirth());
    }

    public void update(int id, Person updatePerson) {
        jdbcTemplate.update("UPDATE person SET fio=?, yearofbirth=? WHERE person_id=?",
                updatePerson.getFio(), updatePerson.getYearOfBirth(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE person_id=?", id);
    }

    public List<Book> getBookByPersonId(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE person_id=?", new BeanPropertyRowMapper<>(Book.class), id);
    }


}
