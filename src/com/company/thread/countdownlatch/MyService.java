package com.company.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-08-12 14:10
 **/

public class MyService extends Thread{
    private CountDownLatch down=new CountDownLatch(1);
    public void testMethod() {
        try {
            System.out.println("A");
            down.await();
            System.out.println("B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void downMethod() {
        System.out.println("X");
        down.countDown();
    }

    @Override
    public void run() {
        testMethod();
    }

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        service.start();
        Thread.sleep(2000);
        service.downMethod();
    }
}
