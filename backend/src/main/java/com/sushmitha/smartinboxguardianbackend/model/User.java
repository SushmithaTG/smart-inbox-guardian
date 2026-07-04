package com.sushmitha.smartinboxguardianbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


//This is called an annotation. It tells Spring Boot:
//"Store this class in the database.
@Entity
public class User {

//    This tells Spring Boot:
//     "The id field is the primary key
    @Id
    private Long id;
    private String name;
    private String email;


//    This is called the no-argument constructor.
//    Spring Boot uses it internally when reading data from the database.
//     Even if you never call it, Spring Boot does.
    public  User(){

    }
    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}