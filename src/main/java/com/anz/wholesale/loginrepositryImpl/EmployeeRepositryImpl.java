package com.anz.wholesale.loginrepositryImpl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.anz.wholesale.loginrepositryImpl.EmployeeSql.GET_ALL_EMPLOYEE_LIST;
import static com.anz.wholesale.loginrepositryImpl.EmployeeSql.NEW_EMPLOYEE_REGISTRATION;
import static com.anz.wholesale.loginrepositryImpl.EmployeeSql.USER_RECORD_UPDATED;
import static com.anz.wholesale.loginrepositryImpl.EmployeeSql.EMPLOYEE_REMOVED;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.stereotype.Repository;
import com.anz.wholesale.loginrepositry.EmployeeRepositry;
import com.anz.wholesale.model.EmployeeEntity;
import com.anz.wholesale.util.EmployeeMapper;

@Repository("EmployeeRepositry")
public class EmployeeRepositryImpl implements EmployeeRepositry {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final Logger LOGGER = LogManager.getLogger(LoginRepositryImpl.class);

	@Override
	public List<EmployeeEntity> getAllEmployee() {

		Map<String, String> paramMap = new HashMap<>();

		List<EmployeeEntity> employeeList = namedParameterJdbcTemplate.query(GET_ALL_EMPLOYEE_LIST, paramMap,
				new EmployeeMapper());

		LOGGER.info("All the list of Employee ");

		return employeeList;

	}

	@Override
	public boolean newEmployee(Integer empId, String empName, String empAddress, Integer empMobileNum, String empDept,
			Character[] empPssword, Character[] empPin) {
		/*
		 * Map<String,Integer> paramMap=new HashMap<>(); paramMap.put("empId",empId);
		 * paramMap.put("empMobileNum", empMobileNum);
		 */

		/* Map<String,Character[]>paramMap1=new HashMap<>(); */

		Map<Object, Object> paramMap = new HashMap<>();
		paramMap.put("empId", empId);
		paramMap.put("empName", empName);
		paramMap.put("empAddress", empAddress);
		paramMap.put("empMobileNum", empMobileNum);
		paramMap.put("empDept", empDept);
		paramMap.put("empPssword", empPssword);
		paramMap.put("empPin", empPin);

		/*
		 * Map<String,String>paramMap=new HashMap<>(); paramMap.put("empName", empName);
		 * paramMap.put("empAddress", empAddress); paramMap.put("empDept", empDept);
		 */

		int newRegristration = namedParameterJdbcTemplate.update(NEW_EMPLOYEE_REGISTRATION,
				(SqlParameterSource) paramMap);

		if (newRegristration != 0) {

			return true;

		} else {

			throw new ClassCastException("Not Able to Regisster New Employee");
		}
	}

	@Override
	public boolean getNewUpdate(Integer empId) {

		/*
		 * MapSqlParameterSource paramMap = new MapSqlParameterSource();
		 * paramMap.addValue("empId", empId); paramMap.addValue("empId", new
		 * SqlLobValue(empId, new DefaultLobHandler()), Types.CLOB);
		 */

		//int updateRecord = namedParameterJdbcTemplate.update(USER_RECORD_UPDATED, paramMap);
		
		int updateRecord = jdbcTemplate.update(USER_RECORD_UPDATED,empId);
		if (updateRecord != 0) {

			return true;

		} else {

			throw new RuntimeException("Unable to Update the Record Please Contact the DBA");
		}
	}

	/*
	 * @Override public boolean getRemoved(Integer empId) {
	 * 
	 * 
	 * MapSqlParameterSource paramMap = new MapSqlParameterSource();
	 * paramMap.addValue("empId", empId);
	 * paramMap.addValue("empAddress",empAddress); paramMap.addValue("empName", new
	 * SqlLobValue( empName, new DefaultLobHandler()), Types.CLOB);
	 * 
	 * 
	 * 
	 * Map<String,Integer>paramMap=new HashMap<>(); paramMap.put<"empId",empId>;
	 * 
	 * int removedEmployee=namedParameterJdbcTemplate.update(EMPLOYEE_REMOVED,
	 * paramMap); if(removedEmployee==0) { return true; }else { throw new
	 * RuntimeException("Employee doesn't Removed From the Database");
	 * 
	 * } }
	 */
	@Override
	public boolean getRemoved(Integer empId) {
		
	int employeeRemoved = jdbcTemplate.update(EMPLOYEE_REMOVED, empId);
		//EmployeeEntity.delete(empId);
	
	if(employeeRemoved !=0)
	{
		LOGGER.info("The Employee Succesfully Removed From the Database");
		return true;
	}else {
		
		throw new RuntimeException("The Employee Doesn't Removed");
	}
		
				 
		
		
	}

}
