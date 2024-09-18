package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-31 23:33
 */
public class No62 {

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        dp[1][1]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1&&j==1) {
                    continue;
                }
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m][n];

    }

    public static void main(String[] args) {
        //输入：m = 3, n = 7
        //输出：28
        //示例 2：
        //
        //输入：m = 3, n = 2
        //输出：3
        //解释：
        //从左上角开始，总共有 3 条路径可以到达右下角。
        //1. 向右 -> 向下 -> 向下
        //2. 向下 -> 向下 -> 向右
        //3. 向下 -> 向右 -> 向下
        //示例 3：
        //
        //输入：m = 7, n = 3
        //输出：28
        //示例 4：
        //
        //输入：m = 3, n = 3
        //输出：6
        No62 no62 = new No62();
        System.out.println(no62.uniquePaths(3, 7));
        System.out.println(no62.uniquePaths(3, 2));
        System.out.println(no62.uniquePaths(7, 3));
        System.out.println(no62.uniquePaths(3, 3));

    }
}
