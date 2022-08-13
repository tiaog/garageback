package com.garage.gerbackg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.garage.gerbackg.model.Mechanic;

public interface MechanicRepository extends CrudRepository<Mechanic, String> {
	
	List<Mechanic> findAll();
			
	Mechanic findByName(String name);
			
	void delete(Mechanic mechanic);
			
	<MechanicTemp extends Mechanic> MechanicTemp save(MechanicTemp mechanic);
	
	List<Mechanic> findByStatus(String status);

}
