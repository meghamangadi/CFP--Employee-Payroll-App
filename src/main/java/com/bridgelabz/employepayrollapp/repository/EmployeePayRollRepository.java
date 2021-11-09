package com.bridgelabz.employepayrollapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.employepayrollapp.entity.EmployeePayRollEntity;

 
@Repository
public interface EmployeePayRollRepository extends CrudRepository<EmployeePayRollEntity,Long> {

}
