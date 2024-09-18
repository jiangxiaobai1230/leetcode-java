package src.dp;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2024-08-15 21:42
 */
public class No123 {
    public int maxProfit(int[] prices) {

        long[][] dp=new long[prices.length+1][5];
        //0,1,2,3,4分别对应没买过/买过一次/卖过一次/买过两次/卖过两次

        for(long[] num:dp){
            Arrays.fill(num,Integer.MIN_VALUE);
        }
        dp[0][0]=0;
        for(int i=1;i< dp.length;i++){
            dp[i][0]=0;
            dp[i][1]=Math.max(dp[i-1][0]-prices[i-1],dp[i-1][1]);
            dp[i][2]=Math.max(dp[i-1][1]+prices[i-1],dp[i-1][2]);
            dp[i][3]=Math.max(dp[i-1][2]-prices[i-1],dp[i-1][3]);
            dp[i][4]=Math.max(dp[i-1][3]+prices[i-1],dp[i-1][4]);
        }
        long result=0;
        for(int i=0;i<5;i++){
            result= Math.max(result,dp[prices.length][i]);
        }
        return (int) result;

    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入：prices = [3,3,5,0,0,3,1,4]
        //输出：6
        //解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
        //     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
        //示例 2：
        //
        //输入：prices = [1,2,3,4,5]
        //输出：4
        //解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
        //     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
        //     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
        //示例 3：
        //
        //输入：prices = [7,6,4,3,1]
        //输出：0
        //解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
        //示例 4：
        //
        //输入：prices = [1]
        //输出：0
        int[] prices = {3,3,5,0,0,3,1,4};
        No123 no123 = new No123();
        System.out.println(no123.maxProfit(prices));
        System.out.println(no123.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(no123.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(no123.maxProfit(new int[]{1}));

    }
}
