import java.security.KeyStore.Entry;
import java.util.*;


public class isAnagram {
    public boolean isAnagram(String s, String t) {
    	
    	
    	
    	if(s.length()!=t.length()) {
    		return false;
    	}
    	
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for(Character c : s.toCharArray()) {
        	if(!hashMap.containsKey(c)) {
        		hashMap.put(c, 1);
        	}
        	else {
        		hashMap.replace(c, hashMap.get(c)+1);
        	}
        }
        
        HashMap<Character, Integer> hashMap1 = new HashMap<Character, Integer>();
        for(Character c : t.toCharArray()) {
        	if(!hashMap1.containsKey(c)) {
        		hashMap1.put(c, 1);
        	}
        	else {
        		hashMap1.replace(c, hashMap.get(c)+1);
        	}
        }
        
        //if(hashMap.e)
        
        for(Character c : t.toCharArray()) {
        	if(!hashMap.containsKey(c)) {
        		return false;
        	}
        	else {
        		if(hashMap.get(c) == 1){
                    hashMap.remove(c);
                }else {
                	hashMap.replace(c, hashMap.get(c)-1);
                }
        	}
        }
        if(hashMap.size()>0) {
        	return false;
        }
    	
    	return true;
    }
    public static void main(String[] args) {
		System.out.print(new isAnagram().isAnagram("aagram", "nagaram"));
	}
}