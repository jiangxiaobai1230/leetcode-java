package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-18 11:28
 */
public class No167 {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int left=0,right=n-1;
        while (left<right){
            int sum=numbers[left]+numbers[right];
            if(sum<target)left++;
            else if (sum>target) {
                right--;

            }
            else return new int[]{left+1,right+1};
        }
        return new int[]{};

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：numbers = [2,7,11,15], target = 9
        //输出：[1,2]
        //解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
        //示例 2：
        //
        //输入：numbers = [2,3,4], target = 6
        //输出：[1,3]
        //解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
        //示例 3：
        //
        //输入：numbers = [-1,0], target = -1
        //输出：[1,2]
        //解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
        int[] numbers = new int[]{2,7,11,15};
        int target = 9;
        No167 no167 = new No167();
        int[] result = no167.twoSum(numbers, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        int[] numbers1 = new int[]{2,3,4};
        int target1 = 6;
        int[] result1 = no167.twoSum(numbers1, target1);
        for (int i = 0; i < result1.length; i++) {
            System.out.println(result1[i]);
        }
        int[] numbers2 = new int[]{-1,0};
        int target2 = -1;
        int[] result2 = no167.twoSum(numbers2, target2);
        for (int i = 0; i < result2.length; i++) {
            System.out.println(result2[i]);
        }

    }
}
