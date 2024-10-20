package src.dp;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2024-06-27 22:55
 */
public class No322 {

    public int coinChange(int[] coins, int amount) {
        int len=coins.length;
        if(len==0||amount==0)return 0;
//        if(len==1&&coins[0]!=amount)return -1;
        int[][] dp=new int[amount+1][len+1];
//        final int inf = 1 << 30;
        final int inf = Integer.MAX_VALUE-1;
        for (int[] g : dp) {
            Arrays.fill(g, inf);
        }
        dp[0][0]=0;
        for(int i=0;i<=amount;i++){
            for(int j=1;j<=len;j++){
                dp[i][j]=dp[i][j-1];
                if(i>=coins[j-1]) {
                    dp[i][j] = Math.min(dp[i][j],dp[i - coins[j - 1]][j] + 1);

                }
            }
        }

        return dp[amount][len]>=inf?-1:dp[amount][len];

    }

    public static void main(String[] args) {

        //示例 1：
        //
        //输入：coins = [1, 2, 5], amount = 11
        //输出：3
        //解释：11 = 5 + 5 + 1
        //示例 2：
        //
        //输入：coins = [2], amount = 3
        //输出：-1
        //示例 3：
        //
        //输入：coins = [1], amount = 0
        //输出：0
        //

        int[] coins = {1, 2, 5};
        int amount = 11;
        No322 no322 = new No322();
        System.out.println(no322.coinChange(coins, amount));
        System.out.println(no322.coinChange(new int[]{2}, 3));
        System.out.println(no322.coinChange(new int[]{1}, 0));


    }
}
