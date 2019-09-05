package com.company.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-08-12 14:57
 **/

public class ThreadA extends Thread {
    private CyclicBarrier cyclicBarrier;

    public ThreadA(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier c = new CyclicBarrier(3);
        ThreadA a = new ThreadA(c);
        a.start();
        Thread.sleep(500);
        System.out.println(c.getNumberWaiting());

        ThreadA b = new ThreadA(c);
        b.start();
        Thread.sleep(500);
        System.out.println(c.getNumberWaiting());

        ThreadA d = new ThreadA(c);
        d.start();
        Thread.sleep(500);
        System.out.println(c.getNumberWaiting());

        ThreadA e = new ThreadA(c);
        e.start();
        Thread.sleep(500);
        System.out.println(c.getNumberWaiting());

        ThreadA f = new ThreadA(c);
        f.start();
        Thread.sleep(500);
        System.out.println(c.getNumberWaiting());
    }
}
