package com.phion.spring.aop;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author yanful
 * <p>
 * create in 2021/1/23 13:50
 */
public class AspectJExpressionPointcutTest {

    /**
     * 判断切点表达式是否有效
     */
    @Test
    public void testClassFilter() {
        String expression = "execution(* com.phion.spring.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloServiceImpl.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* com.phion.spring.*.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(HelloServiceImpl.class.getDeclaredMethod("hello"), HelloServiceImpl.class);
        Assert.assertTrue(matches);
    }

}
