package com.myspring.spring.basics.springin5steps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.myspring.spring.basics.springin5steps.basic.BinarySearchImpl;

@Configuration
@ComponentScan("com.myspring.spring.basics.springin5steps")
public class SpringIn5StepsBasicApplication {

	public static void main(String[] args) {

		// ConfigurableApplicationContext ac = (ConfigurableApplicationContext)
		// SpringApplication
		// .run(SpringIn5StepsDaoApplication.class, args);
		//
		try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
				SpringIn5StepsBasicApplication.class)) {

			BinarySearchImpl b = ac.getBean(BinarySearchImpl.class);
			BinarySearchImpl b1 = ac.getBean(BinarySearchImpl.class);
			System.out.println(b.binarySearch(new int[] { 1, 4, 5 }, 2));
			System.out.println(b);
			System.out.println(b1);
		}
	}
}
