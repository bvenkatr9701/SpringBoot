package com.employee.organization.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.organization.entity.Employee;
import com.employee.organization.exception.EmployeeNotFoundException;
import com.employee.organization.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	EmployeeRepo repository;

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return repository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("for the provided Id not found in Employee"));
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
	   repository.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(long empId, Employee employeeDetails) {
	Employee updateEmployee=repository.findById(empId).orElseThrow(() -> new EmployeeNotFoundException("unable find provided Id"+empId));
				     
	updateEmployee.setEmpName(employeeDetails.getEmpName());
	updateEmployee.setEmail(employeeDetails.getEmail());
	updateEmployee.setDesignation(employeeDetails.getDesignation());
	updateEmployee.setSalary(employeeDetails.getSalary());
		
		return repository.save(updateEmployee);
	}
	
	

}
