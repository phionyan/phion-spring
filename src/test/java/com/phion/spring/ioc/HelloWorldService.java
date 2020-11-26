package com.phion.spring.ioc;

import lombok.Data;

/**
 * @author yanful
 */
@Data
public class HelloWorldService {

    private String msg;

    private User user;

    public void helloWorld(){
        System.out.printf("%s ,who is %s yesrs old ,%s ,say :%s%n",user.getName(),user.getAge(),
                user.getGender(),msg);
    }

}
