package src.hot100;

import java.util.Random;

/**
 * @author: Yuan Yuqing
 * @date: 2025-09-23 21:43
 */
public class No912 {
    public int[] sortArray(int[] nums) {
        int n= nums.length;
        quickSort(nums,0,n-1);
        return nums;

    }
    public int[] quickSort(int[] nums,int left,int right) {
        if(left>=right)return nums;
        Random random=new Random();
        int index=random.nextInt(left,right+1);
        swap(nums,index,left);
        int num=nums[left];
        int i=left,j=right;
        left++;
        while (left<=right){
            if(nums[left]<=num){
                left++;
            }else {
               swap(nums,left,right);
                right--;
            }
        }
        swap(nums,i,right);
        quickSort(nums,i,right-1);
        quickSort(nums,right+1,j);
        return nums;

    }
    public void swap(int[] nums,int i,int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [5,2,3,1]
        //输出：[1,2,3,5]
        //解释：数组排序后，某些数字的位置没有改变（例如，2 和 3），而其他数字的位置发生了改变（例如，1 和 5）。
        //示例 2：
        //
        //输入：nums = [5,1,1,2,0,0]
        //输出：[0,0,1,1,2,5]
        //解释：请注意，nums 的值不一定唯一。
        int[] nums = {5,2,3,1};
        No912 no912 = new No912();
        System.out.println(no912.sortArray(nums));
        nums = new int[]{5,1,1,2,0,0};
        System.out.println(no912.sortArray(nums));

    }
}
