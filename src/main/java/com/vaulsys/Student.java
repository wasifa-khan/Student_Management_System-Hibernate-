package com.vaulsys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
 
public class Student {

	@Id
	
	 @Column(name = "Roll_number")
	
	private int roll;
	
	 @Column(name = "Name")
	private String name;
	 
	 @Column(name = "Age")
	private int age;
	 
	 @Column(name = "Gender")
	private String gender;
	 
	 @Column(name = "Address")
	private String address;
	 
	 @Column(name = "PhoneNumber")
	private String phoneNumber;
	
	
	public Student() {
		
	}


	public Student(int roll, String name, int age, String gender, String address, String phoneNumber) {
		super();
		this.roll = roll;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}


	public int getRoll() {
		return roll;
	}


	public void setRoll(int roll) {
		this.roll = roll;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
}
