package com.bridgelabz.employepayrollapp.model;

import javax.validation.constraints.Pattern;

import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
 
@Data
public class EmployeePayRoll {

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee Name is invalid")
	@NotEmpty 
	private String name;
	@Min(value = 500, message = "Min Wage should be more than 500")
	private long salary;	 
 
}
