package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-09-04 23:13
 */
public class No309 {
    public int maxProfit(int[] prices) {

        int day=prices.length;
        int[][] dp=new int[day][4];
        //一共四个状态
        //0-没有持股且今天没卖出
        //1-没有持股且今天卖出
        //2-持股且今天买入
        //3-持股且今天没买入
        dp[0][0]=0;
        dp[0][1]=0;
        dp[0][2]=-prices[0];
        dp[0][3]=-prices[0];

        for(int i=1;i<day;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=Math.max(dp[i-1][2],dp[i-1][3])+prices[i];
            dp[i][2]=dp[i-1][0]-prices[i];
            dp[i][3]=Math.max(dp[i-1][2],dp[i-1][3]);
        }
        return Math.max(dp[day-1][0],dp[day-1][1]);
    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: prices = [1,2,3,0,2]
        //输出: 3
        //解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
        //示例 2:
        //
        //输入: prices = [1]
        //输出: 0
        //
        int [] prices = {1,2,3,0,2};
        System.out.println(new No309().maxProfit(prices));
        System.out.println(new No309().maxProfit(new int[]{1}));
    }
}
