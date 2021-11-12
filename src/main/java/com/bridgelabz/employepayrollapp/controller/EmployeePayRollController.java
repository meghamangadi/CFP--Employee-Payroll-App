package com.bridgelabz.employepayrollapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeePayRollController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	 
	@PostMapping("/saveemployee")
	public ResponseEntity<Response> saveEmployee(@Valid @RequestBody EmployeePayRoll contactInfo) {
		log.info("save method is called ");
		Response response = employeeServiceImpl.saveEmployeeDetails(contactInfo);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/getemployeeId")
	public ResponseEntity<Response> getContactByID(@RequestParam Long Id) {
		log.info("Get the employee details by Id  {}", Id);
		Response response = employeeServiceImpl.getEmployeeByID(Id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/getAllemployees")
	public ResponseEntity<Response> getAllContact() {
		log.info("Get all employee details ");
		Response response = employeeServiceImpl.getAllEmployeeDetails();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/updateemployeeId")
	public ResponseEntity<Response> updateEmployeetByID(@RequestParam Long Id, @RequestBody EmployeePayRoll emp) {
		log.info("update employee details ");
		Response response = employeeServiceImpl.updateEmployeeByID(Id, emp);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deleteemployeeId")
	public ResponseEntity<Response> deleteEmployeeByID(@RequestParam Long Id) {
		log.info("Delet employee details ");
		Response response = employeeServiceImpl.deleteEmployeeByID(Id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
