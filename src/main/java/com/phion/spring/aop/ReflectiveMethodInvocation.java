package com.phion.spring.aop;

import com.phion.spring.aop.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author yanful
 * <p>
 * create in 2021/1/21 20:26
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

    private Object target;

    private Method method;

    private Object[] args;


    public ReflectiveMethodInvocation() {

    }

    public ReflectiveMethodInvocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return args;
    }

    /**
     * 通过反射调用被代理对象自身的方法
     */
    @Override
    public Object proceed() throws Throwable {
        return method.invoke(target,args);
    }
}
