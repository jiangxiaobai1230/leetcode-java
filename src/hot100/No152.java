package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-12-02 22:51
 */
public class No152 {

    //https://leetcode.cn/problems/maximum-product-subarray/solutions/3831843/cheng-ji-zui-da-zi-shu-zu-by-keen-vvilso-2kww/?envType=study-plan-v2&envId=top-100-liked
    public int maxProduct(int[] nums) {
        int len=nums.length;
        if(len==1)return nums[0];
        int[][] dp=new int[len+1][2];
        dp[0][0]=dp[0][1]=1;
        int res=Integer.MIN_VALUE;
        for(int i=1;i<=len;i++){
            int num=nums[i-1];
            if(num>0){
                dp[i][0]=Math.max(dp[i-1][0]*num,num);
                dp[i][1]=Math.min(dp[i-1][1]*num,num);
            }else if(num<0){
                dp[i][0]=Math.max(dp[i-1][1]*num,num);
                dp[i][1]=Math.min(dp[i-1][0]*num,num);

            }else {
                dp[i][0]=0;
                dp[i][1]=0;
            }
            res=Math.max(res,dp[i][0]);
        }
        return res;

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
        No152 no152 = new No152();
        System.out.println(no152.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(no152.maxProduct(new int[]{-2,0,-1}));

    }
}
