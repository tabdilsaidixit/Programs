import java.util.HashMap;
import java.util.Map;

import javax.activation.MailcapCommandMap;

public class Codec {
    HashMap<String, String> hashMap = new HashMap<String, String>();
    int count =0;
    String shortUrlHead = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(!hashMap.containsKey(longUrl)){
            count++;
            String shortURL = shortUrlHead + count;
            hashMap.put(longUrl, shortURL);
            return shortURL;
        }
        else{
            return hashMap.get(longUrl);
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String originalUrl = null;
    	if(hashMap.values().contains(shortUrl)) {
        	for(Map.Entry<String, String> m: hashMap.entrySet()) {
        		if(m.getValue() == shortUrl) {
        			originalUrl =  m.getKey();
        			break;
        		}
        	}
        }
        return originalUrl;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));