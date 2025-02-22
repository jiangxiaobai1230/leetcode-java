package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-19 16:02
 */
public class No713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        if(n==1)return nums[0]<k?1:0;
        if(k<2)return 0;
        int res=0,sum=1;
        int left=0,right=0;
        //固定right
        while (right<n){
            sum*=nums[right];
            while (sum>=k){
                sum/=nums[left++];
            }
            res+=right-left+1;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [10,5,2,6], k = 100
        //输出：8
        //解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2]、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
        //需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
        //示例 2：
        //
        //输入：nums = [1,2,3], k = 0
        //输出：0
        int[] nums = {1,1,1};
        No713 no713 = new No713();
        System.out.println(no713.numSubarrayProductLessThanK(nums, 1));
        System.out.println(no713.numSubarrayProductLessThanK(new int[]{1,2,3}, 0));


    }
}
