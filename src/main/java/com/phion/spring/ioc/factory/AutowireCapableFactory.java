package com.phion.spring.ioc.factory;

import com.phion.spring.ioc.BeanDefinition;
import com.phion.spring.ioc.PropertyValue;

import java.lang.reflect.Field;

/**
 *
 * 可以实现自动装配的bean工厂，不需要手动注入
 *
 * @author yanful
 */
public class AutowireCapableFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {

        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    /**
     * 封装创建bean的方法
     * @param beanDefinition bean定义信息
     */
    private Object createBeanInstance(BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException {
        return beanDefinition.getBeanClass().newInstance();
    }

    /**
     * 封装属性注入方法
     *
     * 这里采用反射注入属性
     */
    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws NoSuchFieldException, IllegalAccessException {

        for(PropertyValue pv : beanDefinition.getPropertyValues().getPropertyValues()){
            //找出bean中对应的属性
            Field declaredFiled = bean.getClass().getDeclaredField(pv.getName());
            //注入属性值，忽略访问限制
            declaredFiled.setAccessible(true);
            declaredFiled.set(bean,pv.getValue());
        }
    }
}
