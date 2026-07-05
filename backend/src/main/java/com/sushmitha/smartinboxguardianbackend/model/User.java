package com.sushmitha.smartinboxguardianbackend.model;

import jakarta.persistence.*;
//Let MySQL handle the numbering

import jakarta.persistence.Column;

import java.time.LocalDateTime;

//This is called an annotation. It tells Spring Boot:
//"Store this class in the database.
@Entity
@Table(name = "users")
public class User {

//    This tells Spring Boot:
//     "The id field is the primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;


    @Column(nullable = false)
    private String password;

    @Column(name= "created_at")
    private LocalDateTime createdAt;

    @Column(name= "updated_at")
    private LocalDateTime updatedAt;


//    This is called the no-argument constructor.
//    Spring Boot uses it internally when reading data from the database.
//     Even if you never call it, Spring Boot does.
    public  User(){

    }
    public User(String name, String email,String password) {

        this.name = name;
        this.email = email;
        this.password=password;
        this.createdAt=LocalDateTime.now();
        this.updatedAt=LocalDateTime.now();
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

    public String getPassword() { return password; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
}