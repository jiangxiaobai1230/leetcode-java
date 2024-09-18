package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-06-11 00:02
 */
public class No416 {

    public boolean canPartition(int[] nums) {

        int len=nums.length;
        if(len<2)return false;
        int sum=0;
        for(int i=0;i<len;i++){
            sum+=nums[i];
        }
        if(sum%2!=0)return false;
        int target=sum/2;
        int[][] dp=new int[len][target+1];
        if(nums[0]<=target){
            for(int i=nums[0];i<=target;i++) {
                dp[0][i] = nums[0];
            }
        }
        for(int i=1;i<len;i++){
            for(int j=0;j<=target;j++){
                if(j>nums[i]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
                }else
                    dp[i][j]=dp[i-1][j];

                if(j==nums[i]){
                    dp[i][j]=dp[i-1][j-nums[i]]+nums[i];
                }

            }
        }
        return dp[len-1][target]==target;


    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [1,5,11,5]
        //输出：true
        //解释：数组可以分割成 [1, 5, 5] 和 [11] 。
        //示例 2：
        //
        //输入：nums = [1,2,3,5]
        //输出：false
        //解释：数组不能分割成两个元素和相等的子集。

        int[] nums = {1,5,11,5};
        No416 no416 = new No416();
        System.out.println(no416.canPartition(nums));
        System.out.println(no416.canPartition(new int[]{1, 2, 3, 5}));
    }
}
