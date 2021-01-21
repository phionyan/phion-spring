package com.phion.spring.ioc;

import com.phion.spring.beans.AbstractBeanDefinitionReader;
import com.phion.spring.beans.BeanDefinition;
import com.phion.spring.beans.factory.AbstractBeanFactory;
import com.phion.spring.beans.factory.AutowireCapableBeanFactory;
import com.phion.spring.beans.io.ResourceLoader;
import com.phion.spring.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * @author yanful
 */
public class BeanFactoryTest {

    /**
     * 测试延迟加载，可以看出，当调用doCreateBean方法前，
     * bena已经注册到bean工厂，但是未实例化(bean=null)
     * 当我们使用这个类
     */
    @Test
    public void testLazy() throws Exception {

        //1、读取配置文件
        AbstractBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        definitionReader.loadBeanDefinitions("application.xml");

        //2、注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        Map<String, BeanDefinition> registry = definitionReader.getRegistry();
        for (Map.Entry<String, BeanDefinition> entry : registry.entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
        }

        //3、获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloService");
        helloWorldService.helloWorld();

    }


    /**
     * 测试预加载
     */
    @Test
    public void testPreInitiate() throws Exception {
        //1、读取配置文件
        AbstractBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        definitionReader.loadBeanDefinitions("application.xml");

        //2、注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        Map<String, BeanDefinition> registry = definitionReader.getRegistry();
        for (Map.Entry<String, BeanDefinition> entry : registry.entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
        }

        //3、预加载
        beanFactory.preInstantiateSingletons();

        //4、获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloService");
        helloWorldService.helloWorld();
    }
}
