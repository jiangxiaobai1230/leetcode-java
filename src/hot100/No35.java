package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-12-11 23:32
 */
public class No35 {

    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int left=0,right=n-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]<target){
                left=mid+1;
            } else if (nums[mid]>target) {
                right=mid-1;

            }else return mid;
        }
        return left;


    }
    public static void main(String[] args) {
        //示例 1:
        //
        //输入: nums = [1,3,5,6], target = 5
        //输出: 2
        //示例 2:
        //
        //输入: nums = [1,3,5,6], target = 2
        //输出: 1
        //示例 3:
        //
        //输入: nums = [1,3,5,6], target = 7
        //输出: 4
        //
        int[] nums = new int[]{1,3,5,6};
        No35 no35 = new No35();
        System.out.println(no35.searchInsert(nums, 5));
        System.out.println(no35.searchInsert(nums, 2));
        System.out.println(no35.searchInsert(nums, 7));

    }
}
