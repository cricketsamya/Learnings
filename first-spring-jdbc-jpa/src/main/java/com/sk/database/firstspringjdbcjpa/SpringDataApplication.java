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
import com.sk.database.firstspringjdbcjpa.springdata.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonSpringDataRepository jpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Person> values = jpaRepository.findAll();
		for (Person person : values) {
			logger.info(person.toString());
		}
		logger.info("person found {}", jpaRepository.findOne(10002));

		logger.info("Number of rows inserted {}",
				jpaRepository.save(new Person("VM", "Kiev", new Date())));
		logger.info("Number of rows inserted {}",
				jpaRepository.save(new Person("NS", "WBerlin", new Date())));
		logger.info("Number of rows update 10002 {}", jpaRepository
				.save(new Person(10002, "James", "Munich", new Date())));
		jpaRepository.delete(10004);
	}
}
