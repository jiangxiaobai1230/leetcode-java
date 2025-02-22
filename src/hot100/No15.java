package src.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-18 11:24
 */

//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
// 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
public class No15 {
    //https://leetcode.cn/problems/3sum/solutions/1968332/shuang-zhi-zhen-xiang-bu-ming-bai-yi-ge-pno55/?envType=study-plan-v2&envId=top-100-liked

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n-2;i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            if(nums[i]+nums[i+1]+nums[i+2]>0)break;
            if(nums[i]+nums[n-2]+nums[n-1]<0)continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[j] + nums[k]+nums[i];
                if (sum < 0) {
                    j++;
                }
                else if (sum > 0) {
                    k--;
                }
                else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while (j<k&&nums[j] == nums[j - 1]){
                        j++;
                    }
                    k--;
                    while (k>j&&nums[k] == nums[k + 1]){
                        k--;
                    }

                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [-1,0,1,2,-1,-4]
        //输出：[[-1,-1,2],[-1,0,1]]
        //解释：
        //nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
        //nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
        //nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
        //不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
        //注意，输出的顺序和三元组的顺序并不重要。
        //示例 2：
        //
        //输入：nums = [0,1,1]
        //输出：[]
        //解释：唯一可能的三元组和不为 0 。
        //示例 3：
        //
        //输入：nums = [0,0,0]
        //输出：[[0,0,0]]
        //解释：唯一可能的三元组和为 0 。

        No15 no15 = new No15();
        int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> lists = no15.threeSum(nums);
        for (List<Integer> list : lists) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
        System.out.println();
        int[] nums1 = new int[]{0, 1, 1};
        List<List<Integer>> lists1 = no15.threeSum(nums1);
        for (List<Integer> list : lists1) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
        System.out.println();
        int[] nums2 = new int[]{0,0,0};
        List<List<Integer>> lists2 = no15.threeSum(nums2);
        for (List<Integer> list : lists2) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
