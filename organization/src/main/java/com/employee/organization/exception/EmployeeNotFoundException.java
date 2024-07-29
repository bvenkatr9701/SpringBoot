package com.employee.organization.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeNotFoundException extends RuntimeException{
	
	private String message;

}
