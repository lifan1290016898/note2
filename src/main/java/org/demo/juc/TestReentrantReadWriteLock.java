package org.demo.juc;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读和读不会排斥
 * 读和写会排斥
 * 写和写会排斥
 *
 * 在排斥时就会等待锁释放
 *
 */
public class TestReentrantReadWriteLock {

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        TestReentrantReadWriteLock lockTest = new TestReentrantReadWriteLock();
        Thread t1 = new Thread(() -> {
            // 读
            lockTest.readMethod(Thread.currentThread());

            // 写
            lockTest.writeMethod(Thread.currentThread());
        }, "t1");

        Thread t2 = new Thread(() -> {
            // 读
            lockTest.readMethod(Thread.currentThread());

            // 写
            lockTest.writeMethod(Thread.currentThread());
        }, "t2");

        t1.start();
        t2.start();
    }


    public void readMethod(Thread thread){
        try{
            readWriteLock.readLock().lock();
            System.out.println(thread.getName() + "正在进行读操作...");
            Thread.sleep(5000);
            System.out.println(thread.getName() + "读操作完毕!");
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void writeMethod(Thread thread){
        try{
            readWriteLock.writeLock().lock();
            System.out.println(thread.getName() + "正在进行写操作...");
            Thread.sleep(5000);
            System.out.println(thread.getName() + "写操作完毕!");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }


}
