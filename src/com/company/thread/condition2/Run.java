package com.company.thread.condition2;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-16 16:57
 **/

public class Run {
    public static void main(String[] args) {
//        MyService2 myService2 = new MyService2();
//        ThreadA a = new ThreadA(myService2);
//        a.start();
//
//        ThreadB b = new ThreadB(myService2);
//        b.start();

        Sevice sevice = new Sevice();
        sevice.servieMethod1();
    }
}
