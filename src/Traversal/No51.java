package src.Traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-09 23:16
 */
public class No51 {
    private List<List<String>> res=new ArrayList<>();
    private char [][] table;
    public List<List<String>> solveNQueens(int n) {
        table=new char[n][n];
        for (char[] c:table) {
            Arrays.fill(c,'.');

        }
        backtracking(n,0);
        return res;

    }
    public void backtracking(int n,int row){
        if(row==n){
            res.add(ArrayToList(table));
            return;
        }
        for(int i=0;i<n;i++){
            if(isValid(row,i)){
                table[row][i]='Q';
                backtracking(n,row+1);
                table[row][i]='.';
            }
        }



    }
    public List<String> ArrayToList(char [][] table){
        List<String> path=new ArrayList<>();
        for(int i=0;i<table.length;i++){
            path.add(String.copyValueOf(table[i]));
        }
        return path;
    }
    public boolean isValid(int row,int col){
        for(int i=0;i<row;i++){
            if(table[i][col]=='Q')return false;
        }
        //45
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(table[i][j]=='Q')return false;
        }

        //135
        for(int i=row-1,j=col+1;i>=0&&j< table.length;i--,j++){
            if(table[i][j]=='Q')return false;
        }
        return true;

    }

    public static void main(String[] args) {

        //输入：n = 4
        //输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        //解释：如上图所示，4 皇后问题存在两个不同的解法。
        //示例 2：
        //
        //输入：n = 1
        //输出：[["Q"]]
        No51 no51 = new No51();
        List<List<String>> lists = no51.solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
        System.out.println();
        no51 = new No51();
        lists = no51.solveNQueens(1);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
        System.out.println();

    }
}
