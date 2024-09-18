package src.tanxin;

import java.util.stream.IntStream;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-15 11:03
 */
public class No1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum=0;
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0&&k>0){
                nums[i]=-nums[i];
                k--;
            }
            sum+=nums[i];
        }
        if(k>0){
            if(k%2==1){
                sum-=2*nums[nums.length-1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        //示例 1：
        //
        //输入：nums = [4,2,3], k = 1
        //输出：5
        //解释：选择下标 1 ，nums 变为 [4,-2,3] 。
        //示例 2：
        //
        //输入：nums = [3,-1,0,2], k = 3
        //输出：6
        //解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
        //示例 3：
        //
        //输入：nums = [2,-3,-1,5,-4], k = 2
        //输出：13
        //解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。

        int[] nums = {2,-3,-1,5,-4};
        int k = 2;
        No1005 no1005 = new No1005();
        System.out.println(no1005.largestSumAfterKNegations(nums, k));
        nums = new int[]{3,-1,0,2};
        k = 3;
        System.out.println(no1005.largestSumAfterKNegations(nums, k));
        nums = new int[]{4,2,3};
        k = 1;
        System.out.println(no1005.largestSumAfterKNegations(nums, k));




    }
}
