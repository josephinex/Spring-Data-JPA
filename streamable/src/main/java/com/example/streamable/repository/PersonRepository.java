package com.example.streamable.repository;


import com.example.streamable.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Streamable<Person> findByAddressStreet(@Param("address") String address);
}
