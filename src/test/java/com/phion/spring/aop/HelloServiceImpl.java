package com.phion.spring.aop;

/**
 * @author yanful
 * <p>
 * create in 2021/1/21 20:46
 */
public class HelloServiceImpl implements HelloService{

    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public void hello() {
        System.out.println(msg);
    }
}
