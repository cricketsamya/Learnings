package com.sk.springaop.firstspringaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	// execution(* PACAKGE.*.*(..)) -> Given package with any class with any
	// method with any argument
	@AfterReturning(value = "com.sk.springaop.firstspringaop.aspect.CommonJointPointConfig.dataLayerExecution()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		log.info("{} returned value {}", joinPoint.getSignature(), result);
	}

	@AfterThrowing(value = "com.sk.springaop.firstspringaop.aspect.CommonJointPointConfig.dataLayerExecution()", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Object exception) {
		log.info("{} thrown exception {}", joinPoint.getSignature(), exception);
	}

	@After("com.sk.springaop.firstspringaop.aspect.CommonJointPointConfig.dataLayerExecution()")
	public void after(JoinPoint joinPoint) {
		log.info("{} thrown exception {}", joinPoint.getSignature());
	}
}
