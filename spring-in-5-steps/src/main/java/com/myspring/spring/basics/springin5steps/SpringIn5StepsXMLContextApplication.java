package com.myspring.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myspring.spring.basics.springin5steps.xml.XMLPersonDAO;

public class SpringIn5StepsXMLContextApplication {
	private static Logger LOG = org.slf4j.LoggerFactory
			.getLogger(SpringIn5StepsXMLContextApplication.class);

	public static void main(String[] args) {

		// ConfigurableApplicationContext ac = (ConfigurableApplicationContext)
		// SpringApplication
		// .run(SpringIn5StepsDaoApplication.class, args);
		//
		try (ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml")) {

			LOG.info("Loaded Beans -> {}", (Object) ac.getBeanDefinitionNames());
			XMLPersonDAO xmlPersonDao = ac.getBean(XMLPersonDAO.class);
			LOG.info("{} - {}", xmlPersonDao,
					xmlPersonDao.getXmlJdbcConnection());

		}
	}
}
