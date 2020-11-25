package com.phion.spring.ioc;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用对象封装属性信息，而不是直接在beanDefinition里面使用List
 * 好处是可以在封装一些方法
 *
 * @author yanful
 */
@Slf4j
public class PropertyValues {

    private List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        //避免插入重复的属性,所以重写PropertyValue的equals方法
        if (propertyValueList.contains(pv)) {
            log.warn("replicate property ignore ! Property:{}", pv);
            return;
        }
        propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValueList;
    }
}
