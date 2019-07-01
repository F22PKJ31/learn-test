package com.f22pkj31.learn.log;

import com.elong.hotel.dc.util.StringUtils;
import org.apache.log4j.Level;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaojing.xie
 * @create 2019-04-22
 **/
public class SkyNetLogUtil {
    private static final DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @param logger
     * @param level
     * @param model
     * @param category
     * @param subCategory
     * @param msgFormat
     * @param args
     */
    public static void log(Logger logger
            , SkyNetEnums.LogLevelEnum level
            , SkyNetEnums.ModelEnum model
            , SkyNetEnums.CategorieyEnum category
            , SkyNetEnums.SubCategoryEnum subCategory
            , String filter1
            , String filter2
            , Throwable throwable
            , String msgFormat
            , Object... args) {

        //日志格式：日期时间 日志级别 <模块><大类><小类><文本过滤1><文本过滤2>日志内容
        StringBuilder msg = new StringBuilder();
//        msg.append(DateTime.now().toString(format));
        msg.append(" ");
        msg.append(throwable != null ? SkyNetEnums.LogLevelEnum.ERROR.getLevel() : level.getLevel());
        msg.append(" ");
        msg.append(MessageFormat.format("<{0}><{1}><{2}><{3}><{4}>"
                , model.getModel()
                , category.getCategoriey()
                , subCategory.getSubCategory()
                , org.apache.commons.lang3.StringUtils.isBlank(filter1) ? "All" : filter1
                , org.apache.commons.lang3.StringUtils.isBlank(filter2) ? "All" : filter2));
        //无参数
        if (args == null || args.length == 0) {
            msg.append(msgFormat);
        } else {
            String[] arr = new String[args.length];
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof Date) {
                    arr[i] = dataFormat.format(args[i]);
                } else
                    arr[i] = String.valueOf(args[i]);
            }
            msg.append(MessageFormat.format(msgFormat, args));
        }
        //异常内容
        if (throwable != null) {
            msg.append(MessageFormat.format("err={0},trace={1}"
                    , throwable.toString()
                    , StringUtils.getPlainStackTrace(throwable)));
        }
        logger.info(msg.toString());
    }

    public static String getMessage(Level level
            , SkyNetEnums.ModelEnum model
            , SkyNetEnums.CategorieyEnum category
            , SkyNetEnums.SubCategoryEnum subCategory
            , String filter1
            , String filter2
            , Throwable throwable
            , String msgFormat
            , Object... args) {

        //日志格式：日期时间 日志级别 <模块><大类><小类><文本过滤1><文本过滤2>日志内容
        StringBuilder msg = new StringBuilder();
        msg.append(DateTime.now().toString(format));
        msg.append(" ");
        msg.append(throwable != null ? SkyNetEnums.LogLevelEnum.ERROR.getLevel() : level.toString());
        msg.append(" ");
        msg.append(MessageFormat.format("<{0}><{1}><{2}><{3}><{4}>"
                , model.getModel()
                , category.getCategoriey()
                , subCategory.getSubCategory()
                , org.apache.commons.lang3.StringUtils.isBlank(filter1) ? "All" : filter1
                , org.apache.commons.lang3.StringUtils.isBlank(filter2) ? "All" : filter2));
        //无参数
        if (args == null || args.length == 0) {
            msg.append(msgFormat);
        } else {
            String[] arr = new String[args.length];
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof Date) {
                    arr[i] = dataFormat.format(args[i]);
                } else
                    arr[i] = String.valueOf(args[i]);
            }
            msg.append(MessageFormat.format(msgFormat, args));
        }
        //异常内容
        if (throwable != null) {
            msg.append(MessageFormat.format("err={0},trace={1}"
                    , throwable.toString()
                    , StringUtils.getPlainStackTrace(throwable)));
        }
        return msg.toString();
    }


//    static final Throwable getThrowableCandidate(Object[] argArray) {
//        if (argArray != null && argArray.length != 0) {
//            Object lastEntry = argArray[argArray.length - 1];
//            return lastEntry instanceof Throwable ? (Throwable)lastEntry : null;
//        } else {
//            return null;
//        }
//    }
}
