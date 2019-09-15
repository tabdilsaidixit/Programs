import java.util.ArrayList;
import java.util.List;

public class Permute {
	 public List<List<Integer>> permute(int[] nums) {
		 List<List<Integer>> list = new ArrayList<List<Integer>>();
		 int numberOfPermutations = 1;
		 
		 for(int i=1; i<=nums.length; i++) {
			 numberOfPermutations*=i;
		 }
		 
		 int[][] collectionOfIndices = new int[numberOfPermutations][nums.length];
		 
		 
		 
		 
		 
		 return list;
	    }
	 
	 public static void main(String[] args) {
		
	}
}
