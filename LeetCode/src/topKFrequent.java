import java.util.*;
public class topKFrequent {
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> numbersList = new ArrayList<Integer>();
        List<Integer> frequenciesList = new ArrayList<Integer>();
        for(int n:nums){
            if(!numbersList.contains(n)){
               numbersList.add(n);
               frequenciesList.add(1);
            }
            else{
                int index = numbersList.indexOf(n);
                frequenciesList.set(index, frequenciesList.get(index)+1);
            }
        }
        
        for(int i=0; i<frequenciesList.size() ;i++) {
        	for(int j=0; j<frequenciesList.size() ;j++) {
            	if(frequenciesList.get(i)<frequenciesList.get(j)) {
            		int temp = frequenciesList.get(i);
            		frequenciesList.set(i, frequenciesList.get(j));
            		frequenciesList.set(j, temp);
            		
            		temp = numbersList.get(i);
            		numbersList.set(i, numbersList.get(j));
            		numbersList.set(j, temp);
            	}
            }
        }
        
        
        
        return numbersList.subList(0, k);
    }
}
