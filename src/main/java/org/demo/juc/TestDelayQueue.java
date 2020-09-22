package org.demo.juc;

import org.demo.juc.model.Natatorium;

public class TestDelayQueue {

    public static void main(String[] args) {
        Natatorium natatorium = new Natatorium();
        Thread t = new Thread(natatorium);
        t.start();

        natatorium.addSwimmer("jack", 1);
        natatorium.addSwimmer("judy", 2);
        natatorium.addSwimmer("martin", 3);



    }


}
