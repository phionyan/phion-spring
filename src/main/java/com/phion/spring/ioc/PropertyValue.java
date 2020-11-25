package com.phion.spring.ioc;

import java.util.Objects;

/**
 * @author yanful
 */
public class PropertyValue {

    private String name;

    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyValue that = (PropertyValue) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(value, that.value);
    }

    /**
     * 具有相同name和value的hash值相同
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}
