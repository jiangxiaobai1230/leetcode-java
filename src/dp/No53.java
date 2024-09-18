package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-09-13 15:33
 */
public class No53 {
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len];
        //这里的dp[i]指的是以nums[i]结尾的范围内的最大连续和
        dp[0]=nums[0];
        int res=dp[0];
        for(int i=1;i<len;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=Math.max(res,dp[i]);

        }
        return res;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        //输出：6
        //解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
        //示例 2：
        //
        //输入：nums = [1]
        //输出：1
        //示例 3：
        //
        //输入：nums = [5,4,-1,7,8]
        //输出：23
        //

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        No53 no53 = new No53();
        int result = no53.maxSubArray(nums);
        System.out.println(result);
        nums = new int[]{1};
        result = no53.maxSubArray(nums);
        System.out.println(result);
        nums = new int[]{5,4,-1,7,8};
        result = no53.maxSubArray(nums);
        System.out.println(result);

    }
}
