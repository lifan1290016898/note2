package org.demo.other;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MarketDataManager {

    private static final MarketDataManager instance = new MarketDataManager();

    public MarketDataManager() {
        super();
    }

    public static MarketDataManager getInstance() {
        return instance;
    }



    private ConcurrentHashMap<String, List<StatisticsData>> statisticsDataList = new ConcurrentHashMap<String,List<StatisticsData>>();
    public ConcurrentHashMap<String,List<StatisticsData>> getStatisticsDataList() {
        return statisticsDataList;
    }


}
