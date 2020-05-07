package com.atguigu;

import com.sun.crypto.provider.AESKeyGenerator;
import sun.reflect.Reflection;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.ServiceLoader;

public class Test4 {

    public static void main(String[] args) throws Exception {
        System.out.println("Test4.main");
        test09();

    }

    public static void test09() throws Exception {
        Sample s = new Sample();
        int a = s.getA();
        System.out.println("a = " + a);
    }
    public static void test08() throws Exception {

        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("aaaa", "bbb", "ccc");
    }

    public static void test07()  {

        System.out.println(Test4.class.getClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());

    }

    public static void test06()  throws Exception{
        //currentThread()  获取当前线程中的类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //往当前线程中的类加载器中设置加载器。系统加载器在启动的时候，会设置系统加载器到里面。
        Thread.currentThread().setContextClassLoader(Test4.class.getClassLoader().getParent());
        System.out.println(classLoader);
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println( driver.getClass()+"\t" + driver.getClass().getClassLoader());
        }

        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(ServiceLoader.class.getClassLoader());

    }
    public static void test05()  throws Exception{

        System.out.println(System.getProperty("java.system.class.loader"));
        System.out.println(MyClassLoader2.class.getClassLoader());
        System.out.println(Test4.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
    }
    public static void test04()  throws Exception{
        System.out.println(Test1.class.getClassLoader());
        System.out.println(Test4.class.getClassLoader());
    }
    public static void test01()  throws Exception{
        MyClassLoader2 loader2 = new MyClassLoader2("loader2","C://Users//Administrator//Desktop//");
        Class<?> clazz = loader2.loadClass("com.atguigu.Dog");
        Object o = clazz.newInstance();
        System.out.println("o = " + o);
        System.out.println(clazz.getClassLoader());
    }

    public static void test02()  throws Exception{
        AESKeyGenerator ag = new AESKeyGenerator();
        System.out.println(ag.getClass().getClassLoader());
        System.out.println(Test4.class.getClassLoader());
    }

    public static void test03()  throws Exception{
        MyClassLoader2 loader1 = new MyClassLoader2("loader1","C://Users//Administrator//Desktop//");
        MyClassLoader2 loader2 = new MyClassLoader2("loader2","C://Users//Administrator//Desktop//");
        Class<?> clazz1 = loader1.loadClass("com.atguigu.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.atguigu.MyPerson");
        System.out.println(clazz1 == clazz2);
        Object person1 = clazz1.newInstance();
        Object person2 = clazz2.newInstance();
        Method setMyPerson = clazz1.getMethod("setMyPerson", MyPerson.class,String.class,int.class);
        setMyPerson.invoke(person1,person2,"aaa",23);
        System.out.println(
                person1
        );
    }


}
