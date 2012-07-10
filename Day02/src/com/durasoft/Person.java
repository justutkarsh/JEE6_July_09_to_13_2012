package com.durasoft;

public class Person {
	private String firstName;
	private int age;
	
	public Person() {
	}
	public Person(String firstName, int age) {
		this.firstName = firstName;
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
