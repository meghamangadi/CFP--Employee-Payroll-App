package com.bridgelabz.employepayrollapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.employepayrollapp.entity.EmployeePayRollEntity;
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
		employeePayRollRepository.save(empEntity);
		return new  Response(200 ,"Employee added Successfully..!!");
	}



	@Override
	public Response getEmployeeByID(Long Id) {
		Optional<EmployeePayRollEntity> value=employeePayRollRepository.findById(Id);
		EmployeePayRoll empDetails=new EmployeePayRoll();
		empDetails.setName(value.get().getName());
		empDetails.setSalary(value.get().getSalary());
		return  new  Response(200 ,"Retrived Employee Details succesfully..!!",empDetails);	}



	@Override
	public Response updateEmployeeByID(Long Id, EmployeePayRoll empinfo) {
		// TODO Auto-generated method stub
		return null;
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
