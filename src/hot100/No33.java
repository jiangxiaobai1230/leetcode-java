package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-13 15:45
 */
public class No33 {
    //https://leetcode.cn/problems/search-in-rotated-sorted-array/solutions/1987503/by-endlesscheng-auuh/?envType=study-plan-v2&envId=top-100-liked


    public int search(int[] nums, int target) {
        if(nums.length==1) {
            return target==nums[0]?0:-1;
        }
        int left=0,right=nums.length-2,mid=0;
        while (left<=right){
            mid=(left+right)/2;
            int num=nums[mid];
            if(nums[nums.length-1]>num){
                right=mid-1;
            }else{
                left=mid+1;

            }
        }
        int index=left;
        if(target<=nums[nums.length-1]){
            left=index;
            right=nums.length-1;
            while (left<=right){
                mid=(left+right)/2;
                int num=nums[mid];
                if(target==num)return mid;
                if(target>num){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            return -1;
        }
        else {
            left=0;
            right=index-1;
            while (left<=right){
                mid=(left+right)/2;
                int num=nums[mid];
                if(target==num)return mid;
                if(target>num){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            return -1;

        }

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [4,5,6,7,0,1,2], target = 0
        //输出：4
        //示例 2：
        //
        //输入：nums = [4,5,6,7,0,1,2], target = 3
        //输出：-1
        //示例 3：
        //
        //输入：nums = [1], target = 0
        //输出：-1
        int[] nums = {4,5,6,7,0,1,2};
        No33 no33 = new No33();
        System.out.println(no33.search(nums, 0));
        System.out.println(no33.search(nums, 3));

        nums=new int[]{1};

        System.out.println(no33.search(nums, 0));
    }
}
