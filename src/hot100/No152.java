package src.hot100;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-03 17:46
 */
public class No152 {
    public int maxProduct(int[] nums) {
        int len=nums.length;
        int[][] dp=new int[len+1][2];
        int max=Integer.MIN_VALUE;
        //dp[i][0]最小值,dp[i][1]最大值
        dp[0][0]=dp[0][1]=1;
        if(len==1)return nums[0];
        for(int i=0;i<len;i++){
            int num=nums[i];
            if(num>0){
                dp[i+1][1]=Math.max(num,dp[i][1]*num);
                dp[i+1][0]=Math.min(num,dp[i][0]*num);
            } else if (num<0) {
                dp[i+1][1]=Math.max(num,dp[i][0]*num);
                dp[i+1][0]=Math.min(num,dp[i][1]*num);
            }else {
                dp[i+1][1]=0;
                dp[i+1][0]=0;
            }
            max=Math.max(max,dp[i+1][1]);
//            if(num>0){
//                dp[i+1][1]=Math.max(dp[i+1][1],dp[i][1]*num);
//                dp[i+1][0]=Math.min(dp[i+1][0],dp[i][0]*num);
//            } else if (num<0) {
//                dp[i+1][1]=Math.max(dp[i+1][1],dp[i][0]*num);
//                dp[i+1][0]=Math.min(dp[i+1][0],dp[i][1]*num);
//            }else {
//                dp[i+1][1]=1;
//                dp[i+1][0]=1;
//            }
//            max=Math.max(max,dp[i+1][1]);
        }
        return max;

    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: nums = [2,3,-2,4]
        //输出: 6
        //解释: 子数组 [2,3] 有最大乘积 6。
        //示例 2:
        //
        //输入: nums = [-2,0,-1]
        //输出: 0
        //解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

        System.out.println(new No152().maxProduct(new int[]{0,2}));
        System.out.println(new No152().maxProduct(new int[]{-2,0,-1}));

    }
}
