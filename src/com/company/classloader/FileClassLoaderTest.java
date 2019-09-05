package com.company.classloader;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-08-09 17:35
 **/

public class FileClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        FileSystemClassLoader classLoader = new FileSystemClassLoader("/Users/zhouxinjian/Desktop");
        Class<?> helloworld1 = classLoader.loadClass("Helloworld");
        Class<?> helloworld2 = classLoader.loadClass("Helloworld");
        System.out.println(helloworld1.hashCode());
        System.out.println(helloworld2.hashCode());

//        FileSystemClassLoader.copyfile("/Users/zhouxinjian/Desktop/game01.py");
    }
}
