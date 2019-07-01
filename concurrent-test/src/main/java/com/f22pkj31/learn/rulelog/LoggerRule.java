package com.f22pkj31.learn.rulelog;

import org.apache.log4j.spi.LoggingEvent;

/**
 * @author bo.fan
 * @date 2019-06-27
 * @since JDK1.7
 */
public interface LoggerRule {

    LoggingEvent delimitOverallRule(LoggingEvent event, RuleParam ruleParam);

}
