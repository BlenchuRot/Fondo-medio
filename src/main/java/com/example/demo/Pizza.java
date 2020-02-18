package com.example.demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Pizza {

    private @Id @GeneratedValue Long id;
    private String name;
    private String role;

    Pizza() {
    }

    Pizza(String name, String role) {
        this.name = name;
        this.role = role;
    }
}