import java.util.ArrayList;
import java.util.List;

public class Pascal {
	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		if (numRows <= 0) {
			return list;
		}

		for (int i = 1; i <= numRows; i++) {
			List<Integer> firstRow = new ArrayList<Integer>(i);
			for (int l = 0; l < i; l++) {
				firstRow.add(1);
			}
			firstRow.set(0, 1);
			firstRow.set(i - 1, 1);
			for (int k = 1; k < i - 1; k++) {
				List<Integer> previousrow = list.get(i-2);
				
				firstRow.set(k, previousrow.get(k)+previousrow.get(k-1));
			}
			list.add(firstRow);
		}
		return list;
	}

	public static void main(String[] args) {
		List<List<Integer>> xyz = new Pascal().generate(9);

		for (List<Integer> abc : xyz) {
			// System.out.print("c ");
			for (int b : abc) {
				// System.out.print("f ");
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}

}
