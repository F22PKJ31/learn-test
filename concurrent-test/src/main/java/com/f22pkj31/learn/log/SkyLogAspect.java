package com.f22pkj31.learn.log;

import com.elong.hotel.dc.common.util.soa.SoaNode;
import com.elong.hotel.dc.util.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (天网日志切面)
 * <p>
 * <p>
 * 修改历史:											<br>
 * 修改日期    		修改人员   	版本	 		修改内容<br>
 * -------------------------------------------------<br>
 * 2019-05-22 17:42  liulihan     1.0    	初始化创建<br>
 * </p>
 *
 * @author liulihan
 * @version 1.0
 * @since JDK1.7
 */
@Component
@Aspect
@Order(1002)
public class SkyLogAspect {
    private org.slf4j.Logger skyNetlogger = LoggerFactory.getLogger("skyNetLogger");

    /**
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "execution(@com.elong.hotel.dc.common.util.log.SkyLog public * *(..) ) ")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object o = null;
        Throwable e1 = null;
        try {
            o = joinPoint.proceed();
        } catch (Throwable e) {
            e1 = e;
            throw e;
        } finally {
            try {
                String msg = StringUtils.EMPTY;
                String filter1 = StringUtils.EMPTY;
                if (joinPoint.getArgs().length > 1) {
                    if (joinPoint.getArgs()[1] == null) {
                        filter1 = StringUtils.EMPTY;
                    } else if (joinPoint.getArgs()[1] instanceof String) {
                        filter1 = String.valueOf(joinPoint.getArgs()[1]);
                    } else {
                        filter1 = JsonUtils.Fast.toJson(joinPoint.getArgs()[1]);
                    }
                }
                String filter2 = StringUtils.EMPTY;
                if (joinPoint.getArgs().length > 2) {
                    if (joinPoint.getArgs()[2] == null) {
                        filter2 = StringUtils.EMPTY;
                    } else if (joinPoint.getArgs()[2] instanceof String) {
                        filter2 = String.valueOf(joinPoint.getArgs()[2]);
                    } else {
                        filter2 = JsonUtils.Fast.toJson(joinPoint.getArgs()[2]);
                    }

                }
                String req = StringUtils.EMPTY;
                if (joinPoint.getArgs().length > 0) {
                    req = JsonUtils.Fast.toJson(joinPoint.getArgs());
                }
                String className = joinPoint.getTarget().getClass().getName();
                String methodName = joinPoint.getSignature().getName();
                Class<?> classTarget = joinPoint.getTarget().getClass();
                Method objMethod = classTarget.getMethod(methodName, ((MethodSignature) joinPoint.getSignature()).getParameterTypes());
                SkyLog annotation = objMethod.getAnnotation(SkyLog.class);
                SoaNode soaNode = objMethod.getAnnotation(SoaNode.class);
                if (soaNode == null) {
                    String messageFormat = "类名{0},接口名{1},请求内容{2},返回内容:{3}";
                    msg = MessageFormat.format(messageFormat, className, methodName, req, JsonUtils.Fast.toJson(o));
                } else {
                    String messageFormat = "soa调用产品线:{0},soa调用服务线:{1},soa调用方法名:{2},请求内容{3},返回内容:{4}";
                    msg = MessageFormat.format(messageFormat, soaNode.ProductName(), soaNode.ServiceName(), soaNode.MethodName(), req, JsonUtils.Fast.toJson(o));
                }

                //去掉一个字符串中的换行符、回车符,多个空格等
                Pattern p = Pattern.compile("\t|\r|\n");
                Matcher m = p.matcher(msg);
                msg = m.replaceAll("");
                msg = msg.replaceAll(" +", "");

                SkyNetLogUtil.log(skyNetlogger, annotation.level(), annotation.model(), annotation.category()
                        , annotation.subCategory(), filter1, filter2, e1, msg);

            } catch (Exception e) {
                //do nothing
            }

        }
        return o;
    }
}
