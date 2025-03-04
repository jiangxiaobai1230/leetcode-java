package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-03 22:56
 */
public class No416 {
    //dp[i][j]是否刚好能凑到j的背包？


    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0)return false;
        sum=sum/2;
        boolean[] dp=new boolean[sum+1];
        dp[0]=true;
        for(int i=0;i<nums.length;i++){
            for(int j=sum;j>=nums[i];j--){
                dp[j]=dp[j]||dp[j-nums[i]];
            }
        }
        return dp[sum];
    }

//    public boolean canPartition(int[] nums) {
//        int sum=0;
//        for(int i=0;i<nums.length;i++){
//            sum+=nums[i];
//        }
//        if(sum%2!=0)return false;
//        sum=sum/2;
//        boolean[][] dp=new boolean[nums.length+1][sum+1];
//        dp[0][0]=true;
//        for(int i=0;i<nums.length;i++){
//            for(int j=0;j<=sum;j++){
//                if(j<nums[i])dp[i+1][j]=dp[i][j];
//                else dp[i+1][j]=dp[i][j-nums[i]]||dp[i][j];
//
//            }
//        }
//        return dp[nums.length][sum];
//
//    }

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
        System.out.println(new No416().canPartition(new int[]{1,5,11,5}));
        System.out.println(new No416().canPartition(new int[]{1,2,3,5}));

    }
}
