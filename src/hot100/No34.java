package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-20 13:09
 */
public class No34 {
    //https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solutions/1980196/er-fen-cha-zhao-zong-shi-xie-bu-dui-yi-g-t9l9/

    public int[] searchRange(int[] nums, int target) {
        int start=lower_bound(nums,target);
        if(start>=nums.length||nums[start]!=target)return new int[]{-1,-1};
        int end=lower_bound(nums,target+1)-1;
        return new int[]{start,end};

    }

    //求>=target
    //也可以变一下>t,<t,<=t
    //<=8 [>=9]-1
    //<8 [>=8]-1
    //>8 [>=9]
    public int lower_bound(int[] nums, int target){
        int n=nums.length;
        int left=0,right=n-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]<target)left=mid+1;
            else right=mid-1;
        }
        return left;
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [5,7,7,8,8,10], target = 8
        //输出：[3,4]
        //示例 2：
        //
        //输入：nums = [5,7,7,8,8,10], target = 6
        //输出：[-1,-1]
        //示例 3：
        //
        //输入：nums = [], target = 0
        //输出：[-1,-1]
        No34 no34 = new No34();
        int[] res = no34.searchRange(new int[]{5,7,7,8,8,10}, 8);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        System.out.println();
        int[] res1 = no34.searchRange(new int[]{5,7,7,8,8,10}, 6);
        for (int i = 0; i < res1.length; i++) {
            System.out.println(res1[i]);
        }
        System.out.println();
        int[] res2 = no34.searchRange(new int[]{}, 0);
        for (int i = 0; i < res2.length; i++) {
            System.out.println(res2[i]);
        }
    }
}
