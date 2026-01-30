package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-10-25 19:02
 */
public class No136 {
    public int singleNumber(int[] nums) {
        int num=nums[0];
        for(int i=1;i<nums.length;i++){
            num=num^nums[i];
        }
        return num;

    }

    public static void main(String[] args) {
        //示例 1 ：
        //
        //输入：nums = [2,2,1]
        //
        //输出：1
        //
        //示例 2 ：
        //
        //输入：nums = [4,1,2,1,2]
        //
        //输出：4
        //
        //示例 3 ：
        //
        //输入：nums = [1]
        //
        //输出：1
        int[] nums = new int[]{2,2,1};
        No136 no136 = new No136();
        System.out.println(no136.singleNumber(nums));
        nums = new int[]{4,1,2,1,2};
        System.out.println(no136.singleNumber(nums));
        nums = new int[]{1};
        System.out.println(no136.singleNumber(nums));

    }
}
