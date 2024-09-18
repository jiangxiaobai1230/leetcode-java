package src.hash;

import java.util.HashMap;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-20 10:36
 */
public class No1 {

    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        int count=0;

        HashMap<Integer,Integer> visted=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(visted.containsKey(target-nums[i])){
                res[count++]=i;
                res[count]=visted.get(target-nums[i]);
                break;

            }else{
                visted.put(nums[i],i);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        //示例 1：
        //
        //输入：nums = [2,7,11,15], target = 9
        //输出：[0,1]
        //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
        //示例 2：
        //
        //输入：nums = [3,2,4], target = 6
        //输出：[1,2]
        //示例 3：
        //
        //输入：nums = [3,3], target = 6
        //输出：[0,1]

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = new No1().twoSum(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        int[] nums1 = {3, 2, 4};
        int target1 = 6;
        int[] result1 = new No1().twoSum(nums1, target1);
        for (int i = 0; i < result1.length; i++) {
            System.out.println(result1[i]);
        }

        int[] nums2 = {3, 3};
        int target2 = 6;
        int[] result2 = new No1().twoSum(nums2, target2);
        for (int i = 0; i < result2.length; i++) {
            System.out.println(result2[i]);
        }


    }
}
