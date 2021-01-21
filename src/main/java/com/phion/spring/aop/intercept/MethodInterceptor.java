package com.phion.spring.aop.intercept;

/**
 * 方法上的拦截器定义
 *
 * @author yanful
 * <p>
 * create in 2021/1/21 19:35
 */
public interface MethodInterceptor extends Interceptor {

    Object invoke(MethodInvocation var1) throws Throwable;
}
