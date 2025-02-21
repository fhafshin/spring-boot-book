package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.processing.SQL;

import java.util.List;

@Entity
@SequenceGenerator(name = "sequence-generator",initialValue = 1,sequenceName = "book_sequence")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book",schema = SchemaName.SchemaName)
@Where(clause = "deleted is null")
@SQLDelete(sql = "update shop.book set deleted =now() where id=?")
public class Book extends BaseEntityBook {

    private String name;
    private Long price;



    @OneToMany(mappedBy = "book")
    private List<ShoppingCard> shoppingCard;



}
