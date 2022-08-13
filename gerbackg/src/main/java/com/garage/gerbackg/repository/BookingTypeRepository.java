package com.garage.gerbackg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.garage.gerbackg.model.BookingType;

public interface BookingTypeRepository extends CrudRepository<BookingType, String> {
	
	List<BookingType> findAll();
				
	BookingType findByName(String name);
				
	void delete(BookingType bookingtype);
				
	<ServiceTemp extends BookingType> ServiceTemp save(ServiceTemp bookingtype);
		
	List<BookingType> findByStatus(String status);

}
