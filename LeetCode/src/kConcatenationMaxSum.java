
public class kConcatenationMaxSum {
	public int kConcatenationMaxSum(int[] arr, int k) {
        if(k<0) {
        	return 0;
        }
        boolean allNegative = true;
		for(int n: arr) {
			if(n>0) {
				allNegative = false;
				break;
			}
		}
		
		if(allNegative) {
			return 0;
		}
		
		boolean allPositive = true;
		for(int n: arr) {
			if(n<0) {
				allPositive = false;
				break;
			}
		}
		int positiveSum = 0;
		if(allPositive) {
			for(int n: arr) {
				positiveSum+=n;
			}
			System.out.println(positiveSum*k);
			return positiveSum*k;
		}
		
		
		int temSum = 0;
		for(int n: arr) {
			temSum+=n;
		}
		
		if(temSum <0) {
			int[] newArray = new int[arr.length * 2];
			
			
			for(int i=0; i<2; i++) {
				newArray[i] = arr[i%arr.length];
			}
			return getMaximumSubArraySum(newArray);
		}
		int[] newArray = new int[arr.length * k];
		
		
		for(int i=0; i<newArray.length; i++) {
			newArray[i] = arr[i%arr.length];
		}
		
		
		
		return getMaximumSubArraySum(newArray);
    }

	private int getMaximumSubArraySum(int[] newArray) {
		// TODO Auto-generated method stub
		int sum = 0;
		int carry = Integer.MIN_VALUE;
		
		for(int i=0; i<newArray.length; i++) {
			if(carry<0) {
				carry =0;
			}
			if(carry>sum) {
				sum =carry;
			}
			if(newArray[i]>sum) {
				sum = newArray[i];
			}
			carry = carry+newArray[i];
			if(carry>sum) {
				sum =carry;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(new kConcatenationMaxSum().kConcatenationMaxSum(new int[] {1,0,4,1,4}, 4));
	}
	
}
