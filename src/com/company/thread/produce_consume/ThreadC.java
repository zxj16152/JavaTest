package com.company.thread.produce_consume;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-09 17:28
 **/

public class ThreadC extends Thread {
    private C c;

    public ThreadC(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        c.getValue();
    }
}
