package com.tcs.Employee.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name= "department_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Department {
	@Id
	@Column(name = "dept_Id")
	private int id;
	private int organizationId;
	@Column(name = "dept_name")
	private String name;
//	private List<Employee> employees;
	
	
	
}
