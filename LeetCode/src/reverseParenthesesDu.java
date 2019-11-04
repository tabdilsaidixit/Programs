import java.io.CharConversionException;
import java.util.*;
public class reverseParenthesesDu {
    public String reverseParentheses(String s) {
    	 if(s.length()<2){
    	        return s;
    	    }
        String a ="";
    	Stack<Character> stack = new Stack<Character>();
    	Queue<Character> queue = new LinkedList<Character>();
    	
    	for(Character c : s.toCharArray()) {
    		if(c!=')') {
    			
    			stack.push(c);
    		}
    		else {
    			while(stack.peek()!='(') {
    				queue.add(stack.pop());
    			}
    			stack.pop();
    			while(!queue.isEmpty()) {
    				stack.push(queue.poll());
    			}
    		}
    	}
    	while(!stack.isEmpty()) {
			a =stack.pop()+a;
		}
    	
    	
    	return a;
    }
    
    public static void main(String[] args) {
		System.out.print(new reverseParenthesesDu().reverseParentheses("sa(abcd)"));
	}
}
