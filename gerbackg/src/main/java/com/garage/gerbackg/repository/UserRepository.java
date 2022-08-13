package com.garage.gerbackg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.garage.gerbackg.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	List<User> findAll();
	
	User findByUserid(int userid);
	
	void delete(User user);
	
	<UserTemp extends User> UserTemp save(UserTemp user);
	
	User findByEmail(String email);
	
	User findByEmailAndPassword (String email, String password);

}
