package org.demo.other;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class StatisticsData implements Serializable {



    private double statisticsData;
    private String dataTime;


    public double getStatisticsData() {
        return statisticsData;
    }


    public void setStatisticsData(double statisticsData) {
        this.statisticsData = statisticsData;
    }



    public String getDataTime() {
        return dataTime;
    }


    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }



}


