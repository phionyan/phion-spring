package com.phion.spring.aop;

/**
 * 被代理的对象
 *
 * @author yanful
 * <p>
 * create in 2021/1/21 19:24
 */
public class TargetSource {

    private Class<?> targetClass;

    private Object target;

    public TargetSource(){

    }

    public TargetSource(Object target, Class<?> targetClass) {
        this.target = target;
        this.targetClass = targetClass;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }
}
