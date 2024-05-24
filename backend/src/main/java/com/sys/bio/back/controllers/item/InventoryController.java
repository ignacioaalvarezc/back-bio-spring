package com.sys.bio.back.controllers.item;

import com.sys.bio.back.controllers.user.AuthenticationController;
import com.sys.bio.back.models.item.Inventory;
import com.sys.bio.back.models.item.Item;
import com.sys.bio.back.services.item.InventoryService;
import com.sys.bio.back.services.item.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/inventories")
@CrossOrigin("*")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);


    @PostMapping("/")
    public ResponseEntity<Inventory> saveInventory(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.addInventory(inventory));
    }

    @PutMapping("/update/{inventoryId}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable("inventoryId") Long inventoryId,
                                           @Valid @RequestBody Inventory inventory) {
        try {
            inventory.setInventoryId(inventoryId);
            Inventory updatedInventory = inventoryService.updateInventory(inventory);
            return ResponseEntity.ok(updatedInventory);
        } catch (Exception e) {
            log.error("Error al actualizar el inventario con ID: " + inventoryId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> listInventories() {
        return ResponseEntity.ok(inventoryService.getInventories());
    }

    @GetMapping("/id/{inventoryId}")
    public Inventory listInventory(@PathVariable("inventoryId") Long inventoryId) {
        return inventoryService.getInventory(inventoryId);
    }


    @DeleteMapping("/{inventoryId}")
    public void deleteInventory(@PathVariable("inventoryId") Long inventoryId) {
        inventoryService.deleteInventory(inventoryId);
    }
}
