import java.util.*;

public class maxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
    	if(text.length()<6) {
    		return 0;
    	}
        int[] a = new int[26];
        for(Character c: text.toCharArray()) {
        	a[c-'a'] = a[c-'a'] +1;
        }
    	
        int bCount = a['b'-'a'];
        int aCount = a['a' - 'a'];
        int lCount = a['l'-'a'];
        int oCount = a['o'-'a'];
        int nCount = a['n'-'a'];
        int count =0;
        while(true) {
        	bCount--;
        	aCount = aCount-1;
        	lCount = lCount-2;
        	nCount--;
        	oCount = oCount-2;
        	if(bCount<0|| aCount<0||lCount<0||nCount<0||oCount<0) {
        		break;
        	}
        	count++;
        }
    	return count;
    }
    public static void main(String[] args) {
		System.out.println(new maxNumberOfBalloons().maxNumberOfBalloons("balloonnlaebolko"));
	}
}
