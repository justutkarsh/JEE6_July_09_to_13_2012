package com.durasoft.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.durasoft.domain.Employee;
import com.durasoft.service.EmployeeService;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
@LocalBean
public class EmployeesBean implements EmployeesBeanLocal {

	@PersistenceUnit(name="EmployeeUnit")
	private EntityManagerFactory emf; 
	private EmployeeService employeeService;
	
	@PostConstruct
	public void initialize(){
		employeeService = new EmployeeService(emf);
	}

	@Override
	public boolean addEmployee(int id, String name, String dateOfJoining) {
		return employeeService.addEmployee(id, name, dateOfJoining);
	}

	@Override
	public List<Employee> getAll() {
		return employeeService.getAllEmployees();
	}


}
