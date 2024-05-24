package com.sys.bio.back.models.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item {

    @Id
    private Long itemId;

    private String name;

    private String format;

    private String description;

    private Integer currentAmount;
    private Integer totalIncomes;
    private Integer totalExpenses;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

}
