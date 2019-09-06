import java.util.*;
public class lengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		int lenOfMaxSubstring = 0;
		int numberOfChars = s.length();
		for(int i=0; i<numberOfChars; i++)
		{
			int dis = getMaximumDistinctCharactersFromGivenIndex(s, i);
			if(dis>lenOfMaxSubstring) {
				lenOfMaxSubstring = dis;
			}
			i = i+dis;
		}
		
		return lenOfMaxSubstring;
    }
	
	private int getMaximumDistinctCharactersFromGivenIndex(String s, int i) {
		// TODO Auto-generated method stub
		List<Character> charsList = new ArrayList<Character>();
		for(int index = i; index < s.length(); index++) {
			if(!charsList.contains(s.charAt(index))) {
				charsList.add(s.charAt(index));
			}
			else {
				break;
			}
		}
		return charsList.size();
	}

	public static void main(String[] args) {
		System.out.println(new lengthOfLongestSubstring().lengthOfLongestSubstring("saieddiixit"));
	}
}
