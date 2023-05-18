package com.example.projection.model.classbased;


import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
public class PersonDto {

    @Id
    private final Long id;

    private final String firstName;

    private final String lastName;

    private final int age;
}
