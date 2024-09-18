package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-06-12 22:34
 */
public class No494 {

    public int findTargetSumWays(int[] nums, int target) {
        int len=nums.length;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(-target>sum||target>sum)return 0;
        if(len==1){
            if(sum==target||sum==-target)return 1;
            else return 0;
        }
        int left=target+sum;
        if(left<0||left%2!=0)return 0;
        left=left/2;
        int[][] dp=new int[len][left+1];
        if(left>=nums[0]){
            dp[0][nums[0]]=1;
        }
        int zeroNum=0;
        for(int i=0;i<len;i++){
            if(nums[i]==0)zeroNum++;
            dp[i][0]= (int) Math.pow(2,zeroNum);
        }


        for(int i=1;i<len;i++){
            for(int j=0;j<=left;j++){
                if(j>=nums[i]){
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i]];
                }
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[len-1][left];

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
        //

        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        No494 no494 = new No494();
        System.out.println(no494.findTargetSumWays(nums, target));
        System.out.println(no494.findTargetSumWays(new int[]{1}, 1));

    }

}
