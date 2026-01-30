package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2026-01-09 23:37
 */
public class No283 {

    public void moveZeroes(int[] nums) {
        int len=nums.length;
        int zero=0;
        for(int i=0;i<len;i++){
            if(nums[i]!=0) {
                nums[zero++] = nums[i];
            }
        }
        for(int i=zero;i<len;i++){
            nums[i]=0;
        }

    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: nums = [0,1,0,3,12]
        //输出: [1,3,12,0,0]
        //示例 2:
        //
        //输入: nums = [0]
        //输出: [0]
        int[] nums=new int[]{0,1,0,3,12};
        No283 no283=new No283();
        no283.moveZeroes(nums);
        nums=new int[]{0};
        no283.moveZeroes(nums);
    }
}
