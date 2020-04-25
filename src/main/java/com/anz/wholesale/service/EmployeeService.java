package com.anz.wholesale.service;

import java.util.List;

import com.anz.wholesale.model.EmployeeEntity;


public interface EmployeeService {
	

	public List<EmployeeEntity> getAllEmployee()throws Exception;
	
	public boolean newEmployee(int empId, String empName, String empAddress, int empMobileNum, String empDept, Character[] empPssword, Character[] empPin)throws Exception;
	
}
