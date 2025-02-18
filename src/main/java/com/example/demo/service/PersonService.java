package com.example.demo.service;

import com.example.demo.entities.Person1;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person1 save(Person1 person) {
        return personRepository.save(person);
    }

    public Person1 update(Person1 person) {
        Person1 personSelected = personRepository
                .findById(person.getId()).orElseThrow(() -> new RuntimeException("person not found"));
        personSelected.setName(person.getName());
        personSelected.setLastname(person.getLastname());

        return personRepository.save(personSelected);
    }

    public List<Person1> findAll() {

        return personRepository.findAll();
    }

    public Person1 findOne(Long id) {

        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("person not found"));
    }

    public void delete(Long id) {

        personRepository.deleteById(id);
    }
}
