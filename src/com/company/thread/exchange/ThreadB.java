package com.company.thread.exchange;

import java.util.concurrent.Exchanger;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-08-12 13:59
 **/

public class ThreadB extends  Thread {
    private Exchanger<String > exchanger;

    public ThreadB(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("在线程B中得到线程A的值"+exchanger.exchange("中国人B"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}