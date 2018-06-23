package com.learning.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.learning.dao.EmployeeDAO;
import com.learning.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// public void creatEmployee(Employee employee) {
	/*
	 * Connection connection = null; PreparedStatement pStatement = null; try {
	 * connection = dataSource.getConnection(); String sqlQuery =
	 * "INSERT INTO employee_table (employee_name, email, gender, salary) VALUE (?,?,?,?)"
	 * ; pStatement = connection.prepareStatement(sqlQuery); pStatement
	 * .setString(1, employee.getEmployeeName()); pStatement .setString(2,
	 * employee.getEmail()); pStatement .setString(3, employee.getGender());
	 * pStatement .setDouble(4, employee.getSalary());
	 * 
	 * int exexuteUpdate = pStatement.executeUpdate(); if(exexuteUpdate>0)
	 * System.out.println("Employee Data Saved");
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 */

	// }

	public Employee getEmployeeById(int employeeId) {
		String sql = "SELECT * FROM employee_table where id = ?";
		return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), employeeId);
	}

	public void deleteEmployeeById(int employeeId) {
		String sql = "DELETE FROM employee_table where id = ?";
		int update = jdbcTemplate.update(sql, employeeId);
		if (update > 0)
			System.out.println("Employee is Deleted...");

	}

	public void updateEmployeeEmailById(String newEmail, int employeeId) {
		String sql = "UPDATE employee_table SET email = ? where id = ?";
		int update = jdbcTemplate.update(sql, newEmail, employeeId);
		if (update > 0)
			System.out.println("Employee is Updated...");

	}

	public List<Employee> getAllEmployee() {
		String sqlQuery = "SELECT * FROM employee_table";
		return jdbcTemplate.query(sqlQuery, new EmployeeRowMapper());
	}

	public void creatEmployee(Employee employee) {
		String sql = "INSERT INTO employee_table (employee_name, email, gender, salary) VALUE (?,?,?,?)";
		// int update = jdbcTemplate.update(sql, new Object[] {
		// employee.getEmployeeName(), employee.getEmail(), employee.getGender(),
		// employee.getSalary()});
		int update = jdbcTemplate.update(sql, employee.getEmployeeName(), employee.getEmail(), employee.getGender(),
				employee.getSalary());
		if (update > 0)
			System.out.println("Employee is Created...");

	}

}
