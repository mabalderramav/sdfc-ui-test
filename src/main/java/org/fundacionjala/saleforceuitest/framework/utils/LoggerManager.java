package org.fundacionjala.saleforceuitest.framework.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggerManager {

    private static final String CLASS = "|| Class: ";
    private static final String ERROR = "|| Error: ";
    private static final String MESSAGE = " || Message: ";
    private static LoggerManager instance = null;
    private static Logger logger;


    private LoggerManager() {
        logger = LogManager.getLogger(Environment.class);
    }

    public static LoggerManager getInstance() {
        if (instance == null) {
            instance = new LoggerManager();
        }
        return instance;
    }

    public void addInfoLog(String className, String message) {
        logger.info(CLASS + className + MESSAGE + message);
    }

    public void addWarnLog(String className, String message, Throwable errorMessage) {
        logger.warn(CLASS + className + MESSAGE + message);
        logger.info(ERROR + errorMessage);
    }

    public void addErrorLog(String className, String message, Throwable errorMessage) {
        logger.info(CLASS + className + MESSAGE + message);
        logger.info(ERROR + errorMessage);
    }

    public void addFatalLog(String className, String message, Throwable errorMessage) {
        logger.info("|| Class: " + className + MESSAGE + message);
        logger.info(ERROR + errorMessage);
    }

    public void addTraceLog(String className, String message, Throwable errorMessage) {
        logger.info("|| Class: " + className + MESSAGE + message);
        logger.info(ERROR + errorMessage);
    }

    public void addDebugLog(String className, String message, Throwable errorMessage) {
        logger.info("|| Class: " + className + MESSAGE + message);
        logger.info(ERROR + errorMessage);
    }

}
