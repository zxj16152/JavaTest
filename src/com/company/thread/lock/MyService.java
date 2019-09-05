package com.company.thread.lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-16 15:08
 **/

public class MyService {
    private Lock lock  = new ReentrantLock();


    public void await() {
        try {
            lock.lock();
            System.out.println("await  begin ThreadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("await锁被释放1");
        }
    }
    public void signal() {
        try {
            System.out.println("signal");
            lock.lock();
            System.out.println("signal begin ThreadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
        } finally {
            lock.unlock();
            System.out.println("signal锁被释放2");
        }
    }
}
