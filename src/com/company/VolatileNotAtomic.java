package com.company;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-02 10:40
 **/

public class VolatileNotAtomic {
    private static  long count = 0L;
    private static Object object=new Object();
    private static Object object2=new Object();
    private static final int NUMBER = 10000;
    public static void main(String[] args) {
        SubtractThread subtractThread = new SubtractThread();
        subtractThread.start();

        for (int i = 0; i < NUMBER; i++) {
            synchronized (object) {
                count++;
            }

        }
        while (subtractThread.isAlive()) {
            System.out.println("count 最后的值:"+count);
        }
        System.out.println("--------------"+count+"-------------------");
    }
    private static class SubtractThread extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < NUMBER; i++) {
                synchronized (object) {
                    count--;
                }
            }
        }
    }
}
