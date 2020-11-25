package com.phion.spring.ioc.support;

import java.util.Collection;
import java.util.Objects;

/**
 * @author yanful
 */
public class CollectionsUtils {

    public static Boolean isEmpty(Collection<?> collection){
        if(Objects.isNull(collection)){
            return true;
        }
        if(collection.isEmpty()){
            return true;
        }
        return false;
    }

    public static Boolean isNotEmpty(Collection<?> collection){
        return !isEmpty(collection);
    }
}
