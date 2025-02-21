package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
public class BaseEntityBook {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "sequence-generator")

    private Long id;


    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationDate;


    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;


    @Column
    private LocalDateTime deleted;


}
