package src.danDiaoStack;

import java.util.Stack;

/**
 * @author: Yuan Yuqing
 * @date: 2024-10-12 19:39
 */
public class No42 {
    public int trap(int[] height) {
        int len=height.length;
        int sum=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        int mid=0;
        for(int i=1;i<len;i++){
            if(!stack.isEmpty()&&height[stack.peek()]>height[i]){
                stack.push(i);
            } else if (height[stack.peek()]==height[i]) {
                stack.pop();
                stack.push(i);
            }else {
                while (!stack.isEmpty()&&height[stack.peek()]<height[i]){
                    mid=stack.pop();
                    if (!stack.isEmpty()) {
                        int left=stack.peek();
                        int h = Math.min(height[i], height[left]) - height[mid];
                        int w = i - left - 1;
                        sum += h * w;
                    }
                }
                stack.push(i);

            }

        }
        return sum;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //
        //输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
        //输出：6
        //解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
        //示例 2：
        //
        //输入：height = [4,2,0,3,2,5]
        //输出：9
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        No42 no42 = new No42();
        System.out.println(no42.trap(height));

        height = new int[]{4,2,0,3,2,5};
        System.out.println(no42.trap(height));

    }
}
