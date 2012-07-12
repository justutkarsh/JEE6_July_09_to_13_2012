package com.durasoft;

import javax.ejb.Remote;

@Remote
public interface Account {
	double getBalance();
	void deposit(double amount);
	void withdraw(double amount);
}
