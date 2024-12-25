package com.HMS.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMS.inventory.Equipment;
import com.HMS.inventory.InventoryItem;
import com.HMS.inventory.Medicine;
import com.HMS.inventory.service.InventoryService;

@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	@Autowired
    private InventoryService inventoryService;

	// Medicines CRUD Endpoints

    @GetMapping("/medicines")
    public List<Medicine> getAllMedicines() {
        return inventoryService.getAllMedicines();
    }

    @GetMapping("/medicines/{id}")
    public Optional<Medicine> getMedicineById(@PathVariable Long id) {
        return inventoryService.getMedicineById(id);
    }

    @PostMapping("/medicines")
    public void addMedicine(@RequestBody Medicine medicine) {
        inventoryService.saveMedicine(medicine);
    }

    @PutMapping("/medicines/{id}")
    public void updateMedicine(@PathVariable Long id, @RequestBody Medicine updatedMedicine) {
        inventoryService.updateMedicine(id, updatedMedicine);
    }

    @DeleteMapping("/medicines/{id}")
    public void deleteMedicine(@PathVariable Long id) {
        inventoryService.deleteMedicine(id);
    }

    // Equipment CRUD Endpoints

    @GetMapping("/equipment")
    public List<Equipment> getAllEquipment() {
        return inventoryService.getAllEquipment();
    }

    @GetMapping("/equipment/{id}")
    public Optional<Equipment> getEquipmentById(@PathVariable Long id) {
        return inventoryService.getEquipmentById(id);
    }

    @PostMapping("/equipment")
    public void addEquipment(@RequestBody Equipment equipment) {
        inventoryService.saveEquipment(equipment);
    }

    @PutMapping("/equipment/{id}")
    public void updateEquipment(@PathVariable Long id, @RequestBody Equipment updatedEquipment) {
        inventoryService.updateEquipment(id, updatedEquipment);
    }

    @DeleteMapping("/equipment/{id}")
    public void deleteEquipment(@PathVariable Long id) {
        inventoryService.deleteEquipment(id);
    }

    // Low stock alert endpoint
    @GetMapping("/low-stock")
    public List<InventoryItem> getLowStockItems() {
        return inventoryService.checkLowStock();
    }
}
