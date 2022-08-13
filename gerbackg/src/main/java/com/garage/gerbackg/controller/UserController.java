package com.garage.gerbackg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.garage.gerbackg.model.User;
import com.garage.gerbackg.repository.UserRepository;

@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class UserController {
	
	//Actions
	@Autowired
	private UserRepository actions;
	
	//List
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public @ResponseBody List<User> listUsers() {
		return actions.findAll();
	}
	
	//Create
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public @ResponseBody User createUser(@RequestBody User user) {
		return actions.save(user);
	}
	
	//Find
	@RequestMapping(value="/users/{userid}", method=RequestMethod.GET)
	public @ResponseBody User findUser(@PathVariable Integer userid) {
		return actions.findByUserid(userid);
	}
	
	//Update
	@RequestMapping(value="/users", method=RequestMethod.PUT)
	public @ResponseBody User updateUser(@RequestBody User user) {
		return actions.save(user);
	}
	
	//Delete
	@RequestMapping(value="/users/{userid}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteUser(@PathVariable Integer userid) {
		User user = findUser(userid);
		this.actions.delete(user);
	}
	
	//E-mail
	@RequestMapping(value="/emailusers/{email}", method=RequestMethod.GET)
	public @ResponseBody User findEmailUser(@PathVariable String email) {
	return actions.findByEmail(email);
		}
	
	//Create
	@RequestMapping(value="/newuser", method=RequestMethod.POST)
	public @ResponseBody boolean newUser(@RequestBody User user) {
	if (actions.findByEmail(user.getEmail()) == null) {
		actions.save(user);
		return true;
	} else {
		return false;
	}
	}
	
	//Login
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody String login(@RequestBody User user) {
		if (actions.findByEmail(user.getEmail()) == null) {
			return "Email not registered.";
		} else if (actions.findByEmailAndPassword(user.getEmail(), user.getPassword()) == null) {
			return "Wrong password.";
		} else {
			return Integer.toString(actions.findByEmail(user.getEmail()).getUserid());
		}
	}

}
