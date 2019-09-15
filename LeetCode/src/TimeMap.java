import java.util.HashMap;

public class TimeMap {
	
	String key;
	String value;
	int timestamp;
	
	HashMap<String, HashMap<Integer, String>> data = null;
	 /** Initialize your data structure here. */
    public TimeMap() {
    	data = new HashMap<String, HashMap<Integer,String>>();
    }
    
    public void set(String key, String value, int timestamp) {
    	HashMap<Integer, String> existing = null;
    	if(data.containsKey(key)) {
    		existing = data.get(key);
    	}
    	else {
    		existing = new HashMap<Integer,String>();
    	}
    	existing.put(timestamp, value);
    	
    	data.put(key, existing);
    }
    
    public String get(String key, int timestamp) {
    	HashMap<Integer, String> existing = null;
    	if(data.containsKey(key)) {
    		existing = data.get(key);
    	}
    	else {
    		return null;
    	}
    	
    	if(existing.containsKey(timestamp)) {
    		return existing.get(timestamp);
    	}
    	int max = Integer.MIN_VALUE;
    	for(Integer num: existing.keySet()) {
    		if(num<=timestamp) {
    			if(num>max) {
    				max = num;
    			}
    		}
    	}
    	
    	return existing.get(max);
    }
}
