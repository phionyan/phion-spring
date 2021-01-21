package com.phion.spring.aop;

import com.phion.spring.aop.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * aop代理，jdk动态代理实现
 * <p>
 * 根据代理信息（AdvisedSupport)生成代理对象
 *
 * @author yanful
 * <p>
 * create in 2021/1/21 20:10
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

    private AdvisedSupport advised;

    public JdkDynamicAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }

    @Override
    public Object getProxy() {
        //使用JDK动态代理能力，生成代理对象,处理方为当前代理对象(InvocationHandler的实例)，JDK动态代理会调用自己的invoke方法，实现代理
        return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{advised.getTargetSource()
                .getTargetClass()}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //此处处理代理逻辑、对被代理对象增强
        //首先根据被代理信息，找到被代理对象绑定的拦截器，使用其对被代理对象方法增强
        MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
        //具体增强逻辑交由拦截器自身处理,传入被代理对象
        return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(), method, args));
    }
}
