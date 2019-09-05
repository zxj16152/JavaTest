package com.company.classloader;

import com.oracle.tools.packager.IOUtils;

import java.io.*;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-08-09 14:56
 **/

public class FileSystemClassLoader extends ClassLoader {
    private String filePath;

    public FileSystemClassLoader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);
        if (c !=null) {
            return c;
        }else {
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(name);
            } catch (ClassNotFoundException e) {

            }
            if (c !=null) {
                return c;
            }else {
                byte[] classData = getClassData(name);
                if (null == classData) {
                    throw new ClassNotFoundException();
                }else {
                    c= defineClass(name,classData,0,classData.length);
                    return c;
                }
            }
        }
    }

    private byte[] getClassData(String classname){   //com.bjsxt.test.User   d:/myjava/  com/bjsxt/test/User.class
        String path = filePath +"/"+ classname.replace('.', '/')+".class";


        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try{
            is  = new FileInputStream(path);

            byte[] buffer = new byte[1024];
            int temp=0;
            while((temp=is.read(buffer))!=-1){
                baos.write(buffer, 0, temp);
            }

            return baos.toByteArray();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            try {
                if(is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(baos!=null){
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void copyfile(String filePath) {
//        String path=filePath+"/"+name.replace('.', '/')+".class ";
        FileInputStream fis =null;
        FileOutputStream fos =null;
        try {
            fis = new FileInputStream(new File(filePath));
            fos = new FileOutputStream(new File(filePath+".txt"));
            byte[] bytes = new byte[1024];
            int temp=0;
            while ((temp = fis.read(bytes)) != -1) {
                fos.write(bytes, 0,temp);
            }
//            return fos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
//            return null;
        } finally {
            try {
                if (fis !=null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos !=null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

