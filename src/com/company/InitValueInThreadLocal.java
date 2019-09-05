package com.company;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-03 10:28
 **/

public class InitValueInThreadLocal {
    public static final StringBuilder INIT_VALUE = new StringBuilder("init");
    public static final ThreadLocal<StringBuilder> builder = new ThreadLocal<StringBuilder>(){
        @Override
        protected  StringBuilder initialValue() {
            System.out.println("______------------"+INIT_VALUE.toString());
//            return INIT_VALUE;
            return new StringBuilder("init");
        }
    };

    private static class AppendStringThread extends Thread{
        @Override
        public  void run() {
            StringBuilder stringBuilder = builder.get();
            for (int i = 0; i <10 ; i++) {
                stringBuilder.append("-" + i);
            }
            System.out.println(stringBuilder.toString());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new AppendStringThread().start();
        }
        TimeUnit.SECONDS.sleep(10);
    }

}
