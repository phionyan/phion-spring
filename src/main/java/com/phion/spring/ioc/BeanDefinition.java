package com.phion.spring.ioc;

import java.util.List;

/**
 * 注入一个bean的时候，传入的对象
 * <p>
 * 支持通过传入类名来注入对象的方式
 *
 * @author yanful
 */
public class BeanDefinition {

    //实际的对象
    private Object bean;

    private Class beanClass;

    private String beanClassName;

    //存储对象的属性信息
    private PropertyValues propertyValues;

    //使用无参构造器，通过属于注入bean
    public BeanDefinition() {
    }

    /**
     * 通过类名加载此类
     *
     * @param beanClassName 类名
     */
    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    @Override
    public String toString() {
        return "BeanDefinition{" +
                "bean=" + bean +
                ", beanClass=" + beanClass +
                ", beanClassName='" + beanClassName + '\'' +
                ", propertyValues=" + propertyValues +
                '}';
    }
}
