package com.revature.brian.connectionutil;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

import com.revature.brian.dao.EmployeesDAO;
import com.revature.brian.dao.EmployeesDAOImpl;

import com.revature.brian.dao.ReimbursementsDAO;
import com.revature.brian.dao.ReimbursementsDAOImpl;

public class ConnectionUtility {

	public static Connection getConnection() throws SQLException {
		
		Driver PostgresDriver = new Driver();
		DriverManager.registerDriver(PostgresDriver);

		String url = "jdbc:postgresql://localhost:5432/postgres";
		String manager_username = "bossman";
		String manager_password = "bossman";
		return DriverManager.getConnection(url, manager_username, manager_password);
	}
	

	public static void main(String[] args) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			System.out.println("Connection successful.");
		} catch(SQLException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}


	public static EmployeesDAO getEmployeeDAO() {
		return new EmployeesDAOImpl();
	}
	
	public static ReimbursementsDAO getReimbursementsDAO() {
		return new ReimbursementsDAOImpl();
	}
}