package com.phion.spring.ioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * bean工厂，管理所有的bean
 *
 * @author yanful
 */
public class BeanFactory {

    /**
     * 存储所有的bean对象，这就是ioc容器最核心的地方
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    /**
     * 注入对象的方法
     * @param name 对象名称，唯一标识
     * @param beanDefinition 对象定义信息
     */
    public void registerBeanDefiniton(String name,BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
    }
}
