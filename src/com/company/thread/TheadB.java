package com.company.thread;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-08 16:22
 **/

public class TheadB extends Thread {

       private MyList list;
        private Object object;

        public TheadB(Object object,MyList list) {
            this.object = object;
            this.list = list;
        }

        @Override
        public void run() {
            try {
                synchronized (object) {
                    if (list.size()!=5) {
                        System.out.println("wait begin");
                        object.wait();
                        System.out.println("wait end");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
