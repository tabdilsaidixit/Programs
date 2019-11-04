
public class hasCycle {
    public boolean hasCycle(ListNode head) {
        
    	ListNode slow = head;
    	ListNode fast=head.next;
    	while(slow!=null && fast!=null&&fast.next!=null) {
    		if(slow==fast) {
    			return true;
    		}
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	
    	return false;
    }
}
