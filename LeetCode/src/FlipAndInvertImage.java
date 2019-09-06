
public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] A) {
    	
    	int rows = A.length;
    	int cols = A[0].length;
    	for(int i=0; i<rows;i++)
    	for(int j=0; j<=cols/2;j++)
    	{
    		swap(A,i,j, cols);
    	}
    	
       return A; 
    }
    
    public void swap(int[][] A, int i, int j, int cols)
    {
    	int temp = A[i][j];
    	A[i][j] = A[i][cols-j-1]==0?1:0;
    	A[i][cols-j-1] = temp==0?1:0; 
    }
    public static void main(String[] args) {
		int[][]A = new int[][] {{1,1,0,1,0}};
		//int[][]A = new int[][] {{1,1,0},{1,0,1},{0,0,0}};
		
		new FlipAndInvertImage().flipAndInvertImage(A);
		System.out.print(A);
	}
}
