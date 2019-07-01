package com.f22pkj31.learn.rulelog.impl;

import com.f22pkj31.learn.log.SkyNetEnums;
import com.f22pkj31.learn.log.SkyNetLogUtil;
import com.f22pkj31.learn.rulelog.LoggerRule;
import com.f22pkj31.learn.rulelog.RuleParam;
import org.apache.log4j.spi.LoggingEvent;


/**
 * @author bo.fan
 * @date 2019-06-27
 * @since JDK1.7
 */
public class SkyNetLoggerRule implements LoggerRule {


    private SkyNetEnums.ModelEnum first;

    private SkyNetEnums.CategorieyEnum second;

    private SkyNetEnums.SubCategoryEnum third;

    public SkyNetLoggerRule(SkyNetEnums.ModelEnum first, SkyNetEnums.CategorieyEnum second, SkyNetEnums.SubCategoryEnum third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public LoggingEvent delimitOverallRule(LoggingEvent event, RuleParam param) {

        if (param == null) {
            return changeMessage(event, SkyNetLogUtil.getMessage(event.getLevel()
                    , this.first
                    , this.second
                    , this.third
                    , null
                    , null
                    , null
                    , event.getMessage().toString()));
        }
        return changeMessage(event, SkyNetLogUtil.getMessage(event.getLevel()
                , this.first
                , this.second
                , this.third
                , param.getParam(1).toString()
                , param.getParam(2).toString()
                , null
                , event.getMessage().toString()));
    }

    private LoggingEvent changeMessage(LoggingEvent event, Object newMessage) {
        return new LoggingEvent(event.getFQNOfLoggerClass(), event.getLogger()
                , event.getTimeStamp(), event.getLevel()
                , newMessage, event.getThreadName()
                , event.getThrowableInformation(), event.getNDC()
                , event.getLocationInformation(), event.getProperties());
    }


}
