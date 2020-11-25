package com.phion.spring.ioc;

import com.phion.spring.ioc.factory.AutowireCapableFactory;
import com.phion.spring.ioc.factory.BeanFactory;
import com.phion.spring.ioc.io.ResourceLoader;
import com.phion.spring.ioc.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * @author yanful
 */
public class BeanFactoryTest {

    @Test
    public void test() throws Exception {

        //1、读取配置文件
        AbstractBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        definitionReader.loadBeanDefinitions("application.xml");

        //2、注册bean
        BeanFactory beanFactory = new AutowireCapableFactory();
        Map<String,BeanDefinition> registry = definitionReader.getRegistry();
        for(Map.Entry<String,BeanDefinition> entry : registry.entrySet()){
            beanFactory.registerBeanDefinition(entry.getKey(),entry.getValue());
        }

        //3、获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloService");
        helloWorldService.helloWorld();
    }
}
