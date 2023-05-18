package com.example.simple.service;

import com.example.demo.simple.model.Person;
import com.example.demo.simple.model.Task;
import com.example.simple.repository.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person findByTaskName(String taskName){
        return personRepository.findByTasksName(taskName).orElseThrow();
    }

    public Person findByFullName(String firstName, String lastName){
        return personRepository.findByFirstNameAndLastName(firstName, lastName).orElseThrow();
    }

    public Person save(Person person) {
        for (Task task : person.getTasks()) {
            task.setPerson(person);
        }
        return personRepository.save(person);
    }

    public void delete(Long id){
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

    public List<Person> findAll(){
        return personRepository.findAll();
    }
}
