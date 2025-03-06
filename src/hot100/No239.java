package src.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-20 13:03
 */
public class No239 {
    //https://leetcode.cn/problems/sliding-window-maximum/solutions/2361228/239-hua-dong-chuang-kou-zui-da-zhi-dan-d-u6h0/?envType=study-plan-v2&envId=top-100-liked

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        Deque<Integer> deque=new LinkedList<>();
        deque.addLast(nums[0]);
        //形成窗口
        for(int i=1;i<k;i++){
            while (!deque.isEmpty()&&deque.peekLast()<nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0]=deque.peek();
        //开始滑动
        for(int i=k;i<n;i++){
            //出
            if(!deque.isEmpty()&&deque.peek()==nums[i-k]){
                deque.pop();
            }
            //入
            while (!deque.isEmpty()&&deque.peekLast() < nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i-k+1]=deque.peek();
        }
        return res;
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
        int[] res = no239.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
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
