package org.demo.juc;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    public static void main(String[] args) {
        /**
         *  使await()了的线程阻塞, countDown()执行完成后再执行await()方法
         */
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(()->{
            try {
                System.out.println("线程1开始执行!");
                countDownLatch.await();
                System.out.println("线程1执行完毕!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            System.out.println("线程2开始执行!");
            countDownLatch.countDown();
            System.out.println("线程2执行完毕!");
        });


        t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();


    }

}
