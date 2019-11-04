
public class longestPalindrome {
    public String longestPalindrome(String s) {
    	String longestString = "";
    	for(int i=0; i<s.length(); i++) {
    		String one = longestPalindrome(s,i);
    		String two = longestPalindrome1(s,i);
    		if(one.length()>two.length()) {
    			if(longestString.length()<one.length()) {
    				longestString = one;
    			}
    		}
    		else {
    			if(longestString.length()<two.length()) {
    				longestString = two;
    			}
    		}
    	}
    	
        return longestString;
    }
    
    public String longestPalindrome(String s, int index) {
    	int i=0;
    	int before=index;
    	int after=index+1;
    	while((after+i)<s.length()&&(before-i)>=0) {
    		if(s.charAt(after+i)==s.charAt(before-i)) {
    		i++;
    		}
    		else {
    			break;
    		}
    	}
    	if(i==0) {
    		return "";
    	}
    	return s.substring(before-i+1,after+i);
    }
    
    public String longestPalindrome1(String s, int index) {
    	int i=0;
    	while((index+i)<s.length()&&(index-i)>=0) {
    		if(s.charAt(index+i)==s.charAt(index-i)) {
    		i++;
    		}
    		else {
    			break;
    		}
    	}
    	
    	return s.substring(index-(i-1),index+(i));
    }
    
    public static void main(String[] args) {
		System.out.println(new longestPalindrome().longestPalindrome("acbbd"));
	}
    
    
}
