package com.anz.wholesale.loginrepositryImpl;

public class EmployeeSql {
	
	public static final String GET_ALL_EMPLOYEE_LIST= "SELECT * FROM EMPLOYEE";
	
	public static final String NEW_EMPLOYEE_REGISTRATION="INSERT INTO EMPLOYEE(EMP_ID,EMP_NAME,EMP_ADDRESS,EMP_MOBILE_NUMBER,EMP_DEPT,EMP_PASSWORD,EMP_PIN) VALUES(:empId, :empName, :empAddress, :empMobileNum,:empDept,:empPssword,: empPin)";  

}
