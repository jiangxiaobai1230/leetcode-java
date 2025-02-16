package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-12 22:35
 */

//https://leetcode.cn/problems/word-search/solutions/2927294/liang-ge-you-hua-rang-dai-ma-ji-bai-jie-g3mmm/?envType=study-plan-v2&envId=top-100-liked

public class No79 {
    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] w=word.toCharArray();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,w,i,j,0)){
                    return true;
                }
            }
        }
        return false;



    }
    public boolean dfs(char[][] board,char[] word,int i,int j,int k){
        if(board[i][j]!=word[k])return false;
        if(k==word.length-1)return true;
        board[i][j]=0;
        for(int[] d:DIRS){
            int x=i+d[0];
            int y=j+d[1];
            if(x>=0&&x<board.length&&y>=0&&y<board[0].length&&dfs(board,word,x,y,k+1)){
                return true;
            }
        }
        board[i][j]=word[k];
        return false;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
        //输出：true
        //示例 2：
        //
        //
        //输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
        //输出：true
        //示例 3：
        //
        //
        //输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
        //输出：false

        No79 no79 = new No79();
        System.out.println(no79.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(no79.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
        System.out.println(no79.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }
}
