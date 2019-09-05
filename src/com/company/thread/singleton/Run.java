package com.company.thread.singleton;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-17 17:57
 **/

public class Run {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println( Singleton1.getInstance().hashCode());
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                System.out.println( Singleton1.getInstance().hashCode());
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                System.out.println( Singleton1.getInstance().hashCode());

            }
        }.start();
    }
}
