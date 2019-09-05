package com.company.thread.threadexception;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-18 15:28
 **/

public class MyThread extends Thread {
    @Override
    public void run() {
        String username=null;
        System.out.println(username.hashCode());
    }
}
