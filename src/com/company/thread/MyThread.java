package com.company.thread;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-08 10:52
 **/

public class MyThread extends Thread {
//    public MyThread() {
//        System.out.println("构造方法 "+Thread.currentThread().getId());
//    }

    private int i;
    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i = "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
