package src.hot100;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-04 20:05
 */
public class No53 {

    public int maxSubArray(int[] nums) {
        int res=Integer.MIN_VALUE;
        int n=nums.length;
        int[] dp=new int[n+1];
        for(int i=0;i<n;i++){
            dp[i+1]=Math.max(nums[i],dp[i]+nums[i]);
            res=Math.max(res,dp[i+1]);
        }
        return res;
    }
//    public int maxSubArray(int[] nums) {
//        int sum=0,res=Integer.MIN_VALUE;
//        int n=nums.length;
//        if(n==1)return nums[0];
//        for(int i=0;i<n;i++){
//            if(sum>0)sum+=nums[i];
//            else sum=nums[i];
//            res=Math.max(res,sum);
//        }
//        return res;
//    }
//    public int maxSubArray(int[] nums) {
//        int sum=0,res=Integer.MIN_VALUE;
//        int n=nums.length;
//        if(n==1)return nums[0];
//        for(int i=0;i<n;i++){
//            if(sum<0||sum+nums[i]<0)sum=nums[i];
//            else {
//                sum+=nums[i];
//            }
//
//            res=Math.max(res,sum);
//        }
//        return res;
//
//    }

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

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {1};
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println(new No53().maxSubArray(nums1));
        System.out.println(new No53().maxSubArray(nums2));
        System.out.println(new No53().maxSubArray(nums3));

    }
}
