import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class threeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> listOfAllPossibleTriplets = new ArrayList<List<Integer>>();
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

		for (int num : nums) {
			if (!hashMap.containsKey(num)) {
				hashMap.put(num, 1);
			} else {
				hashMap.put(num, hashMap.get(num) + 1);
			}
		}

		int[] distinctNums = new int[hashMap.keySet().size()];
		int[] frequencies = new int[hashMap.keySet().size()];

		int index = 0;
		for (Integer key : hashMap.keySet()) {
			distinctNums[index] = key;
			frequencies[index] = hashMap.get(key);
			index++;
		}
		int[] result = new int[5];
		int height = 0;
		index = 0;
		allPossibleTriplets(height, result, listOfAllPossibleTriplets, distinctNums, frequencies, index);

		return listOfAllPossibleTriplets;
	}

	private void allPossibleTriplets(int height, int[] result,
			List<List<Integer>> listOfAllPossibleTriplets, int[] distinctNums, int[] frequencies, int index) {
		// TODO Auto-generated method stub
		if (height > result.length) {
			return;
		}
		if (height == result.length) {
			int res = 0;
			for (int i = 0; i < result.length; i++) {
				res += result[i];
			}
			if (true) {
				List<Integer> l = new ArrayList<Integer>();
				for (int i = 0; i < result.length; i++) {
					l.add(result[i]);
				}
				listOfAllPossibleTriplets.add(l);
			}
			return;
		}

		for (int i = index; i < distinctNums.length; i++) {
			if (frequencies[i] <= 0) {
				continue;
			}
			frequencies[i] = frequencies[i] - 1;
			result[height] = distinctNums[i];
			height++;
			allPossibleTriplets(height, result, listOfAllPossibleTriplets, distinctNums, frequencies, i);
			height--;
			frequencies[i] = frequencies[i] + 1;
		}

	}


public static void main(String[] args) {
	new threeSum().threeSum(new int[] {-1,0,1,2,-1,-4});
}

}
