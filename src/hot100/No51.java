package src.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-27 21:13
 */
public class No51 {
    private List<List<String>> res=new ArrayList<>();
//    private List<String> path=new ArrayList<>();
    int[] queens;// 皇后放在 (r,queens[r])
    boolean[] col;
    //从左向右斜
    private boolean[] diag1;
    //从右向左斜
    private boolean[] diag2;
    private int n;
    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        queens=new int[n];
        diag1=new boolean[2*n-1];
        diag2=new boolean[2*n-1];
        this.n=n;
        dfs(0);
        return res;
    }
    private void dfs(int r) {
        if(r==n){
            List<String> path=chess();
            res.add(path);
            return;
        }
        for(int c=0;c<n;c++){
            int r_c=r-c+n-1;//r-c范围分布在1-n n-1
            if(!col[c]&&!diag1[r+c]&&!diag2[r_c]) {
                col[c]=diag1[r+c]=diag2[r_c]=true;
                queens[r]=c;
                dfs(r+1);
                col[c]=diag1[r+c]=diag2[r_c]=false;
            }
        }




    }
    private List<String> chess(){
        List<String> path=new ArrayList<>();
        for(int i=0;i<n;i++){
            char[] c=new char[n];
            Arrays.fill(c,'.');
            int index=queens[i];
            c[index]='Q';
//            String s=String.join()
            path.add(new String(c));
        }
        return path;
    }
//    private void dfs(int i,int j,int index){
//        if(i<0||i>=n||j<0||j>=n)return;
//        if(index==n){
//            chess();
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        for(int row=i;row<n;row++){
//            for(int col=j;col<n;col++){
//                if(Valid(row,col)) {
//                    Queen[row]=col;
//                    dfs(i+1,j+1,index+1);
//
//                }
//            }
//        }
//
//    }

//
//    private boolean Valid(int row, int col) {
//        if(row<0||row>=n||col<0||col>=n)return false;
//        //同一行
//        for(int i=0;i<n;i++){
//            if(Queen[i]!=-1)return false;
//        }
//
//        //同一列
//        for(int i=0;i<n;i++){
//            if(Queen[i]==col)return false;
//        }
//        //从左到右斜线
//        for(int i=row+1;i<n;i++){
//            if(Queen[i]==col+i-row)return false;
//
//        }
//        //从右到左斜线
//        for(int i=row-1;i>=0;i--){
//            if(Queen[i]==col+i-row)return false;
//        }
//
//        return true;
//    }


//    private boolean Valid(int row, int col) {
//        if(row<0||row>=n||col<0||col>=n)return false;
//        //同一行
//        for(int i=0;i<n;i++){
//            if(path.get(row).charAt(i)=='Q')return false;
//        }
//
//        //同一列
//        for(int i=0;i<n;i++){
//            if(path.get(i).charAt(col)=='Q')return false;
//        }
//        //从左到右斜线
//        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
//            if(path.get(i).charAt(j)=='Q')return false;
//
//        }
//        //从右到左斜线
//        for(int i=row+1,j=col+1;i<n&&j<n;i++,j++){
//            if(path.get(row).charAt(col)=='Q')return false;
//        }
//
//        return true;
//    }
    public static void main(String[] args) {

        //输入：n = 4
        //输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        //解释：如上图所示，4 皇后问题存在两个不同的解法。
        //示例 2：
        //
        //输入：n = 1
        //输出：[["Q"]]
        No51 no51 = new No51();
        System.out.println(no51.solveNQueens(4));
        no51 = new No51();
        System.out.println(no51.solveNQueens(1));

    }
}



