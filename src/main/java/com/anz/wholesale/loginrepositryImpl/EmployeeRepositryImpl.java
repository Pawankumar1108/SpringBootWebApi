package com.anz.wholesale.loginrepositryImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static  com.anz.wholesale.loginrepositryImpl.EmployeeSql.GET_ALL_EMPLOYEE_LIST;
import static  com.anz.wholesale.loginrepositryImpl.EmployeeSql.NEW_EMPLOYEE_REGISTRATION;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.anz.wholesale.loginrepositry.EmployeeRepositry;
import com.anz.wholesale.model.EmployeeEntity;
import com.anz.wholesale.util.EmployeeMapper;

@Repository("EmployeeRepositry")
public class EmployeeRepositryImpl implements EmployeeRepositry{
 
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private static final Logger LOGGER = LogManager.getLogger(LoginRepositryImpl.class);
	
	@Override
	public List<EmployeeEntity> getAllEmployee() {
		
		Map<String,String >paramMap=new HashMap();
		
		List<EmployeeEntity> employeeList=namedParameterJdbcTemplate.query(GET_ALL_EMPLOYEE_LIST,paramMap, new EmployeeMapper());
		
		LOGGER.info("The Database is Not Able to Fetch All the Employee List");
		
		return employeeList;
		
	
	}

	@Override
	public boolean newEmployee(int empId, String empName, String empAddress, int empMobileNum, String empDept,
			Character[] empPssword,Character[] empPin)throws ClassCastException {
		/*
		 * Map<String,Integer> paramMap=new HashMap<>(); paramMap.put("empId",empId);
		 * paramMap.put("empMobileNum", empMobileNum);
		 */
		
		/* Map<String,Character[]>paramMap1=new HashMap<>(); */
		
		
		Map<Object,Object>paramMap=new HashMap<>();
		paramMap.put("empId",empId);
		paramMap.put("empName", empName);
		paramMap.put("empAddress", empAddress);
		paramMap.put("empMobileNum", empMobileNum);
		paramMap.put("empDept", empDept);
		paramMap.put("empPssword",empPssword);
		paramMap.put("empPin", empPin);
		
		
		/*
		 * Map<String,String>paramMap=new HashMap<>(); paramMap.put("empName", empName);
		 * paramMap.put("empAddress", empAddress); paramMap.put("empDept", empDept);
		 */
		
		
		
		int newRegristration =namedParameterJdbcTemplate.update(NEW_EMPLOYEE_REGISTRATION, (SqlParameterSource) paramMap);
		
		if(newRegristration !=0) {
			
			return true;
			
		}else {
		
			throw new ClassCastException("Not Able to Regisster New Employee");
	    }
		
	}
	
	

}
