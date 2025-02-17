package com.secretSanta.model;

import lombok.Getter;
import lombok.NoArgsConstructor;



@NoArgsConstructor
public class SecretSantaAssignment {
	private String employeeName;
	private String employeeEmail;
	private String secretChildName;
	private String secretChildEmail;
	public SecretSantaAssignment(String employeeName, String employeeEmail, String secretChildName,
			String secretChildEmail) {
		super();
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.secretChildName = secretChildName;
		this.secretChildEmail = secretChildEmail;
		
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getSecretChildName() {
		return secretChildName;
	}
	public void setSecretChildName(String secretChildName) {
		this.secretChildName = secretChildName;
	}
	public String getSecretChildEmail() {
		return secretChildEmail;
	}
	public void setSecretChildEmail(String secretChildEmail) {
		this.secretChildEmail = secretChildEmail;
	}
	
	

}
