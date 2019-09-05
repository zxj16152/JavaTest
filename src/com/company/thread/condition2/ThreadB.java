package com.company.thread.condition2;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-16 16:56
 **/

public class ThreadB extends Thread{
    private MyService2 myService2;

    public ThreadB(MyService2 myService2) {
        this.myService2 = myService2;
    }

    @Override
    public void run() {
        for (int i = 0; i <Integer.MAX_VALUE ; i++) {
            myService2.get();
        }
    }
}
