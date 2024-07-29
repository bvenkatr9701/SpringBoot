package com.employee.organization.service;

import java.util.List;

import com.employee.organization.entity.Department;

public interface IDepartment {
	
public Department saveDepartment(Department department);
	
	public Department getDepartmentById(Long id);
	
	public List<Department> getAllDepartments() ;
	
	public void deleteDepartment(Long id);
	
	public Department updateDepartment(long deptId, Department departmentDetails);

}
