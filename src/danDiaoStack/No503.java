package src.danDiaoStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: Yuan Yuqing
 * @date: 2024-10-10 15:48
 */
public class No503 {

    public int[] nextGreaterElements(int[] nums) {
        int len=nums.length;
        int[] res=new int[len];
        Stack<Integer> stack=new Stack<>();
        Arrays.fill(res,-1);
        stack.push(0);
        for(int i=1;i<2*len-1;i++){
            while (!stack.isEmpty()&&nums[stack.peek()]<nums[i%len]){
                res[stack.peek()]=nums[i%len];
                stack.pop();
            }
            stack.push(i%len);
        }

        return res;

    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: nums = [1,2,1]
        //输出: [2,-1,2]
        //解释: 第一个 1 的下一个更大的数是 2；
        //数字 2 找不到下一个更大的数；
        //第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
        //示例 2:
        //
        //输入: nums = [1,2,3,4,3]
        //输出: [2,3,4,-1,4]
        No503 no503 = new No503();
        int[] res = no503.nextGreaterElements(new int[]{1,2,1});
        for (int i : res) {
            System.out.println(i);
        }
        System.out.println();
        res = no503.nextGreaterElements(new int[]{1,2,3,4,3});

        for (int i : res) {
            System.out.println(i);
        }
    }
}
