package src.tanxin;

import javax.print.DocFlavor;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-14 10:12
 */
public class No122 {

    public int maxProfit(int[] prices) {
        int sum=0;
        int low=prices[0],high=0;
        if(prices.length==1)return 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>low){
                high=prices[i];
                sum+=high-low;
                low=high;
            }else {
                low=prices[i];
            }

        }
        return sum;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：prices = [7,1,5,3,6,4]
        //输出：7
        //解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
        //     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
        //     总利润为 4 + 3 = 7 。
        //示例 2：
        //
        //输入：prices = [1,2,3,4,5]
        //输出：4
        //解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
        //     总利润为 4 。
        //示例 3：
        //
        //输入：prices = [7,6,4,3,1]
        //输出：0
        //解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。

        No122 no122 = new No122();
        System.out.println(no122.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(no122.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(no122.maxProfit(new int[]{7,6,4,3,1}));




    }

}
