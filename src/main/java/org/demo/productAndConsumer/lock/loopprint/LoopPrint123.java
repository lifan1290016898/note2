package org.demo.productAndConsumer.lock.loopprint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 循环打印123
 */
public class LoopPrint123 {
    /**
     * 初始值
     */
    private int value = 1;

    private Lock lock = new ReentrantLock();
    /**
     * 打印1
     */
    private Condition c1 = lock.newCondition();
    /**
     * 打印2
     */
    private Condition c2 = lock.newCondition();
    /**
     * 打印3
     */
    private Condition c3 = lock.newCondition();

    /**
     * 打印1
     */
    public void print1(){
        lock.lock();
        try{
            if(value != 1){
                c1.await();
            }
            System.out.println(1);
            value = 2;
            c2.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印2
     */
    public void print2(){
        lock.lock();
        try{
            if(value != 2){
                c2.await();
            }
            System.out.println(2);
            value = 3;
            c3.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印3
     */
    public void print3(){
        lock.lock();
        try{
            if(value != 3){
                c3.await();
            }
            System.out.println(3);
            value = 1;
            c1.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }



}
