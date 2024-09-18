package src.dp;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2024-06-29 23:08
 */
public class No279 {

//    public int numSquares(int n) {
//        int[][] dp=new int[101][n+1];
//        int[] nums=new int[101];
//        if(n==1)return 1;
//        Arrays.fill(dp[0],10001);
//        dp[0][0]=0;
////        for(int i=1;i<=n;i++){
////            dp[1][i]=n;
////        }
//        for(int i=1;i<=100;i++){
//            for(int j=0;j<=n;j++){
//                dp[i][j] = dp[i - 1][j];
//                    if (j >= i * i) {
//                        for(int k=1;k*i*i<=j;k++) {
//                            dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - k*i * i] + k);
//                        }
//                    }
////                System.out.println("i="+i+",j="+j+",dp[i][j]="+dp[i][j]);
//
//            }
//        }
//
//
//
//        return dp[100][n];
//
//    }


    public int numSquares(int n) {
        int[] dp=new int[n+1];
        if(n==1)return 1;
        Arrays.fill(dp,10001);
        dp[0]=0;
        for(int i=1;i<=Math.sqrt(n)+1;i++){
            int x=i*i;
            for(int j=x;j<=n;j++){
                dp[j]=Math.min(dp[j],dp[j-x]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：n = 12
        //输出：3
        //解释：12 = 4 + 4 + 4
        //示例 2：
        //
        //输入：n = 13
        //输出：2
        //解释：13 = 4 + 9
        //

        System.out.println(new No279().numSquares(6616));
        System.out.println(new No279().numSquares(13));
    }
}
