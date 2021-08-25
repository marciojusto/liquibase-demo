package com.example.liquibase.controller;

import com.example.liquibase.entity.Person;
import com.example.liquibase.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class LiquibaseController {

    private final PersonRepository personRepository;

    @PostMapping
    public Person createPerson(@RequestParam String name, @RequestParam String height, @RequestParam String address) {
        return personRepository.save(new Person(name, height, address));
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return (List<Person>) personRepository.findAll();
    }
}
