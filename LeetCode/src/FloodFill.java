import java.util.HashSet;
import java.util.Set;

public class FloodFill {
	int count =0;
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		
		Set<String> set = new HashSet<String>();
        if(image.length<sr){
            return image;
        }
        int numCols = image[0].length;
        if(numCols<sc){
            return image;
        }
        
        int oldColor = image[sr][sc];
        if(oldColor == newColor){
            return image;
        }
        
        int[][] nImage = floodFill(image, sr, sc, newColor, oldColor, set);
        return nImage;
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor, int oldColor, Set<String> set) {
        System.out.println(++count);
        if(image[sr][sc] == oldColor){
            image[sr][sc] = newColor;
        }
        else {
        	return image;
        }
        if(!set.add(sc+"_"+sr)) {
        	return image;
        }
        
        if(sr-1>=0){
            image = floodFill(image, sr-1, sc, newColor, oldColor,set );
        }
        if(sc-1>=0){
            image = floodFill(image, sr, sc-1, newColor, oldColor,set);
        }
        
        if(sr+1<image.length){
            image = floodFill(image, sr+1, sc, newColor, oldColor,set);
        }
        if(sc+1<image[0].length){
            image = floodFill(image, sr, sc+1, newColor, oldColor,set);
        }
        
        return image;
    }
    public static void main(String[] args) {
		new FloodFill().floodFill(new int[][] {{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2);
	}
}
