package src.Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-30 23:16
 */
public class No239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        Deque<Integer> queue=new LinkedList<>();
        for(int i=0;i<k-1;i++){
            while (!queue.isEmpty()&&queue.peekLast()<nums[i]){
                queue.pollLast();
            }
            queue.addLast(nums[i]);
        }
        for(int i=k-1;i<n;i++){
            while (!queue.isEmpty()&&queue.peekLast()<nums[i]){
                queue.pollLast();
            }
            queue.addLast(nums[i]);
            res[i-k+1]= queue.peekFirst();
            if(!queue.isEmpty()&&queue.peekFirst()==nums[i-k+1]){
                queue.pollFirst();
            }
        }
        return res;
    }



//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int n=nums.length;
//        int[] res=new int[n-k+1];
//        int index=0;
//        Deque<Integer> queue=new LinkedList<>();
//        for(int i=0;i<k-1;i++){
//            while (!queue.isEmpty()&&nums[queue.peekLast()]<nums[i]){
//                queue.pollLast();
//            }
//            queue.addLast(i);
//        }
//        for(int i=k-1;i<n;i++){
//            while (!queue.isEmpty()&&nums[queue.peekLast()]<nums[i]){
//                queue.pollLast();
//            }
//            queue.addLast(i);
//            res[index++]= nums[queue.peekFirst()];
//            if(queue.peekFirst()==i-k+1){
//                queue.removeFirst();
//            }
//
//        }
//
//        return res;
//
//    }
//

//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int n=nums.length;
//        if(k>n){
//            return new int[0];
//        }
//        int[] res=new int[n-k+1];
//        Deque<Integer> deque=new LinkedList<>();
//
//        for(int i=0;i<k;i++){
//            while(!deque.isEmpty() && deque.peekLast()<nums[i]){
//                deque.removeLast();
//            }
//            deque.addLast(nums[i]);
//        }
//        res[0]=deque.peek();
//
//        for(int i=k;i<n;i++){
//            if(deque.peek()==nums[i-k]){
//                deque.removeFirst();
//            }
//
//            while (!deque.isEmpty() && deque.peekLast()<nums[i]){
//                deque.removeLast();
//            }
//            deque.addLast(nums[i]);
//            res[i-k+1]=deque.peek();
//        }
//        return res;
//    }

//    public int[] maxSlidingWindow(int[] nums, int k) {
//
//        if(nums.length == 0 || k == 0) return new int[0];
//        Deque<Integer> deque = new LinkedList<>();
//        int[] res = new int[nums.length - k + 1];
//        // 未形成窗口
//        for(int i = 0; i < k; i++) {
//            while(!deque.isEmpty() && deque.peekLast() < nums[i])
//                deque.removeLast();
//            deque.addLast(nums[i]);
//        }
//        res[0] = deque.peekFirst();
//        // 形成窗口后
//        for(int i = k; i < nums.length; i++) {
//            if(deque.peekFirst() == nums[i - k])
//                deque.removeFirst();
//            while(!deque.isEmpty() && deque.peekLast() < nums[i])
//                deque.removeLast();
//            deque.addLast(nums[i]);
//            res[i - k + 1] = deque.peekFirst();
//        }
//        return res;
//
//
//    }
    public static void main(String[] args) {

        //给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
        //
        //返回 滑动窗口中的最大值 。
        //
        //
        //
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



        int[] nums = new int[]{1,3,1,2,0,5};
        int k = 3;

        No239 no239 = new No239();
        int[] ints = no239.maxSlidingWindow(nums, k);
        for (int i : ints) {
            System.out.println(i);
        }







    }
}
