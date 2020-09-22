package org.demo.juc;

import org.demo.juc.model.Summation;

import java.util.concurrent.FutureTask;

public class TestCallableAndFutureTask {

    public static void main(String[] args) {
        Summation summation = new Summation();

        FutureTask<Integer> futureTask = new FutureTask<>(summation);
        new Thread(futureTask).start();

        try {
            Integer sum = futureTask.get();
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
