package com.garage.gerbackg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.garage.gerbackg.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>{
	
	List<Admin> findAll();
	
	Admin findByEmailAndPassword (String email, String password);
		
	Admin findByAdminid(int adminid);
	
	<AdminTemp extends Admin> AdminTemp save(AdminTemp admin);
	
	void delete(Admin admin);
		
	Admin findByEmail(String email);

}