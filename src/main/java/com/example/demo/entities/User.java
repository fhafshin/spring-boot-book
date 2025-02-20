package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user", schema = SchemaName.SchemaName)
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntityBook {
    @Column(unique = true)
    private String username;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Factor> factors = new ArrayList<>();
}
