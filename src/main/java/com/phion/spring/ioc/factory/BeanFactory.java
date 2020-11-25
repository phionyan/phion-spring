package com.phion.spring.ioc.factory;

import com.phion.spring.ioc.BeanDefinition;

/**
 * bean工厂规范，定义基本功能
 *
 * @author yanful
 */
public interface BeanFactory {

    /**
     * 根据bean名称获取bean
     * @param name bean名称
     * @return 被ioc容器管理的bean
     */
    Object getBean(String name);

    /**
     * 往ioc容器中注册一个bean
     * @param name bean名称
     * @param beanDefinition bean定义信息
     */
    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
