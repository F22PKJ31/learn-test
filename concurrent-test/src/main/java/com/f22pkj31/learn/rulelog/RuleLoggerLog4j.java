package com.f22pkj31.learn.rulelog;

import org.apache.log4j.Level;

/**
 * @author bo.fan
 * @date 2019-07-01
 * @since JDK1.7
 */
public interface RuleLoggerLog4j {

    boolean isTraceEnabled();

    boolean isDebugEnabled();

    boolean isInfoEnabled();

    boolean isEnabledFor(Level warn);
}
