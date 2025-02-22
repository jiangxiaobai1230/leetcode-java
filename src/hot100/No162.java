package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-20 13:07
 */
public class No162 {
    //l左边都是红色，m右边都是蓝色,假设 nums[-1] = nums[n] = -∞，位置0不一定红色,n一定蓝色
    //二分区间的定义是【不确定的值组成的范围】，不是【包含答案的范围】。

//    public int findPeakElement(int[] nums) {
//        int n=nums.length;
//        int left=0,right=n-1;
//        while (left<right){
//            int mid=(left+right)/2;
//            if(nums[mid]<nums[mid+1])left=mid+1;
//            else right=mid;
//        }
//        return left;
//
//    }


    public int findPeakElement(int[] nums) {
        int n=nums.length;
//        if(n==1)return 0;
//        if(n==2)return nums[0]>nums[1]?0:1;
        int left=0,right=n-2;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]<nums[mid+1])left=mid+1;
            else right=mid-1;
        }
        return left;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [1,2,3,1]
        //输出：2
        //解释：3 是峰值元素，你的函数应该返回其索引 2。
        //示例 2：
        //
        //输入：nums = [1,2,1,3,5,6,4]
        //输出：1 或 5
        //解释：你的函数可以返回索引 1，其峰值元素为 2；
        //     或者返回索引 5， 其峰值元素为 6。
        int[] nums = {1,2,3,1};
        No162 no162 = new No162();
        System.out.println(no162.findPeakElement(nums));
        System.out.println(no162.findPeakElement(new int[]{1,2,3}));

    }
}
