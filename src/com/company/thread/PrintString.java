package com.company.thread;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-09 11:28
 **/

public class PrintString implements Runnable {
     private boolean isContinuePrint = true;
    int count=1;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    public void printStringMethod() {
        try {
            while (isContinuePrint) {
                System.out.println("run printStringMethod threadName = "+Thread.currentThread().getName());
                Thread.sleep(1000);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        System.out.println("进入 run 了");

        while (isContinuePrint) {
            System.out.println("----"+count+"----");
            count++;
        }
        System.out.println("线程被停止了");
    }
}
