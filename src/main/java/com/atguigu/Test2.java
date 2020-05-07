package com.atguigu;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class Test2 {
    /**
     * Jar hell问题以及解决办法
     * 当一个类或者一个资源文件中存在多个jar的时候，就会存在jar hell问题。
     * 可以通过以下代码来诊断问题。
     */
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = "com/atguigu/Test1.class";
        Enumeration<URL> urls = classLoader.getResources(path);
        while (urls.hasMoreElements()) {
            System.out.println(urls.nextElement());
        }
        System.out.println("1111111111111111111");
    }
}
