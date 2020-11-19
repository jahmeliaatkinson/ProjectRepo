package com.tcs.Employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.Employee.DAO.EmployeeDAO;
import com.tcs.Employee.DAO.EmployeeDAOImpl;
import com.tcs.Employee.Model.Employee;
import com.tcs.Employee.Service.*;
import com.tcs.Repository.EmployeeRepository;

@Service

public class EmployeeServiceImpl implements EmployeeServices {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public String addEmployee(Employee employee) {
		Employee employee2 = null;
		try {
			employee2 = employeeRepository.save(employee);
			return "success";
		}catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
   @Override
	public String updateEmployee(Employee employee) {
		return null;
	}

   @Override
	public String deleteEmployee(int id) {
		return null;
	}
	
   @Override
   public Optional<Employee> findById(int id) {
	   return null;
   }
		
			
	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Employee>> findByOrganizationId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
