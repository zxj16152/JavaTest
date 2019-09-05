package com.company.thread;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-08 16:19
 **/

public class MyObject {
    public synchronized void methodA() {
        try {
            System.out.println("begin methodA threadName="+Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public  void methodB() {
        try {
            System.out.println("begin methodB threadName="+Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
