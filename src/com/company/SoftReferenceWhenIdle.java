package com.company;

import java.lang.ref.SoftReference;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-02 16:39
 **/

public class SoftReferenceWhenIdle {
    public static void main(String[] args) {
        House seller = new House();
        SoftReference<House> buyer2 = new SoftReference<>(seller);
        seller=null;
        while (true) {
            System.gc();
            System.runFinalization();
            if (buyer2.get()==null) {
                System.out.println("house is null");
                break;
            }else {
                System.out.println("still there");
            }
        }
    }
}
