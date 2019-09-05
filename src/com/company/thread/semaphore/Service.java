package com.company.thread.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-08-12 09:16
 **/

public class Service {
    private Semaphore semaphore = new Semaphore(3);
    private ReentrantLock lock=new ReentrantLock();

    public void testMethod() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+" begin Time"+System.currentTimeMillis());
            lock.lock();
            for (int i = 0; i <5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"打印"+(i+1));
            }
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+" end Time"+System.currentTimeMillis());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ThreadA extends Thread{
        Service service;

        public ThreadA(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.testMethod();
        }
    }
    static class ThreadB extends Thread{
        Service service;

        public ThreadB(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.testMethod();
        }
    }
    static class ThreadC extends Thread{
        Service service;

        public ThreadC(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.testMethod();
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        threadA.setName("a");
        ThreadB threadB = new ThreadB(service);
        threadB.setName("b");
        ThreadC threadC = new ThreadC(service);
        threadC.setName("c");
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
