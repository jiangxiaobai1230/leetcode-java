package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-07-19 22:32
 */
public class No121 {

    public int maxProfit(int[] prices) {
        int len=prices.length;
        if(len==1)return 0;
        if(len==2)return Math.max(0,prices[1]-prices[0]);
        int[] dp=new int[2];
        //dp[i][0]持有,dp[i][1]不持有
        dp[0]=-prices[0];
        dp[1]=0;
        for(int i=1;i<len;i++){
            dp[0]=Math.max(dp[0],-prices[i]);
            dp[1]=Math.max(dp[1],dp[0]+prices[i]);
        }

        return dp[1];

    }

//    public int maxProfit(int[] prices) {
//        int len=prices.length;
//        if(len==1)return 0;
//        if(len==2)return Math.max(0,prices[1]-prices[0]);
//        int high=0,low=0;
//        int[][] dp=new int[len][2];
//        //dp[i][0]持有,dp[i][1]不持有
//        dp[0][0]=-prices[0];
//        dp[0][1]=0;
//        for(int i=1;i<len;i++){
//            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
//            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
//        }
//
//        return dp[len-1][1];
//
//    }

//    public int maxProfit(int[] prices) {
//        int len=prices.length;
//        if(len==1)return 0;
//        if(len==2)return Math.max(0,prices[1]-prices[0]);
//        int high=0,low=Integer.MAX_VALUE,sum=0;
//        for(int i=0;i<len;i++){
//            if(i==0){
//                if(prices[i]<=prices[i+1]){
//                    low=prices[0];
//                }
//
//            }else if(i==len-1){
//                if(prices[i-1]<=prices[i]) {
//                    high = prices[i];
//                }
//            }else {
//                if (prices[i - 1] <= prices[i] && prices[i] >= prices[i + 1]) {
//                    high = prices[i];
//                }
//                if (prices[i - 1] >= prices[i] && prices[i] <= prices[i + 1]) {
//                    low = prices[i];
//                }
//                sum += Math.max(0, high - low);
//            }
//
//        }
//        return sum;
//
//    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：[7,1,5,3,6,4]
        //输出：5
        //解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
        //     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
        //示例 2：
        //
        //输入：prices = [7,6,4,3,1]
        //输出：0
        //解释：在这种情况下, 没有交易完成, 所以最大利润为 0。

        int[] prices = new int[]{7,1,5,3,6,4};
        No121 no121 = new No121();
        System.out.println(no121.maxProfit(prices));
        System.out.println(no121.maxProfit(new int[]{7,6,4,3,1}));
    }
}
