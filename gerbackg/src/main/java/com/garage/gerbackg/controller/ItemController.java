package com.garage.gerbackg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.garage.gerbackg.model.Item;
import com.garage.gerbackg.repository.ItemRepository;

@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class ItemController {
	
	//Actions
	@Autowired
	private ItemRepository actions;
	
	//List
	@RequestMapping(value="/item", method=RequestMethod.GET)
	public @ResponseBody List<Item> listItem() {
		return actions.findAll();
	}
	
	//Create
	@RequestMapping(value="/item", method=RequestMethod.POST)
	public @ResponseBody Item createItem(@RequestBody Item item) {
		item.setTotalprice(item.getUnitprice() * item.getQuantity()); 
		return actions.save(item);
	}
	
	//Find
	@RequestMapping(value="/item/{itemid}", method=RequestMethod.GET)
	public @ResponseBody Item findItem(@PathVariable Integer itemid) {
		return actions.findByItemid(itemid);
	}
			
	//Update
	@RequestMapping(value="/item", method=RequestMethod.PUT)
	public @ResponseBody Item updateItem(@RequestBody Item item) {
		return actions.save(item);
	}
			
	//Delete
	@RequestMapping(value="/item/{itemid}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteItem(@PathVariable Integer itemid) {
		Item item = findItem(itemid);
		this.actions.delete(item);
	}
	
	//List
	@RequestMapping(value="/finditem/{bookingid}", method=RequestMethod.GET)
	public @ResponseBody List<Item> findItemById(@PathVariable Integer bookingid) {
		return actions.findByBookingid(bookingid);
	}

}
