package com.learning.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.learning.dao.EmployeeDAO;
import com.learning.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void creatEmployee(Employee employee) {
		hibernateTemplate.save(employee);
	}

	public Employee getEmployeeById(int employeeId) {
		return hibernateTemplate.get(Employee.class, employeeId);
	}

	public void deleteEmployeeById(int employeeId) {
		Employee employee = hibernateTemplate.get(Employee.class, employeeId);
		hibernateTemplate.delete(employee);
	}

	public void updateEmployeeEmailById(String newEmail, int employeeId) {
		Employee employee = hibernateTemplate.get(Employee.class, employeeId);
		employee.setEmail(newEmail);
		hibernateTemplate.update(employee);

	}

	public List<Employee> getAllEmployee() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		return (List<Employee>) hibernateTemplate.findByCriteria(criteria);
	}

}
