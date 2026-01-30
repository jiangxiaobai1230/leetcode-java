package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2026-01-01 23:15
 */
public class No34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[]{-1,-1};
        if(nums.length==0)return res;
        int start=range(nums,target);
        if(start>=nums.length||nums[start]!=target)return new int[]{-1,-1};
        int end=range(nums,target+1)-1;
        res=new int[]{start,end};
        return res;


    }
    public int range(int[] nums,int target){
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else right=mid-1;
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
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        No34 no34 = new No34();
        int[] ints = no34.searchRange(nums, target);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println();
        target=6;
        ints = no34.searchRange(nums, target);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println();
        nums=new int[0];
        target=0;
        ints = no34.searchRange(nums, target);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println();

    }

}
