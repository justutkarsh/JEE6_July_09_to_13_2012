package com.durasoft.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.durasoft.domain.Employee;

public class EmployeeDao {

	private EntityManagerFactory entityManagerFactory;
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		entityManagerFactory = emf;
	}

	public boolean insertEmployee(int id, String name, String dateOfJoining) {
		boolean result = false;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction txn = em.getTransaction();
			txn.begin();
			Employee emp = new Employee();
			emp.setId(id);
			emp.setName(name);
			emp.setDateOfJoining(dateOfJoining);
			em.persist(emp);
			txn.commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}	
		finally{
			em.close();
		}
		return result;
	}

	public List<Employee> getAllEmployees() {
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Employee> employees = em.createQuery("select e from Employee e").getResultList();
		em.close();
		return employees;
	}

}
