package src.hot100;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-05 19:42
 */
public class No121 {


    public int maxProfit(int[] prices) {
        int res=0,profit=0,n=prices.length;
        for(int i=1;i<n;i++){
            profit+=prices[i]-prices[i-1];
            if(profit<0)profit=0;
            res=Math.max(res,profit);
        }
        return res;
    }

//    public int maxProfit(int[] prices) {
//        int res=0,cost=Integer.MAX_VALUE,n=prices.length;
//        for(int i=0;i<n;i++){
//            cost=Math.min(cost,prices[i]);
//            res=Math.max(res,prices[i]-cost);
//        }
//        return res;
//    }
//    public int maxProfit(int[] prices) {
//        int res=0,n=prices.length;
//        int[] bigNum=new int[n];
//        Arrays.fill(bigNum,-1);
//        bigNum[n-1]=prices[n-1];
//        int maxNum=prices[n-1];
//        for(int i=n-2;i>=0;i--){
//            if(prices[i]<maxNum){
//                bigNum[i]=maxNum;
//            }
//            else {
//                maxNum=prices[i];
//            }
//        }
//        for(int i=0;i<n;i++){
//            if(bigNum[i]!=-1){
//                res=Math.max(res,bigNum[i]-prices[i]);
//            }
//        }
//        return res;
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
        int[] prices = {1,2};
        No121 no121 = new No121();
        System.out.println(no121.maxProfit(prices));
        System.out.println(no121.maxProfit(new int[]{7, 6, 4, 3, 1}));


    }
}
