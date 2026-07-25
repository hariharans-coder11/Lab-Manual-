import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Tracks customer check-in: id -> [stationName, checkInTime]
    private Map<Integer, String> checkInStation = new HashMap<>();
    private Map<Integer, Integer> checkInTime = new HashMap<>();

    // Tracks route stats: "StartStation->EndStation" -> [totalTime, count]
    private Map<String, Double> totalTimeMap = new HashMap<>();
    private Map<String, Integer> countMap = new HashMap<>();

    public UndergroundSystem() {
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInStation.put(id, stationName);
        checkInTime.put(id, t);
    }
    
    public void checkOut(int id, String stationName, int t) {
        // Retrieve check-in information and remove active check-in record
        String startStation = checkInStation.remove(id);
        int startTime = checkInTime.remove(id);
        
        String routeKey = startStation + "->" + stationName;
        int duration = t - startTime;
        
        // Accumulate total time and count for this route
        totalTimeMap.put(routeKey, totalTimeMap.getOrDefault(routeKey, 0.0) + duration);
        countMap.put(routeKey, countMap.getOrDefault(routeKey, 0) + 1);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        return totalTimeMap.get(routeKey) / countMap.get(routeKey);
    }
}
