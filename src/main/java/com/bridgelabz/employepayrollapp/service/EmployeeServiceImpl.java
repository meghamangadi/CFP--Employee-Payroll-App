package com.bridgelabz.employepayrollapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employepayrollapp.entity.EmployeePayRollEntity;
import com.bridgelabz.employepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employepayrollapp.model.EmployeePayRoll;
import com.bridgelabz.employepayrollapp.repository.EmployeePayRollRepository;
import com.bridgelabz.employepayrollapp.response.EmployeePayRollResponse;
import com.bridgelabz.employepayrollapp.response.Response;
import com.bridgelabz.employepayrollapp.utils.TokenUtils;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeePayRollRepository employeePayRollRepository;
	 @Autowired
	 private TokenUtils tokenUtils;
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
		EmployeePayRollResponse empDetails=new EmployeePayRollResponse();
		empDetails.setEmployeeId(tokenUtils.createToken(value.getEmployeeId()));
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
	public Response getEmployeeDetailsByID(String token) {
		Long Id=tokenUtils.decodeToken(token);
		EmployeePayRollEntity value=employeePayRollRepository.findById(Id)
				.orElseThrow(() -> new EmployeePayrollException("Employee with EmployeeId" + Id
                + " Doesn't Exists...!"));
		
		EmployeePayRollResponse empDetails=new EmployeePayRollResponse();
		empDetails.setEmployeeId(token);
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
	public Response updateEmployeeByID(String token, EmployeePayRoll empinfo) {
		Long Id=tokenUtils.decodeToken(token);
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
	public Response deleteEmployeeByID(String token) {
		Long Id=tokenUtils.decodeToken(token);
		employeePayRollRepository.deleteById(Id);
		return new  Response(200 ,"Employee Details Deleted Succesfully..!!");
	}



	@Override
	public Response getAllEmployeeDetails() {
		List<EmployeePayRollEntity> contacts=  (List<EmployeePayRollEntity>) employeePayRollRepository.findAll();
		List<EmployeePayRollResponse> contact=new ArrayList<>();
		for (EmployeePayRollEntity num : contacts) 
		{
		
			String Id=tokenUtils.createToken(num.getEmployeeId());
			EmployeePayRollResponse emp=new EmployeePayRollResponse();
			emp.setEmployeeId(Id);
			emp.setGender(num.getGender());
			emp.setName(num.getName());
			emp.setNote(num.getNote());
			emp.setProfilePic(num.getProfilePic());
			emp.setSalary(num.getSalary());
			emp.setStartDate(num.getStartDate());
			emp.setDepartments(num.getDepartments());
			contact.add(emp);
		}
		
		
		return new  Response(200 ,"Conatct Details retrived Succesfully..!!",contact);
	}



 

	 

}
