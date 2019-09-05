package com.company;
import	java.util.Date;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	static boolean boolValue;
	public static   Integer dataLength=5000;
	public static   Boolean flag=false;
	private static StringBuilder stringBuilderstatic=new StringBuilder("old stringBuilder");
	private static HashMap map=new HashMap();
//	private static ThreadLocal<String > threadLocal=new ThreadLocal (){
//        @Override
//        protected Object initialValue() {
//            return "默认值";
//        }
//    };
//    public static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private static InheritableThreadLocal<Long > inheritableThreadLocal = new InheritableThreadLocal(){
};
	public static void main(String[] args) throws RuntimeException, InterruptedException {
        try {
            for (int i = 0; i <10 ; i++) {
                System.out.println("在Main线程中取值 = "+inheritableThreadLocal.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            ThreadA threadA  =new ThreadA();
            threadA.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void method(Integer dataLength){
        System.out.println(dataLength);
	    dataLength=22;
        System.out.println(dataLength);

    }
    public static void method(StringBuilder sb1,StringBuilder sb2){
	    sb1.append(".methond.first-");
	    sb2.append("method.second-");
	    sb1 = new StringBuilder("new StringBuilder");
	    sb1.append("new method's append");

    }

    public static class ThreadA extends Thread{
        @Override
        public void run() {
            try {
                for (int i = 0; i <10 ; i++) {
                    System.out.println("在ThreadA中取值 =" +inheritableThreadLocal.get());
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
