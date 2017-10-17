package com.sk.springaop.firstspringaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BeforeAspect {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	// execution(* PACAKGE.*.*(..))
	@Before("com.sk.springaop.firstspringaop.aspect.CommonJointPointConfig.dataLayerExecution()")
	public void before(JoinPoint joinPoint) {
		log.info("Intercepted method call {}", joinPoint.getSignature());
	}
}
