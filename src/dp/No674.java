package src.dp;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2024-09-11 16:55
 */
public class No674 {

    public int findLengthOfLCIS(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len];
        Arrays.fill(dp,1);
        int res=1;
        for(int i=0;i<len-1;i++) {
           if(nums[i]<nums[i+1])dp[i+1]=dp[i]+1;
            res = Math.max(res, dp[i+1]);
        }
        return res;

    }

//    public int findLengthOfLCIS(int[] nums) {
//        int len=nums.length;
//        int[] dp=new int[len];
//        Arrays.fill(dp,1);
//        int res=0;
//        for(int i=0;i<len;i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[j + 1]) {
//                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + 1);
//                }
//            }
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//
//    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [1,3,5,4,7]
        //输出：3
        //解释：最长连续递增序列是 [1,3,5], 长度为3。
        //尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
        //示例 2：
        //
        //输入：nums = [2,2,2,2,2]
        //输出：1
        //解释：最长连续递增序列是 [2], 长度为1。

        No674 no674 = new No674();
        int[] nums = new int[]{1,2,3,4};
        System.out.println(no674.findLengthOfLCIS(nums));
        nums = new int[]{2,2,2,2,2};
        System.out.println(no674.findLengthOfLCIS(nums));

    }
}
