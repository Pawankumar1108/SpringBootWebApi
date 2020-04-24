package com.anz.wholesale.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anz.wholesale.loginrepositry.EmployeeRepositry;
import com.anz.wholesale.model.EmployeeEntity;
import com.anz.wholesale.service.EmployeeService;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	EmployeeRepositry employeeRepositry;

	@Override
	public List<EmployeeEntity> getAllEmployee() throws Exception {
		
		return employeeRepositry.getAllEmployee();
	}

	
	
	
	
	
	
}
