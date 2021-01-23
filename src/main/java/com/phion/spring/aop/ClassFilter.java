package com.phion.spring.aop;

public interface ClassFilter {

    boolean matches(Class<?> targetClass);
}
