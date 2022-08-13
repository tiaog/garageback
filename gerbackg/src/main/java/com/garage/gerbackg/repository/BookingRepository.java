package com.garage.gerbackg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.garage.gerbackg.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer>{
	

	List<Booking> findAll();
			

	Booking findByBookingid(int bookingid);
			
	void delete(Booking booking);
			
	<BookingTemp extends Booking> BookingTemp save(BookingTemp booking);
	
	List<Booking> findByBookingstatus(String bookingstatus);
	
	List<Booking> findByDate(String date);
	
	List<Booking> findByDateAndMechanic (String date, String mechanic);
	
	List<Booking> findByUserid (int userid);
	
}
