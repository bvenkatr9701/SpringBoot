package com.employee.organization.exception;

public class DepartmentNotFoundException extends RuntimeException {
	
	String message;

	public DepartmentNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	

}
