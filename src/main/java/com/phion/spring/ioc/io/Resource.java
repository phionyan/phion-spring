package com.phion.spring.ioc.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yanful
 */
public interface Resource {

    /**
     * 资源文件必须提供输入流
     * @return 输入流
     */
    InputStream getInputStream() throws IOException;
}
