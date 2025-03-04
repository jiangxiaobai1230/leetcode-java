package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-02 23:24
 */
public class No70 {
    public int climbStairs(int n) {
        if(n<=2)return n;
        int dp[]=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：n = 2
        //输出：2
        //解释：有两种方法可以爬到楼顶。
        //1. 1 阶 + 1 阶
        //2. 2 阶
        //示例 2：
        //
        //输入：n = 3
        //输出：3
        //解释：有三种方法可以爬到楼顶。
        //1. 1 阶 + 1 阶 + 1 阶
        //2. 1 阶 + 2 阶
        //3. 2 阶 + 1 阶
        //

        System.out.println(new No70().climbStairs(2));
        System.out.println(new No70().climbStairs(3));

    }

}
