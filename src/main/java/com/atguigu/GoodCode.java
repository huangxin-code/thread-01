package com.atguigu;

/**
 *本质上调用类并没有直接引用到定义常量的类，因此不会触发定义常量类的初始化
 * 如下：MyParent1的a常量在编译的时候，会被保存到GoodCode的常量池中。之后GoodCode和MyParent1就没有任何关系了。
 * 甚至直接将MyParent1的class文件删除，GoodCode的main方法依然正常运行，正常得结果
 */
public class GoodCode  extends MyParent1{

    @Override
    public void get() {
        System.out.println("GoodCode.get");
    }

    public static void main(String[] args) {
        GoodCode gc = new GoodCode();
        gc.test();
    }
}
class MyParent1{

    public void put(){
        System.out.println("MyParent1.put");
    }
    public void get(){
        System.out.println("MyParent1.get");
    }

    public  void test(){
        System.out.println("MyParent1.test");
        get();
        put();
    }
}