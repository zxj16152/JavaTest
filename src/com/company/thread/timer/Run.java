package com.company.thread.timer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Timer;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-17 17:19
 **/

public class Run {
    public static void main(String[] args) {
        System.out.println("当前时间：" + new Date());
        LocalDateTime now = LocalDateTime.now();
        MyTask myTask = new MyTask();
        Timer timer = new Timer();
        ZonedDateTime zonedDateTime = now.plusSeconds(10).atZone(ZoneId.systemDefault());
        Instant instant = zonedDateTime.toInstant();
        System.out.println(instant);

        timer.schedule(myTask,  Date.from(instant));
    }
}
