package com.sys.bio.back.repositories.item;

import com.sys.bio.back.models.item.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
