package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-07-05 21:04
 */
public class No213 {


    public int rob(int[] nums) {
        int len=nums.length;
        if(len==1)return nums[0];
        if(len==2)return Math.max(nums[0],nums[1]);
        return Math.max(rob1(nums,0,len-2),rob1(nums,1,len-1));


    }
    public int rob1(int[] nums,int start,int end){
        int ppre=0,pre=0,now=0;
        for(int i=start;i<=end;i++){
            now=Math.max(ppre+nums[i],pre);
            ppre=pre;
            pre=now;
        }
        return pre;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [2,3,2]
        //输出：3
        //解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
        //示例 2：
        //
        //输入：nums = [1,2,3,1]
        //输出：4
        //解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
        //     偷窃到的最高金额 = 1 + 3 = 4 。
        //示例 3：
        //
        //输入：nums = [1,2,3]
        //输出：3
        int[] nums = new int[]{2,3,2};
        No213 no213 = new No213();
        System.out.println(no213.rob(nums));
        no213.rob(nums);
        nums = new int[]{1,2,3,1};
        System.out.println(no213.rob(nums));
        nums = new int[]{1,2,3};
        System.out.println(no213.rob(nums));

    }
}
