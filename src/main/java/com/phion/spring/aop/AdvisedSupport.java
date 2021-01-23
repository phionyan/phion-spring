package com.phion.spring.aop;

import com.phion.spring.aop.intercept.MethodInterceptor;

/**
 * 代理相关的元数据
 *
 * 切入方式的支持，在这里实现具体逻辑
 *
 * 比如拦截器，这里支持拦截方法
 * @author yanful
 * <p>
 * create in 2021/1/21 19:22
 */
public class AdvisedSupport {

    private TargetSource targetSource;

    private MethodInterceptor methodInterceptor;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }
}
