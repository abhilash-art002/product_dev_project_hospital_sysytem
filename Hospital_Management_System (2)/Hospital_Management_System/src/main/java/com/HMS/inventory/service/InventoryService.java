package com.HMS.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.inventory.Equipment;
import com.HMS.inventory.InventoryItem;
import com.HMS.inventory.Medicine;
import com.HMS.inventory.repository.EquipmentRepository;
import com.HMS.inventory.repository.InventoryItemRepository;
import com.HMS.inventory.repository.MedicineRepository;

@Service
public class InventoryService {
	@Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private InventoryItemRepository inventoryItemRepository;
 // CRUD operations for Medicines
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public Optional<Medicine> getMedicineById(Long id) {
        return medicineRepository.findById(id);
    }

    public void saveMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    public void updateMedicine(Long id, Medicine updatedMedicine) {
        if (medicineRepository.existsById(id)) {
            updatedMedicine.setId(id);
            medicineRepository.save(updatedMedicine);
        }
    }

    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }

    // CRUD operations for Equipment
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    public Optional<Equipment> getEquipmentById(Long id) {
        return equipmentRepository.findById(id);
    }

    public void saveEquipment(Equipment equipment) {
        equipmentRepository.save(equipment);
    }
              
    public void updateEquipment(Long id, Equipment updatedEquipment) {
        if (equipmentRepository.existsById(id)) {
            updatedEquipment.setId(id);
            equipmentRepository.save(updatedEquipment);
        }
    }

    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }

    // Low stock check for InventoryItems
    public List<InventoryItem> checkLowStock() {
        return inventoryItemRepository.findByStockLevelLessThan(10); // Example threshold
    }

   }
