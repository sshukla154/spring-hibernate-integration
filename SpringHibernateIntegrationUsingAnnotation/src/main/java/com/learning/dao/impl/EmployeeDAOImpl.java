package com.learning.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.learning.dao.EmployeeDAO;
import com.learning.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private HibernateTemplate hibernateTemplate;

	@Autowired
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
