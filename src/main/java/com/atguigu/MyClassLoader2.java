package com.atguigu;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyClassLoader2 extends ClassLoader {

    private String classLoaderName;

    public final static String fileExtension = ".class";

    public String path ;

    public MyClassLoader2(String classLoaderName, String path){
        super();
        this.classLoaderName = classLoaderName;
        this.path = path;
    }


    public MyClassLoader2(ClassLoader classLoader, String classLoaderName, String path){
        super(classLoader);
        this.classLoaderName = classLoaderName;
        this.path = path;
    }

    public String toString(){
        return "["+this.classLoaderName+"]";
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("MyClasssLoader2.findClass");
        byte[] date = loadClassData(className);
        return this.defineClass(className,date,0,date.length);
    }

    private byte[] loadClassData(String name){
        FileInputStream fis = null;
        ByteArrayOutputStream fout = new ByteArrayOutputStream();
        byte[] bytes = null;
        try {
            this.classLoaderName = this.classLoaderName.replace(".","//");
            String filePath = path+name;
            filePath = filePath.replace(".","//");
            filePath = filePath+fileExtension;
            fis = new FileInputStream(new File(filePath));
            int ch= 0;
            while (-1 != (ch = fis.read())){
                fout.write(ch);
            }
            bytes = fout.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader2 loader1 = new MyClassLoader2("loader1","C://Users//Administrator//Desktop//");
        Class<?> clazz = loader1.loadClass("com.atguigu.Test1");
        System.out.println(clazz.hashCode());
        Object o = clazz.newInstance();
        System.out.println("o = " + o);
        System.out.println("--------------------------");
        loader1 = new MyClassLoader2("loader1","C://Users//Administrator//Desktop//");
        clazz = loader1.loadClass("com.atguigu.Test1");
        System.out.println(clazz.hashCode());
        o = clazz.newInstance();
        System.gc();
        System.out.println("o = " + o);

       /* MyClasssLoader2 loader2 = new MyClasssLoader2(loader1,"loader2","C://Users//Administrator//Desktop//");
        clazz = loader2.loadClass("com.atguigu.Test1");
        System.out.println(clazz.hashCode());
        o = clazz.newInstance();
        System.gc();
        System.out.println("o = " + o);*/
    }
}
