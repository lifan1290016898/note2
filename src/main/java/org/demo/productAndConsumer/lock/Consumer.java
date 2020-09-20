package org.demo.productAndConsumer.lock;

public class Consumer implements Runnable {

    private LockVersionCar car;

    public Consumer(LockVersionCar car){
        this.car = car;
    }


    @Override
    public void run() {
        if(car != null){
            while(true){
                car.consumerCar();
            }
        }
    }
}
