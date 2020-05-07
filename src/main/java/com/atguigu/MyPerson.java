package com.atguigu;

public class MyPerson {

    private MyPerson myPerson;

    public void setMyPerson(MyPerson myPerson,String abc ,int aa){
        this.myPerson = myPerson;
    }


    @Override
    public String toString() {
        return "MyPerson{" +
                "myPerson=" + myPerson +
                '}';
    }
}
