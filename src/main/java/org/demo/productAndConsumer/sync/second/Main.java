package org.demo.productAndConsumer.sync.second;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {
        BlockingQueue<CarData> queue = new LinkedBlockingQueue<>(100);

        Car car = new Car(queue);
        Consumer c1 = new Consumer(car);
        Consumer c2 = new Consumer(car);

        Product p1 = new Product(car);
        Product p2 = new Product(car);

        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(c1);
        pool.execute(c2);
        pool.execute(p1);
        pool.execute(p2);

    }


}
