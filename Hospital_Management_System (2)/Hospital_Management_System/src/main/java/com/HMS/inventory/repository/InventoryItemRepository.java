package com.HMS.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HMS.inventory.InventoryItem;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long>{
	List<InventoryItem> findByStockLevelLessThan(int stockLevel);
}
