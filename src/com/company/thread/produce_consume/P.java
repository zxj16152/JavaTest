package com.company.thread.produce_consume;

import com.company.thread.produce_consume.ValueObject;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-09 17:14
 **/

public class P {
    private String lock;

    public P(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                while (!ValueObject.value.equals("0")) {
                    System.out.println("生产者 "+Thread.currentThread().getName()+"  WAITING");
                    lock.wait();
                }
                System.out.println("生产者 "+Thread.currentThread().getName()+"  RUNNING");
                ValueObject.value="1";
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
