package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-15 01:00
 */
public class No287 {
    //https://leetcode.cn/problems/find-the-duplicate-number/solutions/1169969/shu-ju-jie-gou-he-suan-fa-er-fen-fa-cha-8ybnw/?envType=study-plan-v2&envId=top-100-liked
//https://leetcode.cn/problems/find-the-duplicate-number/solutions/1195510/kuai-man-zhi-zhen-287-xun-zhao-zhong-fu-la52t/?envType=study-plan-v2&envId=top-100-liked

    public int findDuplicate(int[] nums) {
        int len=nums.length;
        int left=1,right=len-1;
        while (left<right){
            int mid=(left+right)/2;
            int count=0;
            for(int num:nums){
                if(num<=mid)count++;
            }
            if(count>mid)right=mid;
            else left=mid+1;
        }
        return left;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [1,3,4,2,2]
        //输出：2
        //示例 2：
        //
        //输入：nums = [3,1,3,4,2]
        //输出：3
        //示例 3 :
        //
        //输入：nums = [3,3,3,3,3]
        //输出：3
        int[] nums = {1,3,4,2,2};
        No287 no287 = new No287();
        System.out.println(no287.findDuplicate(nums));
        nums = new int[]{3,1,3,4,2};
        System.out.println(no287.findDuplicate(nums));
        nums = new int[]{3,3,3,3,3};
        System.out.println(no287.findDuplicate(nums));
    }
}
