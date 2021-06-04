package org.demo;

import java.util.concurrent.Semaphore;

public class OtherTest {

    public static void main(String[] args) {

    }

    public void semaphoreMethod() throws Exception{
        // 限流...每次只允许10个线程执行...
        Semaphore semaphore = new Semaphore(10);
        semaphore.acquire(); // 加锁

        semaphore.release(); // 释放锁
    }

}
