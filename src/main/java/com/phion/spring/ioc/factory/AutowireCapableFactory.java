package com.phion.spring.ioc.factory;

/**
 *
 * 可以实现自动装配的bean工厂，不需要手动注入
 *
 * @author yanful
 */
public class AutowireCapableFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
