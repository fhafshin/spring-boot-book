package com.example.demo.service;

import com.example.demo.entities.Person1;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {

    public Person1 save(Person1 person);

    public Person1 update(Person1 person);

    public void delete(Long id);

    public List<Person1> findAll();

    public Person1 findOne(Long id);

    public String test();

    public Person1 findByNameAndLastName(String name, String lastname);

   public Person1 findbyNameStartSTr(String name);
}
