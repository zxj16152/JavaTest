package com.company.thread.lock;

import com.company.thread.condition.MyService;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-16 15:11
 **/

public class ThreadB extends Thread {
    private MyService myService;
    public ThreadB(MyService myService) {
        this.myService=myService;
    }

    @Override
    public void run() {
//        myService.methodB();
    }
}
