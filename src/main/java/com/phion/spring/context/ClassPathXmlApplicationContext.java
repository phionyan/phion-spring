package com.phion.spring.context;

import com.phion.spring.beans.BeanDefinition;
import com.phion.spring.beans.factory.AbstractBeanFactory;
import com.phion.spring.beans.factory.AutowireCapableBeanFactory;
import com.phion.spring.beans.io.ResourceLoader;
import com.phion.spring.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * 通过读取xml配置实现的应用上下文
 *
 * @author yanful
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    //配置文件的位置
    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
        //初始化bean工厂
        super(beanFactory);
        this.configLocation = configLocation;
        //刷新bean工厂数据
        refresh();
    }

    @Override
    public void refresh() throws Exception {

        //使用xml bean 解析器读取资源
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
        reader.loadBeanDefinitions("application.xml");

        //将注册表中的bean注入bean工厂
        for (Map.Entry<String, BeanDefinition> entry : reader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(),entry.getValue());
        }

    }
}
