package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shopping_card",schema = SchemaName.SchemaName)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ShoppingCard extends BaseEntityBook {

    private int count;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "factor_id")
    private Factor factor;


}
