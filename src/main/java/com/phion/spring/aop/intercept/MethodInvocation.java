package com.phion.spring.aop.intercept;

import java.lang.reflect.Method;

public interface MethodInvocation extends Invocation {
    Method getMethod();
}