package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-09 22:12
 */
public class No41 {
    //https://leetcode.cn/problems/first-missing-positive/solutions/304743/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked

    public int firstMissingPositive(int[] nums) {
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]<=0)nums[i]=len+1;
        }
        for(int i=0;i<len;i++){
            if(nums[i]<=len){
                int num=Math.abs(nums[i]);
                if(num<=len) {
                    nums[num - 1] = -Math.abs(nums[num - 1]);
                }
            }
        }
        for(int i=0;i<len;i++){
            if(nums[i]>0)return i+1;
        }
        return len+1;
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [1,2,0]
        //输出：3
        //解释：范围 [1,2] 中的数字都在数组中。
        //示例 2：
        //
        //输入：nums = [3,4,-1,1]
        //输出：2
        //解释：1 在数组中，但 2 没有。
        //示例 3：
        //
        //输入：nums = [7,8,9,11,12]
        //输出：1
        //解释：最小的正数 1 没有出现。
        int[] nums = {1,2,0};
        No41 no41 = new No41();
        int res = no41.firstMissingPositive(nums);
        System.out.println(res);
        nums = new int[]{3,4,-1,1};
        res = no41.firstMissingPositive(nums);
        System.out.println(res);
        nums = new int[]{7,8,9,11,12};
        res = no41.firstMissingPositive(nums);
        System.out.println(res);
    }
}
