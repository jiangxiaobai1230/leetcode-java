package src.Traversal;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-10 18:36
 */
public class No37 {
    public void solveSudoku(char[][] board) {
        backtracking(board);

    }
    public boolean backtracking(char[][] board)
    {
       for(int i=0;i<9;i++){
           for(int j=0;j<9;j++){
               if(board[i][j]!='.')continue;
               for(char c='1';c<='9';c++){
                   if(isValid(board,i,j,c)){
                       board[i][j]=c;
                       if(backtracking(board)){
                           return true;
                       };
                       board[i][j]='.';
                   }
               }
               return false;
           }
       }

        return true;
    }
    public boolean isValid(char[][] board,int row,int col,char c){

        //同一行
        for(int i=0;i<9;i++){
            if(board[row][i]==c)return false;
        }

        //同一列
        for(int i=0;i<9;i++){
            if(board[i][col]==c)return false;
        }

        //3*3
        int startRow=row/3*3;
        int startCol=col/3*3;
        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol;j<startCol+3;j++){
                if(c==board[i][j])return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {


        //输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
        //输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        No37 no37 = new No37();
        no37.solveSudoku(board);
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
