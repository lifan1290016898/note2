package org.demo.juc;

import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {

    public static void main(String[] args) {
        /**
         * 在该容器做写操作时,会复制一个容器,此时就会有两个容器, 新容器做写(增|删|该)操作, 旧容器做读操作, 之后就把新容器
         * 的引用指向旧容器, 从而实现了线程安全的读写分离操作
         */
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("abc");
        boolean bool1 = list.addIfAbsent("abc"); // 添加失败
        System.err.println(bool1);
        list.add("bdc");
        boolean bool2 = list.addIfAbsent("def");// 添加成功
        System.err.println(bool2);
        list.stream().forEach((x)-> System.out.println(x));
    }


}
