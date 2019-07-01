package com.f22pkj31.learn.rulelog.impl;


import com.f22pkj31.learn.rulelog.RuleParam;

/**
 * @author bo.fan
 * @date 2019-06-27
 * @since JDK1.7
 */
public class SkyNetRuleParam implements RuleParam {

    private String one;

    private String two;

    private SkyNetEnums.LogLevelEnum logLevelEnum;

    public SkyNetRuleParam(String one, String two) {
        this.one = one;
        this.two = two;
    }

    @Override
    public Object getParam(Object key) {
        if (ObjectUtils.equals(key, 1)) {
            return one;
        } else if (ObjectUtils.equals(key, 2)) {
            return two;
        } else {
            return logLevelEnum;
        }
    }
}
