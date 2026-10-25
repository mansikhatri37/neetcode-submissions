class TimeMap {

    // "alice" -> {1, "foo"}
    //       -> {2, foo2}
    HashMap<String, Map<Integer,String>> map;

    public TimeMap() {
        
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        if(!map.containsKey(key)){

            map.put(key, new HashMap<>());
        }

        if(!map.get(key).containsKey(timestamp)){
            map.get(key).put(timestamp, value);
        }

    }
    
    public String get(String key, int timestamp) {
        
        //we try to find the maximum timestamp <= required timestamp

        if(!map.containsKey(key)){
            return "";
        }

        else{

            //key is present
            //look into timestamp

            int max = -1;

            for(int time : map.get(key).keySet()){

                if(time <= timestamp){
                    max = Math.max(max, time);
                }
            }

            if(max == -1 ) return "";

            return map.get(key).get(max);
        }
    }
}
