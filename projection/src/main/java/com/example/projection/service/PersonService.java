package com.example.projection.service;


import com.example.projection.interfacebased.NamesOnly;
import com.example.projection.model.Person;
import com.example.projection.model.Task;
import com.example.projection.model.classbased.PersonDto;
import com.example.projection.repository.PersonProjectionRepository;
import com.example.projection.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonProjectionRepository personProjectionRepository;

    public Person findByTaskName(String taskName) {
        return personRepository.findByTasksName(taskName).orElseThrow();
    }

    public Person findByFullName(String firstName, String lastName) {
        return personRepository.findByFirstNameAndLastName(firstName, lastName).orElseThrow();
    }

    public Person save(Person person) {
        for (Task task : person.getTasks()) {
            task.setPerson(person);
        }
        return personRepository.save(person);
    }

    public void delete(Long id) {
        Person person = personRepository.findById(id).get();
        for (Task task : person.getTasks()) {
            task.setPerson(null);
        }
        personRepository.deleteById(id);
    }

    public List<Person> findByAgeLessOrEqual(int age) {
        return personRepository.findByAgeLessThanEqual(age);
    }

    public List<Person> findByFirstNameStartingWith(String nameStartsWith) {
        return personRepository.findByFirstNameStartingWith(nameStartsWith);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public PersonDto findByFirstName(String firstName) {
        return personProjectionRepository.findByFirstName(firstName);
    }

    public List<NamesOnly> findByAddress(String street) {
        return personProjectionRepository.findByAddressStreet(street);
    }

    public Person findByEmail(String emailAddress) {
        return personRepository.findByEmail(emailAddress);
    }
}
