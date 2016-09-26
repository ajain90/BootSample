package com.boot.logger;

import org.slf4j.LoggerFactory;

public final class SBLogger {

	private static final String CLASS_NAME = SBLogger.class.getName();

	private SBLogger() {

	}

	public static void entry(String className, String methodName) {
		final String currmethod = "entry";
		LoggerFactory.getLogger(className).trace(CLASS_NAME + " " + currmethod + " " + className + " " + methodName);
	}

	public static void exit(String className, String methodName) {
		final String currmethod = "exit";
		LoggerFactory.getLogger(className).trace(CLASS_NAME + " " + currmethod + " " + className + " " + methodName);
	}
}
