package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "factor",schema = SchemaName.SchemaName)
@Getter
@Setter
public class Factor extends BaseEntityBook{
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "factor")
    private List<ShoppingCard> shoppingCards = new ArrayList<>();

}
