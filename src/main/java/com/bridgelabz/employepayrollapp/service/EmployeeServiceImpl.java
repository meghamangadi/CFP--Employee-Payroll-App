package com.bridgelabz.employepayrollapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employepayrollapp.entity.EmployeePayRollEntity;
import com.bridgelabz.employepayrollapp.model.EmployeePayRoll;
import com.bridgelabz.employepayrollapp.repository.EmployeePayRollRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeePayRollRepository employeePayRollRepository;
	
	@Override
	public void saveEmployeeDetails(EmployeePayRoll emp) {
		EmployeePayRollEntity empEntity=new EmployeePayRollEntity();
		empEntity.setName(emp.getName());
		empEntity.setSalary(emp.getSalary());
		employeePayRollRepository.save(empEntity);
		 
	}

	@Override
	public EmployeePayRoll getEmployeeDetails(Long Id) {
		Optional<EmployeePayRollEntity> value=employeePayRollRepository.findById(Id);
		EmployeePayRoll empDetails=new EmployeePayRoll();
		empDetails.setName(value.get().getName());
		empDetails.setSalary(value.get().getSalary());
		return empDetails;
	}

}
