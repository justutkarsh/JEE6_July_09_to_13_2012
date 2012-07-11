package com.durasoft.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.durasoft.domain.User;

public class UsersDao {
	private EntityManagerFactory entityManagerFactory;
	
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	public User loadUser(String userName,String password){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query query = em.createQuery("select u from User u where " +
				"u.userName=:p1 and u.password=:p2");
		query.setParameter("p1", userName);
		query.setParameter("p2", password);
		List<User> users = query.getResultList();
		User user = null;
		if(users.size() == 1){
			user = (User)users.get(0);
		}
		em.close();
		return user;
	}
}
