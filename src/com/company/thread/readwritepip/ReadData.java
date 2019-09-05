package com.company.thread.readwritepip;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-10 10:20
 **/

public class ReadData {
    public void readMethod(PipedInputStream in) {
        try {
            System.out.println("read :");
            byte[] bytes = new byte[20];
            int readLength;
            while ((readLength = in.read(bytes)) != -1) {
                String newData = new String(bytes, 0, readLength);
                System.out.println(newData);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
