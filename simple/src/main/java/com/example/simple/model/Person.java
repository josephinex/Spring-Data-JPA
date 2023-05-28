package com.example.simple.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;


@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private int age;

    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_info_id", unique = true)
    private ContactInfo contactInfo;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Collection<Task> tasks = new ArrayList<>();
}
