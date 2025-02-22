package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-19 15:22
 */
public class No209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length,sum=0;
        int res=n+1;
        int left=0,right=left;
        while (right<n){
            sum+=nums[right];
            while (sum>=target){
                res=Math.min(res,right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;

        }
        return res==n+1?0:res;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：target = 7, nums = [2,3,1,2,4,3]
        //输出：2
        //解释：子数组 [4,3] 是该条件下的长度最小的子数组。
        //示例 2：
        //
        //输入：target = 4, nums = [1,4,4]
        //输出：1
        //示例 3：
        //
        //输入：target = 11, nums = [1,1,1,1,1,1,1,1]
        //输出：0
        //
        int[] num={2,3,1,2,4,3};
        No209 no209 = new No209();
        System.out.println(no209.minSubArrayLen(7, num));
        System.out.println(no209.minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(no209.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }
}
