package com.durasoft.service;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import com.durasoft.dao.PersonsDao;
import com.durasoft.domain.Person;
import com.durasoft.domain.User;

public class HomeService {
	private PersonsDao personsDao;
	public HomeService(EntityManagerFactory emf){
		personsDao = new PersonsDao();
		personsDao.setEntityManagerFactory(emf);
	}
	public Person getPerson(User user){
		return personsDao.getPersonForUserId(user.getId());
	}
	
	public List<Person> getPersonsList(){
		return personsDao.getAll();
	}
}
