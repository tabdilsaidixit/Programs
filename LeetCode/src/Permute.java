import java.util.*;

public class Permute {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		TreeMap<Integer, Integer> hashSet = new TreeMap<Integer, Integer>();
		for(int num:nums) {
			if(!hashSet.containsKey(num)) {
				hashSet.put(num, 0);
			}
			hashSet.put(num, hashSet.get(num)+1);
		}
		
		
		

		return list;
	}
	
	void getPermutations(List<List<Integer>> finalList,int[] nums,
			List<Integer> currentList, TreeMap<Integer, Integer> hashSet, int level) {
		if(currentList.size()==nums.length) {
			finalList.add(currentList);
		}
		
		
	}

	public static void main(String[] args) {

		List<List<Integer>> list = new Permute().permute(new int[] { 1, 2, 3 });
		for (List<Integer> l : list) {
			for (Integer i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}
}
