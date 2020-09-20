package org.demo.deadlock;

public class MyLock2 implements Runnable {

    private Object lock1;

    private Object lock2;

    public MyLock2(Object lock1, Object lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock2){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1){

            }
        }
    }
}
