package com.example.streamable.controller;

import com.example.streamable.model.Address;
import com.example.streamable.model.Person;
import com.example.streamable.service.PersonService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/names/{address}")
    public List<String> getPersonNamesByAddress(@PathVariable String address) {
        return personService.getPersonNamesByPhoneNumber(address);
    }

    //TODO: Populate DB with SQL script
    @PostMapping
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }
}
