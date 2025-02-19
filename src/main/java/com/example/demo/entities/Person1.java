package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "person")
public class Person1 extends BaseEntity {

@Column(name = "name",length = 20)
   private String name;
@Column(name = "lastname")
   private String lastname;

//@Column(scale = 6,nullable = false,unique = true,updatable = false)
//   private BigDecimal test;
}
