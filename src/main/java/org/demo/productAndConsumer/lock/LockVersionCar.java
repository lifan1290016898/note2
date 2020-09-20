package org.demo.productAndConsumer.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockVersionCar {

    private int count;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();


    public void productCar(){
        lock.lock();
        try{
            if(this.count < 20){
                Thread.sleep((int)(1000 * Math.random()));
                this.count++;
                System.out.println(Thread.currentThread().getName() + "生产了一辆车, 总数是" + this.count);
                condition.signalAll();
            } else {
                condition.await();
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consumerCar(){
        this.lock.lock();
        try{
            if(this.count > 0){
                Thread.sleep((int)(1000 * Math.random()));
                this.count--;
                System.out.println(Thread.currentThread().getName() + "消费了一辆车, 总数是:" + this.count);
                condition.signalAll();
            } else {
                condition.await();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.lock.unlock();
        }
    }







}
