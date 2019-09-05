package com.company.thread.condition2.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-17 15:12
 **/

public class Service {
    private ReentrantReadWriteLock lock= new ReentrantReadWriteLock();
    public void read() {
        try {
            lock.readLock().lock();
            System.out.println("获得读锁"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println("获得写锁"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
