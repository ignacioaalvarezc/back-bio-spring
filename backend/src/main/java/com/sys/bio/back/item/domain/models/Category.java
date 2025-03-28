package com.sys.bio.back.item.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sys.bio.back.item.domain.models.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    private Long categoryId;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Item> items = new LinkedHashSet<>();
}
