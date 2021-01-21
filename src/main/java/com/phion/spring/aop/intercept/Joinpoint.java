package com.phion.spring.aop.intercept;

public interface Joinpoint {

    Object proceed() throws Throwable;
}