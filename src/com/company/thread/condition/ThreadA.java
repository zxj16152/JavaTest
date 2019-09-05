package com.company.thread.condition;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-16 15:54
 **/

public class ThreadA extends Thread {
    private MyService service;

    public ThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}
