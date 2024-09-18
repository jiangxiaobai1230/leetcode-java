package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-08-16 23:37
 */
public class No188 {


    public int maxProfit(int k, int[] prices) {

        int len=prices.length;

        //在第*天交易*次，状态为0/1-不持有/持有
        int[][][] dp=new int[len][k+1][2];
        // base case:
        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
        }


        for(int i=1;i<len;i++){
            for(int j=1;j<=k;j++){
                dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j-1][1]+prices[i]);
                dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j][0]-prices[i]);
            }
        }

        return dp[len-1][k][0];


    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：k = 2, prices = [2,4,1]
        //输出：2
        //解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
        //示例 2：
        //
        //输入：k = 2, prices = [3,2,6,5,0,3]
        //输出：7
        //解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
        //     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

        int[] prices = new int[]{2,4,1};
        System.out.println(new No188().maxProfit(2, prices));
        prices = new int[]{3,2,6,5,0,3};
        System.out.println(new No188().maxProfit(2, prices));


    }
}
