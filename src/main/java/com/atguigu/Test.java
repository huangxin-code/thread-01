package com.atguigu;

public class Test {

    /**
     *
     */
    private int num;

    /**
     *
     */
    private String str;

    public Test(int num, String str) {
        System.out.println("Test(int num, String str)");
        this.num = num;
        this.str = str;
    }

    public Test(String str) {
        System.out.println(" Test(String str)");
        this.str = str;
    }

    public Test() {
        System.out.println("Test() ");
    }

    public static void main(String[] args) throws  Exception {
        test02();
    }

    private static void test02() throws Exception {
        Class[] classes = new Class[]{int.class,String.class};
        Test t1 = Test.class.getConstructor(classes).newInstance(23,"sfas");
        Test t2 = Test.class.getDeclaredConstructor(String.class).newInstance("bbbb");
        Object o = Class.forName("com.atguigu.Test").getConstructor().newInstance();

    }

    private static void test01() throws Exception {
        Test t1 = Test.class.newInstance();
        System.out.println("t1 = " + t1);
        System.out.println(t1.getClass());
        Test t2 = t1.getClass().newInstance();
        System.out.println("t2 = " + t2);
        Class<?> clazz = Class.forName("com.atguigu.Test");
        System.out.println("clazz = " + clazz);

    }


}
