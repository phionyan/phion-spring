package com.phion.spring.ioc.factory;

import com.phion.spring.ioc.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 抽象bean工厂，管理所有的bean
 *
 * 提供默认的注册与获取bean的方法
 *
 * @author yanful
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    /**
     * 存储所有的bean对象，这就是ioc容器最核心的地方
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    /**
     * 注入对象的方法
     * @param name 对象名称，唯一标识
     * @param beanDefinition 对象定义信息
     */
    @Override
    public void registerBeanDefinition(String name,BeanDefinition beanDefinition) throws Exception {

        Object bean = doCreateBean(beanDefinition);

        beanDefinition.setBean(bean);

        beanDefinitionMap.put(name,beanDefinition);
    }

    /**
     * 通过类定义信息注入默认的bean，抽象方法，给子类实现
     * @param beanDefinition bean定义信息
     * @return 注入的bean
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException, NoSuchFieldException, Exception;
}
