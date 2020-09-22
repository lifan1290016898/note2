package org.demo.juc.model;

import java.util.concurrent.DelayQueue;

/**
 * 游泳馆类
 */
public class Natatorium implements Runnable {

    private DelayQueue<Swimmer> swimmers = new DelayQueue<>();

    private volatile boolean isOpen = Boolean.TRUE;

    public void addSwimmer(String name, int playTime) {
        long endTime = System.currentTimeMillis() + 60 * 1000 * playTime;
        boolean bool = this.swimmers.add(new Swimmer(name, endTime));
        if (bool) {
            System.out.println("欢迎" + name + "来到游泳馆, " + "可玩时间为:" + playTime + "分钟");
        }
    }


    @Override
    public void run() {
        try {
            while(isOpen){
                Swimmer takeUser = this.swimmers.take();
                System.out.println(takeUser.getName() + "时间已到!");
                if(this.swimmers.size() == 0){
                    this.isOpen = Boolean.FALSE;
                    System.out.println("游泳馆关闭!!!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
