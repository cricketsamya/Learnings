package com.myspring.spring.basics.springin5steps;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.myspring.spring.basics.springin5steps.properties.SomeExternalService;

@Configuration
@ComponentScan("com.myspring.spring.basics.springin5steps")
@PropertySource("classpath:app.properties")
public class SpringIn5StepsPropertiesApplication {

	public static void main(String[] args) {

		// ConfigurableApplicationContext ac = (ConfigurableApplicationContext)
		// SpringApplication
		// .run(SpringIn5StepsDaoApplication.class, args);
		//
		try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
				SpringIn5StepsPropertiesApplication.class)) {

			SomeExternalService service = ac.getBean(SomeExternalService.class);
			System.out.println(service);
			System.out.println(service.retrunServiceUrl());

		}
	}
}
