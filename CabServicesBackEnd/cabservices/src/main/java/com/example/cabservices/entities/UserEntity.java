package com.example.cabservices.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("serial")
@Entity
@Table(name = "user_table")
@JsonRootName("user_table")
@JsonInclude(content = Include.NON_NULL)
public class UserEntity implements Serializable {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "userId")
	@JsonProperty
	private int userId;

	@Column(name = "Name")
	@JsonProperty
	private String name;

	@Column(name = "gender")
	@JsonProperty
	private String gender;

	@Column(name = "age")
	@JsonProperty
	private int age;

	@Column(name = "emailId", unique = true)
	@JsonProperty
	private String emailId;

	@Column(name = "password")
	@JsonProperty
	private String password;

	@Column(name = "mobileNo")
	@JsonProperty
	private long mobileNo;


	@Column(name = "city")
	@JsonProperty
	private String city;

	@Column(name = "state")
	@JsonProperty
	private String state;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
