
public class isValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if(board.length!=9)
        {
        	return false;
        }
        if(board[0].length!=9) {
        	return false;
        }
        
    	if(!isRowWiseCorrect(board)) {
    		return false;
    	}

    	if(!isColsWiseCorrect(board)) {
    		return false;
    	}
    	int startRow =0;
    	
    	while(startRow<=6) {
    		int startCol =0;
    		while(startCol<=6) {
        		if(isRowColWiseCorrect(board,startRow,startRow+2, startCol,startCol+2)) {
        			return false;
        		}
        		startCol+=3;
        	}
    		startRow+=3;
    	}
    	
    	return true;
    }
    public boolean isRowWiseCorrect(char[][] board) {
    	boolean isCorrect =true;
    	int[] newArray = new int[9];
    	for(int i=0; i<board.length; i++) {
    		resetArray(newArray);
    		for(int j=0; j<board[i].length;i++) {
    			if(board[i][j]=='.') {
    				continue;
    			}
    			int x = board[i][j]-'1';
    			if(x>=0 &&x<9) {
    				newArray[x] = newArray[x]+1;
    				if(newArray[x]>1) {
    					return false;
    				}
    			}
    			else {
    				return false;
    			}
    		}
    	}
    	
    	
    	return isCorrect;
    	
    }
    
    public boolean isColsWiseCorrect(char[][] board) {
    	boolean isCorrect =true;
    	int[] newArray = new int[9];
    	for(int i=0; i<board.length; i++) {
    		resetArray(newArray);
    		for(int j=0; j<board[i].length;i++) {
    			if(board[j][i]=='.') {
    				continue;
    			}
    			int x = board[j][i]-'1';
    			if(x>=0 &&x<9) {
    				newArray[x] = newArray[x]+1;
    				if(newArray[x]>1) {
    					return false;
    				}
    			}
    			else {
    				return false;
    			}
    		}
    	}
    	
    	
    	return isCorrect;
    	
    }
    
    public boolean isRowColWiseCorrect(char[][] board, int startRow, int endRow, int startCol, int endCol) {
    	boolean isCorrect =true;
    	int[] newArray = new int[9];
    	for(int i=startRow; i<=endRow; i++) {
    		resetArray(newArray);
    		for(int j=startCol; j<endCol;i++) {
    			if(board[i][j]=='.') {
    				continue;
    			}
    			int x = board[i][j]-'1';
    			if(x>=0 &&x<9) {
    				newArray[x] = newArray[x]+1;
    				if(newArray[x]>1) {
    					return false;
    				}
    			}
    			else {
    				return false;
    			}
    		}
    	}
    	
    	
    	return isCorrect;
    	
    }
    
    public void resetArray(int[] newArray) {
    	for(int i=0; i<newArray.length; i++) {
    		newArray[i] =0;
    	}
    }
}
