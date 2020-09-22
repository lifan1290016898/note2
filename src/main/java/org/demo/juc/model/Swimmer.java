package org.demo.juc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 游泳者类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Swimmer implements Delayed {

    private String name;

    private Long endTime;

    @Override
    public long getDelay(TimeUnit unit) {
        return endTime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed swimmerDelayed) {
        Swimmer targetSwimmer = (Swimmer) swimmerDelayed;
        return this.getDelay(TimeUnit.SECONDS) - targetSwimmer.getDelay(TimeUnit.SECONDS) > 0 ? 1 : 0;
    }
}
