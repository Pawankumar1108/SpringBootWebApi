package com.anz.wholesale.loginrepositry;

import java.util.List;

import com.anz.wholesale.model.EmployeeEntity;

public interface EmployeeRepositry {
	
	public List<EmployeeEntity> getAllEmployee();
	
	public boolean newEmployee(int empId, String empName, String empAddress, int empMobileNum, String empDept,Character[]empPssword, Character[] empPin)throws Exception;
		
	

}
