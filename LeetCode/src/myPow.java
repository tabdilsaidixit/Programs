import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

public class myPow {
    public double myPow(double x, int n) {
        
    	if(x==0) {
    		return 0;
    	}
    	
    	if(n ==0 ) {
    		return 1;
    	}
    	double sign = 1;
    	if(x<0) {
    		if(n%2!=0) {
    			sign = -1;
        	}
    	}
    	boolean isMin = n==Integer.MIN_VALUE;
    	if(isMin) {
    		n = n+1;
    	}
    	x = Math.abs(x);
    	HashMap<Integer, Double> hashMap = new HashMap<Integer, Double>();
    	
    	Stack<Integer> powers = new Stack<Integer>();
    	powers.push(1);
    	int temp =Math.abs(n);
    	if(n>0)
    	{
    		hashMap.put(1, x);
    	}
    	else
    	{
    		hashMap.put(1, 1/x);
    	}
    	
    	int start = 2;
    	while(start<=temp) {
    		if(!(hashMap.containsKey(start))) {
        		int key = start/2;
        		double val = hashMap.get(key)*hashMap.get(key);
        		//double val  =0;
        		hashMap.put(start, val);
        		powers.push(start);
        		start = start*2;
        		if(start<0){
        			break;
        		}
        		System.out.println(start);
        	}
    	}
    	
    	double res = 1;
    	
    	
    	while(temp!=0) {
    		while(powers.lastElement()>temp) {
    			powers.pop();
    		}
    		int largestPower = powers.lastElement();
    		while(largestPower<=temp) {
    			//System.out.println(res);
    			res *= hashMap.get(largestPower);
    			temp = temp - largestPower;
    		}
    	}
    	
    	if(isMin) {
    		res /=x;
    	}
    	
    	return res*sign;
    }
    public double myPow1(double x, int n) {
    	return Math.pow(x, n);
    }
    
    public static void main(String[] args) {
    	System.out.println(new myPow().myPow(2.00000,-2147483648));
	}
}
