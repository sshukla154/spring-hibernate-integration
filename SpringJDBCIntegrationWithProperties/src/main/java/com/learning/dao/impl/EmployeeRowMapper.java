package com.learning.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.learning.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmployeeName(rs.getString("employee_name"));
		employee.setEmail(rs.getString("email"));
		employee.setGender(rs.getString("gender"));
		employee.setSalary(rs.getDouble("salary"));
		employee.setEmployeeId(rs.getInt("id"));
		return employee;
	}

}
