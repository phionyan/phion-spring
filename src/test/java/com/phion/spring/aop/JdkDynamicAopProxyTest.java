package com.phion.spring.aop;

import com.phion.spring.context.ApplicationContext;
import com.phion.spring.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author yanful
 * <p>
 * create in 2021/1/21 19:47
 */
public class JdkDynamicAopProxyTest {

    @Test
    public void testInterceptor() throws Exception {
        //以非aop方式调用helloService
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        HelloService helloService = (HelloService) applicationContext.getBean("helloService1");
        helloService.hello();

        //以aop方式调用helloService

        //1、设置被代理对象
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloService, HelloService.class);
        advisedSupport.setTargetSource(targetSource);

        //2、设置拦截器
        LogInterceptor interceptor = new LogInterceptor();
        advisedSupport.setMethodInterceptor(interceptor);

        //3、创建代理
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        HelloService HelloServiceProxy = (HelloService) jdkDynamicAopProxy.getProxy();

        //4、执行增强后的方法
        HelloServiceProxy.hello();

    }
}
