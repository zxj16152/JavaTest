package com.company.thread.timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-17 17:17
 **/

public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("任务执行了："+new Date());
    }
}
