package com.company.thread.condition;



/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-16 15:51
 **/

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.start();
        Thread.sleep(3000);
        myService.signal();
    }
}
