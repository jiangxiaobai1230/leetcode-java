package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-09-07 23:31
 */
public class No714 {

    public int maxProfit(int[] prices, int fee) {
        int days=prices.length;
        int[][] dp=new int[days][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<days;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }


        return dp[days-1][0];
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
        //输出：8
        //解释：能够达到的最大利润:
        //在此处买入 prices[0] = 1
        //在此处卖出 prices[3] = 8
        //在此处买入 prices[4] = 4
        //在此处卖出 prices[5] = 9
        //总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
        //示例 2：
        //
        //输入：prices = [1,3,7,5,10,3], fee = 3
        //输出：6

        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        No714 no714 = new No714();
        System.out.println(no714.maxProfit(prices, fee));
        System.out.println(no714.maxProfit(new int[]{1,3,7,5,10,3}, 3));

    }
}
