package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-03 23:37
 */
public class No62 {

//    public int uniquePaths(int m, int n) {
//        int[][] dp=new int[m+1][n+1];
//        dp[0][1]=1;
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                dp[i+1][j+1]=dp[i][j+1]+dp[i+1][j];
//            }
//        }
//        return dp[m][n]/2;
//
//    }

    public int uniquePaths(int m, int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[j+1]+=dp[j];
            }
        }
        return dp[n];
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
        System.out.println(new No62().uniquePaths(3, 7));
        System.out.println(new No62().uniquePaths(3, 2));
        System.out.println(new No62().uniquePaths(7, 3));
        System.out.println(new No62().uniquePaths(3, 3));

    }
}
