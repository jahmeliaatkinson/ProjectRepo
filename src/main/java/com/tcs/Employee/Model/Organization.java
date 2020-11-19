package com.tcs.Employee.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "organization_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor



public class Organization {
@Id
@Column(name = "org_Id")
	private int id;
@Column(name = "org_name")
	private String name;
@Column(name = "org_address")
	private String address;
//	private List<Department> departments = new ArrayList<>();
	//private List<Employee> employees = new ArrayList<>();
	
	
	
	
	
	
	
	
	
}
