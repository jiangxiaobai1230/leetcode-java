package src.hot100;

import com.sun.nio.sctp.PeerAddressChangeNotification;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-05 14:07
 */
public class No84 {
    //https://leetcode.cn/problems/largest-rectangle-in-histogram/solutions/1856193/by-ac_oier-i470/?envType=study-plan-v2&envId=top-100-liked

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> deque=new LinkedList<>();
        int n=heights.length;
        int[] l=new int[n];
        int[] r=new int[n];
        Arrays.fill(l,-1);
        Arrays.fill(r,n);
        for(int i=0;i<n;i++){
            while (!deque.isEmpty()&&heights[deque.peek()]>heights[i])r[deque.pop()]=i;
            deque.push(i);
        }
        deque.clear();
        for(int i=n-1;i>=0;i--){
            while (!deque.isEmpty()&&heights[deque.peek()]>heights[i])l[deque.pop()]=i;
            deque.push(i);
        }
        int res=0;
        for(int i=0;i<n;i++){
            int area=Math.max(heights[i]*(r[i]-l[i]-1),heights[i]);
            res=Math.max(res,area);
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
        System.out.println(new No84().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(new No84().largestRectangleArea(new int[]{2, 4}));

    }

}
