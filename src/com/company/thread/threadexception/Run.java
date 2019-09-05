package com.company.thread.threadexception;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-18 15:28
 **/

public class Run {
    public static void main(String[] args) {
        MyThread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("线程 ："+t.getName()+"出现异常：");
                e.printStackTrace();
            }
        });
        MyThread t1 = new MyThread();
        t1.setName("线程t1");
        t1.start();

        MyThread t2= new MyThread();
        t2.setName("线程t2");
        t2.start();
    }
}
