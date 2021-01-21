package com.phion.spring.aop;

import com.phion.spring.aop.intercept.MethodInterceptor;
import com.phion.spring.aop.intercept.MethodInvocation;

import java.util.Date;

/**
 *
 * 日志拦截器，记录被调用的方法及调用时长
 *
 * @author yanful
 * <p>
 * create in 2021/1/21 20:01
 */
public class LogInterceptor implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        String methodName = invocation.getMethod().getName();
        System.out.println(String.format("%s调用开始------%s",methodName,new Date()));

        //调用实际方法
        Object proceed = invocation.proceed();

        System.out.println(String.format("%s调用结束------%s",methodName,new Date()));

        return proceed;
    }
}
