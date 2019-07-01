package com.f22pkj31.learn.rulelog.impl;

import com.f22pkj31.learn.log.SkyNetEnums;
import org.apache.log4j.Level;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;

/**
 * @author xiaojing.xie
 * @create 2019-04-22
 **/
public class SkyNetLogUtil2 {
    private static final DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @param model
     * @param category
     * @param subCategory
     */
    public static Object log(Level level
            , SkyNetEnums.ModelEnum model
            , SkyNetEnums.CategorieyEnum category
            , SkyNetEnums.SubCategoryEnum subCategory
            , String filter1
            , String filter2
            , String message
            , Throwable throwable) {

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
        //异常内容
        msg.append(message);
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
