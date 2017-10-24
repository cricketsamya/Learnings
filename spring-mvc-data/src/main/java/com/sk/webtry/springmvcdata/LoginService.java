package com.sk.webtry.springmvcdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.webtry.springmvcdata.dao.Person;
import com.sk.webtry.springmvcdata.dao.PersonJpaRepository;

@Service
public class LoginService {
	@Autowired
	private PersonJpaRepository jpaRepository;

	public boolean validateUser(String user, String password) {
		Person person = jpaRepository.findByUsernameAndPassword(user, password);
		return person != null;
	}

	public boolean checkIfUserExists(String user) {
		return jpaRepository.checkIfUserExists(user);
	}

	public void createUser(String name, String location, String username,
			String password) {
		jpaRepository
				.createUser(new Person(name, location, username, password));
	}
}