package com.example.projection.controller;


import com.example.projection.interfacebased.NamesOnly;
import com.example.projection.model.Person;
import com.example.projection.model.classbased.PersonDto;
import com.example.projection.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{taskName}")
    public Person findByTaskName(@PathVariable("taskName") String taskName) {
        return personService.findByTaskName(taskName);
    }

    @GetMapping("/credential")
    public Person findByFullName(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        return personService.findByFullName(firstName, lastName);
    }

    @GetMapping
    public List<Person> findByAgeLessOrEqual(@RequestParam("age") int age) {
        return personService.findByAgeLessOrEqual(age);
    }

    @GetMapping("/name")
    public List<Person> findBy(@RequestParam("startWith") String nameStartsWith) {
        return personService.findByFirstNameStartingWith(nameStartsWith);
    }

    @GetMapping("/persons")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/projection")
    public PersonDto findByFirstName(@RequestParam String firstName) {
        return personService.findByFirstName(firstName);
    }

    @GetMapping("/projection/{street}")
    public List<NamesOnly> findByAddress(@PathVariable("street") String street) {
        return personService.findByAddress(street);
    }

    @GetMapping("/named")
    public Person findByEmail(@RequestParam String emailAddress) {
        return personService.findByEmail(emailAddress);
    }

    //TODO: Populate DB with SQL script
    @PostMapping
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }
}
