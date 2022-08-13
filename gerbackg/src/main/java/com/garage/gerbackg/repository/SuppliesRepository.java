package com.garage.gerbackg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.garage.gerbackg.model.Supplies;

public interface SuppliesRepository extends CrudRepository<Supplies, String> {
	
	List<Supplies> findAll();
		
	Supplies findByProductname(String productname);
		
	void delete(Supplies supplies);
		
	<SuppliesTemp extends Supplies> SuppliesTemp save(SuppliesTemp supplies);

}
