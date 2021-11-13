package com.bridgelabz.employepayrollapp.model;

import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;
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
	@Pattern(regexp = "male|female", message = " Gender  needs to be male or female")
	public String gender;	 
	public LocalDate startDate;      
	public LocalDate updatedDate;
	@NotBlank(message = "Note can not be empty")
	public String note;
	@NotBlank(message = "profilePic can not be empty")
	public String profilePic;
	@NotNull(message = "department should not be empty")
	public List<String> departments;

}
