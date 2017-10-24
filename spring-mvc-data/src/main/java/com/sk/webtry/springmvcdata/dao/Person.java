package com.sk.webtry.springmvcdata.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
// @Table(name="person")
@NamedQueries({
		@NamedQuery(name = "find_all_persons", query = "select p from Person p"),
		@NamedQuery(name = "find_by_username_password", query = "select p from Person p where p.username = :username and p.password = :password"),
		@NamedQuery(name = "check_if_user_exists", query = "select p from Person p where p.username = :username") })
public class Person {

	@Id
	@GeneratedValue
	private int id;
	@Column(name = "name")
	private String name;
	private String location;
	private Date birthDate;
	private String username;
	private String password;

	public Person(String name, String location, String username, String password) {
		super();
		this.name = name;
		this.location = location;
		this.username = username;
		this.password = password;
		this.birthDate = new Date();
	}

	public Person() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", location=" + location
				+ ", birthDate=" + birthDate + "]";
	}

}
