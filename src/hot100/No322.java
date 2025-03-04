package src.hot100;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-02 22:33
 */
public class No322 {

    public int coinChange(int[] coins, int amount) {
        if(amount==0)return 0;
        int len=coins.length;
        if(len==1)return amount%coins[0]==0?amount/coins[0]:-1;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<len;j++) {
                if (i>=coins[j]){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];

    }
//    public int coinChange(int[] coins, int amount) {
//        if(amount==0)return 0;
//        int len=coins.length;
//        if(len==1)return amount%coins[0]==0?amount/coins[0]:-1;
//        int[][] dp=new int[len+1][amount+1];
//        Arrays.fill(dp[0], Integer.MAX_VALUE / 2); // 除 2 防止下面 + 1 溢出
//        dp[0][0] = 0;
//        for(int i=1;i<=len;i++){
//            for(int j=0;j<=amount;j++){
//                if(j<coins[i-1])dp[i][j]=dp[i-1][j];
//                else dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
//            }
//        }
//        int ans=dp[len][amount];
//        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
//
//
//
//    }

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

        int res = new No322().coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(res);
        res = new No322().coinChange(new int[]{2}, 3);
        System.out.println(res);
        res = new No322().coinChange(new int[]{1}, 0);
        System.out.println(res);

    }
}
