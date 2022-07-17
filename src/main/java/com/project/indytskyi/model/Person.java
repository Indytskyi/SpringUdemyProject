package com.project.indytskyi.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Calendar;

public class Person {

    private int person_id;

    @Pattern(regexp = "[A-Z]\\w+ [A-Z]\\w+ [A-Z]\\w+", message = "Your fio should be in this format: Surname Name " +
            "FatherName")
    private String fio;

    @Min(value = 1900, message = "Year should be greater than 1900")
    @Max(value = 2022, message = "Year should be less than 2022")
    private int yearOfBirth;

    public Person() {
    }

    public Person(int person_id, String fio, int yearOfBirth) {
        this.person_id = person_id;
        this.fio = fio;
        this.yearOfBirth = yearOfBirth;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
