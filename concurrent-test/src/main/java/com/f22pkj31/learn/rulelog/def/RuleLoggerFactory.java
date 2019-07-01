package com.f22pkj31.learn.rulelog.def;

import com.f22pkj31.learn.rulelog.LoggerRule;
import org.apache.log4j.LogManager;

/**
 * @author bo.fan
 * @date 2019-07-01
 * @since JDK1.7
 */
public class RuleLoggerFactory {


    public static RuleLoggerLog4jAdapter getLog4j(String name, LoggerRule rule) {
        return new RuleLoggerLog4jAdapter(LogManager.getLogger(name), rule);
    }

    public static RuleLoggerLog4jAdapter getLog4j(Class clazz, LoggerRule rule) {
        return new RuleLoggerLog4jAdapter(LogManager.getLogger(clazz), rule);
    }

    public static RuleLoggerLog4jAdapter getLog4j(String name) {
        return new RuleLoggerLog4jAdapter(LogManager.getLogger(name), null);
    }

    public static RuleLoggerLog4jAdapter getLog4j(Class clazz) {
        return new RuleLoggerLog4jAdapter(LogManager.getLogger(clazz), null);
    }

    public static RuleLoggerSlf4jAdapter getSlf4j(String name, LoggerRule rule) {
        return new RuleLoggerSlf4jAdapter(RuleLoggerFactory.getLog4j(name, rule));
    }

    public static RuleLoggerSlf4jAdapter getSlf4j(Class clazz, LoggerRule rule) {
        return new RuleLoggerSlf4jAdapter(RuleLoggerFactory.getLog4j(clazz, rule));
    }

    public static RuleLoggerSlf4jAdapter getSlf4j(String name) {
        return new RuleLoggerSlf4jAdapter(RuleLoggerFactory.getLog4j(name, null));
    }

    public static RuleLoggerSlf4jAdapter getSlf4j(Class clazz) {
        return new RuleLoggerSlf4jAdapter(RuleLoggerFactory.getLog4j(clazz, null));
    }

}
