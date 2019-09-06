public class XYZ{
	 public boolean isPrime(int n){
	        for(int i =3 ; i<=Math.sqrt(n); i++){
	            if(n%i==0) {
	            	return false;
	            }
	        }
	        
	        return true;
	    }
	 
	 
	 public int countPrimes(int n) {
	     if(n<=1) {
	    	 return 0;
	     }
	     int count = 1;
	     for(int i=3;i<=n;i=i+2) {
	    	 if(isPrime(i)) {
	    		 count++;
	    	 }
	     }
		 return count;
		 
	    }
	 public static void main(String[] args) {
		System.out.print(new XYZ().countPrimes(100));
	}
}