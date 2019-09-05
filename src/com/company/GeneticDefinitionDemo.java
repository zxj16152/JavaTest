package com.company;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019/6/25 14:51
 **/

public class GeneticDefinitionDemo<T> {
    static <String,T,Alibaba> String get (String string,Alibaba alibaba){
        return string;
    }

    public static void main(String[] args) {
        Integer first=222;
        Long second=333L;
        Integer integer = get(first, second);
        System.out.println(integer);
    }
}
