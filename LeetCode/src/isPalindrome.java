
import java.util.*;
public class isPalindrome {
    public boolean isPalindrome1(ListNode head) {
    	int sum =0;
        int sum2=0;
        int index =0;
        while(head!=null) {
        	sum = sum*10 + head.val;
        	sum2 = (int) (sum2 + (Math.pow(10, index)*(head.val)));
            head = head.next;
            index++;
        }
    	
    	return sum==sum2;
    }
    public boolean isPalindrome4(ListNode head) {
        StringBuilder sum =new StringBuilder();
     	StringBuilder sum2=new StringBuilder();
         while(head!=null) {
         	sum.append(head.val);
         	sum2.insert(0, head.val);
         	System.out.println(sum.toString());
         	System.out.println(sum2.toString());
             head = head.next;
         }
         if(sum.toString().compareTo(sum2.toString())==0) {
         	return true;
         }
         else {
         	return false;
         }
     }
    public boolean isPalindrome2(ListNode head) {
    	String sum ="";
        String sum2="";
        while(head!=null) {
        	sum = sum+ head.val;
        	sum2 = head.val+sum;
        	head = head.next;
        }
        System.out.println(sum);
        System.out.println(sum2);
        if(sum.compareTo(sum2)==0) {
        	return true;
        }
        else {
        	return false;
        }
    }
    
    
    public boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<Integer>(); 
        while(head!=null) {
        	arr.add(head.val);
        }
        boolean isPal = true;
    	for(int i=0; i<=arr.size()/2; i++) {
    		if(arr.get(i)!=arr.get(arr.size()-1-i)) {
    			isPal =false;
    		}
    	}
    	return isPal;
    }
    
    
}
