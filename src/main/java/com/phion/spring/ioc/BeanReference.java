package com.phion.spring.ioc;

import lombok.Data;

/**
 * 对象引用信息
 *
 * @author yanful
 */
@Data
public class BeanReference {

    private String name;

    private Object bean;

    public BeanReference(String name){
        this.name = name;
    }
}
