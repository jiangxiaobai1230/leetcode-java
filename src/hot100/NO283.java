package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-19 11:11
 */
public class NO283 {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        if(n<2)return;
        int i0=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[i0];
                nums[i0]=temp;
                i0++;
            }
        }

    }

//    public void moveZeroes(int[] nums) {
//        int n=nums.length;
//        if(n<2)return;
//        int nonZeroCount=0;
//        for(int i=0;i<n;i++){
//            if(nums[i]!=0)nums[nonZeroCount++]=nums[i];
//        }
//        for(int i=nonZeroCount;i<n;i++){
//            nums[i]=0;
//
//        }
//
//    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: nums = [0,1,0,3,12]
        //输出: [1,3,12,0,0]
        //示例 2:
        //
        //输入: nums = [0]
        //输出: [0]
        int[] nums = {0,1,0,3,12};
        NO283 no283 = new NO283();
        no283.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        int[] nums1 = {0};
        no283.moveZeroes(nums1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }

    }
}
