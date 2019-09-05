package com.company.thread.readwritepip;

import java.io.PipedOutputStream;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-10 10:32
 **/

public class ThreadWrite extends Thread {
    private WriteData write;
    private PipedOutputStream out;

    public ThreadWrite(WriteData write, PipedOutputStream out) {
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        write.writeMethod(out);
    }
}
