package com.example.simple.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("EMAIL")
//@PrimaryKeyJoinColumn(name = "email_id")
public class Email extends ContactInfo {
    private String emailAddress;
}
