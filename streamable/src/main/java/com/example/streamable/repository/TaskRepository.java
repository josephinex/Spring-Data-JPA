package com.example.streamable.repository;

import com.example.streamable.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    @Query("select t from Task t where t.name = ?1")
    List<Task> findByTaskName(String taskName);

    //Named Parameters
    @Query("select t from Task t where t.person.firstName = :firstName and t.person.lastName = :lastName")
    List<Task> findByPerson(@Param("firstName") String firstName, @Param("lastName") String lastName);

    //SpEL expressions
    @Query("select t from #{#entityName} t where t.name like ?1%")
    List<Task> findTasksStartWith(@Param("name") String name);
}
