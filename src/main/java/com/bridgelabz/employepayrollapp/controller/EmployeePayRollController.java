package com.bridgelabz.employepayrollapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employepayrollapp.model.EmployeePayRoll;
import com.bridgelabz.employepayrollapp.response.Response;
import com.bridgelabz.employepayrollapp.service.EmployeeServiceImpl;

import lombok.extern.slf4j.Slf4j;
@CrossOrigin 
@RestController
@Slf4j


@RequestMapping("/employeePayrollservice")
public class EmployeePayRollController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	 
	 
	@PostMapping("/saveemployee")
	public ResponseEntity<Response> saveEmployee(@Valid @RequestBody EmployeePayRoll emp) {
		log.info("save method is called{} ",emp.toString());
		Response response = employeeServiceImpl.saveEmployeeDetails(emp);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/getemployeeId/token")
	public ResponseEntity<Response> getEmployeeDetailsByID(@RequestHeader(name = "token") String token) {
		log.info("Get the employee details by Id  {}", token);
		Response response = employeeServiceImpl.getEmployeeDetailsByID(token);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping("/getemployeeId")
	public ResponseEntity<Response> getEmployeeByID(@RequestParam Long Id) {
		log.info("Get the employee details by Id  {}", Id); 
		Response response = employeeServiceImpl.getEmployeeByID(Id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/getAllemployees")
	public ResponseEntity<Response> getAllEmployeeDetails() {
		log.info("Get all employee details ");
		System.out.println("Helloooooooooooooooooooooooooooooooooooooooooooo");
		Response response = employeeServiceImpl.getAllEmployeeDetails();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
 
	@PutMapping("/updateemployeeId")
	public ResponseEntity<Response> updateEmployeetByID(@RequestHeader(name = "token") String token, @RequestBody EmployeePayRoll emp) {
		log.info("update employee details ");
		Response response = employeeServiceImpl.updateEmployeeByID(token, emp);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	 
	@DeleteMapping("/deleteemployeeId")
	public ResponseEntity<Response> deleteEmployeeByID(/*@RequestHeader(name = "token")*/@RequestParam String token) {
		log.info("Delet employee details ");
		Response response = employeeServiceImpl.deleteEmployeeByID(token);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
