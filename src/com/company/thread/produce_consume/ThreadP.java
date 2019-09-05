package com.company.thread.produce_consume;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-09 17:26
 **/

public class ThreadP extends Thread{
    private P p;

    public ThreadP(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.setValue();
        }
    }
}
