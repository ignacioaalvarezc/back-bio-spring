package com.sys.bio.back.models.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "inventories")
public class Inventory {

    @Id
    private Long inventoryId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Item item;
    private Boolean type;
    private Integer amount;
    private Date date;
    private LocalTime hour;
}
