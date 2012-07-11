package com.durasoft;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="accounts")
public class Account {
	@Id
	@Column(name="account_number")
	private int accountNumber;
	private long balance;
	private String owner;
	@Transient
	private String pan;
	
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Account(int accountNumber, long balance, String owner) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.owner = owner;
	}
	public Account() {
	}
	@Override
	public String toString() {
		return owner + "(" + accountNumber + "): " + balance;
	}
	
}
