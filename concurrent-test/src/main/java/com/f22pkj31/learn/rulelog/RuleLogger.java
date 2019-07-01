package com.f22pkj31.learn.rulelog;

/**
 * @author bo.fan
 * @date 2019-07-01
 * @since JDK1.7
 */
public interface RuleLogger {

    void trace(String message);

    void trace(String message, Throwable t);

    void traceWithRule(String message, RuleParam param);

    void traceWithRule(String message, Throwable t, RuleParam param);

    void debug(String message);

    void debug(String message, Throwable t);

    void debugWithRule(String message, RuleParam param);

    void debugWithRule(String message, Throwable t, RuleParam param);

    void info(String message);

    void info(String message, Throwable t);

    void infoWithRule(String message, RuleParam param);

    void infoWithRule(String message, Throwable t, RuleParam param);

    void warn(String message);

    void warn(String message, Throwable t);

    void warnWithRule(String message, RuleParam param);

    void warnWithRule(String message, Throwable t, RuleParam param);

    void error(String message);

    void error(String message, Throwable t);

    void errorWithRule(String message, RuleParam param);

    void errorWithRule(String message, Throwable t, RuleParam param);

    LoggerRule getRule();

}
