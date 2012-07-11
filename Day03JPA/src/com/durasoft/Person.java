package com.durasoft;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="persons")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column
	private int age;
	
	@ManyToOne(targetEntity=Company.class)
	@JoinColumn(name="company_id")
	private Company company;
	
	
	@OneToMany(targetEntity=Dog.class,cascade=CascadeType.ALL)
	@JoinColumn(name="person_id")
	private Set<Dog> dogs;
	
	
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Set<Dog> getDogs() {
		return dogs;
	}
	public void setDogs(Set<Dog> dogs) {
		this.dogs = dogs;
	}
	public Person(){
		
	}
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
