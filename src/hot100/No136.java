package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-04 18:03
 */
public class No136 {
    public int singleNumber(int[] nums) {
        int res=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            res=res^nums[i];
        }
        return res;

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
        System.out.println(new No136().singleNumber(new int[]{2,2,1}));
        System.out.println(new No136().singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(new No136().singleNumber(new int[]{1}));

    }
}
