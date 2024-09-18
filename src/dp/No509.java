package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-30 23:18
 */
public class No509 {

    public int fib(int n) {
        if(n==0)return 0;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        //
        //
        //示例 1：
        //
        //输入：n = 2
        //输出：1
        //解释：F(2) = F(1) + F(0) = 1 + 0 = 1
        //示例 2：
        //
        //输入：n = 3
        //输出：2
        //解释：F(3) = F(2) + F(1) = 1 + 1 = 2
        //示例 3：
        //
        //输入：n = 4
        //输出：3
        //解释：F(4) = F(3) + F(2) = 2 + 1 = 3

        int n=2;

        No509 no509 = new No509();
        System.out.println(no509.fib(n));
        no509 = new No509();
        n=3;
        System.out.println(no509.fib(n));
        no509 = new No509();
        n=4;
        System.out.println(no509.fib(n));

    }
}
