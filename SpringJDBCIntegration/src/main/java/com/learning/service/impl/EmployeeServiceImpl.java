package com.learning.service.impl;

import java.util.List;

import com.learning.dao.EmployeeDAO;
import com.learning.model.Employee;
import com.learning.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO= employeeDAO;
	}
	
	
	public void addEmployee(Employee employee) {
		employeeDAO.creatEmployee(employee);
		
	}

	public Employee fetchEmployeeById(int employeeId) {
		return employeeDAO.getEmployeeById(employeeId);
	}

	public void removeEmployeeById(int employeeId) {
		employeeDAO.deleteEmployeeById(employeeId);
	}

	public void updateEmployeeEmailById(String newEmail, int employeeId) {
		employeeDAO.updateEmployeeEmailById(newEmail, employeeId);
	}

	public List<Employee> getAllEmployeeInfo() {
		return employeeDAO.getAllEmployee();
	}

}
