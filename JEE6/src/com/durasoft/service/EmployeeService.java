package com.durasoft.service;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import com.durasoft.dao.EmployeeDao;
import com.durasoft.domain.Employee;

public class EmployeeService {

	private EmployeeDao employeeDao;
	
	public EmployeeService(EntityManagerFactory emf) {
		employeeDao = new EmployeeDao();
		employeeDao.setEntityManagerFactory(emf);
	}

	public boolean addEmployee(int id, String name, String dateOfJoining) {
		return employeeDao.insertEmployee(id,name,dateOfJoining);
	}

	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

}
