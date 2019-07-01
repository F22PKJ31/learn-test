package com.f22pkj31.learn.rulelog.def;

import com.f22pkj31.learn.rulelog.LoggerRule;
import com.f22pkj31.learn.rulelog.RuleLogger;
import com.f22pkj31.learn.rulelog.RuleLoggerLog4j;
import com.f22pkj31.learn.rulelog.RuleParam;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;

/**
 * @author bo.fan
 * @date 2019-06-28
 * @since JDK1.7
 */
public class RuleLoggerLog4jAdapter implements RuleLogger, RuleLoggerLog4j {

    private static final String FQCN = RuleLoggerLog4jAdapter.class.getName();

    private final LoggerRule rule;

    private final Logger logger;

    RuleLoggerLog4jAdapter(Logger logger, LoggerRule rule) {
        this.rule = rule;
        this.logger = logger;
    }

    /**
     * This method creates a new logging event and logs the event
     * without further checks.
     */
    protected LoggingEvent getLoggerEvent(String fqcn, Priority level, String message, Throwable t, LoggerRule rule, RuleParam param) {
        return new RuleLoggerEvent(fqcn, logger, level, message, t, rule, param);
    }

    protected void forcedLog(String fqcn, Priority level, String message, Throwable t, LoggerRule rule, RuleParam param) {
        logger.callAppenders(getLoggerEvent(fqcn, level, message, t, rule, param));
    }

    protected void forcedLog(String fqcn, Priority level, String message, Throwable t) {
        logger.callAppenders(new LoggingEvent(fqcn, logger, level, message, t));
    }


    @Override
    public void trace(String message) {
        logger.trace(message);
    }

    @Override
    public void trace(String message, Throwable t) {
        logger.trace(message, t);
    }

    @Override
    public void traceWithRule(String message, RuleParam param) {
        if (logger.getLoggerRepository().isDisabled(Level.TRACE_INT)) {
            return;
        }
        if (Level.TRACE.isGreaterOrEqual(logger.getEffectiveLevel())) {
            if (rule == null) {
                forcedLog(FQCN, Level.TRACE, message, null);
            } else {
                forcedLog(FQCN, Level.TRACE, message, null, rule, param);
            }
        }
    }

    @Override
    public void traceWithRule(String message, Throwable t, RuleParam param) {
        if (logger.getLoggerRepository().isDisabled(Level.TRACE_INT)) {
            return;
        }

        if (Level.TRACE.isGreaterOrEqual(logger.getEffectiveLevel())) {
            if (rule == null) {
                forcedLog(FQCN, Level.TRACE, message, null);
            } else {
                forcedLog(FQCN, Level.TRACE, message, t, rule, param);
            }
        }
    }

    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    @Override
    public void debug(String message, Throwable t) {
        logger.debug(message, t);
    }

    @Override
    public void debugWithRule(String message, RuleParam param) {
        if (logger.getLoggerRepository().isDisabled(Level.DEBUG_INT)) {
            return;
        }
        if (Level.DEBUG.isGreaterOrEqual(logger.getEffectiveLevel())) {
            if (rule == null) {
                forcedLog(FQCN, Level.DEBUG, message, null);
            } else {
                forcedLog(FQCN, Level.DEBUG, message, null, rule, param);
            }
        }
    }

    @Override
    public void debugWithRule(String message, Throwable t, RuleParam param) {
        if (logger.getLoggerRepository().isDisabled(Level.DEBUG_INT)) {
            return;
        }

        if (Level.DEBUG.isGreaterOrEqual(logger.getEffectiveLevel())) {
            if (rule == null) {
                forcedLog(FQCN, Level.DEBUG, message, null);
            } else {
                forcedLog(FQCN, Level.DEBUG, message, t, rule, param);
            }
        }
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void info(String message, Throwable t) {
        logger.info(message, t);
    }

    @Override
    public void infoWithRule(String message, RuleParam param) {
        if (logger.getLoggerRepository().isDisabled(Level.INFO_INT)) {
            return;
        }
        if (Level.INFO.isGreaterOrEqual(logger.getEffectiveLevel())) {
            if (rule == null) {
                forcedLog(FQCN, Level.INFO, message, null);
            } else {
                forcedLog(FQCN, Level.INFO, message, null, rule, param);
            }
        }
    }

    @Override
    public void infoWithRule(String message, Throwable t, RuleParam param) {
        if (logger.getLoggerRepository().isDisabled(Level.INFO_INT)) {
            return;
        }

        if (Level.INFO.isGreaterOrEqual(logger.getEffectiveLevel())) {
            if (rule == null) {
                forcedLog(FQCN, Level.INFO, message, null);
            } else {
                forcedLog(FQCN, Level.INFO, message, t, rule, param);
            }
        }
    }

    @Override
    public void warn(String message) {
        logger.warn(message);
    }

    @Override
    public void warn(String message, Throwable t) {
        logger.warn(message, t);
    }

    @Override
    public void warnWithRule(String message, RuleParam param) {
        if (logger.getLoggerRepository().isDisabled(Level.WARN_INT)) {
            return;
        }
        if (Level.WARN.isGreaterOrEqual(logger.getEffectiveLevel())) {
            if (rule == null) {
                forcedLog(FQCN, Level.WARN, message, null);
            } else {
                forcedLog(FQCN, Level.WARN, message, null, rule, param);
            }
        }
    }

    @Override
    public void warnWithRule(String message, Throwable t, RuleParam param) {
        if (logger.getLoggerRepository().isDisabled(Level.WARN_INT)) {
            return;
        }

        if (Level.WARN.isGreaterOrEqual(logger.getEffectiveLevel())) {
            if (rule == null) {
                forcedLog(FQCN, Level.WARN, message, null);
            } else {
                forcedLog(FQCN, Level.WARN, message, t, rule, param);
            }
        }
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public void error(String message, Throwable t) {
        logger.error(message, t);
    }

    @Override
    public void errorWithRule(String message, RuleParam param) {
        if (logger.getLoggerRepository().isDisabled(Level.ERROR_INT)) {
            return;
        }
        if (Level.ERROR.isGreaterOrEqual(logger.getEffectiveLevel())) {
            if (rule == null) {
                forcedLog(FQCN, Level.ERROR, message, null);
            } else {
                forcedLog(FQCN, Level.ERROR, message, null, rule, param);
            }
        }
    }

    @Override
    public void errorWithRule(String message, Throwable t, RuleParam param) {
        if (logger.getLoggerRepository().isDisabled(Level.ERROR_INT)) {
            return;
        }

        if (Level.ERROR.isGreaterOrEqual(logger.getEffectiveLevel())) {
            if (rule == null) {
                forcedLog(FQCN, Level.ERROR, message, null);
            } else {
                forcedLog(FQCN, Level.ERROR, message, t, rule, param);
            }
        }
    }

    public void log(String callerFQCN, Priority level, String message, Throwable t, RuleParam param) {
        if (logger.getLoggerRepository().isDisabled(level.toInt())) {
            return;
        }
        if (level.isGreaterOrEqual(logger.getEffectiveLevel())) {
            if (rule == null) {
                forcedLog(FQCN, Level.ERROR, message, null);
            } else {
                forcedLog(FQCN, Level.ERROR, message, t, rule, param);
            }
        }
    }

    @Override
    public LoggerRule getRule() {
        return rule;
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    @Override
    public boolean isEnabledFor(Level warn) {
        return logger.isEnabledFor(warn);
    }
}
