import java.util.*;
public class reverseParentheses {
    public String reverseParentheses(String s) {
        
    	Stack<Character> charStack = new Stack<Character>();
    	int count =0;
    	for(Character c : s.toCharArray()) {
    		if(c=='(') {
    			
    		}
    		else if(c==')') {
    			
    		}
    		else {
    			count++;
    			
    		}
    	}
    	
    	char[] newCharArray = new char[count];
    	count =0;
    	int currentStart =-1;
    	int currentend=-1;
    	int actualStringPointer =0;
    	for(Character c : s.toCharArray()) {
    		
    		if(c=='(') {
    			currentStart = actualStringPointer;
    		}
    		else if(c==')') {
    			currentend = actualStringPointer;
    			
    		}
    		else {
    			
    			if(charStack.isEmpty()) {
    				newCharArray[count] = c; 
    			}
    			count++;
    		}
    		
    		actualStringPointer++;
    	}
    	
    	
    	return newCharArray.toString();
    }
    public static void main(String[] args) {
		System.out.print(new reverseParentheses().reverseParentheses("(abcd)"));
	}
}
