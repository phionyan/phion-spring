package com.phion.spring.ioc.io;

import java.net.URL;

/**
 * 资源文件加载器
 *
 * 通过传入的地址，采取相应的资源文件加载方法并返回对应的资源文件信息
 *
 * @author yanful
 */
public class ResourceLoader {

    /**
     * 根据文件位置获取资源文件信息
     * @param location 文件位置信息
     * @return 资源文件信息
     */
    public Resource getResource(String location){
        //通过类加载器加载资源
        URL url = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(url);
    }
}
