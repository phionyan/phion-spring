package com.phion.spring.context;

import com.phion.spring.ioc.HelloWorldService;
import org.junit.Test;

/**
 * @author yanful
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        HelloWorldService helloWorldService = (HelloWorldService) context.getBean("helloService");
        helloWorldService.helloWorld();
    }
}
