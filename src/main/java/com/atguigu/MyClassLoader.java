package com.atguigu;

public class MyClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = systemClassLoader.loadClass("com.atguigu.c");
        System.out.println(aClass);
        System.out.println("------------");

        Class<?> aClass1 = Class.forName("com.atguigu.c");
        System.out.println(aClass1);
        System.out.println("------------");

        Class<?> aClass2 = Class.forName("com.atguigu.c");
        System.out.println(aClass2);
    }
}

 class c{

    static {
        System.out.println("c.static initializer");
    }

 }
