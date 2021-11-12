package com.bridgelabz.employepayrollapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.employepayrollapp.model.EmployeePayRoll;
import com.bridgelabz.employepayrollapp.response.Response;
import com.bridgelabz.employepayrollapp.service.EmployeeServiceImpl;

@RestController

public class EmployeePayRollController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	 
	@PostMapping("/saveemployee")
	public ResponseEntity<Response> saveEmployee(@RequestBody EmployeePayRoll contactInfo) {
		Response response = employeeServiceImpl.saveEmployeeDetails(contactInfo);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/getemployeeId")
	public ResponseEntity<Response> getContactByID(@RequestParam Long Id) {
		Response response = employeeServiceImpl.getEmployeeByID(Id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/getAllemployees")
	public ResponseEntity<Response> getAllContact() {
		Response response = employeeServiceImpl.getAllEmployeeDetails();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/updateemployeeId")
	public ResponseEntity<Response> updateEmployeetByID(@RequestParam Long Id, @RequestBody EmployeePayRoll emp) {
		Response response = employeeServiceImpl.updateEmployeeByID(Id, emp);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deleteemployeeId")
	public ResponseEntity<Response> deleteEmployeeByID(@RequestParam Long Id) {
		Response response = employeeServiceImpl.deleteEmployeeByID(Id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
