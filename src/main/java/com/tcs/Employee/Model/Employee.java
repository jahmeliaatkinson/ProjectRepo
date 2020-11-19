package com.tcs.Employee.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name= "employee_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Employee {
	@Id
	@Column(name = "emp_id")
	private int id;
	private int organizationId;
	private int departmentId;
	@Column(name="emp_name")
	private String name;
	private int age;
	private String position;

	
	
	
}
