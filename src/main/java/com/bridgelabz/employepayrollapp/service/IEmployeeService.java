package com.bridgelabz.employepayrollapp.service;

import com.bridgelabz.employepayrollapp.model.EmployeePayRoll;

public interface IEmployeeService {

	
	
	public void saveEmployeeDetails(EmployeePayRoll emp);
	public EmployeePayRoll getEmployeeDetails(Long Id);
}
