package com.company.thread.exchange;

import java.util.concurrent.Exchanger;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-08-12 13:49
 **/

public class ThreadA extends  Thread {
    private Exchanger<String > exchanger;

    public ThreadA(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("在线程A 中得到线程B的值"+exchanger.exchange("中国人A"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
