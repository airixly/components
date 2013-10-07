package com.airixly.components;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: Lyanxi
 * Date: 13-10-7
 */
public class MyLogger {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(MyLogger.class);
        PropertyConfigurator.configure("log4j.properties");
        logger.info("Hello World");
    }
}
