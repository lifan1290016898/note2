package org.demo.juc;

import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        Thread t1 = new Thread(()->{
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("线程1执行");
        });

        Thread t2 = new Thread(()->{
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("线程2执行");
        });

        Thread t3 = new Thread(()->{
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("线程3执行!");
        });

        t3.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.start();
        t2.start();

    }


}
