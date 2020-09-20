package org.demo.productAndConsumer.sync.second;

import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Car {

    private int count;

    private BlockingQueue<CarData> queue;

    public Car(BlockingQueue<CarData> queue){
        this.queue = queue;
    }

    @SneakyThrows
    public synchronized void productCar(){

        CarData data = new CarData();
        boolean bool = this.queue.offer(data, 2, TimeUnit.SECONDS);
        if(bool){
            int id = this.count++;
            data.setId(id);
            System.out.println("生产一辆车,编号是:" + id + ", 生产数一共为:" + this.queue.size());
            Thread.sleep((long) (1000 * Math.random()));
            notifyAll();
        } else {
            System.out.println("生产失败......");
        }

        if(this.queue != null && this.queue.size() >= 100){
            wait();
        }
    }

    @SneakyThrows
    public synchronized void consumerCar(){

        CarData data = this.queue.poll(2, TimeUnit.SECONDS);
        if(data != null){
            System.out.println("销售一辆车, 编号为:" + data.getId() + ", 剩余库存数是:" + this.queue.size());
            Thread.sleep((long) (1000 * Math.random()));
            notifyAll();
        }


        if(this.queue != null && this.queue.size() <= 0){
            wait();
        }
    }

}
