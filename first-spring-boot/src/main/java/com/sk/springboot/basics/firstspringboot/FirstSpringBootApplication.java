package com.sk.springboot.basics.firstspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(
				FirstSpringBootApplication.class, args);
		for (String bean : applicationContext.getBeanDefinitionNames()) {
			System.out.println(bean);
		}
	}
}
