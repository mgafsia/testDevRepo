package com.mga.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private Integer age;

    public User() {
    }

    public User(long id, User user) {
        this.id = id;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.age = user.age;
    }

    public User(long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }
}
