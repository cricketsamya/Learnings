package com.sk.springaop.firstspringaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJointPointConfig {
	@Pointcut("execution(* com.sk.springaop.firstspringaop.data.*.*(..))")
	public void dataLayerExecution() {
	}

	@Pointcut("execution(* com.sk.springaop.firstspringaop.business.*.*(..))")
	public void bussinessLayerExecution() {
	}

	@Pointcut("bussinessLayerExecution() && dataLayerExecution()")
	public void allLayerExecution() {
	}

	// ANY BEAN containing dao in name
	@Pointcut("bean(*dao*)")
	public void beanContainsDao() {
	}

	// All methods in a package
	@Pointcut("within(com.sk.springaop.firstspringaop.data..*)")
	public void dataLayerExecutionWithin() {
	}

	@Pointcut("@annotation(com.sk.springaop.firstspringaop.aspect.TrackTime)")
	public void trackTimeAnnotation() {
	}
}
