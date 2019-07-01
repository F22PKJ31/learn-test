package com.f22pkj31.learn.rulelog.def;


import com.f22pkj31.learn.rulelog.LoggerRule;
import com.f22pkj31.learn.rulelog.RuleParam;
import com.f22pkj31.learn.rulelog.impl.SkyNetLoggerRule;
import com.f22pkj31.learn.rulelog.impl.SkyNetRuleParam;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;

import java.util.Map;

/**
 * @author bo.fan
 * @date 2019-06-27
 * @since JDK1.7
 */
public class RuleLoggerEvent extends LoggingEvent {

    private LoggerRule rule;

    private RuleParam param;

    public RuleLoggerEvent(String fqnOfCategoryClass, Category logger, Priority level,
                           Object message, Throwable throwable, LoggerRule rule, RuleParam param) {
        super(fqnOfCategoryClass, logger, level, message, throwable);
        this.rule = rule;
        this.param = param;
    }

    public RuleLoggerEvent(String fqnOfCategoryClass, Category logger, long timeStamp,
                           Priority level, Object message, Throwable throwable, LoggerRule rule, RuleParam param) {
        super(fqnOfCategoryClass, logger, timeStamp, level, message, throwable);
        this.rule = rule;
        this.param = param;
    }

    public RuleLoggerEvent(String fqnOfCategoryClass, Category logger, long timeStamp,
                           Level level, Object message, String threadName, ThrowableInformation throwable, String ndc,
                           LocationInfo info, Map properties, SkyNetLoggerRule rule, SkyNetRuleParam param) {
        super(fqnOfCategoryClass, logger, timeStamp, level, message, threadName, throwable, ndc, info, properties);
        this.rule = rule;
        this.param = param;
    }

    public LoggerRule getLoggerRule() {
        return rule;
    }

    public RuleParam getRuleParam() {
        return param;
    }
}
