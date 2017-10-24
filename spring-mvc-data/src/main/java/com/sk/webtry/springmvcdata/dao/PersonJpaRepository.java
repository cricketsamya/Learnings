package com.sk.webtry.springmvcdata.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}

	public Person insert(Person person) {
		return entityManager.merge(person);

	}

	public Person update(Person person) {
		return entityManager.merge(person);

	}

	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}

	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery(
				"find_all_persons", Person.class);
		return namedQuery.getResultList();
	}

	public Person findByUsernameAndPassword(String username, String password) {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery(
				"find_by_username_password", Person.class);
		namedQuery.setParameter("username", username);
		namedQuery.setParameter("password", password);
		List<Person> list = namedQuery.getResultList();
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	public boolean checkIfUserExists(String username) {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery(
				"check_if_user_exists", Person.class);
		namedQuery.setParameter("username", username);
		List<Person> list = namedQuery.getResultList();
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;

	}

	public void createUser(Person person) {
		entityManager.merge(person);
	}
}
