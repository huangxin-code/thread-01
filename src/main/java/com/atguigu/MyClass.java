package com.atguigu;

public class MyClass {

    public String str = "test";

    public static Integer in = 5;

    public MyClass(String str){
        this.str = str;
    }


    private int a = 5 ;

    public static void main(String[] args) {
        MyClass mc = new MyClass("123");
        mc.setStr("hahah");
        in = 10;
    }

    public synchronized void setStr(String str){
        this.str = Sample.abc;
        this.str = str;
    }
}
