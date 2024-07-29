package com.employee.organization.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.organization.entity.Department;
import com.employee.organization.exception.DepartmentNotFoundException;
import com.employee.organization.repository.DepartmentRepo;

import jakarta.transaction.Transactional;

@Service
public class DepartmentServiceImpl implements IDepartment {
	
	@Autowired
    DepartmentRepo repository;
	 @Transactional
	    public Department saveDepartment(Department department) {
	        // Set the department for each employee in the department
	        department.getEmployees().forEach(employee -> employee.setDepartment(department));
	        return repository.save(department);
	    }

	@Override
	public Department getDepartmentById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("The provided id not found in department"+id));
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void deleteDepartment(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Department updateDepartment(long deptdId, Department departmentDetails) {
		// TODO Auto-generated method stub
		
	Department updateDepartment	=repository.findById(deptdId).orElseThrow(() -> new DepartmentNotFoundException("The provided id not found in department"+deptdId));
		
	updateDepartment.setDeptName(departmentDetails.getDeptName());
	updateDepartment.setDescription(departmentDetails.getDescription());
	updateDepartment.setEstablishedDate(departmentDetails.getEstablishedDate());
	updateDepartment.setLocation(departmentDetails.getLocation());
	
		return repository.save(updateDepartment);
	}

}
