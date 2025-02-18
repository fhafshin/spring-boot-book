package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "person")
public class Person1 {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="sequence_generator" )
   @SequenceGenerator(name = "sequence_generator" ,allocationSize = 1,initialValue = 1)
   private Long id;

   private String name;

   private String lastname;


}
