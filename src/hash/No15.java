package src.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-21 09:27
 */
public class No15 {


    public List<List<Integer>> threeSum(int[] nums) {

        int sum, len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] > 0||len==0) {
            return res;
        }
        for(int k=0;k<len-2;k++){
            int i=k+1;
            int j=len-1;

            if(k>0&& nums[k]==nums[k-1]){
                continue;
            }
            while(i<j){
                while(i-1!=k&&i<j&&nums[i]==nums[i-1]){
                    i++;
                }
                while(j>i&&j<len-1&&nums[j]==nums[j+1]){
                    j--;
                }
                if(i>=j){
                    continue;
                }
                sum=nums[i]+nums[j]+nums[k];

                if(sum>0){
                    j--;
                }else if(sum<0){
                    i++;
                }else{
                    res.add(Arrays.asList(nums[k],nums[i],nums[j]));
                    i++;
                    j--;
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
        //


        No15 no15 = new No15();
        int[] nums = new int[]{2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4};
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
        for (List<Integer> list1 : lists) {
            for (int i = 0; i < list1.size(); i++) {
                System.out.print(list1.get(i) + " ");
            }
            System.out.println();
        }
        System.out.println();
        int[] nums2 = new int[]{0, 0, 0};
        List<List<Integer>> lists2 = no15.threeSum(nums2);
        for (List<Integer> list2 : lists) {
            for (int i = 0; i < list2.size(); i++) {
                System.out.print(list2.get(i) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //[-2,0,0,2,2]




}
