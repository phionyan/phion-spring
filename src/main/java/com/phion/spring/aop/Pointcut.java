package com.phion.spring.aop;

/**
 *
 *
 * @author yanful
 * <p>
 * create in 2021/1/23 13:54
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
