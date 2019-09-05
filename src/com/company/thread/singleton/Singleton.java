package com.company.thread.singleton;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-17 17:53
 **/

public class Singleton {
    private volatile static Singleton singleton;
    private volatile static Object object=new Object();

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton != null){
        }else {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {
                if (singleton == null) {

                singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
}
