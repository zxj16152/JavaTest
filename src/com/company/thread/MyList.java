package com.company.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-09 15:30
 **/

public class MyList {
    private List list = new ArrayList<String>();
    public void add() {
        list.add("123");
    }
    public int size() {
        return list.size();
    }
}
