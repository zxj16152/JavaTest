package com.company;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-02 15:43
 **/

public class SoftReferenceHouse {
    public static void main(String[] args) {
        ArrayList<SoftReference> houses = new ArrayList<>();
        int i=0;
        while (true) {
            SoftReference<House> buyer2 = new SoftReference<>(new House());
            houses.add(buyer2);
            System.out.println("i="+(++i));
        }
    }

}
class House{
    public Door[] doors=new Door[2000];
    class Door{}
}
