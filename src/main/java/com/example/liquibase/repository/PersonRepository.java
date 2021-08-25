package com.example.liquibase.repository;

import com.example.liquibase.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("SELECT p.name FROM Person p WHERE p.name LIKE %:personName%")
    Person findByName(String personName);

}
