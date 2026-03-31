package com.example.learner.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users") //cant use User by default because it is a reserved keyword
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String passwordHash;

    public User(){
    }

    public User(String username, String passwordHash){
        this.username = username;
        this.passwordHash = passwordHash;
    }

}
