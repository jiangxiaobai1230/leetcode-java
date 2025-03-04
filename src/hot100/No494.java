package src.hot100;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-28 23:24
 */
public class No494 {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int[][] memo;
        for(int i=0;i<n;i++){
            target+=nums[i];
        }
        if(target<0||target%2!=0)return 0;
        target=target/2;
        memo=new int[n+1][target+1];
        memo[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
                if(j<nums[i-1])memo[i][j]=memo[i-1][j];
                else memo[i][j]=memo[i-1][j]+memo[i-1][j-nums[i-1]];
            }

        }
        return memo[n][target];


    }




    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [1,1,1,1,1], target = 3
        //输出：5
        //解释：一共有 5 种方法让最终目标和为 3 。
        //-1 + 1 + 1 + 1 + 1 = 3
        //+1 - 1 + 1 + 1 + 1 = 3
        //+1 + 1 - 1 + 1 + 1 = 3
        //+1 + 1 + 1 - 1 + 1 = 3
        //+1 + 1 + 1 + 1 - 1 = 3
        //示例 2：
        //
        //输入：nums = [1], target = 1
        //输出：1
        System.out.println(new No494().findTargetSumWays(new int[]{1,1,1,1,1}, 3));
        System.out.println(new No494().findTargetSumWays(new int[]{1}, 1));

    }
}
