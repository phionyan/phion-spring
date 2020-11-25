package com.phion.spring.ioc;

import lombok.Data;

/**
 * @author yanful
 */
@Data
public class HelloWorldService {

    private String msg;

    public void helloWorld(){
        System.out.println(getMsg());
    }

}
