package com.myspring.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.myspring.spring.basics.componentscan.ComponentDAO;

@Configuration
@ComponentScan("com.myspring.spring.basics.componentscan")
public class SpringIn5StepsComponentScanApplication {

	private static Logger LOG = org.slf4j.LoggerFactory
			.getLogger(SpringIn5StepsBasicApplication.class);

	public static void main(String[] args) {

		ApplicationContext ac = new AnnotationConfigApplicationContext(
				SpringIn5StepsComponentScanApplication.class);
		ComponentDAO componentDAO = ac.getBean(ComponentDAO.class);

		LOG.info("{}", componentDAO);
		LOG.info("{}", componentDAO.getJdbcConnection());
	}
}
