package com.company.thread.semaphore;

import java.sql.SQLOutput;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-08-12 10:43
 **/

public class RepastService {
   private volatile Semaphore setSemaphore= new Semaphore(10);
   private volatile Semaphore getSemaphore= new Semaphore(20);
   private volatile ReentrantLock lock=new ReentrantLock();
   private volatile Condition setCondition=lock.newCondition();
   private volatile Condition getCondition=lock.newCondition();

    private volatile Object[] productionPosition = new Object[4];

    private boolean isFull() {
        boolean isFull=true;
        for (Object o : productionPosition) {
            if (o==null) {
                isFull=false;
                break;
            }
        }
        return isFull;
    }

    private boolean isEmpty(){
        boolean isEmpty=true;
        for (Object o : productionPosition) {
            if (o !=null) {
                isEmpty=false;
                break;
            }

        }
        return isEmpty;
    }
    public void set(){
        try {
//            System.out.println("set");
            setSemaphore.acquire();
            lock.lock();
            while (isFull()) {
//                System.out.println("生产者在等待");
                setCondition.await();
            }
            for (int i = 0; i <productionPosition.length ; i++) {
                if (productionPosition[i] ==null) {
                    productionPosition[i]  = "数据";
                    System.out.println(Thread.currentThread().getName()+"生产了"+productionPosition[i]);
                    break;
                }
            }
            getCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            setSemaphore.release();
        }
    }

    public void get() {
        try {
//            System.out.println("get");
            getSemaphore.acquire();
            lock.lock();
            while (isEmpty()) {
//                System.out.println("消费者在等待");
                getCondition.await();
            }

            for (int i = 0; i < productionPosition.length; i++) {
                if (productionPosition[i] !=null) {
                    System.out.println(Thread.currentThread().getName()+"消费了"+productionPosition[i]);
                    productionPosition[i]=null;
                    break;
                }
            }
            setCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            getSemaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RepastService service = new RepastService();
        Runnable[] arrayP=new Runnable[60];
        Runnable[] arrayC=new Runnable[60];

        for (int i = 0; i < 60; i++) {
            arrayP[i]=()->service.set();
            arrayC[i]=()->service.get();
        }

        Thread.sleep(2000);

        for (int i = 0; i < 60; i++) {
            new Thread(arrayP[i]).start();
            new Thread(arrayC[i]).start();
        }
    }

}
