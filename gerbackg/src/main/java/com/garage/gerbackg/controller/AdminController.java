package com.garage.gerbackg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.garage.gerbackg.model.Admin;
import com.garage.gerbackg.repository.AdminRepository;

@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired
	private AdminRepository actions;
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public @ResponseBody List<Admin> listAdmin() {
		return actions.findAll();
	}
		
	@RequestMapping(value="/admin", method=RequestMethod.POST)
	public @ResponseBody Admin createAdmin(@RequestBody Admin admin) {
		return actions.save(admin);
	}
		
	@RequestMapping(value="/admin/{adminid}", method=RequestMethod.GET)
	public @ResponseBody Admin findAdmin(@PathVariable Integer adminid) {
		return actions.findByAdminid(adminid);
	}
		
	@RequestMapping(value="/admin", method=RequestMethod.PUT)
	public @ResponseBody Admin updateAdmin(@RequestBody Admin admin) {
		return actions.save(admin);
	}
		
	@RequestMapping(value="/admin/{adminid}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteAdmin(@PathVariable Integer adminid) {
		Admin admin = findAdmin(adminid);
		this.actions.delete(admin);
	}
		
	@RequestMapping(value="/admin/{email}", method=RequestMethod.GET)
	public @ResponseBody Admin findEmailAdmin(@PathVariable String email) {
	return actions.findByEmail(email);
		}
	
	@RequestMapping(value="/adminlogin", method=RequestMethod.POST)
	public @ResponseBody String login(@RequestBody Admin admin) {
		if (actions.findByEmail(admin.getEmail()) == null) {
			return "E-mail not found.";
		} else if (actions.findByEmailAndPassword(admin.getEmail(), admin.getPassword()) == null) {
			return "Invalid password.";
		} else {
			return "Successful.";
		}
	}

}
