package com.phion.spring.ioc.support;

/**
 * @author yanful
 */
public class StringUtils {

    public static Boolean isEmpty(String str){
        return str == null || str.length() <= 0;
    }

    public static Boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
