package com.durasoft.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.durasoft.domain.Person;

public class PersonsDao {
	private EntityManagerFactory entityManagerFactory;
	
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	public Person getPersonForUserId(int userId){
		EntityManager em = entityManagerFactory.createEntityManager();
		Person person = null; 
		Query query = em.createQuery("select p from Person p " +
				"where p.user.id=:p1");
		query.setParameter("p1", userId);
		List<Person> persons = query.getResultList();
		if(persons.size() == 1){
			person = persons.get(0);
		}
		em.close();
		return person;
	}
	public List<Person> getAll(){
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Person> persons = em.createQuery("select p from Person p").getResultList();
		em.close();
		return persons;
	}
}
