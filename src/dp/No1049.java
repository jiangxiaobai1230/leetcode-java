package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-06-11 22:12
 */
public class No1049 {

    public int lastStoneWeightII(int[] stones) {
        int len=stones.length;
        if(len<2)return stones[0];
        int sum=0;
        for(int i=0;i<len;i++){
            sum+=stones[i];
        }
        int target=sum/2;
        int[][] dp=new int[len][target+1];
        for(int i=stones[0];i<=target;i++){
            dp[0][i]=stones[0];
        }
        for(int i=1;i<len;i++){
            for(int j=0;j<=target;j++){
                if(j>=stones[i]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-stones[i]]+stones[i]);
                }
                else dp[i][j]=dp[i-1][j];
            }
        }

        return sum-2*dp[len-1][target];
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：stones = [2,7,4,1,8,1]
        //输出：1
        //解释：
        //组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
        //组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
        //组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
        //组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
        //示例 2：
        //
        //输入：stones = [31,26,33,21,40]
        //输出：5

        int[] stones={2,7,4,1,8,1};
        No1049 no1049 = new No1049();
        System.out.println(no1049.lastStoneWeightII(stones));
        stones=new int[]{31,26,33,21,40};
        System.out.println(no1049.lastStoneWeightII(stones));
    }
}
