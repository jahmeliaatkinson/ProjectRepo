package com.tcs.Employee.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
public class DBUtils {
	
	
	@PostConstruct
	public void init() {
		System.out.println("init called");
	}
	
	
	@PreDestroy
	public void destroy() {
		
		System.out.println("destroy called");
		
	}
	
	
	
	@Autowired
	DataSource dataSource;
	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeConnection(Connection connection) {

		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
