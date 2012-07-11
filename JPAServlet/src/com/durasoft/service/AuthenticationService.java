package com.durasoft.service;

import javax.persistence.EntityManagerFactory;

import com.durasoft.dao.UsersDao;
import com.durasoft.domain.User;

public class AuthenticationService {
	private UsersDao usersDao;
	
	public AuthenticationService(EntityManagerFactory emf){
		usersDao = new UsersDao();
		usersDao.setEntityManagerFactory(emf);
	}
	
	public User authenticate(String userName,String password){
		User user = usersDao.loadUser(userName, password);
		return user;
	}
}
