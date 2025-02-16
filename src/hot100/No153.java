package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-13 16:35
 */
public class No153 {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        int left=0,right=n-2;
        while (left<=right){
            int mid=(left+right)/2;
            int num=nums[mid];
            if(num>nums[n-1])left=mid+1;
            else right=mid-1;
        }
        return left==0?nums[0]:nums[left];

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [3,4,5,1,2]
        //输出：1
        //解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
        //示例 2：
        //
        //输入：nums = [4,5,6,7,0,1,2]
        //输出：0
        //解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
        //示例 3：
        //
        //输入：nums = [11,13,15,17]
        //输出：11
        //解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
        int[] nums = {3,4,5,1,2};
        No153 no153 = new No153();
        int res = no153.findMin(nums);
        System.out.println(res);
        nums = new int[]{4,5,6,7,0,1,2};
        res = no153.findMin(nums);
        System.out.println(res);
        nums = new int[]{11,13,15,17};
        res = no153.findMin(nums);
        System.out.println(res);

    }
}
