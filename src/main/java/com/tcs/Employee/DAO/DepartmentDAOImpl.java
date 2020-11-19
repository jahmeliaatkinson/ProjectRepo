package com.tcs.Employee.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.Employee.Model.Department;
import com.tcs.Employee.Model.Employee;
import com.tcs.Employee.Utils.DBUtils;


//@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
@Autowired
DBUtils dbUtils;
	
	
	
	@Override
	public String addDepartment(Department department) {
		
		
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String adddepartment = "insert into Department (id,organizationId, Name) values(?,?,?)";
		try {
		    preparedStatement = connection.prepareStatement(adddepartment);
			preparedStatement.setInt(1,department.getId());
			preparedStatement.setInt(2,department.getOrganizationId());
			preparedStatement.setString(3,department.getName());
		
			
			
			result = preparedStatement.executeUpdate();
			
			if (result>0)
			{
				connection.commit();
				return "success";
			}
			else {
				return "fail";
			}
		} catch (SQLException e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		}
		
		finally {
			dbUtils.closeConnection(connection);
		}
		
		
		
	}

	
	
	
	@Override
	public String updateDepartment(Department department) {
		
		
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		try {
			String sql = "UPDATE Department set OrganizationId=?, Name=? WHERE Id=?"  ;
			
		    preparedStatement = connection.prepareStatement(sql);
		    
			
			preparedStatement.setInt(1, department.getOrganizationId());
			preparedStatement.setString(2, department.getName());
			preparedStatement.setInt(3, department.getId());
			result = preparedStatement.executeUpdate();
					
			
			
		
			
			if (result>0)
			{
				connection.commit();
				return "success";
			}
			else {
				return "fail";
			}
			
		} catch (SQLException e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		}
		
		finally {
			dbUtils.closeConnection(connection);
		}
	
		
		
		
	
	}
	
	
		
		
		

	@Override
	public String deleteDepartment(int id) {
		
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int resultSet = 0;
		
		int result = 0;
	
	
		try {
			String query = "delete from Department where Id=?";
		 preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,id);
			resultSet = preparedStatement.executeUpdate();
		
			
			if (result>0)
			{
				connection.commit();
				
				return "success";
			}
			else {
			
				connection.commit();
				return "fail";
			}
		
			

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		}
		
		finally {
			dbUtils.closeConnection(connection);
		}
	
		
		
	}

	@Override
	public Optional<Department> findById(int id) {
		
		
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Department department = null;
		String query = "select * from Department where id=?";
		try {
		 preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,id);
			resultSet = preparedStatement.executeQuery();
			
			
			if (resultSet.next())
			{
			    department = new Department();
				department.setId(resultSet.getInt("Id"));
				department.setOrganizationId(resultSet.getInt("organizationId"));
				department.setName(resultSet.getString("name"));
				
			}
			
			
		} catch (SQLException e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		}
		
		finally {
			dbUtils.closeConnection(connection);
		}
		
		return Optional.of(department);
		
	}
		


		
		
	

	@Override
	public Optional<List<Department>> getDepartments() {
	
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Department department= null;
	
		try {
			String query = "SELECT * FROM Department";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				int id = resultSet.getInt(1);
				int OrganizationId = resultSet.getInt(2);
				String Name = resultSet.getString(3);
				
				
				
				
			    department = new Department();
				department.setId(resultSet.getInt("Id"));
				department.setOrganizationId(resultSet.getInt("organizationId"));
				department.setName(resultSet.getString("name"));
				
				
				System.out.println("id: " +resultSet.getInt(1));
				System.out.println("organizationId: " +resultSet.getInt(2));
				System.out.println("Name: " +resultSet.getString(3));
				
			}
			
			
			
			
		} catch (SQLException e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		}
		
		finally {
			dbUtils.closeConnection(connection);
		}
		
		return Optional.empty();
		
		
		
	}

	@Override
	public Optional<List<Department>> findByOrganizationId(int id) {
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Department department = null;
		String query = "select * from Department where organizationId=?";
		try {
		
			 preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1,id);
				resultSet = preparedStatement.executeQuery();
				
			
			while (resultSet.next())
			{
				int Id = resultSet.getInt(1);
				int OrganizationId = resultSet.getInt(2);
				String Name = resultSet.getString(3);
				
				
				
			    department = new Department();
				department.setId(resultSet.getInt("Id"));
				department.setOrganizationId(resultSet.getInt("organizationId"));
				department.setName(resultSet.getString("name"));
				
				
				System.out.println("id: " +resultSet.getInt(1));
				System.out.println("organizationId: " +resultSet.getInt(2));
				System.out.println("Name: " +resultSet.getString(3));
				
			}
			
			
		} catch (SQLException e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		}
		
		finally {
			dbUtils.closeConnection(connection);
		}
		
		return Optional.empty();
	}
	}

