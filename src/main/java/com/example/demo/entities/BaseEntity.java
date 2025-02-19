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
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long lastModifiedUserId;
    private Long creatorUserId;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationDate;
    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;

}
