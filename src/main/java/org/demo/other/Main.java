package org.demo.other;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<StatisticsData> listStatisticsDate = new LinkedList<>();
            StatisticsData priceDate = new StatisticsData(0.1, "2021-01-19 15:00:00");
            listStatisticsDate.add(priceDate);
            System.out.println(listStatisticsDate);
            AnalysisUtil.removeListByTime(listStatisticsDate, 3600000, priceDate);
            System.out.println(listStatisticsDate);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
