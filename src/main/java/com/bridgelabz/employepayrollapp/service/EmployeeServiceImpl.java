package com.bridgelabz.employepayrollapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employepayrollapp.entity.EmployeePayRollEntity;
import com.bridgelabz.employepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employepayrollapp.model.EmployeePayRoll;
import com.bridgelabz.employepayrollapp.repository.EmployeePayRollRepository;
import com.bridgelabz.employepayrollapp.response.Response;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeePayRollRepository employeePayRollRepository;
	
	@Override
	public Response saveEmployeeDetails(EmployeePayRoll emp) {
		EmployeePayRollEntity empEntity=new EmployeePayRollEntity();
		empEntity.setName(emp.getName());
		empEntity.setSalary(emp.getSalary());
		empEntity.setGender(emp.getGender());
		empEntity.setNote(emp.getNote());
		empEntity.setProfilePic(emp.getProfilePic());
		empEntity.setStartDate(emp.getStartDate());
		empEntity.setUpdatedDate(emp.getUpdatedDate());
		empEntity.setDepartments(emp.getDepartments());
		employeePayRollRepository.save(empEntity);
		return new  Response(200 ,"Employee added Successfully..!!");
	}



	@Override
	public Response getEmployeeByID(Long Id) {
		EmployeePayRollEntity value=employeePayRollRepository.findById(Id)
				.orElseThrow(() -> new EmployeePayrollException("Employee with EmployeeId" + Id
                + " Doesn't Exists...!"));
		EmployeePayRoll empDetails=new EmployeePayRoll();
		empDetails.setName(value. getName());
		empDetails.setSalary(value.getSalary());
		empDetails.setGender(value.getGender());
		empDetails.setNote(value.getNote());
		empDetails.setProfilePic(value.getProfilePic());
		empDetails.setStartDate(value.getStartDate());
		empDetails.setUpdatedDate(value.getUpdatedDate());
		empDetails.setDepartments(value.getDepartments());		 
		return  new  Response(200 ,"Retrived Employee Details succesfully..!!",empDetails);	}



	@Override
	public Response updateEmployeeByID(Long Id, EmployeePayRoll empinfo) {
		EmployeePayRollEntity value=employeePayRollRepository.findById(Id)
				.orElseThrow(() -> new EmployeePayrollException("Employee with EmployeeId" + Id
                + " Doesn't Exists...!"));
		EmployeePayRollEntity empEntity=new EmployeePayRollEntity();
		empEntity.setEmployeeId (value.getEmployeeId());
		empEntity.setName (value.getName());
		empEntity.setSalary(value.getSalary());
		empEntity.setGender(value.getGender());
		empEntity.setNote(value.getNote());
		empEntity.setProfilePic(value.getProfilePic());
		empEntity.setStartDate(value.getStartDate());
		empEntity.setUpdatedDate(value.getUpdatedDate());
		empEntity.setDepartments(value.getDepartments());	
		employeePayRollRepository.save(empEntity);
		return new  Response(200 ,"Employee updated Successfully..!!");
	}



	@Override
	public Response deleteEmployeeByID(Long Id) {
		employeePayRollRepository.deleteById(Id);
		return new  Response(200 ,"Employee Details Deleted Succesfully..!!");
	}



	@Override
	public Response getAllEmployeeDetails() {
		List<EmployeePayRollEntity> contacts=  (List<EmployeePayRollEntity>) employeePayRollRepository.findAll();		 
		return new  Response(200 ,"Conatct Details Deleted Succesfully..!!",contacts);
	}



 

	 

}
