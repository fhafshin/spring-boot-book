package com.example.demo.entities;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {


    @NotNull
    private Long id;


    @Setter(AccessLevel.NONE)
    private String name;

    public Person(String name, Long id) {
        this.name = name;
        this.id = id;
    }


}
