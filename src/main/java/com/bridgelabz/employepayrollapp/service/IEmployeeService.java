package com.bridgelabz.employepayrollapp.service;

 
import com.bridgelabz.employepayrollapp.model.EmployeePayRoll;
import com.bridgelabz.employepayrollapp.response.Response;

public interface IEmployeeService {

	public Response saveEmployeeDetails(EmployeePayRoll emp);
	public Response getEmployeeByID(Long Id);
	public Response updateEmployeeByID(Long Id,EmployeePayRoll empinfo);
	public Response deleteEmployeeByID(Long Id);
	public  Response getAllEmployeeDetails();
  
}
