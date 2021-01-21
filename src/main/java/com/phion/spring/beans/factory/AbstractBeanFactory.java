package com.phion.spring.beans.factory;

import com.phion.spring.beans.BeanDefinition;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 抽象bean工厂，管理所有的bean
 * <p>
 * 提供默认的注册与获取bean的方法
 *
 * @author yanful
 */
@Slf4j
public abstract class AbstractBeanFactory implements BeanFactory {

    /**
     * 存储所有的bean对象，这就是ioc容器最核心的地方
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    //使用list存储所有bean名称不可变
    private final List<String> beanDefinitionNames = new ArrayList<>();

    /**
     * 对延迟加载适配
     *
     * @param name bean名称
     * @return bean
     */
    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (Objects.isNull(beanDefinition)) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (Objects.isNull(bean)) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    /**
     * 注入对象的方法
     * <p>
     * 默认使用延迟加载，即使用时才实例化bean
     *
     * @param name           对象名称，唯一标识
     * @param beanDefinition 对象定义信息
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {

        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    /**
     * 提前初始化bean
     */
    public void preInstantiateSingletons() throws Exception {
        for (String name : beanDefinitionNames) {
            getBean(name);
        }
    }

    /**
     * 通过类定义信息注入默认的bean，抽象方法，给子类实现
     *
     * @param beanDefinition bean定义信息
     * @return 注入的bean
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException, NoSuchFieldException, Exception;
}
