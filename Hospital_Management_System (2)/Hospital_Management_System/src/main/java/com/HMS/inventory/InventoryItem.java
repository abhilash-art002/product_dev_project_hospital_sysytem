package com.HMS.inventory;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity          
public class InventoryItem {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String itemName;
	    private int stockLevel;

	 
	    @OneToMany(mappedBy = "inventoryItem")
	    private List<Medicine> medicines;

	    @OneToMany(mappedBy = "inventoryItem")
	    private List<Equipment> equipments;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getItemName() {
			return itemName;
		}

		public void setItemName(String itemName) {
			this.itemName = itemName;
		}

		public int getStockLevel() {
			return stockLevel;
		}

		public void setStockLevel(int stockLevel) {
			this.stockLevel = stockLevel;
		}

		public List<Medicine> getMedicines() {
			return medicines;
		}

		public void setMedicines(List<Medicine> medicines) {
			this.medicines = medicines;
		}

		public List<Equipment> getEquipments() {
			return equipments;
		}

		public void setEquipments(List<Equipment> equipments) {
			this.equipments = equipments;
		} 
}
