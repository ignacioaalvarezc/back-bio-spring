package com.sys.bio.back.repositories.item;

import com.sys.bio.back.models.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
