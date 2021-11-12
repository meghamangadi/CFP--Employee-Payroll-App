package com.bridgelabz.employepayrollapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployepayrollappApplication {

	public static void main(String[] args) {

		log.info("Welcome to the Employee Payroll System");
		SpringApplication.run(EmployepayrollappApplication.class, args);
	}

}
