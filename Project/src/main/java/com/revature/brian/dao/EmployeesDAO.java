package com.revature.brian.dao;

import java.util.List;

import com.revature.brian.model.Employees;

public interface EmployeesDAO {
	public Employees selectEmployees(String emp_username);
	public List<Employees> selectAllEmployees();
	public Employees updateEmployees (String emp_username, Employees employee);
	public Employees getEmployeeByLogin (String emp_username, String emp_password);
	public Employees getManagerByLogin (String emp_username, String emp_password);
}
