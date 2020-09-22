package org.demo.juc.model;

import java.util.concurrent.Callable;

public class Summation implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println("正在计算1~100之和");
        int sum = 0;
        for(int i = 1; i <= 100; i++){
            Thread.sleep(200);
            sum += i;
        }
        return sum;
    }

}
