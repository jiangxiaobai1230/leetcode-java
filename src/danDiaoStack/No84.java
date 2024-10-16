package src.danDiaoStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: Yuan Yuqing
 * @date: 2024-10-16 22:24
 */
public class No84 {

    public int largestRectangleArea(int[] heights) {
        int len=heights.length;
        if(len==1)return heights[0];
        int[] newheights=new int[len+2];
        newheights[0]=0;
        newheights[len+1]=0;
        for(int i=1;i<len+1;i++){
            newheights[i]=heights[i-1];
        }
        int res=0;
        Stack<Integer> stack= new Stack<>();
        stack.push(0);
        for(int i=1;i<len+2;i++){
            if(newheights[i]<newheights[stack.peek()]){
                while (!stack.isEmpty()&&newheights[i]<newheights[stack.peek()]) {
                    int curIndex=stack.pop();
                    int width = i - stack.peek() - 1;
                    res = Math.max(res, newheights[curIndex] * width);
                }
            }
            stack.push(i);


        }

        return res;

    }

    public static void main(String[] args) {
        //示例 1:
        //
        //
        //
        //输入：heights = [2,1,5,6,2,3]
        //输出：10
        //解释：最大的矩形为图中红色区域，面积为 10
        //示例 2：
        //
        //
        //
        //输入： heights = [2,4]
        //输出： 4

        int[] heights = {2,1,5,6,2,3};
        No84 no84 = new No84();
        System.out.println(no84.largestRectangleArea(heights));
        heights = new int[]{2,4};
        System.out.println(no84.largestRectangleArea(heights));
    }

}
