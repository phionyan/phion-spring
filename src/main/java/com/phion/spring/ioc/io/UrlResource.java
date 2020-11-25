package com.phion.spring.ioc.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 可以通过一个URL信息获取配置文件
 *
 * @author yanful
 */
public class UrlResource implements Resource{


    private URL url;

    public UrlResource(URL url){
        this.url = url;
    }

    /**
     * 通过URL获取文件输入流
     */
    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
