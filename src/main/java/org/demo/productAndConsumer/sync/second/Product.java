package org.demo.productAndConsumer.sync.second;

public class Product implements Runnable {

    private Car car;

    public Product(Car car){
        this.car = car;
    }

    @Override
    public void run() {
        if(this.car != null){
          while(true){
              car.productCar();
          }
        }
    }
}
