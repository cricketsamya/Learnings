package com.sk.database.firstspringjdbcjpa.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.database.firstspringjdbcjpa.entity.Person;

public interface PersonSpringDataRepository extends
		JpaRepository<Person, Integer> {

}
