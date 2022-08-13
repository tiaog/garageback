package com.garage.gerbackg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.garage.gerbackg.model.Mechanic;
import com.garage.gerbackg.repository.MechanicRepository;

@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class MechanicController {
	
	//Actions
	@Autowired
	private MechanicRepository actions;
	
	//List mechanics
	@RequestMapping(value="/mechanic", method=RequestMethod.GET)
	public @ResponseBody List<Mechanic> listMechanic() {
		return actions.findAll();
	}
			
	//Create
	@RequestMapping(value="/mechanic", method=RequestMethod.POST)
	public @ResponseBody Mechanic createMechanic(@RequestBody Mechanic mechanic) {
		return actions.save(mechanic);
	}
			
	//Find
	@RequestMapping(value="/mechanic/{name}", method=RequestMethod.GET)
	public @ResponseBody Mechanic findMechanic(@PathVariable String name) {
		return actions.findByName(name);
	}
			
	//Update
	@RequestMapping(value="/mechanic", method=RequestMethod.PUT)
	public @ResponseBody Mechanic updateMechanic(@RequestBody Mechanic mechanic) {
		return actions.save(mechanic);
	}
			
	//Delete
	@RequestMapping(value="/mechanic/{name}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteMechanic(@PathVariable String name) {
		Mechanic mechanic = findMechanic(name);
		this.actions.delete(mechanic);
	}
	
	//Active mechanics
	@RequestMapping(value="/activemechanics", method=RequestMethod.GET)
	public @ResponseBody List<Mechanic> activeMechanic() {
		return actions.findByStatus("active");
	}

}
