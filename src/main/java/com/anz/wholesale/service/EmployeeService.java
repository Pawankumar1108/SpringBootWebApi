package com.anz.wholesale.service;

import java.util.List;

import com.anz.wholesale.model.EmployeeEntity;


public interface EmployeeService {
	

	public List<EmployeeEntity> getAllEmployee()throws Exception;
	
	public boolean newEmployee(Integer empId, String empName, String empAddress, Integer empMobileNum, String empDept,
			Character[] empPssword, Character[] empPin)throws Exception;
	
	public boolean getNewUpdate(Integer empId)throws Exception;

	public boolean getRemoved(Character[] empPin)throws Exception;

	

	
}
