package com.atguigu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;

public class MyException {

    public void get(){
        try {
            FileInputStream is = new FileInputStream("aaa");
            ServerSocket ss = new ServerSocket(9999);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception exception){

        }finally {
            System.out.println();
        }
    }
}
