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
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book(name, author, year) VALUES (?, ?, ?)", book.getName(),
                book.getAuthor(), book.getYear());
    }

    public void update(int id, Book updateBook) {
        jdbcTemplate.update("UPDATE book SET name=?, author=?, year=? WHERE book_id=?",
                updateBook.getName(), updateBook.getAuthor(), updateBook.getYear(), id);
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE book_id=?", new BeanPropertyRowMapper<>(Book.class), id)
                .stream().findAny().orElse(null);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE book_id=?", id);
    }



    public Optional<Person> getBookOwner(int id) {
        return jdbcTemplate.query("SELECT person.* FROM book JOIN person ON book.person_id = person.person_id " +
                        "WHERE book.book_id = ?",  new BeanPropertyRowMapper<>(Person.class), id)
                .stream().findAny();
    }

    public void release(int id) {
        jdbcTemplate.update("UPDATE book SET person_id=NULL WHERE book_id=?", id);
    }

    public void appoint(int id, Person person) {
        jdbcTemplate.update("UPDATE book SET person_id=? WHERE book_id=?", person.getPerson_id(), id);
    }
}
