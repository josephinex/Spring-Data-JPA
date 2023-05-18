package com.example.simple.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("PHONE")
//@PrimaryKeyJoinColumn(name = "phone_id")
public class Phone extends ContactInfo{

    private String phoneNumber;
}
