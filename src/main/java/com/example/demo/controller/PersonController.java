package com.example.demo.controller;

import com.example.demo.entities.Person1;
import com.example.demo.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;

    }

    @PostMapping("/create")
    public ResponseEntity<Person1> create(@RequestBody Person1 person) {

        var new_person = personService.save(person);

        return ResponseEntity.ok(new_person);
    }

    @GetMapping("/test")
    public String test() {
        return personService.test();
    }

    @PutMapping("/update")
    public ResponseEntity<Person1> update(@RequestBody Person1 person) {

        return ResponseEntity.ok(personService.update(person));
    }

    @GetMapping("/find-all")
    public List<Person1> findAll() {
        return personService.findAll();
    }

    @GetMapping("/find-one/{id}")
    public ResponseEntity<Person1> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findOne(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        personService.delete(id);

        return ResponseEntity.ok().build();
    }
}
