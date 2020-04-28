package com.anz.wholesale.loginrepositry;

import java.util.List;

import com.anz.wholesale.model.EmployeeEntity;

public interface EmployeeRepositry {
	
	public List<EmployeeEntity> getAllEmployee();
	
	public boolean newEmployee(Integer empId, String empName, String empAddress, Integer empMobileNum, String empDept,Character[]empPssword, Character[] empPin)throws Exception;

	public boolean getNewUpdate(Integer empId, String empName);
		
	

}
