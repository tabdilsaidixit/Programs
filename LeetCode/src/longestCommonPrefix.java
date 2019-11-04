
public class longestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0){
            return "";
        }
        
        String shortest = "";
        int length = Integer.MAX_VALUE;
        for(String str: strs ){
            if(length> str.length()){
                length = str.length();
                shortest = str;
            }
        }
        
        for(String str: strs){
            if(shortest.length() == 0){
                return "";
            }
            int l = shortest.length();
            int matchLen = 0;
            for(int i=0; i<l ; i++){
                if(str.charAt(i) != shortest.charAt(i)){
                    break;
                }
                matchLen++;
            }
            shortest = shortest.substring(0,matchLen+1 );
            
            
        }
        
        return shortest;
    }
}
