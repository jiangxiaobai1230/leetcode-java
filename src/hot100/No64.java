package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-14 22:13
 */
public class No64 {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        if(m==1&&n==1)return grid[0][0];
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i-1<0&&j-1<0){
                    dp[i][j]=grid[i][j];
                }else if(i-1<0){
                    dp[i][j]=grid[i][j]+dp[i][j-1];
                }else if(j-1<0){
                    dp[i][j]=grid[i][j]+dp[i-1][j];
                }else dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];

            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
        //输出：7
        //解释：因为路径 1→3→1→1→1 的总和最小。
        //示例 2：
        //
        //输入：grid = [[1,2,3],[4,5,6]]
        //输出：12
        No64 no64 = new No64();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int res = no64.minPathSum(grid);
        System.out.println(res);
        grid = new int[][]{{1,2,3},{4,5,6}};
        res = no64.minPathSum(grid);
        System.out.println(res);
    }
}
