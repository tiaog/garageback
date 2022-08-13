package com.garage.gerbackg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.garage.gerbackg.model.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {
	
	List<Item> findAll();
				
	Item findByItemid(int itemid);
				
	void delete(Item item);
				
	<ItemTemp extends Item> ItemTemp save(ItemTemp item);

	List<Item> findByBookingid(int bookingid);

}
