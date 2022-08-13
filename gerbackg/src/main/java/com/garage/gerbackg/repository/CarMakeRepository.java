package com.garage.gerbackg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.garage.gerbackg.model.CarMake;

public interface CarMakeRepository extends CrudRepository<CarMake, String> {
	
	List<CarMake> findAll();
				
	CarMake findByName(String name);
				
	void delete(CarMake make);
				
	<MakeTemp extends CarMake> MakeTemp save(MakeTemp make);
		
	List<CarMake> findByStatus(String status);

}
