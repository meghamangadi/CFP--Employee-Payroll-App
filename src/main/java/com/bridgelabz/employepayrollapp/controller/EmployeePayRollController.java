package com.bridgelabz.employepayrollapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employepayrollapp.model.EmployeePayRoll;
import com.bridgelabz.employepayrollapp.service.EmployeeServiceImpl;

 

@RestController
public class EmployeePayRollController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@PostMapping("/post/employeeDetails")
	public void save(@RequestBody EmployeePayRoll employee) {
		 employeeServiceImpl.saveEmployeeDetails(employee);
	}
	
	@PostMapping("/get/employeeDetails")
	public void getEmployeeDetails(@RequestParam Long id) {
		 employeeServiceImpl.getEmployeeDetails(id);
	}
}
