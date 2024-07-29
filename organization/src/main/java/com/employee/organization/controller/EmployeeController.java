package com.employee.organization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.organization.entity.Employee;
import com.employee.organization.service.EmployeeServiceImpl;


@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl employeeService;
	
	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
	{
		Employee saveEmployee=employeeService.saveEmployee(employee);
		
		return new ResponseEntity<Employee>(saveEmployee, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{empid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empid") long empId)
	{
       Employee employee	=	employeeService.getEmployeeById(empId);
       System.out.println(employee);
       
       return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	 @GetMapping("/all")
	public List<Employee> getAllEmployees() {
	        return employeeService.getAllEmployees();
	    }
	 
	  @DeleteMapping("delete/{id}")
	 public ResponseEntity<?> deleteEmployee(@PathVariable long id) {
	         employeeService.deleteEmployee(id);
	        return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);        

	         
	  }
	  
	  @PutMapping("update/{id}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
	        Employee updateemployee=employeeService.updateEmployee(id, employeeDetails);
	              
	        return new ResponseEntity<Employee>(updateemployee,HttpStatus.CREATED);
	    }
}
