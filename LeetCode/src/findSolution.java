import java.util.*;
public class findSolution {
	int customfunction(int x, int y) {
		return 0;
	}
    public List<List<Integer>> findSolution( int z) {
    	List<List<Integer>> list = new  ArrayList<List<Integer>>();
    	
    	int start_x =1, start_y =1;
    	
    	for(int i=1; i<z; i++) {
    		for(int j=1; j<z; i++) {
    			if(customfunction(i,j)==z) {
    				List<Integer> l = new ArrayList<Integer>();
        			l.add(i);
        			l.add(j);
        			list.add(l);
    			}
    			if(i!=j) {
    				if(customfunction(j, i)==z) {
        				List<Integer> l = new ArrayList<Integer>();
            			l.add(j);
            			l.add(i);
            			list.add(l);
        			}
    			}
    		}
    	}
    	return list;
    	
    	
    }
}
