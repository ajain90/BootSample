package com.boot.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.boot.logger.SBLogger;

@Aspect
@Component
public class LoggerAspect {

	@Before("execution(* *com.boot.controllers..*(..))")
	public void logBefore(JoinPoint joinPoint) {
		SBLogger.entry(joinPoint.getSignature().getDeclaringType().getName(), joinPoint.getSignature().getName());
	}

	@After("execution(* *com.boot.controllers..*(..))")
	public void logAfter(JoinPoint joinPoint) {
		SBLogger.exit(joinPoint.getClass().getName(), joinPoint.getSignature().getName());
	}
}
