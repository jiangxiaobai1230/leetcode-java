package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-04 18:53
 */
public class No169 {

    public int majorityElement(int[] nums) {
        int len=nums.length;
        int num=nums[0],count=1;
        for(int i=1;i<len;i++){
            if(nums[i]==num){
                count++;
            }else {
                count--;
                if(count==0){
                    num=nums[i];
                    count=1;
                }
            }
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

        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new No169().majorityElement(nums1));
        System.out.println(new No169().majorityElement(nums2));

    }
}
