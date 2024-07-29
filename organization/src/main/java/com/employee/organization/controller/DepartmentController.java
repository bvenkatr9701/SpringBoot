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

import com.employee.organization.entity.Department;
import com.employee.organization.entity.Employee;
import com.employee.organization.service.DepartmentServiceImpl;
import com.employee.organization.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentServiceImpl departmentService;
	
	@PostMapping("/create")
	public ResponseEntity<Department> createEmployee(@RequestBody Department department)
	{
		Department saveDepartment=departmentService.saveDepartment(department);
		
		
		
		return new ResponseEntity<Department>(saveDepartment, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{deptId}")
	public ResponseEntity<Department> getEmployeeById(@PathVariable("deptId") long deptId)
	{
       Department department	=	departmentService.getDepartmentById(deptId);
       
       return new ResponseEntity<Department>(department,HttpStatus.OK);
	}
	
	 @GetMapping("/all")
	public List<Department> getAllEmployees() {
	        return departmentService.getAllDepartments();
	    }
	 
	  @DeleteMapping("delete/{id}")
	 public ResponseEntity<?> deleteEmployee(@PathVariable long id) {
		  departmentService.deleteDepartment(id);
	        return new ResponseEntity<String>("Deaprtment deleted successfully", HttpStatus.OK);        

	         
	  }
	  
	  @PutMapping("update/{id}")
	    public ResponseEntity<Department> updateEmployee(@PathVariable long id, @RequestBody Department departmentDetails) {
	        Department updateDepartment=departmentService.updateDepartment(id, departmentDetails);
	              
	        return new ResponseEntity<Department>(updateDepartment,HttpStatus.CREATED);
	    }

}
