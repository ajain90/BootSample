package com.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boot.aspects.LoggerAspect;

@Configuration
public class GenericApplicationConfig {

	@Bean
	public LoggerAspect getLoggerAspect() {
		return new LoggerAspect();
	}
}
