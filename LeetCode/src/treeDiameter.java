import java.util.*;
public class treeDiameter {
	public int treeDiameter(int[][] edges) {
		List<Integer> nodesList =new ArrayList<Integer>();
		
		int numberOdEdges = edges.length;
		
		for(int i =0; i<numberOdEdges; i++) {
			if(!nodesList.contains(edges[i][0]))
			{
				nodesList.add(edges[i][0]);				
			}
			if(!nodesList.contains(edges[i][1]))
			{
				nodesList.add(edges[i][1]);				
			}
		}
		
		int numberOfNodes = nodesList.size();
		boolean[] visitedNodes = new boolean[numberOdEdges];
		int maxDiameter = 0;
		int dia = 0;
		for(int i = 0; i<numberOfNodes; i++) {
			Arrays.fill(visitedNodes, false);
			
			
		}
		Arrays.fill(visitedNodes, false);
		
		
		return 0;

	}
}
