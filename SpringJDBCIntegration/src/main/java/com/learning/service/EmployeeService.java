package com.learning.service;

import java.util.List;

import com.learning.model.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);

	public Employee fetchEmployeeById(int employeeId);

	public void removeEmployeeById(int employeeId);

	public void updateEmployeeEmailById(String newEmail, int employeeId);

	public List<Employee> getAllEmployeeInfo();

}
