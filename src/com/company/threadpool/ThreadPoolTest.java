package com.company.threadpool;

import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-09-05 10:48
 **/

public class ThreadPoolTest {
    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 5; i++) {
//            Future<?> future = threadPool.submit(() -> {
//                System.out.println("current thread name" + Thread.currentThread().getName());
//                Object object = null;
//                System.out.print("result## " + object.toString());
//            });
//            try {
//                Object o = future.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }

        /**
         创建一个给定初始延迟的间隔性的任务，之后的下次执行时间是上一次任务从执行到结束所需要的时间+* 给定的间隔时间
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        System.out.println("current Time" + System.currentTimeMillis());
        scheduledExecutorService.scheduleWithFixedDelay(()->{
            System.out.println("current Time" + System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName()+"正在执行");
        }, 5, 3, TimeUnit.SECONDS);
    }
}
