package com.company.thread.readwritepip;

import java.io.PipedInputStream;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-10 10:33
 **/

public class ThreadRead extends Thread {
    private ReadData read;
    private PipedInputStream in;

    public ThreadRead(ReadData read, PipedInputStream in) {
        this.read = read;
        this.in = in;
    }

    @Override
    public void run() {
        read.readMethod(in);
    }
}
