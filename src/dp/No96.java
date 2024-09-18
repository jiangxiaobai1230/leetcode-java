package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-06-03 23:25
 */
public class No96 {


    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        //输入：n = 3
        //输出：5
        //示例 2：
        //
        //输入：n = 1
        //输出：1

        No96 no96 = new No96();
        System.out.println(no96.numTrees(3));
        System.out.println(no96.numTrees(1));
    }
}
