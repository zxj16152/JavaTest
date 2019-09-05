package com.company;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019/3/15 09:29
 **/

public class Person {
    int age;
    String name;
    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
