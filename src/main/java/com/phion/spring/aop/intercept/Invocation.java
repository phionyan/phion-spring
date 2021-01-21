package com.phion.spring.aop.intercept;

public interface Invocation extends Joinpoint {

    Object[] getArguments();
}