import java.beans.FeatureDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Permutation {

	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(nums.length<1) {
			return list;
		}
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (Integer n : nums) {
			if (!map.containsKey(n)) {
				map.put(n, 1);
			} else {
				map.put(n, map.get(n) + 1);
			}
		}

		int[] distictNumbers = new int[map.keySet().size()];
		int[] frequency = new int[map.keySet().size()];
		int index = 0;

		for (Integer ent : map.keySet()) {
			distictNumbers[index] = ent;
			frequency[index] = map.get(ent);
			index++;
		}

		int[] result = new int[nums.length];
		
		permute(distictNumbers,frequency,result,0, list);
		return list;

	}

	void permute(int[] distictNumbers, int[] frequency, int[] result, int height, List<List<Integer>> list) {
		
		if(height == result.length) {
			List<Integer> li = new ArrayList<Integer>();
			for(int nu:result) {
				li.add(nu);
			}
			list.add(li);
		}
		
		for(int i=0; i<distictNumbers.length; i++) {
			if(frequency[i]==0) {
				continue;
			}
			result[height] = distictNumbers[i];
			frequency[i] = frequency[i]-1;
			permute(distictNumbers,frequency,result,height+1, list);
			frequency[i] = frequency[i]+1;
		}

	}
	
	public static void main(String[] args) {
		List<List<Integer>> l = new Permutation().permute(new int[] {1,2,3});
		for(List<Integer> ll:l) {
			for(Integer lll:ll) {
				System.out.print(lll);
			}
			System.out.println();
		}
	}
}
