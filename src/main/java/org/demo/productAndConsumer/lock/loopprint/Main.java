package org.demo.productAndConsumer.lock.loopprint;

public class Main {

    public static void main(String[] args) {
        final LoopPrint123 loopPrint123 = new LoopPrint123();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    loopPrint123.print1();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    loopPrint123.print2();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    loopPrint123.print3();
                }
            }
        }).start();

    }


}
