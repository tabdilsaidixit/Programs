import java.util.*;
public class isHappy{
	
	 public boolean isHappy(int n) {	        
		 Set<Integer> hashSet = new HashSet<Integer>();
		 int sum =n;
		 int temp = n;
		 while(sum!=1) {
			 temp=sum;
			 sum=0;
			 while(temp!=0) {
				 int rem = temp%10;
				 temp = temp/10;
				 sum = sum + (rem*rem);
			 }
			 if(!hashSet.add(sum)) {
				 return false;
			 }
		 }
		 
		 return true;
	    }
	 public static void main(String[] args) {
		System.out.println(new isHappy().isHappy(1));
	}
}