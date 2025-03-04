package src.hot100;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-03 15:57
 */
public class No300 {
    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len+1];
        Arrays.fill(dp,1);
        dp[0]=0;
        int res=1;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++) {
                if (nums[j] < nums[i]) {
                    dp[i + 1] = Math.max(dp[i+1], dp[j+1] + 1);
                }
            }
            res=Math.max(res,dp[i+1]);
        }
        return res;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [10,9,2,5,3,7,101,18]
        //输出：4
        //解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
        //示例 2：
        //
        //输入：nums = [0,1,0,3,2,3]
        //输出：4
        //示例 3：
        //
        //输入：nums = [7,7,7,7,7,7,7]
        //输出：1
        System.out.println(new No300().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
        System.out.println(new No300().lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(new No300().lengthOfLIS(new int[]{7,7,7,7,7,7,7}));

    }
}
