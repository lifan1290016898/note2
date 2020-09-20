package org.demo.productAndConsumer.sync.first;

public class Main {

    public static void main(String[] args) {
        Car car = new Car();

        Product product = new Product(car);
        Consumer consumer = new Consumer(car);

        Thread t1 = new Thread(product, "t1-p");
        Thread t2 = new Thread(product, "t2-p");
        Thread t3 = new Thread(consumer, "t3-c");
        Thread t4 = new Thread(consumer, "t4-c");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}
