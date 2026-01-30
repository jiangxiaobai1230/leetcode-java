package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-08-27 17:06
 */


//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。

public class Main {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            int num=nums[i];
            if(i>0&&nums[i-1]==num)continue;
            int j=i+1;
            int k=n-1;
            if(num+nums[i+1]+nums[i+2]>0)continue;
            if(num+nums[n-1]+nums[n-2]<0)continue;
            while (j<k){
                int sum=num+nums[j]+nums[k];
                if(sum<0){
                    j++;
                } else if (sum>0) {
                    k--;

                }else {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while (j<k&&nums[j]==nums[j-1])j++;
                    while (j<k&&nums[k]==nums[k+1])k--;
                }
            }

        }
        return res;

    }
}
