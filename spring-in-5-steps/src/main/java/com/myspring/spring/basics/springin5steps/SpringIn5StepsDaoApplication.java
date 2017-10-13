package com.myspring.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.myspring.spring.basics.springin5steps.dao.PersonDAO;

@Configuration
@ComponentScan
public class SpringIn5StepsDaoApplication {
	private static Logger LOG = org.slf4j.LoggerFactory
			.getLogger(SpringIn5StepsDaoApplication.class);

	public static void main(String[] args) {

		ApplicationContext ac = new AnnotationConfigApplicationContext(
				SpringIn5StepsDaoApplication.class);
		PersonDAO personDAO = ac.getBean(PersonDAO.class);
		PersonDAO personDAO1 = ac.getBean(PersonDAO.class);

		LOG.info("{}", personDAO);
		LOG.info("{}", personDAO.getJdbcConnection());
		LOG.info("{}", personDAO.getJdbcConnection());
		LOG.info("{}", personDAO1);
		LOG.info("{}", personDAO1.getJdbcConnection());
	}
}
