package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@SequenceGenerator(name = "sequence-generator",initialValue = 1,sequenceName = "book_sequence")
@Getter
@Setter
@Table(name = "book",schema = SchemaName.SchemaName)
public class Book extends BaseEntityBook {

    private String name;
    private Long price;


    @OneToMany(mappedBy = "book")
    private List<ShoppingCard> shoppingCard;



}
