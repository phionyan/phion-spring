package com.phion.spring.ioc.io;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * @author yanful
 */
public class ResourceLoaderTest {

    @Test
    public void test() throws IOException {
        ResourceLoader resourceLoader = new ResourceLoader();
        InputStream ios = resourceLoader.getResource("application.xml").getInputStream();
        byte[] data = new byte[1024];
        String dataStr = new String();
        int len = 0;
        while ((len = ios.read(data)) != -1){
            dataStr += new String(data);
        }
        System.out.println(dataStr);
    }
}
