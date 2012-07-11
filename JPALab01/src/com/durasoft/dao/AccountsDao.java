package com.durasoft.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.durasoft.Account;

public class AccountsDao {
	private EntityManagerFactory emf;
	private EntityManager em;
	public AccountsDao(){
		emf = Persistence.createEntityManagerFactory("JPALab01");
	}
	public void createAccount(int accountNumber,long balance,String owner){
		Account acc = new Account(accountNumber, balance, owner);
		em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(acc);
		txn.commit();
		em.close();
	}
	public long getBalance(int accountNumber){
		em = emf.createEntityManager();
		Account acc = em.find(Account.class, accountNumber);
		em.close();
		return acc.getBalance();
	}
	public void updateAccount(int accountNumber,long amount){
		em = emf.createEntityManager();
		Account acc = em.find(Account.class, accountNumber);
		acc.setBalance(acc.getBalance()+amount);
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(acc);
		txn.commit();
		em.close();
	}
	public List<Account> getAllAccounts(){
		em = emf.createEntityManager();
		List<Account> accounts = 
				em.createQuery("select acc from Account acc").getResultList();
		em.close();
		return accounts;
	}
}
