package com.employee.organization.service;

import java.util.List;
import java.util.Optional;

import com.employee.organization.entity.Employee;

public interface IEmployeeService {
	
	public Employee saveEmployee(Employee employee);
	
	public Employee getEmployeeById(Long id);
	
	public List<Employee> getAllEmployees() ;
	
	public void deleteEmployee(Long id);
	
	public Employee updateEmployee(long empId, Employee employeeDetails);

}


