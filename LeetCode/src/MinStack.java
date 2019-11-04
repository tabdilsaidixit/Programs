import java.util.*;

public class MinStack {
    LinkedList<Integer> linkedList = null;
    
    /** initialize your data structure here. */
    public MinStack() {
    	linkedList = new LinkedList<Integer>();
    }
    
    public void push(int x) {
    	linkedList.add(0,x);
        
    }
    
    public void pop() {
    	
    	if(!linkedList.isEmpty()) {
    		linkedList.remove(0);
    	}
    }
    
    public int top() {
    	if(!linkedList.isEmpty()) {
    		int top = linkedList.get(0);
    		linkedList.remove(0);
    		return top;
    	}
    	else
    		return -1;
    }
    
    public int getMin() {
    	int s =linkedList.size();
    	int min = Integer.MAX_VALUE;
    	for(int i=0; i< s; i++) {
    		if(min>linkedList.get(i)) {
    			min = linkedList.get(i);
    		}
    	}
    	return min;
    }
}
