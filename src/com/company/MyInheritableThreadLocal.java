package com.company;


/**
 *
 * @ClassName:MyInheritableThreadLocal
 * @Description:可继承线程本地变量
 * @author denny.zhang
 * @date 2017年12月7日下午5:24:40
 */
public class MyInheritableThreadLocal{
    //线程本地共享变量
    private static final InheritableThreadLocal<Object> threadLocal = new InheritableThreadLocal<Object>(){
        /**
         * ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法值
         */
        @Override
        protected Object initialValue()
        {
            System.out.println("[线程"+Thread.currentThread().getName()+"]调用get方法时，当前线程共享变量没值，调用initialValue获取默认值！");
            return null;
        }

        @Override
        protected Object childValue(Object parentValue) {
            System.out.println("==========="+"[线程"+Thread.currentThread().getName()+"]parentValue============"+parentValue);
            return (Integer)parentValue*2;
        }

    };

    public static void main(String[] args){
        //主线程设置1
        threadLocal.set(1);
        //1.开启任务1线程
        new Thread(new MyIntegerTask("IntegerTask1")).start();
        //2.中间休息3秒，用以测试数据差异
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //开启任务2线程
        new Thread(new MyIntegerTask("IntegerTask2")).start();
    }

    /**
     *
     * @ClassName:MyIntegerTask
     * @Description:整形递增线程
     * @author diandian.zhang
     * @date 2017年12月4日上午10:00:41
     */
    public static class MyIntegerTask implements Runnable{
        private String name;

        MyIntegerTask(String name)
        {
            this.name = name;
        }

        @Override
        public void run()
        {
            for(int i = 0; i < 5; i++)
            {
                // ThreadLocal.get方法获取线程变量
                if(null == MyInheritableThreadLocal.threadLocal.get())
                {
                    // ThreadLocal.set方法设置线程变量
                    MyInheritableThreadLocal.threadLocal.set(0);
                    System.out.println("i="+i+"[线程" + name + "]当前线程不存在缓存,set 0");
                }
                else
                {
                    int num = (Integer)MyInheritableThreadLocal.threadLocal.get();
                    System.out.println("i="+i+"[线程" + name + "]get=" + num);
                    MyInheritableThreadLocal.threadLocal.set(num + 1);
                    System.out.println("i="+i+"[线程" + name + "]往threadLocal中set: " + MyInheritableThreadLocal.threadLocal.get());
                    //当i=3即循环4次时，移除当前线程key
                    if(i == 3)
                    {
                        System.out.println("i="+i+"[线程" + name + "]，remove" );
                        MyInheritableThreadLocal.threadLocal.remove();
                    }
                }
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
