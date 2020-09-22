package org.demo.juc;

import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.putIfAbsent("k1", "v3");
        map.putIfAbsent("k3", "v2");
        map.putIfAbsent("k3", "v3");// key 存在则添加, 否则不添加
        System.out.println(map);
    }

}
