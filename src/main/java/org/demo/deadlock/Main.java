package org.demo.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决死锁的两种方案
 *      死锁存在的原因就是因为资源互相占用所以到时程序无法继续向下运行, 如果要解决这个问题只有两种方式
 *      1、增加资源数
 *      2、在资源有限时使用Lock的tryLock()方法上锁
 */
public class Main {

    public final static Object lock1_1 = new Object();
    public final static Object lock2_1 = new Object();
    public final static Object lock1_2 = new Object();
    public final static Object lock2_2 = new Object();


    private final static Lock lock1 = new ReentrantLock();
    private final static Lock lock2 = new ReentrantLock();



    public static void main(String[] args) {
//        deadlock();
//        multiSourceDeadLock();
        monitorThread();
    }

    /**
     * 会出现死锁
     */
    public static void deadlock(){
        Thread t1 = new Thread(new MyLock1(lock1_1, lock2_1));
        Thread t2 = new Thread(new MyLock2(lock1_1, lock2_1));
        t1.start();
        t2.start();
    }

    /**
     * 解决方案1: 多个资源解决问题
     */
    public static void multiSourceDeadLock(){
        Thread t1 = new Thread(new MyLock1(lock1_1, lock2_2));
        Thread t2 = new Thread(new MyLock2(lock1_2, lock2_1));
        t1.start();
        t2.start();
    }

    /**
     * 解决方案2: 上锁时使用Lock的tryLock()方法上锁
     */
    public static void monitorThread(){
        Thread t1 = new Thread(new MyLock3(lock1, lock2), "t1");
        Thread t2 = new Thread(new MyLock4(lock1, lock2), "t2");

        Thread t3 = new Thread(()->{
            while(true){
                try{
                    Thread.sleep(5000);
                    Thread.State state = t1.getState();
                    System.out.println(state);
                    if(state == Thread.State.TERMINATED){
                        break;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


        t1.start();
        t2.start();
        t3.start();
    }



}
