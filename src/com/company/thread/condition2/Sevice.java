package com.company.thread.condition2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-16 17:30
 **/

public class Sevice {
    private ReentrantLock lock=new ReentrantLock();

    public void servieMethod1() {
        try {
            lock.lock();
            System.out.println("serviceMethod1 getHoldCount="+lock.getHoldCount());
            servieMethod12();
        } finally {
            lock.unlock();
        }
    }

    private void servieMethod12() {
        try {
            lock.lock();
            System.out.println("serviceMethod2 getHoldCount="+lock.getHoldCount());
        } finally {
            lock.unlock();
        }
    }
}
