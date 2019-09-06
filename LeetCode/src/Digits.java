import java.util.HashMap;
import java.util.TreeMap;

public class Digits {

public String originalDigits(String s) {
	
	
	int[] num = new int[10];
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    Integer val = map.get(c);
	    if (val != null) {
	        map.put(c, new Integer(val + 1));
	    }
	    else {
	       map.put(c, 1);
	   }
	}
	
	
	
	if(map.containsKey('z'))
	{
		int c = map.get('z');
		num[0] = c;
		
		map.remove('z');
		if(c>0)
		{	
		map.replace('e', map.get('e') - c);
		map.replace('r', map.get('r') - c);
		map.replace('o', map.get('o') - c);
		}
	}
	
	if(map.containsKey('w'))
	{
		int c = map.get('w');
		num[2] = c;
		map.remove('w');
		if(c>0)
		{
		map.replace('t', map.get('t') - c);
		map.replace('o', map.get('o') - c);
		}
	}
	if(map.containsKey('u'))
	{
		int c = map.get('u');
		num[4] = c;
		map.remove('u');
		if(c>0)
		{
		map.replace('f', map.get('f') - c);
		map.replace('o', map.get('o') - c);
		map.replace('r', map.get('r') - c);
		}
	}
	if(map.containsKey('x'))
	{
		int c = map.get('x');
		num[6] = c;
		map.remove('x');
		if(c>0)
		{
		map.replace('s', map.get('s') - c);
		map.replace('i', map.get('i') - c);
		}
	}
	if(map.containsKey('g'))
	{
		int c = map.get('g');
		num[8] = c;
		map.remove('g');
		if(c>0)
		{
		map.replace('e', map.get('e') - c);
		map.replace('i', map.get('i') - c);
		map.replace('h', map.get('h') - c);
		map.replace('t', map.get('t') - c);
		}
	}
	if(map.containsKey('o'))
	{
		int c = map.get('o');
		num[1] = c;
		map.remove('o');
		if(c>0)
		{
		map.replace('n', map.get('n') - c);
		map.replace('e', map.get('e') - c);
		}
	}
	if(map.containsKey('h'))
	{
		int c = map.get('h');
		num[3] = c;
		map.remove('h');
		if(c>0)
		{
		map.replace('t', map.get('t') - c);
		map.replace('r', map.get('r') - c);
		map.replace('e', map.get('e') - 2*c);
		}
	}
	
	if(map.containsKey('f'))
	{
		int c = map.get('f');
		num[5] = c;
		map.remove('f');
		if(c>0)
		{
		map.replace('i', map.get('i') - c);
		map.replace('v', map.get('v') - c);
		map.replace('e', map.get('e') - 2*c);
		}
	}
	if(map.containsKey('s'))
	{
		int c = map.get('s');
		num[7] = c;
		map.remove('s');
		if(c>0)
		map.replace('n', map.get('n') - c);
	}
	if(map.containsKey('n'))
	{
		int c = map.get('n');
		num[9] = c;
	}
	
	String finalResult = "";
	
	for(int i=0; i<=9; i++)
	{
		for(int j=0;j<num[i];j++)
		{
			finalResult += Integer.toString(i);
		}
	}
	
        return finalResult;
    }
public static void main(String[] args) {
	String x = new Digits().originalDigits("fviefuro");
	System.out.print(x);
}
}
