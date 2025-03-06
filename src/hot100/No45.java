package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-05 23:56
 */
public class No45 {
    public int jump(int[] nums) {
        int res=-1,maxDistance=0,end=0;
        for(int i=0;i<nums.length;i++){
            maxDistance=Math.max(maxDistance,nums[i]+i);

            if(i==end){
                res++;
                end=maxDistance;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: nums = [2,3,1,1,4]
        //输出: 2
        //解释: 跳到最后一个位置的最小跳跃数是 2。
        //     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
        //示例 2:
        //
        //输入: nums = [2,3,0,1,4]
        //输出: 2
        int[] nums = {2, 3, 1, 1, 4};
        No45 no45 = new No45();
        System.out.println(no45.jump(nums));
        nums = new int[]{2, 3, 0, 1, 4};
        System.out.println(no45.jump(nums));

    }
}
