package com.example.streamable.service;

import com.example.streamable.model.Address;
import com.example.streamable.model.Person;
import com.example.streamable.model.Task;
import com.example.streamable.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<String> getPersonNamesByPhoneNumber(String address) {
        return personRepository.findByAddressStreet(address)
                .stream()
                .filter(person -> person.getFirstName().startsWith("J"))
                .map(Person::getLastName)
                .toList();
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
}
