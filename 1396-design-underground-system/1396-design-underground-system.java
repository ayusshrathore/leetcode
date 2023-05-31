class UndergroundSystem {
    private Map<Integer, Pair<String, Integer>> checkInMap;
    private Map<String, Pair<Integer, Integer>> checkOutMap;
    
    public UndergroundSystem() {
        this.checkInMap = new HashMap<Integer, Pair<String, Integer>>(); // id -> {entryStation, entryTime}
        this.checkOutMap = new HashMap<String, Pair<Integer, Integer>>(); // route -> {totalTime, countOfPersons}
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInInfo = checkInMap.get(id);
        
        String startStation = checkInInfo.getKey();
        int entryTime = checkInInfo.getValue();
        
        String endStation = stationName;
        int endTime = t;
        
        String route = startStation + "_" + endStation;
        
        int totalTime = endTime-entryTime;
        
        Pair<Integer, Integer> p = checkOutMap.getOrDefault(route, new Pair<>(0, 0));
        int totalTravelTime = p.getKey() + totalTime;
        int count = p.getValue() + 1;
        
        checkOutMap.put(route, new Pair<>(totalTravelTime, count));
        
        checkInMap.remove(id); // remove the person from the checkInMap since he/she has reached the dest.
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "_" + endStation;
        
        Pair<Integer, Integer> p = checkOutMap.get(route);
        
        int totalTime = p.getKey();
        int count = p.getValue();
        
        return (double) totalTime / count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */