package com.phion.spring.ioc.beans;

import com.phion.spring.ioc.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象的读取bean信息的工具类
 *
 * 提供注册表了解扫描出的bean信息，提供资源加载器获取资源文件
 *
 * @author yanful
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    //定义注册表，用来保存所有注册的bean，同时可以避免扫描重复的bean定义信息
    private Map<String,BeanDefinition> registry;

    //资源加载器
    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.registry = new HashMap<>();
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
