package com.company.thread.lock;


/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-16 15:11
 **/

public class ThreadBB extends Thread {
    private MyService myService;
    public ThreadBB(MyService myService) {
        this.myService=myService;
    }

    @Override
    public void run() {
//        myService.methodB();
        myService.await();
    }
}
