package org.demo.deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class MyLock4 implements Runnable {

    private Lock lock1;

    private Lock lock2;

    public MyLock4(Lock lock1, Lock lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }



    @Override
    public void run() {
        try{
            lock1.lock();
            Thread.sleep(3000);
            boolean bool = lock2.tryLock(2, TimeUnit.SECONDS);
            if(bool){
                System.out.println(Thread.currentThread().getName() + "加锁成功!");
            } else {
                System.out.println(Thread.currentThread().getName() + "加锁失败!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock1.unlock();
            lock2.unlock();
        }
    }
}
