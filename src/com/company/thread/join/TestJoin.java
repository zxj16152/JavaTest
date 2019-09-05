package com.company.thread.join;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-10 11:18
 **/

public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
      Runnable runnable=  ()->{
          try {
              Thread.sleep(5000);
              System.out.println("=================");
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join(2000);
        System.out.println("runnable 执行完了");
    }
}
