package com.learning.dao;

import java.util.List;

import com.learning.model.Employee;

public interface EmployeeDAO {

	public void creatEmployee(Employee employee);

	public Employee getEmployeeById(int employeeId);

	public void deleteEmployeeById(int employeeId);

	public void updateEmployeeEmailById(String newEmail, int employeeId);

	public List<Employee> getAllEmployee();

}
