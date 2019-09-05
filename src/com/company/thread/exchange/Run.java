package com.company.thread.exchange;

import java.util.concurrent.Exchanger;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-08-12 13:59
 **/

public class Run {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ThreadA a=new ThreadA(exchanger);
        ThreadB b = new ThreadB(exchanger);
        a.start();
        b.start();
    }
}
