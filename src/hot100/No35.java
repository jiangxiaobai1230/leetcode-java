package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-27 23:52
 */
public class No35 {
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target)return mid;
            else if (nums[mid]>target) {
                right=mid-1;

            }else left=mid+1;
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

        int res = new No35().searchInsert(new int[]{1,3,5,6}, 5);
        System.out.println(res);
        res = new No35().searchInsert(new int[]{1,3,5,6}, 2);
        System.out.println(res);
        res = new No35().searchInsert(new int[]{1,3,5,6}, 7);
        System.out.println(res);

    }
}
