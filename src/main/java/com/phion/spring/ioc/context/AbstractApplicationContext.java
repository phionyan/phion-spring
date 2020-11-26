package com.phion.spring.ioc.context;

import com.phion.spring.ioc.beans.factory.AbstractBeanFactory;

/**
 * 抽象应用上下文，定义基本功能
 * <p>
 * 1、具备DI的能力
 *
 * @author yanful
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    //bean工厂，提供DI能力
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * 能够刷新上下文内容
     */
    public abstract void refresh() throws Exception;

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
