package com.atguigu;

public class Test3 {

    public void get(Grandpa grandpa){
        System.out.println("grandPa");
    }
    public void get(Father father){
        System.out.println("father");
    }
    public void get(Son son){
        System.out.println("son");
    }

    public static void main(String[] args) {
        Test3 t = new Test3();
        Grandpa father = new Father();
        Grandpa son = new Son();
        t.get(father);
        t.get(son);
    }
}


class  Grandpa{}

class Father extends Grandpa{}

class Son extends  Father{}