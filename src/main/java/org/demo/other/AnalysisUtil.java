package org.demo.other;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public class AnalysisUtil {

    //list 为缓存的list，time为保存的时间秒数
    public static void removeListByTime(List<StatisticsData> list, double time, StatisticsData sdData) {

        DateTimeFormatter dateToStrFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String endDate = sdData.getDataTime();
        LocalDateTime endDateTime = LocalDateTime.parse(endDate, dateToStrFormatter);

        Iterator<StatisticsData> it = list.iterator();
        while(it.hasNext()){
            StatisticsData sd = it.next();
            String startDate = sd.getDataTime();
            LocalDateTime startDateTime = LocalDateTime.parse(startDate, dateToStrFormatter);
            Duration duration = Duration.between(startDateTime, endDateTime);
            double deleyTime = duration.toMillis();  //遍历 获取list里面的数据时间与当前时间的时间差，与保存时间做对比，大于的删除。
            if(deleyTime > time){
                it.remove();
            }else {
                break;
            }
        }


    }


    //list 为缓存的list，count为保存的数据个数
    public static void removeListByCount(List<StatisticsData> list, double count, StatisticsData sdData) {

        if(list.size()<count) {
            list.add(sdData);
        }else {
            list.remove(0);
            list.add(sdData);
        }


    }

}
