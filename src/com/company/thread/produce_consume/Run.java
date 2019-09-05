package com.company.thread.produce_consume;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-09 17:29
 **/

public class Run {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String(" ");
        P p = new P(lock);
        C c = new C(lock);
        ThreadP[] pthread = new ThreadP[2];
        ThreadC[] cthread = new ThreadC[2];
        for (int i = 0; i <2 ; i++) {
            pthread[i] = new ThreadP(p);
            pthread[i].setName("生产者"+(i+1));
            cthread[i] = new ThreadC(c);
            cthread[i].setName("消费者"+(i+1));
            pthread[i].start();
            cthread[i].start();
        }
        Thread.sleep(5000);
        Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadArray);
        for (int i = 0; i <threadArray.length ; i++) {
            System.out.println(threadArray[i].getName()+" "+threadArray[i].getState());

        }
    }
}
