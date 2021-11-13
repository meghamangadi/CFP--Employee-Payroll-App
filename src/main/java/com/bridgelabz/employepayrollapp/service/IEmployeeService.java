package com.bridgelabz.employepayrollapp.service;

 
import com.bridgelabz.employepayrollapp.model.EmployeePayRoll;
import com.bridgelabz.employepayrollapp.response.Response;

public interface IEmployeeService {

	public Response saveEmployeeDetails(EmployeePayRoll emp);
	public Response getEmployeeDetailsByID(String Id);
	public Response getEmployeeByID(Long Id);
	public Response updateEmployeeByID(String Id,EmployeePayRoll empinfo);
	public Response deleteEmployeeByID(String Id);
	public  Response getAllEmployeeDetails();
  
}
