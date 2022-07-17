package com.project.indytskyi.model;

import javax.validation.constraints.*;

public class Book {
    private int book_id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 70, message = "Name should be between 2 and 30 characters")
    private String name;

    //    @NotEmpty(message = "Author should not be empty")
//    @Size(min = 2, max = 70, message = "Author should be between 2 and 30 characters")
    @Pattern(regexp = "[A-Z]\\w+ [A-Z]\\w+", message = "Author should be contains: Surname and Name ")
    private String author;

    @NotNull(message = "Year should be not empty")
    @Min(value = 0, message = "Year should be greater than 0")
    private int year;


    public Book() {
    }

    public Book(int book_id, String name, String author, int year) {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
        this.year = year;

    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
