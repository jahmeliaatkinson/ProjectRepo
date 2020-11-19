package com.tcs.Employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.Employee.DAO.EmployeeDAO;
import com.tcs.Employee.DAO.EmployeeDAOImpl;
import com.tcs.Employee.DAO.OrganizationDAO;
import com.tcs.Employee.DAO.OrganizationDaoImpl;
import com.tcs.Employee.Model.Department;
import com.tcs.Employee.Model.Organization;
import com.tcs.Repository.DepartmentRepository;
import com.tcs.Repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {


	@Autowired
	OrganizationRepository organizationRepository;
	
	
	@Override
	public String addOrganization(Organization organization) {
	Organization organization2 = null;
		try {
			organization2 = organizationRepository.save(organization);
			return "success";
		}catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		
		

	
	}

	@Override
	public String updateOrganization(Organization organization) {
		return null;
		
	}

	@Override
	public String deleteOrganization(int id) {
		return null;
	}

	@Override
	public Optional<Organization> findById(int id) {
		return null;
	}

	@Override
	public Optional<List<Organization>> getOrganization() {
		return null;
	}

	

}
