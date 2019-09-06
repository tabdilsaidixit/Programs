
public class baseNeg2 {
	public String baseNeg2(int N) {
		 String s = "";
	        if(N==0){
	            return "0";
	        }
			while(N!=0) {
				
				int rem = N & 1;
				s = rem+s;
	            N = -(N >> 1);
	            System.out.println(N);
			}
			
			return s;
        
    }
	public static void main(String[] args) {
		String ans = new baseNeg2().baseNeg2(6);
		System.out.println(ans);
	}

}
