package com.example.simple.repository;

import com.example.demo.simple.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByTasksName(String taskName); //how it makes join under the hood?

    //Optional<Person> findByContactInfoPhoneNumber(String phoneNumber);

    Optional<Person> findByFirstNameAndLastName(String firstName, String lastName);

    List<Person> findByAgeLessThanEqual(int age);

    List<Person> findByFirstNameStartingWith(String nameStartsWith);
}
