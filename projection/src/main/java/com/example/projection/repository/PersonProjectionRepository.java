package com.example.projection.repository;

import com.example.projection.interfacebased.NamesOnly;
import com.example.projection.model.Person;
import com.example.projection.model.classbased.PersonDto;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PersonProjectionRepository extends Repository<Person, Long> {
    PersonDto findByFirstName(String firstName);

    List<NamesOnly> findByAddressStreet(String streetName);
}
