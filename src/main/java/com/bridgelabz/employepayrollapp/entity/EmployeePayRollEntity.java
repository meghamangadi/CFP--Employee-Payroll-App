package com.bridgelabz.employepayrollapp.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "employeepayroll_db")
public class EmployeePayRollEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	private String name;
	private long salary;
	private String gender; 
	public LocalDate startDate; 
	public String note; 
	public String profilePic;	 
	public LocalDate updatedDate;
	
	
	
	
	 @ElementCollection
	    @CollectionTable(name = "employee_department",
	            joinColumns = @JoinColumn(name ="id"))
	    @Column(name = "department")
	    private List<String> departments;
	 
}
