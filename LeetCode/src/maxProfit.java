
public class maxProfit {
    public int maxProfit(int[] prices) {
    	
    	int lowPrice = prices[0];
    	int startIndex = 1;
    	for(startIndex = 1;startIndex<prices.length; startIndex++) {
			if(lowPrice>prices[startIndex] ) {
				lowPrice=prices[startIndex];
			}
			else {
				break;
			}
		}
    	//System.out.print(lowPrice);
    	
    	int hiPrice = lowPrice; 
    	
    	for(;startIndex<prices.length; startIndex++) {
			if(hiPrice<prices[startIndex] ) {
				hiPrice=prices[startIndex];
			}
		}

    	//System.out.print(hiPrice);
    	
    	    	
        return hiPrice -lowPrice;
    }
    public static void main(String[] args) {
		int profit = new maxProfit().maxProfit(new int [] {7,6,4,3,1});
		System.out.print(profit);
	}
}
