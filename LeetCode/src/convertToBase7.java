
public class convertToBase7 {
	
	public String convertToBase7(int num) {
        
		String s = "";
		int nu=0;
		int sign = num>0?1:-1;
		int temp = num * sign;
		int ind = 0;
		while(temp>0)
		{
			int rem = temp%7;
			nu = (int)(nu+ rem*Math.pow(10, ind++));
			temp /= 7;
		}
		nu *= sign; 
		return   Integer.toString(nu);
    }

	public static void main(String[] args) {
		String s = new convertToBase7().convertToBase7(-101);
		System.out.print(s);
	}
}
