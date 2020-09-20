package org.demo.productAndConsumer.sync.second;

public class Consumer implements Runnable {

    private Car car;

    public Consumer(Car car){
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
