package com.durasoft;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class AccountBean implements Account {
	private double balance;

	@PostActivate
	public void activate(){
		System.out.println("*****AccountBean activated " + this);
		
	}
	@PrePassivate
	public void passivate(){
		System.out.println("*****AccountBean passivated " + this);
	}
	@PostConstruct
	public void initialize(){
		System.out.println("*****AccountBean created " + this);
	}
	
	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		balance -= amount;
	}
}
