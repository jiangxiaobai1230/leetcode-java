package src.hot100;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-02 23:42
 */
public class No279 {
    public int numSquares(int n) {
        if(n==1)return 1;
        int[] dp=new int[n+1];
        Arrays.fill(dp,n);
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=100;j++){
                if(i<j*j)break;
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
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
        System.out.println(new No279().numSquares(12));
        System.out.println(new No279().numSquares(13));

    }
}
