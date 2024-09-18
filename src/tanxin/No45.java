package src.tanxin;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-15 10:21
 */
public class No45 {

    public int jump(int[] nums) {
        int step=0;
        int end=0;
        int maxCoverage=0;
        for(int i=0;i<nums.length-1;i++){
            maxCoverage=Math.max(maxCoverage,nums[i]+i);
            if(i==end){
                end=maxCoverage;
                step++;
            }

        }
        return step;

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
        int[] nums = new int[]{2,1};
        System.out.println(new No45().jump(nums));
        System.out.println(new No45().jump(new int[]{2,3,1,1,4}));

    }
}
