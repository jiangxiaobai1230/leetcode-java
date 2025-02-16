package src.hot100;

import java.util.*;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-14 16:33
 */

//https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/2361969/215-shu-zu-zhong-de-di-k-ge-zui-da-yuan-d786p/?envType=study-plan-v2&envId=top-100-liked

public class No215 {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> num=new ArrayList<>();
        for(int i:nums){
            num.add(i);
        }

        return quickSelect(num,k);

    }
    public int quickSelect(List<Integer> nums, int k){
        List<Integer> big=new ArrayList<>();
        List<Integer> small=new ArrayList<>();
        List<Integer> equal=new ArrayList<>();
        Random random=new Random();
        int pivot=nums.get(random.nextInt(nums.size()));
        for(int num:nums){
            if(num>pivot)big.add(num);
            else if (num<pivot) {
                small.add(num);
            }
            else equal.add(num);
        }
        if(big.size()>=k){
            return quickSelect(big,k);
        } else if (big.size()+equal.size()<k) {
            return quickSelect(small,k-big.size()-equal.size());

        }
        return pivot;

    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: [3,2,1,5,6,4], k = 2
        //输出: 5
        //示例 2:
        //
        //输入: [3,2,3,1,2,4,5,5,6], k = 4
        //输出: 4
        //
        No215 no215 = new No215();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int res = no215.findKthLargest(nums, k);
        System.out.println(res);
        nums = new int[]{3,2,3,1,2,4,5,5,6};
        k = 4;
        res = no215.findKthLargest(nums, k);
        System.out.println(res);
    }
}
