import java.util.HashMap;

public class NumJewelsInStones {
	
    public int numJewelsInStones(String J, String S) {
        
    	HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    	
    	int[] charArray = S.chars().toArray();
    	
    	for(int j:charArray)
    	{
    		if(!hashMap.containsKey(j))
    		{
    			hashMap.put(j, 1);
    		}
    		else
    		{
    			hashMap.replace(j, hashMap.get(j)+1);
    		}
    	}
    	
    	int count =0;
    	for(int k:J.chars().toArray())
    	{
    		if(hashMap.containsKey(k))
    		{
    			count+=hashMap.get(k);
    		}
    	}
    	return count;
    }
	
	public static void main(String[] args) {
		int count = new NumJewelsInStones().numJewelsInStones("ac", "aAAbbbbcC");
		System.out.print(count);
	}

}
