package com.company.thread.synchronize;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-19 09:49
 **/

public class PublicVar {
    public String username = "A";
    public String password = "AA";

    public synchronized void setValue(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(5000);
            this.password = password;
            System.out.println("setValue method thread name ="+Thread.currentThread().getName()+" username="+username+" password="+password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void getValue() {
            System.out.println("getValue method thread name ="+Thread.currentThread().getName()+" username="+username+" password="+password);

    }

    public static void main(String[] args) throws InterruptedException {
        PublicVar var = new PublicVar();
        Thread thread = new Thread(){
            @Override
            public void run() {
                var.setValue("B", "BB");
            }
        };
        thread.start();

        Thread.sleep(200);
        var.getValue();
    }
}
