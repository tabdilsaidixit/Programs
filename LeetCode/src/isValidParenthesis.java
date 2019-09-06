import java.util.Stack;

public class isValidParenthesis {
    public boolean isValid(String s) {
        
    	Stack<Character> stack = new Stack<Character>();
    	char[] charArr = s.toCharArray();
    	for(Character c:charArr) {
    		if(c=='('||c=='{'||c=='[') {
    			stack.push(c);
    		}
    		else {
    			if(stack.isEmpty()) {
    				return false;
    			}
    			switch (c) {
				case ')':
					
						if(stack.lastElement() =='(') {
							stack.pop();
						}
						else {
							return false;
						}
					
					
					break;
				case '}':
					
						if(stack.lastElement() =='{') {
							stack.pop();
						}
						else {
							return false;
						}
					
					break;
				case ']':
					
						if(stack.lastElement() =='[') {
							stack.pop();
						}
						else {
							return false;
						}
					
					break;

				default:
					return false;
				}
    		}
    		
    	}
    	if(stack.isEmpty())
    	{
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}
