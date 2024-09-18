package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-06-25 23:34
 */
public class No518 {

    public int change(int amount, int[] coins) {

        int len=coins.length;
        int[][] dp=new int[len+1][amount+1];
        dp[0][0]=1;
        for(int i=1;i<=len;i++){
            int coin=coins[i-1];
            for(int j=0;j<=amount;j++){
                dp[i][j] =dp[i - 1][j];
                for(int k=1;k*coin<=j;k++) {
                    dp[i][j] += dp[i - 1][j-k*coin];
                }
            }
        }
        return dp[len][amount];

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：amount = 5, coins = [1, 2, 5]
        //输出：4
        //解释：有四种方式可以凑成总金额：
        //5=5
        //5=2+2+1
        //5=2+1+1+1
        //5=1+1+1+1+1
        //示例 2：
        //
        //输入：amount = 3, coins = [2]
        //输出：0
        //解释：只用面额 2 的硬币不能凑成总金额 3 。
        //示例 3：
        //
        //输入：amount = 10, coins = [10]
        //输出：1

        int[] coins = new int[]{1, 2, 5};
        System.out.println(new No518().change(5, coins));
        coins = new int[]{2};
        System.out.println(new No518().change(3, coins));
        coins = new int[]{10};
        System.out.println(new No518().change(10, coins));

    }
}
