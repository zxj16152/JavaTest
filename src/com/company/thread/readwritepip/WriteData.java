package com.company.thread.readwritepip;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-10 10:16
 **/

public class WriteData {
    public void writeMethod(PipedOutputStream out) {
        try {
            System.out.println("write :");
            for (int i = 0; i < 300; i++) {
                String outData = "_" + (i + 1);
                out.write(outData.getBytes());
//                System.out.println(outData);
            }
//            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
