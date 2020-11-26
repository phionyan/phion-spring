package com.phion.spring.ioc.beans.factory;

import com.phion.spring.ioc.beans.BeanDefinition;

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
    Object getBean(String name) throws Exception;
}
