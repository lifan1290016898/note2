package org.demo.productAndConsumer.sync.first;

import lombok.Data;
import lombok.SneakyThrows;

@Data
public class Car {

    private int count;

    @SneakyThrows
    public synchronized void producterCar(){
        if(count < 20){
            Thread.sleep(100);
            this.count++;
            System.out.println("当前线程:" + Thread.currentThread().getName() + "生产了1辆车, 总数是:" + this.count);
            notifyAll();
        } else {
            wait();
        }
    }

    @SneakyThrows
    public synchronized void consumerCar(){
        if(count > 0){
            Thread.sleep(100);
            this.count--;
            System.out.println("当前线程:" + Thread.currentThread().getName() + "消费了1辆车, 剩余:" + this.count + "辆");
            notifyAll();
        } else {
            wait();
        }
    }


}
