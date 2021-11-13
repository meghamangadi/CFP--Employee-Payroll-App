package com.bridgelabz.employepayrollapp.response;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
@Data
public class EmployeePayRollResponse {
	private String employeeId;
	private String name;
	private long salary;
	public String gender;
	public LocalDate startDate;
	public LocalDate updatedDate;
	public String note;
	public String profilePic;
	public List<String> departments;

}
