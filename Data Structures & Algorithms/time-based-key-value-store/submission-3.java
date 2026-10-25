class TimeMap {

    private Map<String, TreeMap<Integer,String>> map ;

    public TimeMap() {
        
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        
        if(!map.containsKey(key)) return "";

        TreeMap<Integer, String> timestamps = map.get(key);

        //get the maximum timestamp that is less that or equal to the requested timestamp
        Map.Entry<Integer, String> entry = timestamps.floorEntry(timestamp);

        return entry == null ? "" : entry.getValue();
    }
}
