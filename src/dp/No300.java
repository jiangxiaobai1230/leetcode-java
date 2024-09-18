package src.dp;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2024-09-11 14:49
 */
public class No300 {
    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len];
        Arrays.fill(dp,1);
        int res=0;
        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }

            }
            res=Math.max(res,dp[i]);
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
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        No300 no300 = new No300();
        System.out.println(no300.lengthOfLIS(nums));
        nums = new int[]{0,1,0,3,2,3};
        System.out.println(no300.lengthOfLIS(nums));
        nums = new int[]{7,7,7,7,7,7,7};
        System.out.println(no300.lengthOfLIS(nums));
    }
}
