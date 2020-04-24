package com.anz.wholesale.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anz.wholesale.model.EmployeeEntity;
import com.anz.wholesale.service.EmployeeService;

@RestController("Employee")
public class EmployeeController /* extends Exception */ {

	@Autowired
	EmployeeService employeeService;

	private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);

	@GetMapping("/employeelist")
	public List<EmployeeEntity> allEmployee() throws Exception {
		
			LOGGER.info("All Registered User in Database is  Excecuting");
			return employeeService.getAllEmployee();
	}

	/*
	 * 
	 * public void employeesNotFoundException()throws EmployeesNotFoundException {
	 * try { wrapException(new )
	 * 
	 * }catch(EmployeesNotFoundException e) { throw new
	 * EmployeesNotFoundException("The Exception is Handeled ");
	 * 
	 * }
	 */
}


