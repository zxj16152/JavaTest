package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019/6/12 10:01
 **/

public class testThreadlocal {
    private static ThreadLocal<Integer> variableHolder =new ThreadLocal<Integer>(){
        protected Integer initialValue(){
            return 0;
        }
    };
    public static int getValue(){
        return variableHolder.get();
    }
    public static void increment(){
        variableHolder.set(variableHolder.get()+1);
    }
    public static void main(String[] args) {

                 ExecutorService executor = Executors.newCachedThreadPool();
                 for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                                 int before = getValue();
                               increment();
                               int after = getValue();
                                System.out.println("before: " + before + ", after: " + after);
                            });
                     }
    }
}
