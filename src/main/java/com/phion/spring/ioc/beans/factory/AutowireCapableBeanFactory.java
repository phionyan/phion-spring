package com.phion.spring.ioc.beans.factory;

import com.phion.spring.ioc.beans.BeanDefinition;
import com.phion.spring.ioc.BeanReference;
import com.phion.spring.ioc.beans.PropertyValue;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 *
 * 可以实现自动装配的bean工厂，不需要手动注入
 *
 * @author yanful
 */
@Slf4j
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
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
    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {

        for(PropertyValue pv : beanDefinition.getPropertyValues().getPropertyValues()){
            //找出bean中对应的属性
            Field declaredFiled = bean.getClass().getDeclaredField(pv.getName());
            //找出对应属性值
            Object value = pv.getValue();
            if(value instanceof BeanReference){
                BeanReference reference = (BeanReference) value;
                value = getBean(reference.getName());
            }
            //注入属性值，忽略访问限制
            declaredFiled.setAccessible(true);
            declaredFiled.set(bean,value);
        }
    }
}
