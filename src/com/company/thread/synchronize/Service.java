package com.company.thread.synchronize;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-19 10:15
 **/

public class Service {
    public synchronized void service1() {
        System.out.println("service1");
        service2();
    }

    public synchronized void service2() {
        System.out.println("service2");
        service3();
    }

    public synchronized void service3() {
        System.out.println("service3");
    }

    public static void main(String[] args) {
        Service service = new Service();
        Runnable runnable = () -> {
            service.service1();
        };
        new Thread(runnable).start();
    }
}
