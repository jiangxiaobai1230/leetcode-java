package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-06-01 23:12
 */
public class No63{

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length<=1&&obstacleGrid[0].length<=1)return obstacleGrid[0][0]==0?1:0;
        if(obstacleGrid[0][0]==1)return 0;
        int[][] dp=new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        dp[1][1]=1;
        for(int i=1;i<=obstacleGrid.length;i++){
            for(int j=1;j<=obstacleGrid[0].length;j++){
                if(i==1&&j==1){
                    continue;
                } else if (i<=obstacleGrid.length&&j<=obstacleGrid[0].length&&obstacleGrid[i-1][j-1]==1) {
                    dp[i][j]=0;
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }

            }
        }

        return dp[obstacleGrid.length][obstacleGrid[0].length];

    }

    public static void main(String[] args) {
        //输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
        //输出：2
        //解释：3x3 网格的正中间有一个障碍物。
        //从左上角到右下角一共有 2 条不同的路径：
        //1. 向右 -> 向右 -> 向下 -> 向下
        //2. 向下 -> 向下 -> 向右 -> 向右
        //示例 2：
        //
        //
        //输入：obstacleGrid = [[0,1],[0,0]]
        //输出：1
        int[][] obstacleGrid = {{1,0}};
        No63 no63 = new No63();
        System.out.println(no63.uniquePathsWithObstacles(obstacleGrid));
        System.out.println(no63.uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));

    }
}
