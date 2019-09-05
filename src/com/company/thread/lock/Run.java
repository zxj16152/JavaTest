package com.company.thread.lock;



/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-16 15:15
 **/

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();

        ThreadBB threadBB = new ThreadBB(myService);
//        threadBB.setName("BB");
        threadBB.start();
        Thread.sleep(100);

        myService.signal();

//        ThreadA threadA = new ThreadA(myService);
//        threadA.setName("A");
//        threadA.start();
//
//        ThreadAA threadAA = new ThreadAA(myService);
//        threadAA.setName("AA");
//        threadAA.start();
//
//        ThreadB threadB = new ThreadB(myService);
//        threadB.setName("B");
//        threadB.start();



    }
}
