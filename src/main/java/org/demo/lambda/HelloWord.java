package org.demo.lambda;

public class HelloWord {

    public static void main(String[] args) {
//        method1();
        method2();
    }


    public static void method1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Word");
            }
        }).start();
    }

    public static void method2(){
        new Thread(() -> System.out.println("hello word")).start();
    }





}
