/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.backtracking;

/**
 *
 * @author moghaleb
 */
class soduko {
    private static int ASCII_ZERO = 0x30;
    public void solveSudoku(char[][] board) {
        
        if(board == null || board.length == 0)
            return;
        
        int n = board.length;
        solveSudoku(board, n);
    }
    
    private boolean isValidLoc(char[][] board, int num, int row, int col) {
        
        for(int d=0; d<board.length; d++) {
            if(board[row][d] == '.') continue; 
            int currVal = Integer.parseInt(String.valueOf(board[row][d]));
            if(currVal == num)
                return false;
        }
        
        for(int d=0; d<board[0].length; d++){
            if(board[d][col] == '.') continue; 
            int currVal = Integer.parseInt(String.valueOf(board[d][col]));
            if(currVal == num)
                return false;
        }
        
        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;
 
        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++)
        {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++)
            {
                if(board[r][d] == '.') continue; 
                int currVal = Integer.parseInt(String.valueOf(board[r][d]));
                if (currVal == num)
                {
                    return false;
                }
            }
        }
        return true;
        
    }
    
    private boolean solveSudoku(char[][] board, int N) {
        
        int row = -1; 
        int col = -1;
        boolean isEmpty = true;
        
        for(int i = 0; i< N; i++){
            for(int j = 0; j<N; j++) {
                if(board[i][j] == '.'){
                    isEmpty = false;
                    row = i; col = j;
                    break;
                }
            }
            if(!isEmpty)
                break;
        }
        
        if(isEmpty)
            return true;
        
        for(int num = 1; num<=N; num++){
            if(isValidLoc(board, num, row, col)) {
                board[row][col] = (char) (num+ASCII_ZERO);
                if(solveSudoku(board, N))
                    return true;
                else
                    board[row][col] = '.';
            }
        }
        return false;
        
    }
    
    public static void main(String[] args){
        soduko s=new soduko();
       s.solveSudoku(new char[][]{{'1','2','3'},{'2','3','6'}});
        
//        int[][] arr1 = { { 1, 2, 3  } row 0
//, { 4, 5, 6 }  row 1};
    }
}
