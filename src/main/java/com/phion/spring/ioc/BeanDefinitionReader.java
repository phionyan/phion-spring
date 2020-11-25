package com.phion.spring.ioc;

/**
 * bean加载器定义
 *
 * 要求bean加载器必须提供loadBeanDefinitions方法
 *
 * @author yanful
 */
public interface BeanDefinitionReader {

    /**
     * 加载bean的方法
     * @param location 数据源位置
     */
    void loadBeanDefinitions(String location) throws Exception;
}
