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
import com.sk.database.firstspringjdbcjpa.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Person> values = personJdbcDao.findAll();
		for (Person person : values) {
			logger.info(person.toString());
		}
		logger.info("person found {}", personJdbcDao.findById(10002));

		List<Person> personsByLocation = personJdbcDao.findByLocation("Berlin");
		for (Person person : personsByLocation) {
			logger.info(person.toString());
		}
		logger.info("Number of rows deleted {}",
				personJdbcDao.deleteById(10004));
		logger.info("Number of rows deleted {}",
				personJdbcDao.deleteByIdAndName(10002, "James"));
		logger.info("Number of rows inserted 10005 {}", personJdbcDao
				.insert(new Person(10005, "VM", "Kiev", new Date())));
		logger.info("Number of rows update 10005 {}", personJdbcDao
				.update(new Person(10005, "VM", "Berlin", new Date())));
	}
}
