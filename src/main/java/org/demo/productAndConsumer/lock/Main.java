package org.demo.productAndConsumer.lock;

public class Main {

    public static void main(String[] args) {
        LockVersionCar car = new LockVersionCar();

        Product product1 = new Product(car);
        Product product2 = new Product(car);
        Consumer consumer1 = new Consumer(car);
        Consumer consumer2 = new Consumer(car);


        Thread t1 = new Thread(product1, "t1-p");
        Thread t2 = new Thread(product2, "t2-p");
        Thread t3 = new Thread(consumer1, "t3-c");
        Thread t4 = new Thread(consumer2, "t4-c");

        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }


}
