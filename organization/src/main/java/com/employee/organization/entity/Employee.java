package com.employee.organization.entity;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="employee")

public class Employee {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long empId;
	private String empName;
	private String email;
	private double salary;
	private String designation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	
	@JoinColumn(name="department_id")
	@JsonBackReference
	
	private Department department;

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", email=" + email + ", salary=" + salary
				+ ", designation=" + designation + ", department=" + department + "]";
	}

	

	
	

 
	
	
	}

	
	
	
	
	


