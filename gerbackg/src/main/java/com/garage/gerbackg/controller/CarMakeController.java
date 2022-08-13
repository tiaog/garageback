package com.garage.gerbackg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.garage.gerbackg.model.CarMake;
import com.garage.gerbackg.repository.CarMakeRepository;

@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class CarMakeController {
	
	@Autowired
	private CarMakeRepository actions;
	
	//List
	@RequestMapping(value="/carmake", method=RequestMethod.GET)
	public @ResponseBody List<CarMake> listCarMake() {
		return actions.findAll();
	}
				
	//Create
	@RequestMapping(value="/carmake", method=RequestMethod.POST)
	public @ResponseBody CarMake createCarMake(@RequestBody CarMake carmake) {
		return actions.save(carmake);
	}
				
	//Find
	@RequestMapping(value="/carmake/{name}", method=RequestMethod.GET)
	public @ResponseBody CarMake findCarMake(@PathVariable String name) {
		return actions.findByName(name);
	}
				
	//Update
	@RequestMapping(value="/carmake", method=RequestMethod.PUT)
	public @ResponseBody CarMake updateCarMake(@RequestBody CarMake carmake) {
		return actions.save(carmake);
	}
				
	//Delete
	@RequestMapping(value="/carmake/{name}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteCarMake(@PathVariable String name) {
		CarMake carmake = findCarMake(name);
		this.actions.delete(carmake);
	}
		
	//Active
	@RequestMapping(value="/activecarmake", method=RequestMethod.GET)
	public @ResponseBody List<CarMake> activeCarMake() {
		return actions.findByStatus("active");
	}

}
