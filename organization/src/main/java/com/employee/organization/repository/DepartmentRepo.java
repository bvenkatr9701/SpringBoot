package com.employee.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.organization.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
