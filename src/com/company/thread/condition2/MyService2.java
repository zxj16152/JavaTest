package com.company.thread.condition2;
import	java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Condition;
import	java.util.concurrent.locks.ReentrantLock;
import	java.util.concurrent.RejectedExecutionHandler;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-16 16:50
 **/

public class MyService2 {
    private ReentrantLock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    private boolean hasValue=false;

    public void set() {
        try {
            lock.lock();
            while (hasValue) {
                condition.await();
            }
            System.out.println("打印 * ");
            hasValue=true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (!hasValue) {
                condition.await();
            }
            System.out.println("打印 ** ");
            hasValue=false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
