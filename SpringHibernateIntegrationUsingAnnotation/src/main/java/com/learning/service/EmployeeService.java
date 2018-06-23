package com.learning.service;

import java.util.List;

import com.learning.model.Employee;

public interface EmployeeService {

	public abstract void addEmployee(Employee employee);

	public abstract Employee fetchEmployeeById(int employeeId);

	public abstract void removeEmployeeById(int employeeId);

	public abstract void updateEmployeeEmailById(String newEmail, int employeeId);

	public abstract List<Employee> getAllEmployeeInfo();

}
