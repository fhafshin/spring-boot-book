package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shopping_card",schema = SchemaName.SchemaName)
public class ShoppingCard extends BaseEntityBook {

    private int count;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "factor_id")
    private Factor factor;


}
