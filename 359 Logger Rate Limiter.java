class Logger {
    private Map<String, Integer> cache;

    public Logger() {
        // LinkedHashMap keeps the insersion order
        cache= new LinkedHashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        // iterate the map to delete old entries
        // cuz the timestamp is universal for all the entries
        Iterator<Map.Entry<String, Integer>> iterator = cache.entrySet().iterator();
        while (iterator.hasNext()) {
            if (timestamp - iterator.next().getValue() >= 10) iterator.remove();
            else break;
        }
        
        if (cache.containsKey(message)) return false;
        cache.put(message, timestamp);
        
        return true;
    }
}