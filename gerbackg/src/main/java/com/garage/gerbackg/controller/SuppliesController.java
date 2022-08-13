package com.garage.gerbackg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.garage.gerbackg.model.Supplies;
import com.garage.gerbackg.repository.SuppliesRepository;

@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class SuppliesController {
	
	//Actions
	@Autowired
	private SuppliesRepository actions;
	
	//Get price
	@RequestMapping(value="/getprice", method=RequestMethod.POST)
	public @ResponseBody double getPrice(@RequestBody String productname) {
	return actions.findByProductname(productname).getUnitprice();

}
	
	//List
	@RequestMapping(value="/supplies", method=RequestMethod.GET)
	public @ResponseBody List<Supplies> listSupplies() {
		return actions.findAll();
	}
		
	//Create
	@RequestMapping(value="/supplies", method=RequestMethod.POST)
	public @ResponseBody Supplies createSupplies(@RequestBody Supplies supplies) {
		return actions.save(supplies);
	}
		
	//Find
	@RequestMapping(value="/supplies/{productname}", method=RequestMethod.GET)
	public @ResponseBody Supplies findSupplies(@PathVariable String productname) {
		return actions.findByProductname(productname);
	}
		
	//Update
	@RequestMapping(value="/supplies", method=RequestMethod.PUT)
	public @ResponseBody Supplies updateSupplies(@RequestBody Supplies supplies) {
		return actions.save(supplies);
	}
		
	//Delete
	@RequestMapping(value="/supplies/{productname}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteSupplies(@PathVariable String productname) {
		Supplies supplies = findSupplies(productname);
		this.actions.delete(supplies);
	}
	
}
