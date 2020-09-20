package org.demo.productAndConsumer.sync.first;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Consumer implements Runnable {

    private Car car;

    @Override
    public void run() {
        if(car != null){
            while(true){
                car.consumerCar();
            }
        }
    }
}
