package com.company.thread.condition2.condition3;

import com.company.Main;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-17 14:45
 **/

public class Run {
    private volatile static int nextPrintWho=1;

    private static Lock lock =new ReentrantLock();
    final private static Condition conditionA=lock.newCondition();
    final private static Condition conditionB=lock.newCondition();
    final private static Condition conditionC=lock.newCondition();
    public static void main(String[] args) {
        Thread threadA=new Thread(){
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (nextPrintWho != 1) {
                        conditionA.await();
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println("ThreadA "+(i+1));
                    }
                    nextPrintWho=2;
                    conditionB.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread threadB=new Thread(){
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (nextPrintWho != 2) {
                        conditionA.await();
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println("ThreadB "+(i+1));
                    }
                    nextPrintWho=3;
                    conditionC.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread threadC=new Thread(){
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (nextPrintWho != 3) {
                        conditionA.await();
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println("ThreadC "+(i+1));
                    }
                    nextPrintWho=1;
                    conditionA.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread[] ath = new Thread[5];
        Thread[] bth = new Thread[5];
        Thread[] cth = new Thread[5];
        for (int i = 0; i < 5; i++) {
           ath[i]= new Thread(threadA);
           bth[i]= new Thread(threadB);
           cth[i]= new Thread(threadC);
           ath[i].start();
           bth[i].start();
           cth[i].start();
        }

    }
}
