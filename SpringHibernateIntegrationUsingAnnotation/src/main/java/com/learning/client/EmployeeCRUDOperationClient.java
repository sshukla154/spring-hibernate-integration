package com.learning.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learning.model.Employee;
import com.learning.service.EmployeeService;
import com.learning.service.impl.EmployeeServiceImpl;

public class EmployeeCRUDOperationClient {
	public static void main(String[] args) {
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
		EmployeeService employeeService = applicationContext.getBean("employeeService", EmployeeServiceImpl.class);

//		 createEmployee(employeeService);

//		getEmpById(employeeService);

		 getAllEmployeeDetails(employeeService);

//		 employeeService.updateEmployeeEmailById("s@gmail.com", 4);

//		 employeeService.removeEmployeeById(1);

		applicationContext.close();
	}

	private static void getAllEmployeeDetails(EmployeeService employeeService) {
		List<Employee> empList = employeeService.getAllEmployeeInfo();
		empList.forEach(employee -> {
			System.out.println(employee.toString());
		});
	}

	private static void getEmpById(EmployeeService employeeService) {
		Employee emp = employeeService.fetchEmployeeById(1);
		System.out.println(emp.toString());
	}

	private static void createEmployee(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setEmployeeName("Testing Usign Annotation");
		employee.setEmail("annotation@gmail.com");
		employee.setGender("Male");
		employee.setSalary(12331.0);
		employeeService.addEmployee(employee);
	}
}
