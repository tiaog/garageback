package com.garage.gerbackg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.garage.gerbackg.model.CarType;

public interface CarTypeRepository extends CrudRepository<CarType, String> {
	
	List<CarType> findAll();
					
	CarType findByName(String name);
					
	void delete(CarType carType);
					
	<CarTypeTemp extends CarType> CarTypeTemp save(CarTypeTemp carType);
			
	List<CarType> findByStatus(String status);

}
