package com.durasoft.ejb;

import java.util.List;

import javax.ejb.Local;

import com.durasoft.domain.Employee;

@Local
public interface EmployeesBeanLocal {
	boolean addEmployee(int id,String name,String dateOfJoining);
	List<Employee> getAll();
}
