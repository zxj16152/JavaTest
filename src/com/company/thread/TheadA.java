package com.company.thread;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-08 16:22
 **/

public class TheadA extends Thread {
    private MyList list;
   private Object object;

    public TheadA(Object object,MyList list) {
        this.object = object;
        this.list = list;
    }

    @Override
    public void run() {
        try {
            synchronized (object) {
                for (int i = 0; i <10 ; i++) {
                    list.add();
                    if (list.size()==5) {
                        object.notify();
                        System.out.println("通知发出");
                    }
                    System.out.println("添加了"+(i+1)+"个元素");
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
