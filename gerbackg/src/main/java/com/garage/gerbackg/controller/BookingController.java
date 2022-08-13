package com.garage.gerbackg.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.garage.gerbackg.model.Booking;
import com.garage.gerbackg.model.Item;
import com.garage.gerbackg.repository.ItemRepository;
import com.garage.gerbackg.repository.BookingRepository;
import com.garage.gerbackg.repository.SuppliesRepository;

@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class BookingController {
	
	@Autowired
	private BookingRepository actions;
		
	@Autowired
	private ItemRepository actions2;
	
	@Autowired
	private SuppliesRepository actions3;
		
	@RequestMapping(value="/bookings", method=RequestMethod.GET)
	public @ResponseBody List<Booking> listUsers() {
		return actions.findAll();
	}
		
	//New booking
	@RequestMapping(value="/bookings", method=RequestMethod.POST)
	public @ResponseBody Booking createBooking(@RequestBody Booking booking) {
		return actions.save(booking);
	}
		
	//Find a booking
	@RequestMapping(value="/bookings/{bookingid}", method=RequestMethod.GET)
	public @ResponseBody Booking findBooking(@PathVariable Integer bookingid) {
		return actions.findByBookingid(bookingid);
	}
		
	//Update a booking
	@RequestMapping(value="/bookings", method=RequestMethod.PUT)
	public @ResponseBody Booking updateBooking(@RequestBody Booking booking) {
		return actions.save(booking);
	}
		
	//Delete a booking
	@RequestMapping(value="/bookings/{bookingid}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteBooking(@PathVariable Integer bookingid) {
		Booking booking = findBooking(bookingid);
		this.actions.delete(booking);
	}
		
	//Create new booking / item charge
	@RequestMapping(value="/newbooking", method=RequestMethod.POST)
	public @ResponseBody boolean newBooking(@RequestBody Booking booking) {
		booking.setBookingstatus("Booked");
		Item bkItm = new Item();
		if (booking.getBookingtype().equals("Annual Service")) {
			booking.setServicetime(1);
		} else if (booking.getBookingtype().equals("Major Service")) {
			booking.setServicetime(2);
		} else if (booking.getBookingtype().equals("Repair/Fault")) {
			booking.setServicetime(1);
		} else if (booking.getBookingtype().equals("Major Repair")) {
			booking.setServicetime(2);
	}
		actions.save(booking);
		String chargename = booking.getBookingtype() + " charge";
		bkItm.setProductname(chargename);
		bkItm.setBookingid(booking.getBookingid());
		bkItm.setUnitprice(actions3.findByProductname(chargename).getUnitprice());
		bkItm.setQuantity(1);
		bkItm.setTotalprice(bkItm.getUnitprice() * bkItm.getQuantity());
		actions2.save(bkItm);
		return true;
	}
		
	//List by booking status and sort by date
	@RequestMapping(value="/bookingsbystatus/{bookingstatus}", method=RequestMethod.GET)
	public @ResponseBody List<Booking> listBookingsByStatus(@PathVariable String bookingstatus) {
		List<Booking> orderedBookings = actions.findByBookingstatus(bookingstatus);
		Comparator<Booking> compareByDate = (Booking o1, Booking o2) -> o1.getDate().compareTo( o2.getDate() );
		Collections.sort(orderedBookings, compareByDate);
		return orderedBookings;
	}
		
	//List of bookings by date
	@RequestMapping(value="/bookingsbydate/{date}", method=RequestMethod.GET)
	public @ResponseBody List<Booking> listBookingsByDate(@PathVariable String date) {
		return actions.findByDate(date);
	}
		
	//Change bookings by status
	@RequestMapping(value="/changestatus/{bookingid}/{bookingstatus}", method=RequestMethod.GET)
	public @ResponseBody Booking changeStatus(@PathVariable int bookingid, @PathVariable String bookingstatus) {
		Booking booking = findBooking(bookingid);
		booking.setBookingstatus(bookingstatus);
		return actions.save(booking);
	}
		
	//Roster by Date/Mechanic
	@RequestMapping(value="/roster/{date}/{mechanic}", method=RequestMethod.GET)
	public List<Booking> listByDateAndMechanic(@PathVariable String date, @PathVariable String mechanic){
		return actions.findByDateAndMechanic(date, mechanic);
	}
		
	//Mechanic Availability
	@RequestMapping(value="/changemechanic/{bookingid}/{mechanic}", method=RequestMethod.GET)
	public @ResponseBody int changeMechanic(@PathVariable int bookingid, @PathVariable String mechanic) {
	Booking booking = findBooking(bookingid);
	List<Booking> dailyBookings = listByDateAndMechanic(booking.getDate(), mechanic);
	int totalTime = 0;
	for (int i = 0; i < dailyBookings.size(); i++) {
		totalTime += dailyBookings.get(i).getServicetime();
	}
	if (totalTime + booking.getServicetime() <= 4) {
		booking.setMechanic(mechanic);
		actions.save(booking);
	}
		return totalTime + booking.getServicetime();
	}
	
	//Last car registered
	@RequestMapping(value="/lastdetails/{userid}", method=RequestMethod.GET)
	public @ResponseBody Booking lastCarDetails(@PathVariable int userid) {
	List<Booking> userBookings = actions.findByUserid(userid);
	Comparator<Booking> compareByDate = (Booking o1, Booking o2) -> o1.getDate().compareTo( o2.getDate() );
	Collections.sort(userBookings, compareByDate);
		return userBookings.get(userBookings.size() - 1);
	}
	
	//Check last booking
	@RequestMapping(value="/userhasbookings/{userid}", method=RequestMethod.GET)
	public @ResponseBody boolean userHasBookings(@PathVariable int userid) {
	List<Booking> userBookings = actions.findByUserid(userid);
	if (userBookings.isEmpty()) {
		return false;
	} else {
		return true;
	}
	}

}
