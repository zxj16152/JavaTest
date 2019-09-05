package com.company.thread;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-08 10:45
 **/

public class Run1 {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        MyList myList = new MyList();
        TheadB theadB = new TheadB(o,myList);
        theadB.start();
        Thread.sleep(30);

        TheadA theadA = new TheadA(o,myList);
        theadA.start();

    }
}
