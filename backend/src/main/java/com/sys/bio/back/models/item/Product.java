package com.sys.bio.back.models.item;

import com.sys.bio.back.models.packaging.BoxFormat;
import com.sys.bio.back.models.packaging.BoxName;
import com.sys.bio.back.models.packaging.Provider;
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
@Table(name = "products")
public class Product {

    @Id
    private Long productId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Provider provider;
    @ManyToOne(fetch = FetchType.EAGER)
    private BoxName boxName;
    @ManyToOne(fetch = FetchType.EAGER)
    private BoxFormat boxFormat;

    private Integer strawAmount;
    private Integer currentAmount;


}
