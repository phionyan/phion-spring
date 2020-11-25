package com.phion.spring.ioc.xml;

import com.phion.spring.ioc.BeanDefinition;
import com.phion.spring.ioc.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author yanful
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("application.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        for (Map.Entry<String, BeanDefinition> entry : registry.entrySet()) {
            String key = entry.getKey();
            BeanDefinition value = entry.getValue();
            System.out.println(String.format("beanName:%s-----------class:%s",key,value));
        }
        Assert.assertTrue(registry.size() > 0);
    }
}


