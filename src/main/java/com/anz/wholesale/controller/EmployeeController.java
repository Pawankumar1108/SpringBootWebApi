package com.anz.wholesale.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.anz.wholesale.model.EmployeeEntity;
import com.anz.wholesale.model.EmployeePasswordResponse;
import com.anz.wholesale.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController("Employee")
public class EmployeeController /* extends Exception */ {

	@Autowired
	EmployeeService employeeService;

	private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);

	//Get Method used to View or Fetch all the Records from the database
	@GetMapping("/employeelist")
	public List<EmployeeEntity> allEmployee() throws Exception {
		
			LOGGER.info("All Registered User in Database is  Excecuting");
			return employeeService.getAllEmployee();
	}
	
	//Post Method used for the Inseeting New Record s into the table
	@PostMapping("/newregistration")
	public boolean newEmployeeRegisrty(@RequestBody String jsonRequest)throws Exception{
		
		LOGGER.info("New Resistration for employee Is Excuting");
		ObjectMapper objectMapper = new ObjectMapper();
		EmployeeEntity employeeEntity = objectMapper.readValue(jsonRequest, EmployeeEntity.class);
		return employeeService.newEmployee(employeeEntity.getEmpId(),employeeEntity.getEmpName(),employeeEntity.getEmpAddress(),employeeEntity.getEmpMobileNum(),employeeEntity.getEmpDept(),employeeEntity.getEmpPssword(),employeeEntity.getEmpPin() );
		
	}
	
	// Updating Database record from Existing Records
	
	@PutMapping("/employee/{empId}")
	public boolean updateRecord(@RequestHeader Integer empId)throws Exception {
		
		LOGGER.info("The Updating Record is Excuting");
		/*
		 * ObjectMapper objectMapper = new ObjectMapper(); EmployeeEntity employeeEntity
		 * = objectMapper.readValue(jsonRequest, EmployeeEntity.class);
		 */
		return employeeService.getNewUpdate(empId);
	}
	
	//Removing the Existing Employee From the Database
	@DeleteMapping("/employee/{empId}")
	public boolean removeEmployee(@RequestHeader Integer empId)throws Exception{

		LOGGER.info("Removing Employee Running ");
		/*
		 * ObjectMapper objectMapper = new ObjectMapper(); EmployeeEntity employeeEntity
		 * = objectMapper.readValue(jsonRequest, EmployeeEntity.class);
		 */
		
		return employeeService.getRemoved(empId);
		
	}
	
	
	@GetMapping("/employee/{empPssword}")
	public EmployeePasswordResponse employeePasswordResponse(@RequestParam String empPssword) {
		
		if(!empPssword.contentEquals(empPssword)) {
			
			throw new IncorrectPasswordException("Wrong Password");
			}
		
		
		return new EmployeePasswordResponse("Password Accepted"); 
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


