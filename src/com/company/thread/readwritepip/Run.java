package com.company.thread.readwritepip;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-10 10:35
 **/

public class Run {
    public static void main(String[] args) throws IOException, InterruptedException {
        WriteData writeData = new WriteData();
        ReadData readData = new ReadData();
        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();
//        outputStream.connect(inputStream);
        inputStream.connect(outputStream);
        ThreadRead threadRead = new ThreadRead(readData, inputStream);
        threadRead.start();

        Thread.sleep(2000);

        ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
        threadWrite.start();
        
    }


}
