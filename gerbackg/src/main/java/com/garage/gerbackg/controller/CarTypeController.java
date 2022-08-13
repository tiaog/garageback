package com.garage.gerbackg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.garage.gerbackg.model.CarType;
import com.garage.gerbackg.repository.CarTypeRepository;

@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class CarTypeController {
	
	//Actions
	
	@Autowired
	private CarTypeRepository actions;
	
	//List
	@RequestMapping(value="/cartype", method=RequestMethod.GET)
	public @ResponseBody List<CarType> listCarType() {
		return actions.findAll();
	}
					
	//Create
	@RequestMapping(value="/cartype", method=RequestMethod.POST)
	public @ResponseBody CarType createCarType(@RequestBody CarType carType) {
		return actions.save(carType);
	}
					
	//Find
	@RequestMapping(value="/cartype/{name}", method=RequestMethod.GET)
	public @ResponseBody CarType findCarType(@PathVariable String name) {
		return actions.findByName(name);
	}
					
	//Update
	@RequestMapping(value="/cartype", method=RequestMethod.PUT)
	public @ResponseBody CarType updateCarType(@RequestBody CarType carType) {
		return actions.save(carType);
	}
					
	//Delete
	@RequestMapping(value="/cartype/{name}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteCarType(@PathVariable String name) {
		CarType carType = findCarType(name);
		this.actions.delete(carType);
	}
			
	//Active
	@RequestMapping(value="/activecartype", method=RequestMethod.GET)
	public @ResponseBody List<CarType> activeCarType() {
		return actions.findByStatus("active");
	}

}
