package com.anz.wholesale.util;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.anz.wholesale.model.EmployeeEntity;


public class EmployeeMapper implements RowMapper<EmployeeEntity> {
	

	@Override
	public EmployeeEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
       EmployeeEntity employeeEntity =new EmployeeEntity();
       employeeEntity.setEmpId(rs.getInt("EMP_ID"));
       employeeEntity.setEmpName(rs.getString("EMP_NAME"));
       employeeEntity.setEmpAddress(rs.getString("EMP_ADDRESS"));
       employeeEntity.setEmpMobileNum(rs.getInt("EMP_MOBILE_NUMBER"));
       employeeEntity.setEmpDept(rs.getString("EMP_DEPT"));
		/*
		 * employeeEntity.setEmpPssword(rs.getInt("EMP_PASSWORD"));
		 * 
		 * Array array = rs.getArray(setEmpPssword[0]); Integer[] javaArray =
		 * (Integer[]) employeeEntity.getInt();
		 */
       
       
       
		
		return employeeEntity;
		
	}
}	

