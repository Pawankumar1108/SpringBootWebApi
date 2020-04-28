package com.anz.wholesale.model;

public class EmployeeEntity {
	
	private Integer empId;
	private String empName;
	private String empAddress;
	private Integer empMobileNum;
	private String empDept;
	private Character[] empPssword =new Character[8];
	private Character[]empPin=new Character[5];

	
	
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
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
	
	public Integer getEmpMobileNum() {
		return empMobileNum;
	}
	public void setEmpMobileNum(Integer empMobileNum) {
		this.empMobileNum = empMobileNum;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public Character[] getEmpPssword() {
		return empPssword;
	}
	public void setEmpPssword(Character[] empPssword) {
		this.empPssword = empPssword;
	}
	public Character[] getEmpPin() {
		return empPin;
	}
	public void setEmpPin(Character[] empPin) {
		this.empPin = empPin;
	}
	
	
	
	

}
