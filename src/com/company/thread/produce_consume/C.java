package com.company.thread.produce_consume;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-09 17:20
 **/

public class C {
    private String lock;

    public C(String lock) {
        this.lock = lock;
    }
    public void getValue() {
        try {
            synchronized (lock) {
                while (ValueObject.value.equals("0")) {
                    System.out.println("消费者 "+Thread.currentThread().getName()+" WAITING");
                    lock.wait();
                }
                    System.out.println("消费者 "+Thread.currentThread().getName()+" RUNNING");
                ValueObject.value="0";
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
