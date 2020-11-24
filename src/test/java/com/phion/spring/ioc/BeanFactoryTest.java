package com.phion.spring.ioc;

import org.junit.Test;

/**
 * @author yanful
 */
public class BeanFactoryTest {

    @Test
    public void test(){

        //1、初始化bean工厂
        BeanFactory beanFactory = new BeanFactory();

        //2、注入bean
        BeanDefinition definition = new BeanDefinition(new HelloWorldService());
        beanFactory.registerBeanDefiniton("helloService",definition);

        //3、获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloService");
        helloWorldService.helloWorld();
    }
}
