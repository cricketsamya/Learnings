package com.sk.springaop.firstspringaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sk.springaop.firstspringaop.business.Business1;
import com.sk.springaop.firstspringaop.business.Business2;

@SpringBootApplication
public class FirstSpringAopApplication implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Business1 business1;
	@Autowired
	private Business2 business2;

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(business1.calculateSomething());
		log.info(business2.calculateSomething());
	}
}
