package com.example.demo.controller;

import com.example.demo.entities.Person;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable int id){
        return "path variable id:"+id;
    }

    @GetMapping("/request-param")
    public String requestParam(@RequestParam int id){
        return "request param id:"+id;
    }

    @PostMapping("/new-person")
    public ResponseEntity<Person> newPerson(@RequestBody @Valid Person person){


        Person p=new Person();

        return ResponseEntity.ok(person);
    }


}
