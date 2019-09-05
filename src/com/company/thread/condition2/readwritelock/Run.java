package com.company.thread.condition2.readwritelock;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-17 15:24
 **/

public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                service.write();
                service.read();
            }
        };
        thread1.setName("A");


        Thread thread2 = new Thread() {
            @Override
            public void run() {
                service.read();
                service.write();
            }
        };
        thread2.setName("B");

        thread1.start();
        thread2.start();
    }
}