import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
    	HashMap<Integer, List<String>> hashMap = new HashMap<Integer, List<String>>();
    	List<String> list = new ArrayList<String>();
		hashMap.put(1, list);
		list.add("()");
    	if(n==1) {
    		
    		return list;
    	}
    	
    	for(int i=2; i<=n; i++) {
    		List<String> l = hashMap.get(i-1);
    		List<String> newList = getNewValidParanthesis(l);
    		hashMap.put(i, newList);
    		if(hashMap.containsKey(i-1)) {
    			hashMap.remove(i-1);
    		}
    	}
    	return hashMap.get(n);
    }

	private List<String> getNewValidParanthesis(List<String> l) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		
		for(String str: l) {
			String newS = str.concat("()");
			if(!list.contains(newS)) {
				list.add(newS);
			}
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)=='(') {
					
					String newStrin = str.substring(0,i+1).concat("()").concat(str.substring(i+1, str.length()));
					if(!list.contains(newStrin)) {
						list.add(newStrin);
					}
				}
				
			}
			
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		for(String s: new generateParenthesis().generateParenthesis(4)) {
			System.out.println(s);
		}
	}
}
