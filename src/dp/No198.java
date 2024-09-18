package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-07-01 22:15
 */
public class No198 {

    public int rob(int[] nums) {
        int len=nums.length;
        if(len==1)return nums[0];
        if(len==2)return Math.max(nums[0],nums[1]);
        int[] dp=new int[len];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<len;i++){
            dp[i] = Math.max(dp[i - 1] , dp[i - 2] + nums[i]);
        }

        return dp[len-1];

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：[1,2,3,1]
        //输出：4
        //解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
        //     偷窃到的最高金额 = 1 + 3 = 4 。
        //示例 2：
        //
        //输入：[2,7,9,3,1]
        //输出：12
        //解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
        //     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
        int[] nums = {1,2,3,1};
        No198 no198 = new No198();
        System.out.println(no198.rob(nums));
        nums = new int[]{2,7,9,3,1};
        System.out.println(no198.rob(nums));

    }
}
