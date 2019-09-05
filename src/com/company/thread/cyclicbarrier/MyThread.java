package com.company.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-08-12 14:42
 **/

public class MyThread extends Thread{
    private CyclicBarrier cyclicBarrier;

    public MyThread(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int)Math.random()*1000);
            System.out.println(Thread.currentThread().getName()+"到了");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("全都到了！");
            }
        });
        MyThread[] threads = new MyThread[5];
        for (int i = 0; i <threads.length ; i++) {
            threads[i]=new MyThread(cyclicBarrier);
        }
        for (int i = 0; i <threads.length ; i++) {
            threads[i].start();
        }
    }
}
