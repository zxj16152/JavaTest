package com.company.thread.singleton;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-17 17:53
 **/

public class Singleton1 {
//    private volatile static Singeton1 singleton;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
       return SingltonHolder.singleton1;
    }

    public static class SingltonHolder{
       private static Singleton1 singleton1=new Singleton1();
    }
}
