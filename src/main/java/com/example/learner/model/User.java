package com.example.learner.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users") //cant use User by default because it is a reserved keyword
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String passwordHash;
}
