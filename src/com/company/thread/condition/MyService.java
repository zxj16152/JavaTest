package com.company.thread.condition;
import java.util.concurrent.locks.*;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-16 15:08
 **/

public class MyService {
    private Lock lock  = new ReentrantLock();
    private Condition condition=lock.newCondition();

    public void await() {
        try {
            lock.lock();
            System.out.println("await  begin ThreadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("await锁被释放1");
        }
    }
    public void signal() {
        try {
            lock.lock();
            System.out.println("signal begin ThreadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
            condition.signal();
        } finally {
            lock.unlock();
            System.out.println("signal锁被释放2");
        }
    }
}
