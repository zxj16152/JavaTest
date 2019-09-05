package com.company.thread.synchronize;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-19 10:44
 **/

public class Service1 {
    public synchronized static void printA() {
        try {
            System.out.println("线程 "+Thread.currentThread().getName()+" "+System.currentTimeMillis()+"进入printA");
            Thread.sleep(3000);
            System.out.println("线程 "+Thread.currentThread().getName()+" "+System.currentTimeMillis()+"离开printA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void printB() {
        try {
            System.out.println("线程 "+Thread.currentThread().getName()+" "+System.currentTimeMillis()+"进入printB");
            Thread.sleep(3000);
            System.out.println("线程 "+Thread.currentThread().getName()+" "+System.currentTimeMillis()+"离开printB");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Service1 s1 = new Service1();
        Service1 s2 = new Service1();

        new Thread(()->{
            s1.printA();
        },"A").start();

        new Thread(()->{
            s2.printB();
        },"B").start();
    }
}
