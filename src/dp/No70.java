package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-30 23:25
 */
public class No70 {

    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        if(n<=2)return n;
        dp[0]=0;
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
        No70 no70 = new No70();
        System.out.println(no70.climbStairs(2));
        System.out.println(no70.climbStairs(3));


    }

}
