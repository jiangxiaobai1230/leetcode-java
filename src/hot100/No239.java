package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-20 13:03
 */
public class No239 {
    public int[] maxSlidingWindow(int[] nums, int k) {


        return new int[]{};

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
        //输出：[3,3,5,5,6,7]
        //解释：
        //滑动窗口的位置                最大值
        //---------------               -----
        //[1  3  -1] -3  5  3  6  7       3
        // 1 [3  -1  -3] 5  3  6  7       3
        // 1  3 [-1  -3  5] 3  6  7       5
        // 1  3  -1 [-3  5  3] 6  7       5
        // 1  3  -1  -3 [5  3  6] 7       6
        // 1  3  -1  -3  5 [3  6  7]      7
        //示例 2：
        //
        //输入：nums = [1], k = 1
        //输出：[1]
        //

        No239 no239 = new No239();
        int[] res = no239.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        System.out.println();
        int[] res1 = no239.maxSlidingWindow(new int[]{1}, 1);
        for (int i = 0; i < res1.length; i++) {
            System.out.println(res1[i]);
        }
    }
}
