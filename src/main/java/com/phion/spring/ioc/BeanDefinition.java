package com.phion.spring.ioc;

/**
 * 注入一个bean的时候，传入的对象
 *
 * @author yanful
 */
public class BeanDefinition {

    //实际的对象
    private Object bean;

    public BeanDefinition(Object bean){
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
