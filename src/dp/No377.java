package src.dp;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2024-06-26 23:46
 */
public class No377 {

    public int combinationSum4(int[] nums, int target) {

        int len=nums.length;
        int[][] dp=new int[target+1][len+1];
        for(int i=0;i<=len;i++){
            dp[0][i]=1;
        }
        Arrays.sort(nums);

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= nums.length; j++) {
                if(i >= nums[j-1]){
                    for (int k = 0; k < j; k++) {
                        dp[i][j] += dp[i - nums[k]][j];
                    }
                }
                else dp[i][j] = dp[i][j - 1];
            }
        }



        return dp[target][len];

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [1,2,3], target = 4
        //输出：7
        //解释：
        //所有可能的组合为：
        //(1, 1, 1, 1)
        //(1, 1, 2)
        //(1, 2, 1)
        //(1, 3)
        //(2, 1, 1)
        //(2, 2)
        //(3, 1)
        //请注意，顺序不同的序列被视作不同的组合。
        //示例 2：
        //
        //输入：nums = [9], target = 3
        //输出：0

        No377 no377 = new No377();
        int[] nums = new int[]{1, 2, 3};
        int target = 4;
        System.out.println(no377.combinationSum4(nums, target));
        target = 4;
        nums = new int[]{3,1,2,4};
        System.out.println(no377.combinationSum4(nums, target));


    }
}
