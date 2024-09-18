package src.tanxin;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-14 10:46
 */
public class No55 {

    public boolean canJump(int[] nums) {
        int coverRange=0;
        for (int i=0;i<=coverRange;i++){
            coverRange=Math.max(coverRange,nums[i]+i);
            if(coverRange>=nums.length-1)return true;
        }
        return false;

    }


    public static void main(String[] args) {

        //示例 1：
        //
        //输入：nums = [2,3,1,1,4]
        //输出：true
        //解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
        //示例 2：
        //
        //输入：nums = [3,2,1,0,4]
        //输出：false
        //解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
        //
        int[] nums = {1,2,3};
        No55 no55 = new No55();
        System.out.println(no55.canJump(nums));
        System.out.println(no55.canJump(new int[]{3,2,1,0,4}));


    }
}
