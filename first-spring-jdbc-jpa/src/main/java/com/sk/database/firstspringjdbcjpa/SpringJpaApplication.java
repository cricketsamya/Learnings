package com.sk.database.firstspringjdbcjpa;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sk.database.firstspringjdbcjpa.entity.Person;
import com.sk.database.firstspringjdbcjpa.jpa.PersonJpaRepository;

//@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PersonJpaRepository jpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Person> values = jpaRepository.findAll();
		for (Person person : values) {
			logger.info(person.toString());
		}
		logger.info("person found {}", jpaRepository.findById(10002));

		// List<Person> personsByLocation =
		// jpaRepository.findByLocation("Berlin");
		// for (Person person : personsByLocation) {
		// logger.info(person.toString());
		// }

		// logger.info("Number of rows deleted {}",
		// jpaRepository.deleteByIdAndName(10002, "James"));
		logger.info("Number of rows inserted {}",
				jpaRepository.insert(new Person("VM", "Kiev", new Date())));
		logger.info("Number of rows inserted {}",
				jpaRepository.insert(new Person("NS", "WBerlin", new Date())));
		logger.info("Number of rows update 10002 {}", jpaRepository
				.update(new Person(10002, "James", "Munich", new Date())));
		jpaRepository.deleteById(10004);
	}
}
