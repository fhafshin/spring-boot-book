package com.example.demo.entities;

import com.example.demo.common.enums.Payed;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "factor",schema = SchemaName.SchemaName)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Factor extends BaseEntityBook{
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "factor")
    private List<ShoppingCard> shoppingCards = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    private Payed payed;



}
