package com.anz.wholesale.model;

public class EmployeeEntity {
	
	private int empId;
	private String empName;
	private String empAddress;
	private int empMobileNum;
	private String empDept;
	private char[] empPssword =new char[8];
	private char[]empPin=new char[5];
	
	
	
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public int getEmpMobileNum() {
		return empMobileNum;
	}
	public void setEmpMobileNum(int empMobileNum) {
		this.empMobileNum = empMobileNum;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public char[] getEmpPssword() {
		return empPssword;
	}
	public void setEmpPssword(char[] empPssword) {
		this.empPssword = empPssword;
	}
	public char[] getEmpPin() {
		return empPin;
	}
	public void setEmpPin(char[] empPin) {
		this.empPin = empPin;
	}
	
	
	
	

}
