package com.garage.gerbackg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.garage.gerbackg.model.BookingType;
import com.garage.gerbackg.repository.BookingTypeRepository;

@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class BookingTypeController {

	@Autowired
	private BookingTypeRepository actions;
	
	//List
	@RequestMapping(value="/bookingtype", method=RequestMethod.GET)
	public @ResponseBody List<BookingType> listBookingType() {
		return actions.findAll();
	}
				
	//Create
	@RequestMapping(value="/bookingtype", method=RequestMethod.POST)
	public @ResponseBody BookingType createBookingType(@RequestBody BookingType bookingtype) {
		return actions.save(bookingtype);
	}
				
	//Find
	@RequestMapping(value="/bookingtype/{name}", method=RequestMethod.GET)
	public @ResponseBody BookingType findBookingType(@PathVariable String name) {
		return actions.findByName(name);
	}
				
	//Update
	@RequestMapping(value="/bookingtype", method=RequestMethod.PUT)
	public @ResponseBody BookingType updateBookingType(@RequestBody BookingType bookingtype) {
		return actions.save(bookingtype);
	}
				
	//Delete service
	@RequestMapping(value="/bookingtype/{name}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteBookingType(@PathVariable String name) {
		BookingType bookingtype = findBookingType(name);
		this.actions.delete(bookingtype);
	}
		
	//Active
	@RequestMapping(value="/activebookingtypes", method=RequestMethod.GET)
	public @ResponseBody List<BookingType> activeBookingType() {
		return actions.findByStatus("active");
	}

	
}
