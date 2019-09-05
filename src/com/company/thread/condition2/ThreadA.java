package com.company.thread.condition2;

import com.company.thread.condition.MyService;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-16 16:54
 **/

public class ThreadA extends Thread{
    private MyService2 myService2;

    public ThreadA(MyService2 myService2) {
        this.myService2 = myService2;
    }

    @Override
    public void run() {
        for (int i = 0; i <Integer.MAX_VALUE ; i++) {
            myService2.set();
        }
    }
}
