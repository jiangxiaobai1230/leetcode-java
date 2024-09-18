package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-31 23:18
 */
public class No746 {

    public int minCostClimbingStairs(int[] cost) {

        int sum=0;
        int[] dp=new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=cost.length;i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2]+cost[i-2]);
        }
        return dp[cost.length];

    }

    public static void main(String[] args) {

        //示例 1：
        //
        //输入：cost = [10,15,20]
        //输出：15
        //解释：你将从下标为 1 的台阶开始。
        //- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
        //总花费为 15 。
        //示例 2：
        //
        //输入：cost = [1,100,1,1,1,100,1,1,100,1]
        //输出：6
        //解释：你将从下标为 0 的台阶开始。
        //- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
        //- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
        //- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
        //- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
        //- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
        //- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
        //总花费为 6 。
        // f

        int[] cost = new int[]{10,15,20};
        No746 no746 = new No746();
        System.out.println(no746.minCostClimbingStairs(cost));
        cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        System.out.println(no746.minCostClimbingStairs(cost));
    }
}
