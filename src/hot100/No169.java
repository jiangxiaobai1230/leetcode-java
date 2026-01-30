package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-10-25 19:07
 */
public class No169 {
    public int majorityElement(int[] nums) {
        int num=nums[0],count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=num){
                count--;
                if(count==0){
                    num=nums[i];
                    count=1;
                }
            }else count++;
        }
        return num;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [3,2,3]
        //输出：3
        //示例 2：
        //
        //输入：nums = [2,2,1,1,1,2,2]
        //输出：2
        int[] nums = new int[]{3,2,3};
        No169 no169 = new No169();
        System.out.println(no169.majorityElement(nums));
        nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(no169.majorityElement(nums));
        nums = new int[]{1};
        System.out.println(no169.majorityElement(nums));

    }
}
