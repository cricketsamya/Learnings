package com.sk.springaop.firstspringaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AroundAspect {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	// execution(* PACAKGE.*.*(..)) -> Given package with any class with any
	// method with any argument
	@Around("com.sk.springaop.firstspringaop.aspect.CommonJointPointConfig.trackTimeAnnotation()")
	public void methodExecutionCalculation(ProceedingJoinPoint joinPoint)
			throws Throwable {
		long startTime = System.currentTimeMillis();
		joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;
		log.info("Time taken by {} is {} ms", joinPoint.getSignature(),
				timeTaken);
	}
}
