import java.util.*;
public class circularPermutation {
    public int maxLength(List<String> arr) {
        if(arr == null) {
        	return 0;
        }
    	if(arr.size()==0) {
    		return 0;
    	}
    	if(arr.size() == 1) {
    		return arr.get(0).length();
    	}
    	List<String> given = arr;
    	List<String> uni = maxLength1(arr);
    	while(!given.equals(uni)) {
    		given = uni;
    		uni = maxLength1(given);
    	}
    	int max =0;
    	for(String st: uni) {
    		if(max<st.length()) {
    			max = st.length();
    		}
    	}
    	
    	
    	return max;
    }
    
    public List<String> maxLength1(List<String> arr) {
    	List<String> uniq = new ArrayList<String>();
    	int  size =arr.size();
    	int[] alpha = new int[26];
    	for(int i=0; i<size; i++) {
    		//uniq.add(arr.get(i));
    		for(int j=i+1; j<size; j++) {
    			String concat = arr.get(i).concat(arr.get(j));
    			if(!uniq.contains(uniq)) {
        			uniq.add(concat);
        			for(int k=0; k<26; k++) {
        				alpha[k] = 0; 
        			}
        			
        			for(char c: concat.toCharArray()){
        				alpha[c-'a'] = alpha[c-'a'] + 1; 
        			}
        			for(int k=0; k<26; k++) {
        				if(alpha[k]>1) {
        					uniq.add(concat);
        				}
        			}
    			}
    		}
    	}
    	return uniq;
    }
    
    public static void main(String[] args) {
		List<String> newList = new ArrayList<String>();
		newList.add("un");
		newList.add("iq");
		newList.add("ue");
		new circularPermutation().maxLength(newList);
	}
}
