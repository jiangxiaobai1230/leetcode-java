package src.hash;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-21 11:37
 */
public class No18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        int sum,len=nums.length;
        Arrays.sort(nums);
        if(nums[0]>0&&target>0 && nums[0]>target){
            return res;
        }
        if(target<0 && nums[0]>0){
            return res;
        }
        if(len<4){
            return res;
        }
        for(int i=0;i<len-3;i++){

            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<len-2;j++){
                int l=j+1;
                int r=len-1;

                if(j-1>i&& nums[j]==nums[j-1]){
                    continue;
                }
                while(l<r) {
                    sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum > target) {
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;

                    }
                }

            }

        }
        return res;
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [1,0,-1,0,-2,2], target = 0
        //输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        //示例 2：
        //
        //输入：nums = [2,2,2,2,2], target = 8
        //输出：[[2,2,2,2]]
        No18 no18 = new No18();
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        List<List<Integer>> lists = no18.fourSum(nums, 0);
//        for (List<Integer> list : lists) {
//            for (Integer integer : list) {
//                System.out.print(integer + " ");
//            }
//            System.out.println();
//        }


        int[] nums1 = {1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> lists1 = no18.fourSum(nums1, -294967296);
        for (List<Integer> list : lists1) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }


    }
}
