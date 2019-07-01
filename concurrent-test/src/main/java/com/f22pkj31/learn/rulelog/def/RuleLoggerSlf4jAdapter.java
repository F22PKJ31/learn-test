package com.f22pkj31.learn.rulelog.def;

import com.f22pkj31.learn.rulelog.LoggerRule;
import com.f22pkj31.learn.rulelog.RuleLogger;
import com.f22pkj31.learn.rulelog.RuleParam;
import org.apache.log4j.Level;
import org.slf4j.Marker;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;

/**
 * @author bo.fan
 * @date 2019-06-28
 * @since JDK1.7
 */
public class RuleLoggerSlf4jAdapter extends MarkerIgnoringBase implements RuleLogger {

    private static final String FQCN = RuleLoggerSlf4jAdapter.class.getName();
    private final boolean traceCapable;
    private final RuleLoggerLog4jAdapter logger;

    RuleLoggerSlf4jAdapter(RuleLoggerLog4jAdapter logger) {
        this.logger = logger;
        traceCapable = isTraceEnabled();
    }

    public boolean isTraceEnabled() {
        if (traceCapable) {
            return logger.isTraceEnabled();
        } else {
            return logger.isDebugEnabled();
        }
    }

    public void trace(String msg) {
        logger.log(FQCN, traceCapable ? Level.TRACE : Level.DEBUG, msg, null, null);
    }

    public void trace(String format, Object arg) {
        if (isTraceEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            logger.log(FQCN, traceCapable ? Level.TRACE : Level.DEBUG, ft
                    .getMessage(), ft.getThrowable(), null);
        }
    }

    public void trace(String format, Object arg1, Object arg2) {
        if (isTraceEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            logger.log(FQCN, traceCapable ? Level.TRACE : Level.DEBUG, ft
                    .getMessage(), ft.getThrowable(), null);
        }
    }

    public void trace(String format, Object... arguments) {
        if (isTraceEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
            logger.log(FQCN, traceCapable ? Level.TRACE : Level.DEBUG, ft
                    .getMessage(), ft.getThrowable(), null);
        }
    }

    public void trace(String msg, Throwable t) {
        logger.log(FQCN, traceCapable ? Level.TRACE : Level.DEBUG, msg, t, null);
    }

    public void traceWithRule(String msg, RuleParam param) {
        logger.log(FQCN, traceCapable ? Level.TRACE : Level.DEBUG, msg, null, param);
    }

    public void traceWithRule(String format, Object arg, RuleParam param) {
        if (isTraceEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            logger.log(FQCN, traceCapable ? Level.TRACE : Level.DEBUG, ft
                    .getMessage(), ft.getThrowable(), param);
        }
    }

    public void traceWithRule(String format, Object arg1, Object arg2, RuleParam param) {
        if (isTraceEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            logger.log(FQCN, traceCapable ? Level.TRACE : Level.DEBUG, ft
                    .getMessage(), ft.getThrowable(), param);
        }
    }

    public void traceWithRule(String format, RuleParam param, Object... arguments) {
        if (isTraceEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
            logger.log(FQCN, traceCapable ? Level.TRACE : Level.DEBUG, ft
                    .getMessage(), ft.getThrowable(), param);
        }
    }

    public void traceWithRule(String msg, Throwable t, RuleParam param) {
        logger.log(FQCN, traceCapable ? Level.TRACE : Level.DEBUG, msg, t, param);
    }


    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    public void debug(String msg) {
        logger.log(FQCN, Level.DEBUG, msg, null, null);
    }

    public void debug(String format, Object arg) {
        if (logger.isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            logger.log(FQCN, Level.DEBUG, ft.getMessage(), ft.getThrowable(), null);
        }
    }

    public void debug(String format, Object arg1, Object arg2) {
        if (logger.isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            logger.log(FQCN, Level.DEBUG, ft.getMessage(), ft.getThrowable(), null);
        }
    }

    public void debug(String format, Object... arguments) {
        if (logger.isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
            logger.log(FQCN, Level.DEBUG, ft.getMessage(), ft.getThrowable(), null);
        }
    }


    public void debug(String msg, Throwable t) {
        logger.log(FQCN, Level.DEBUG, msg, t, null);
    }

    public void debugWithRule(String msg, RuleParam param) {
        logger.log(FQCN, Level.DEBUG, msg, null, param);
    }

    public void debugWithRule(String format, Object arg, RuleParam param) {
        if (logger.isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            logger.log(FQCN, Level.DEBUG, ft.getMessage(), ft.getThrowable(), param);
        }
    }

    public void debugWithRule(String format, Object arg1, Object arg2, RuleParam param) {
        if (logger.isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            logger.log(FQCN, Level.DEBUG, ft.getMessage(), ft.getThrowable(), param);
        }
    }

    public void debugWithRule(String format, RuleParam param, Object... arguments) {
        if (logger.isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
            logger.log(FQCN, Level.DEBUG, ft.getMessage(), ft.getThrowable(), param);
        }
    }

    public void debugWithRule(String msg, Throwable t, RuleParam param) {
        logger.log(FQCN, Level.DEBUG, msg, t, param);
    }

    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    public void info(String msg) {
        logger.log(FQCN, Level.INFO, msg, null, null);
    }

    public void info(String format, Object arg) {
        if (logger.isInfoEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            logger.log(FQCN, Level.INFO, ft.getMessage(), ft.getThrowable(), null);
        }
    }

    public void info(String format, Object arg1, Object arg2) {
        if (logger.isInfoEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            logger.log(FQCN, Level.INFO, ft.getMessage(), ft.getThrowable(), null);
        }
    }

    public void info(String format, Object... argArray) {
        if (logger.isInfoEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            logger.log(FQCN, Level.INFO, ft.getMessage(), ft.getThrowable(), null);
        }
    }

    public void info(String msg, Throwable t) {
        logger.log(FQCN, Level.INFO, msg, t, null);
    }


    public void infoWithRule(String msg, RuleParam param) {
        logger.log(FQCN, Level.INFO, msg, null, param);
    }

    public void infoWithRule(String format, Object arg, RuleParam param) {
        if (logger.isInfoEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            logger.log(FQCN, Level.INFO, ft.getMessage(), ft.getThrowable(), param);
        }
    }

    public void infoWithRule(String format, Object arg1, Object arg2, RuleParam param) {
        if (logger.isInfoEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            logger.log(FQCN, Level.INFO, ft.getMessage(), ft.getThrowable(), param);
        }
    }

    public void infoWithRule(String format, RuleParam param, Object... argArray) {
        if (logger.isInfoEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            logger.log(FQCN, Level.INFO, ft.getMessage(), ft.getThrowable(), param);
        }
    }

    public void infoWithRule(String msg, Throwable t, RuleParam param) {
        logger.log(FQCN, Level.INFO, msg, t, param);
    }


    public boolean isWarnEnabled() {
        return logger.isEnabledFor(Level.WARN);
    }

    public void warn(String msg) {
        logger.log(FQCN, Level.WARN, msg, null, null);
    }

    public void warn(String format, Object arg) {
        if (logger.isEnabledFor(Level.WARN)) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            logger.log(FQCN, Level.WARN, ft.getMessage(), ft.getThrowable(), null);
        }
    }

    public void warn(String format, Object arg1, Object arg2) {
        if (logger.isEnabledFor(Level.WARN)) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            logger.log(FQCN, Level.WARN, ft.getMessage(), ft.getThrowable(), null);
        }
    }

    public void warn(String format, Object... argArray) {
        if (logger.isEnabledFor(Level.WARN)) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            logger.log(FQCN, Level.WARN, ft.getMessage(), ft.getThrowable(), null);
        }
    }

    public void warn(String msg, Throwable t) {
        logger.log(FQCN, Level.WARN, msg, t, null);
    }


    public void warnWithRule(String msg, RuleParam param) {
        logger.log(FQCN, Level.WARN, msg, null, null);
    }

    public void warnWithRule(String format, Object arg, RuleParam param) {
        if (logger.isEnabledFor(Level.WARN)) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            logger.log(FQCN, Level.WARN, ft.getMessage(), ft.getThrowable(), null);
        }
    }

    public void warnWithRule(String format, Object arg1, Object arg2, RuleParam param) {
        if (logger.isEnabledFor(Level.WARN)) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            logger.log(FQCN, Level.WARN, ft.getMessage(), ft.getThrowable(), null);
        }
    }

    public void warnWithRule(String format, RuleParam param, Object... argArray) {
        if (logger.isEnabledFor(Level.WARN)) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            logger.log(FQCN, Level.WARN, ft.getMessage(), ft.getThrowable(), null);
        }
    }

    public void warnWithRule(String msg, Throwable t, RuleParam param) {
        logger.log(FQCN, Level.WARN, msg, t, null);
    }


    public boolean isErrorEnabled() {
        return logger.isEnabledFor(Level.ERROR);
    }

    public void error(String msg) {
        logger.log(FQCN, Level.ERROR, msg, null, null);
    }

    public void error(String format, Object arg) {
        if (logger.isEnabledFor(Level.ERROR)) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            logger.log(FQCN, Level.ERROR, ft.getMessage(), ft.getThrowable(), null);
        }
    }

    public void error(String format, Object arg1, Object arg2) {
        if (logger.isEnabledFor(Level.ERROR)) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            logger.log(FQCN, Level.ERROR, ft.getMessage(), ft.getThrowable(), null);
        }
    }

    public void error(String format, Object... argArray) {
        if (logger.isEnabledFor(Level.ERROR)) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            logger.log(FQCN, Level.ERROR, ft.getMessage(), ft.getThrowable(), null);
        }
    }

    public void error(String msg, Throwable t) {
        logger.log(FQCN, Level.ERROR, msg, t, null);
    }


    public void errorWithRule(String msg, RuleParam param) {
        logger.log(FQCN, Level.ERROR, msg, null, param);
    }

    public void errorWithRule(String format, Object arg, RuleParam param) {
        if (logger.isEnabledFor(Level.ERROR)) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            logger.log(FQCN, Level.ERROR, ft.getMessage(), ft.getThrowable(), param);
        }
    }

    public void errorWithRule(String format, Object arg1, Object arg2, RuleParam param) {
        if (logger.isEnabledFor(Level.ERROR)) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            logger.log(FQCN, Level.ERROR, ft.getMessage(), ft.getThrowable(), param);
        }
    }

    public void errorWithRule(String format, RuleParam param, Object... argArray) {
        if (logger.isEnabledFor(Level.ERROR)) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            logger.log(FQCN, Level.ERROR, ft.getMessage(), ft.getThrowable(), param);
        }
    }

    public void errorWithRule(String msg, Throwable t, RuleParam param) {
        logger.log(FQCN, Level.ERROR, msg, t, param);
    }

    public void log(Marker marker, String callerFQCN, int level, String msg,
                    Object[] argArray, Throwable t) {
        Level log4jLevel = getLevel(level);
        logger.log(callerFQCN, log4jLevel, msg, t, null);
    }

    private Level getLevel(int level) {
        Level log4jLevel;
        switch (level) {
            case LocationAwareLogger.TRACE_INT:
                log4jLevel = traceCapable ? Level.TRACE : Level.DEBUG;
                break;
            case LocationAwareLogger.DEBUG_INT:
                log4jLevel = Level.DEBUG;
                break;
            case LocationAwareLogger.INFO_INT:
                log4jLevel = Level.INFO;
                break;
            case LocationAwareLogger.WARN_INT:
                log4jLevel = Level.WARN;
                break;
            case LocationAwareLogger.ERROR_INT:
                log4jLevel = Level.ERROR;
                break;
            default:
                throw new IllegalStateException("Level number " + level
                        + " is not recognized.");
        }
        return log4jLevel;
    }

    public void log(Marker marker, String callerFQCN, int level, String msg,
                    Object[] argArray, Throwable t, RuleParam param) {
        Level log4jLevel = getLevel(level);
        logger.log(callerFQCN, log4jLevel, msg, t, param);
    }


    @Override
    public LoggerRule getRule() {
        return logger.getRule();
    }
}
