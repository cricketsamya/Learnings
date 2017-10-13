package com.myspring.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.myspring.spring.basics.springin5steps.cdi.SomeCDIBusiness;

@Configuration
@ComponentScan
public class SpringIn5StepsCDIApplication {
	private static Logger LOG = org.slf4j.LoggerFactory
			.getLogger(SpringIn5StepsCDIApplication.class);

	public static void main(String[] args) {

		ApplicationContext ac = new AnnotationConfigApplicationContext(
				SpringIn5StepsCDIApplication.class);
		SomeCDIBusiness business = ac.getBean(SomeCDIBusiness.class);
		// CDI
		LOG.info("{}", business);
		LOG.info("{}", business.getSomeCDIDao());
	}
}
