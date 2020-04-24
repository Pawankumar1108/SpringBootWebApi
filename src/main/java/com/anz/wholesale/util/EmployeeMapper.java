package com.anz.wholesale.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.anz.wholesale.model.EmployeeEntity;


public class EmployeeMapper implements RowMapper<EmployeeEntity> {
	

	@Override
	public EmployeeEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		
       EmployeeEntity employeeEntity =new EmployeeEntity();
		
		return employeeEntity;
		
	}
}	

