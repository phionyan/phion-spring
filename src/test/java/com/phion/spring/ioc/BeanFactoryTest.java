package com.phion.spring.ioc;

import com.phion.spring.ioc.factory.AutowireCapableFactory;
import com.phion.spring.ioc.factory.BeanDefinition;
import org.junit.Test;

/**
 * @author yanful
 */
public class BeanFactoryTest {

    @Test
    public void test(){

        //1、初始化bean工厂
        BeanFactory beanFactory = new AutowireCapableFactory();

        //2、注入bean
        BeanDefinition definition = new BeanDefinition();
        definition.setBeanClassName("com.phion.spring.ioc.HelloWorldService");
        beanFactory.registerBeanDefinition("helloService",definition);

        //3、获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloService");
        helloWorldService.helloWorld();
    }
}
