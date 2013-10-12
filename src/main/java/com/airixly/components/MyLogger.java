package com.airixly.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: Airixly
 * Date: 13-10-7
 */
public class MyLogger {
    private static final Logger logger = LoggerFactory.getLogger(MyLogger.class);

    public static void main(String[] args) {
        logger.debug("Start debug");
        logger.info("Start info");
        logger.warn("Start warn");
        logger.error("Start error");
    }
}
