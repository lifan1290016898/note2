package org.demo.productAndConsumer.lock;

public class Product implements Runnable {

    private LockVersionCar car;

    public Product(LockVersionCar car) {
        this.car = car;
    }

    @Override
    public void run() {
        if (car != null) {
            while (true) {
                car.productCar();
            }
        }
    }
}
