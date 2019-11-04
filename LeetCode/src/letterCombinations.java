import java.util.*;

public class letterCombinations {
    public List<String> letterCombinations(String digits) {
        
    	List<String> strList = new ArrayList<String>();
    	List<List<Character>> list = new ArrayList<List<Character>>();
    	char character = 'a';
    	int count = 3;
    	for(int i=2; i<=9; i++) {
    		if(i==7||i==9) {
    			count = 4;
    		}
    		else {
    			count = 3;
    		}
    		ArrayList<Character> charList  = new ArrayList<Character>();
    		for(int j=0; j<count;j++) {
    			charList.add(character++);
    		}
    		list.add(charList);
    		
    	}
    	
    	int level=0;
    	char digi= digits.charAt(level);
    	int num = digi-'0';
    	List<Character> charList = list.get(num-2);
    	for(Character c: charList) {
    		strList.add(""+c);
    	}
    	return letterCombinations(digits, 1, list, strList);
    }
    List<String> letterCombinations(String digits, int level, List<List<Character>> list, List<String> strList){
    	if(level == digits.length()) {
    		return strList;
    	}
    	List<String> stringList = new ArrayList<String>();
    	char digi= digits.charAt(level);
    	int num = digi-'0';
    	List<Character> charList = list.get(num-2);
    	for(String s: strList) {
    		for(Character c: charList) {
    			stringList.add(s+c);
        	}
    	}
    	strList = stringList;
    	return letterCombinations(digits, level +1, list, strList);
    }
    
    public static void main(String[] args) {
		new letterCombinations().letterCombinations("23");
	}
}
