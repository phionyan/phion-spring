package com.phion.spring.ioc;

import com.phion.spring.ioc.factory.AutowireCapableFactory;
import com.phion.spring.ioc.factory.BeanFactory;
import org.junit.Test;

/**
 * @author yanful
 */
public class BeanFactoryTest {

    @Test
    public void test() throws Exception {

        //1、初始化bean工厂
        BeanFactory beanFactory = new AutowireCapableFactory();

        //2、bean定义
        BeanDefinition definition = new BeanDefinition();
        definition.setBeanClassName("com.phion.spring.ioc.HelloWorldService");

        //3、注入属性
        PropertyValues values = new PropertyValues();
        PropertyValue pv = new PropertyValue("msg","this is my msg!");
        values.addPropertyValue(pv);
        definition.setPropertyValues(values);

        //4、注入bean
        beanFactory.registerBeanDefinition("helloService",definition);

        //5、获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloService");
        helloWorldService.helloWorld();
    }
}
